--CHuongw 5
--1. Hiển thị toàn bộ tên nhân viên và tên phòng ban làm việc sắp xếp theo tên phòng ban.
select distinct EMP.ENAME, D.DNAME
from EMP
         join DEPT D on EMP.DEPTNO = D.DEPTNO
group by D.DNAME, EMP.ENAME
order by D.DNAME asc;
--2. Hiển thị tên nhân viên, vị trí địa lý, tên phòng với điều kiện lương >1500.
select EMP.ENAME, D.LOC, D.DNAME
from EMP
         join DEPT D on EMP.DEPTNO = D.DEPTNO
where EMP.SAL > 1500;
--3. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương.
select distinct ENAME,
                JOB,
                SAL,
                s.GRADE
from EMP,SALGRADE s
order by GRADE asc;
--4. Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương, với  điều kiện mức lương=3.
select distinct ENAME,
                JOB,
                NVL(SAL,0),
                s.GRADE
from EMP,SALGRADE s
where s.GRADE=3;
--5. Hiển thị những nhân viên tại DALLAS
select e.ENAME, d.LOC, e.SAL
from EMP e
         join DEPT d on e.DEPTNO = d.DEPTNO
where d.LOC = (select LOC from DEPT where LOC = 'DALLAS');
--6. Hiển thị tên nhân viên , nghề nghiệp, lương, mức lương, tên phòng làm việc trừ nhân
--viên có nghề là cleck và sắp xếp theo chiều giảm.
select e.ENAME,
       e.JOB,
       e.SAL,
       case
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 1) and (select HISAL from SALGRADE where GRADE = 1)
               then '1'
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 2) and (select HISAL from SALGRADE where GRADE = 2)
               then '2'
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 3) and (select HISAL from SALGRADE where GRADE = 3)
               then '3'
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 4) and (select HISAL from SALGRADE where GRADE = 4)
               then '4'
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 5) and (select HISAL from SALGRADE where GRADE = 5)
               then '5'
           end as GRADE,
       d.DNAME
from EMP e
         join DEPT d on e.DEPTNO = d.DEPTNO
where e.JOB =  (select JOB from DEPT where JOB != 'CLERK')
order by SAL desc;
--7. Hiển thị chi tiết về những nhân viên kiếm được 60000$ 1 năm hoặc nghề là cleck.
--(gồm các trường tên, nghề, thu nhập, mã phòng, tên phòng, mức lương)
select e.ENAME,
       e.JOB,
       e.SAL,
       d.DEPTNO,
       d.DNAME,
       case
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 1) and (select HISAL from SALGRADE where GRADE = 1)
               then '1'
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 2) and (select HISAL from SALGRADE where GRADE = 2)
               then '2'
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 3) and (select HISAL from SALGRADE where GRADE = 3)
               then '3'
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 4) and (select HISAL from SALGRADE where GRADE = 4)
               then '4'
           when e.SAL between (select LOSAL from SALGRADE where GRADE = 5) and (select HISAL from SALGRADE where GRADE = 5)
               then '5'
           end as GRADE
from EMP e
         join DEPT d on e.DEPTNO = d.DEPTNO
where e.SAL * 12 = 60000
   or e.JOB = 'CLERK';
--8. Hiển thị những phòng không có nhân viên nào làm việc.
select d.DEPTNO
from DEPT d
         left join EMP e on d.DEPTNO = e.DEPTNO
where e.DEPTNO is null;
--9. Hiển thị mã nhân viên, tên nhân viên, mã người quản lý, tên người quản lý

-- select EMPNO, ENAME, MGR,(select distinct e2.ENAME from EMP e2 where e.MGR=e2.MGR)
-- from EMP e;

--11. Hiển thị nghề nghiệp được tuyển dụng vào năm 1981 và không được tuyển dụng vào năm 1994.
select distinct d.DEPTNO,E.JOB,E.HIREDATE
from DEPT d join EMP E on d.DEPTNO = E.DEPTNO
where  exists(select distinct JOB from EMP where to_char(HIREDATE, 'YYYY') not in'1994' and to_char(HIREDATE, 'YYYY') in '1981');
--14. Tìm những nhân viên kiếm được lương cao nhất trong mỗi loại nghề nghiệp.

-- select Distinct e.EMPNO,JOB,(select distinct MAX(SAL) from EMP where e.JOB=JOB)as MAXSAL
-- from EMP e
-- order by (select distinct MAX(SAL) from EMP where e.JOB=JOB) asc ;

--15. Tìm mức lương cao nhất trong mỗi phòng ban, sắp xếp theo thứ tự phòng ban.
select Distinct d.DNAME,d.DEPTNO,(select distinct NVL(MAX(SAL),0) from EMP where e.DEPTNO=DEPTNO)as MAXSAL
from EMP e right join  DEPT d on e.DEPTNO = d.DEPTNO
order by d.DEPTNO asc;
--16. Tìm nhân viên gia nhập vào phòng ban sớm nhất


--17. Hiển thị những nhân viên có mức lương lớn hơn lương TB của phòng ban mà họ làm việc.
select e.ENAME,e.SAL
    from EMP e
group by e.DEPTNO, e.ENAME, e.SAL
having AVG(e.SAL) >AVG((select avg(SAL) from EMP where e.DEPTNO=EMP.DEPTNO group by DEPTNO));
--18. Hiển thị tên nhân viên, mã nhân viên, mã giám đốc, tên giám đốc, phòng ban làm
--việc của giám đốc, mức lương của giám đốc.
