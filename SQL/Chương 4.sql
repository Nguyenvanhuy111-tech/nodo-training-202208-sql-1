--Chuong 4

-- 1. Liệt kê tên nhân viên, mã phòng ban và lương nhân viên được tăng 15% (PCTSAL).
select DEPTNO, ENAME, NVL(SAL * 0.15, 0) as PCTSAL
from EMP;
--2. Viết câu lệnh hiển thị như sau:
select CONCAT(RPAD(ENAME, 10, '*'), LPAD(JOB, 15, '*')) as EMPLOYEE_AND_JOB
from EMP;
--3. Viết câu lệnh hiển thị như sau:
select CONCAT(ENAME || ' (', JOB || ')') as EMPLOYEE
from EMP;
--4. Viết câu lệnh hiển thị như sau:
select UPPER(ENAME), DEPTNO, INITCAP(JOB)
from EMP;
--5. Tìm ngày thứ 6 đầu tiên cách 2 tháng so với ngày hiện tại hiển thị ngày dưới dạng 09
--February 1990.
select to_char(next_day(add_months(current_date, 2), 'FRIDAY'), 'dd-MM-yyyy') as DAY
from DUAL;

--6. Tìm thông itn về tên nhân viên, ngày gia nhập công ty của nhân viên phòng số 20,
--sao cho hiển thị như sau:
select ENAME, NVL(to_char(HIREDATE, 'Month,DDth-YYYY'), 0) as DATE_HIRED
from EMP
where DEPTNO = 20;
--7. Hiển thị tên nhân viên, ngày gia nhập công ty, ngày xét nâng lương (sau ngày gia
--nhập công ty 1 năm), sắp xếp theo thứ tự ngày xét nâng lương.
select ENAME,
       NVL(to_char(HIREDATE, 'dd-MM-YYYY'), 0)                 as HIREDATE,
       NVL(to_char(add_months(HIREDATE, 12), 'dd-MM-YYYY'), 0) as REVIEW
from EMP
order by add_months(HIREDATE, 12) asc;
--8. Hiển thị tên nhân viên và lương dưới dạng
select ENAME,
       case
           when SAL > 0 and SAL < 1500 then 'BELOW 1500'
           when SAL > 1500 then SAL || ''
           end
           as SALARY
from EMP;
--9. Cho biết thứ của ngày hiện tại
select to_char(current_date, 'day') as DAY
from DUAL;
--10. Đưa chuỗi dưới dạng nn/nn, kiểm tra nếu khúng khuôn dạng trả lời là YES, ngược lại
--là NO. Kiểm tra với các chuỗi 12/34, 01/1a, 99\88
--VALUE VALID?
select decode('12/34', '12/34', 'yes', '01/1a', 'no', '99\98', 'no', 'udefine') decode_check
from DUAL;

--11. Hiển thị tên nhân viên, ngày gia nhập công ty, ngày lĩnh lương sao cho ngày lĩnh
--lương phải vào thứ 6, nhân viên chỉ được nhận lương sau ít nhất 15 ngày làm việc tại
--công ty, sắp xếp theo thứ tự ngày gia nhập công ty.
select ENAME, HIREDATE, next_day(HIREDATE + 15, 'FRIDAY') as NHanLuong
from emp
where (current_date - HIREDATE) >= 15
order by HIREDATE asc;

--4.5.2
--1. Tìm lương thấp nhất, lớn nhất và lương trung bình của tất cả các nhân viên
select MIN(SAL) as MINSAL, MAX(SAL) as MAXSAL, to_number(AVG(SAL)) as AVG
from EMP;
--2. Tìm lương nhỏ nhất và lớn của mỗi loại nghề nghiệp
select JOB, min(SAL) as MINSAL, MAX(SAL) As MAXSAL
from EMP
group by JOB;
--3. Tìm xem có bao nhiêu giám đốc trong danh sách nhân viên.
select count(JOB) as SLMANAGER
FROM EMP
where JOB = 'PRESIDENT';
--4. Tìm tất cả các phòng ban mà số nhân viên trong phòng >3
select DEPTNO, COUNT(DEPTNO) as SLEMP
from EMP
group by DEPTNO
having count(DEPTNO) > 3;
--5. Tìm ra mức lương nhỏ nhất của mỗi nhân viên làm việc cho một giám đốc nào đó
--sắp xếp theo thứ tự tăng dần của mức lương.
select min(SAL) as MINSAL
from EMP
where JOB != 'PRESIDENT' and DEPTNO = '10'
   or DEPTNO = '15'
group by DEPTNO
order by min(SAL) asc;


