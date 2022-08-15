--Chương 2
-- 1
select *
from SALGRADE;
-- 2
select *
from EMP;
-- 3
select Distinct JOB
from EMP;
--4
SELECT ENAME ,NVL(SAL,0)
from EMP;
--5
select ENAME || ' HAS HELP THE POSITION OF PRESIDENT IN DEPT ' || NVL(DEPTNO,0) || ' SINCE ' || TO_CHAR(HIREDATE,'dd-MM-yyyy')
from EMP;

--6
DESCRIBE SCOTT.EMP;

--7
COLUMN SAl JUSTIFY LEFT FORMAT $ 99,990.00
COLUMN hiredate FORMAT A9 NULL 'Not hired'



--Chương 3

-- 1
select ENAME,DEPTNO, SAL
from EMP
where SAL between 1000 and 2000;


--2
select Distinct DEPTNO,DNAME
from DEPT
ORDER BY DNAME ASC;

--3
select EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO
from EMP
WHERE DEPTNO between 10 and 20
group by ENAME, EMPNO, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
order by ENAME ASC;


--4
select ENAME,JOB
from EMP
where JOB='CLERK' and DEPTNO=20;

--5
select ENAME
from EMP
where ENAME like '%TH%' or ENAME like  '%LL%';

--6
select ENAME,JOB,SAL
from EMP
where JOB != 'PRESIDENT';


--7
select ENAME,DEPTNO,TO_DATE(HIREDATE,'dd-Mon-RRRR') as HIREDATE
from EMP
where HIREDATE like '%-83';

--8
select SAL * 12 as ANUAL_SAL,NVL(COMM,0) as COMM
from EMP
where JOB='SALESMAN' and SAL >EMP.COMM
group by COMM, SAL * 12
order by Sal*12 Desc;

