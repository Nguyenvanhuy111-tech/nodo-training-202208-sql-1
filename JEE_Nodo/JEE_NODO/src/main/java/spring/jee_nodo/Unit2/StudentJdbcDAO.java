package spring.jee_nodo.Unit2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDAO {
    @Autowired
    private PlatformTransactionManager transactionManager = new PlatformTransactionManager() {
        @Override
        public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
            return null;
        }

        @Override
        public void commit(TransactionStatus status) throws TransactionException {

        }

        @Override
        public void rollback(TransactionStatus status) throws TransactionException {

        }
    };

    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplete;

    private String insertQuery;
    private String updateAgeByNameSQL = "update STUDENT_MPP set age = ? where name = ?";


    public void save(Object name, Object age) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        String countQuery = "Select Count(*) from STUDENT_MPP";
        try {
            Integer total = jdbcTemplete.queryForObject(countQuery, Integer.class);
            LOGGER.info("Before save data, total record is " + total);

            String sql = "insert into STUDENT_MPP (id,name,age) values (SEQ_Student_MP.nextval,?,?)";
            jdbcTemplete.update(sql, name, age);

            total = jdbcTemplete.queryForObject(countQuery, Integer.class);
            LOGGER.info("After save data, total record is " + total);

            String countQuery2 = "SELECT COUNT(*) FROM STUDENT_MPP";
            Integer total2 = jdbcTemplete.queryForObject(countQuery2, Integer.class);

            transactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
            transactionManager.rollback(status);

            Integer total = jdbcTemplete.queryForObject(countQuery, Integer.class);
            LOGGER.info("After save data, total record is " + total);
        }
    }

    public void insert(String name, Integer age) {
        jdbcTemplete.update(insertQuery, name, age);
        LOGGER.info("Create record name= " + name + " Age= " + age);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplete = new JdbcTemplate(dataSource);
    }

    private void createTableIfNotExists() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "STUDENT_MPP", null);
//        if (rs.next()) {
//            LOGGER.info("Table "+rs.getString("STUDENT_MPP")+" already exists");
//        }
        String sql = "create table STUDENT_MPP"
                + "("
                + "id int primary key ,"
                + "name varchar(100),"
                + "age int default (20)"
                + ")";
//        jdbcTemplete.execute(sql);
    }

    public int totalRecord() {
        String sql = "select count(*) from STUDENT_MPP";
        return jdbcTemplete.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
                ResultSet rs = stmt.executeQuery(sql);
                return rs.next() ? rs.getInt(1) : 0;
            }
        });
    }

    //update age by name
    public void updateAgeByName(String name, Integer age) {
        jdbcTemplete.update(updateAgeByNameSQL, age, name);
        LOGGER.info("Update age by name " + name + " Age= " + age);
    }

    public String getInsertQuery() {
        return insertQuery;
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    private final static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            } catch (Exception e) {
                LOGGER.error(e, e);
                return mapRow(rs, i);
            }
        }
    }


    //add student
    public int[] addStudent(List<Student> students) {
        List<Object[]> batch = new ArrayList<>();
        students.forEach(student -> {
            batch.add(new Object[]{student.getName(), student.getAge()});
        });
        return jdbcTemplete.batchUpdate(insertQuery, batch);
    }

    public List<Student> loadStudent(String name) {
        return jdbcTemplete.query("SELECT *FROM STUDENT_MPP WHERE NAME LIKE '%" + name + "%'", new StudentRowMapper());
    }
}
