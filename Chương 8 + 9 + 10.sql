--CHUONG 8
--1. Thêm dữ liệu vào bảng PROJECTS.
INSERT INTO PROJECTS (PROJID, P_DESC, P_START_DATE, P_END_DATE, BUDGET_AMOUNT, MAX_NO_STAFF)
VALUES (1, 'WRITE C030 COURSE', '02-10-88', '07-12-88', 500, 1);
INSERT INTO PROJECTS (PROJID, P_DESC, P_START_DATE, P_END_DATE, BUDGET_AMOUNT, MAX_NO_STAFF)
VALUES (2, 'PROOF READ NOTES', '01-10-89', '10-JAN-89', 600, 1);
--2. Thêm dữ liệu vào bảng ASSIGNMENTS.
INSERT INTO ASSIGNMENTS (PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE)
VALUES (1, 'WRITE C030 COURSE', '02-10-88', '07-12-88', 500, 1);
INSERT INTO ASSIGNMENTS (PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE)
VALUES (2, 'PROOF READ NOTES', '01-10-89', '10-JAN-89', 600, 1);
--3. Cập nhật trường ASIGNMENT_TYPE từ WT thành WR.
UPDATE ASSIGNMENTS
SET ASSIGN_TYPE='WR'
WHERE ASSIGN_TYPE = 'WT';
--4. Nhập thêm số liệu vào bảng ASSIGNMENTS.
INSERT INTO ASSIGNMENTS (PROJID, EMPNO, A_START_DATE, A_END_DATE, BILL_AMOUNT, ASSIGN_TYPE)
VALUES (2, 'PROOF READ NOTES', '01-10-89', '10-JAN-89', 600, 1);

--CHUONG 9
--1. Tạo Index trên cột PROJID cho bảng ASSIGNMENT
CREATE INDEX IPROJID ON ASSIGNMENTS (PROJID);
--2. Hiển thị danh sách của nhân viên thuộc sự quản lý của người có tên là 1 biến được nhập từ bàn phím
select e.ENAME as EMP_NAME, e.SAL as EMP_SAL, m.ENAME as MGR_NAME, e.SAL as MGR_SAL
from EMP e,
     EMP m
where e.MGR = m.EMPNO
  AND M.ENAME = &NAME_QL;

--Chuong 10
--1. Tạo view có hiển thị như sau:
Create view aggredates100
as
select *
from aggredates;

drop view aggredates100;
--2. Tạo view để nhập số liệu vào bảng ASIGNMENT với các điều kiện sau:
--PROJID <2000, P_START_DATE<P_END_DATE
--Các giá trị có thể chấp nhận của assign_type là PS, WT hoặc ED
--EMPNO có giá trị NOT NULL
--BILL_RATE < 50 Với ASSIGN_TYPE Là PS
--BILL_RATE < 60 Với ASSIGN_TYPE Là WT
--BILL_RATE < 70 Với ASSIGN_TYPE Là ED
CREATE VIEW ASSIGMENT_VIEW
AS
SELECT PROJ_ID, A_START_DATE, A_END_DATE, ASSIGN_TYPE, BILL_AMOUNT
FROM ASIGNMENTT
WHERE PROJ_ID < 2000
    AND A_START_DATE < A_END_DATE
    AND EMPNO IS NOT NULL
    AND
      'PS' = (select ASSIGN_TYPE from ASIGNMENTT where BILL_AMOUNT < 50)
   or 'WT' = (select ASSIGN_TYPE from ASIGNMENTT where BILL_AMOUNT < 60)
   or 'ED' = (select ASSIGN_TYPE from ASIGNMENTT where BILL_AMOUNT < 70)
WITH CHECK OPTION;

DROP VIEW ASSIGMENT_VIEW;


--3. Định nghĩa bảng MESSAGES có cấu trúc
create table MESSAGES
(
    NUMCOL1       NUMBER(9,2),
    NUMCOL2       NUMBER(9,2),
    CHARCOL1      VARCHAR2(60),
    CHARCOL2      VARCHAR2(60),
    DATECOL1      DATE,
    DATECOL1      DATE
);
