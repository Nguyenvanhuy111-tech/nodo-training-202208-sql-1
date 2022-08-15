--Chuong 7
--1. Tạo bảng PROJECT với các column được chỉ ra dưới đây, PROJID là promary key, và P_END_DATE > P_START_DATE.
create table PROJECT
(
    PROJID NUMBER(4) PRIMARY KEY ,
    P_DESC VARCHAR2(20),
    P_START_DATE DATE,
    P_END_DATE DATE,
    BUDGET_AMOUNT NUMBER(7,2),
    MAX_NO_STAFF NUMBER(2)
)

--2. Tạo bảng ASSIGNMENTS với các column được chỉ ra dưới đây, đồng thời cột
--PROJID là foreign key tới bảng PROJECT, cột EMPNO là foreign key tới bảng EMP.
create table ASSIGNMENTS
(
    PROJID NUMBER(4) NOT NULL CONSTRAINT FK_PROJECT REFERENCES SCOTT.PROJECT(PROJID),
    EMPNO NUMBER(4) NOT NULL CONSTRAINT FK_emp REFERENCES SCOTT.EMP(EMPNO),
    A_START_DATE DATE,
    A_END_DATE DATE,
    BILL_AMOUNT NUMBER(4,2),
    ASSIGN_TYPE VARCHAR2(2)
);

--3. Thêm column COMMENTS kiểu LONG vào bảng PROJECTS. Thêm column HOURS kiểu NUMBER vào bảng ASSIGNMENTS.
ALTER TABLE PROJECTS ADD (COMMENTS LONG);
ALTER TABLE ASSIGMENTS ADD (HOURS NUMBER);

--4. Sử dụng view USER_OBJECTS hiển thị tất cả các đối tượng user sở hữu.
SELECT * FROM TAB;

SELECT OBJECT_NAME
FROM USER_OBJECTS
WHERE OBJECT_TYPE = 'TABLE';

--5. Thêm ràng buộc duy nhất (UNIQUE) cho 2 column PROJECT_ID và EMPNO của bảng ASSIGNMENTS.
ALTER TABLE ASSIGNMENTS MODIFY (PROJID UNIQUE);
ALTER TABLE ASSIGNMENTS MODIFY (EMPNO UNIQUE);

--6. Xem các thông tin về các ràng buộc trong USER_CONSTRAINTS.
DESCRIBE USER_CONSTRAINTS;
--7. Xem trong USER hiện tại có tất cả bao nhiêu bảng.
SELECT * FROM TAB;
