create table PHAMMANH_NHAXUATBAN
(
    NXB_ID        NUMBER(4)
        constraint PHAMMANH_NHAXUATBAN_PK
            primary key,
    NXB_MA        VARCHAR2(255) UNIQUE,
    NXB_TEN       VARCHAR2(255),
    NXB_TRANGTHAI INT,
    NXB_DIACHI    VARCHAR2(500),
    NXB_MOTA      VARCHAR2(500)
);
CREATE SEQUENCE PHAMMANH_NHAXUATBAN_SEQ
    START WITH 1
    INCREMENT BY 1
;
INSERT INTO SCOTT.PHAMMANH_NHAXUATBAN (NXB_ID, NXB_MA, NXB_TEN, NXB_TRANGTHAI, NXB_DIACHI, NXB_MOTA)
VALUES (PHAMMANH_NHAXUATBAN_SEQ.nextval, 'NXB1', 'MANH', 0, 'QN', 'HAY');
INSERT INTO PHAMMANH_NHAXUATBAN (NXB_ID, NXB_MA, NXB_TEN, NXB_TRANGTHAI, NXB_DIACHI, NXB_MOTA)
VALUES (PHAMMANH_NHAXUATBAN_SEQ.nextval, 'NXB2', 'MANH2', 1, 'QN', 'qUA HAY');
INSERT INTO PHAMMANH_NHAXUATBAN (NXB_ID, NXB_MA, NXB_TEN, NXB_TRANGTHAI, NXB_DIACHI, NXB_MOTA)
VALUES (PHAMMANH_NHAXUATBAN_SEQ.nextval, 'NXB3', 'MANH3', 1, 'QN', 'qUA HAY');

DROP TABLE PHAMMANH_NHAXUATBAN;
DROP SEQUENCE PHAMMANH_NHAXUATBAN_SEQ;
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

create table PHAMMANH_TACGIA
(
    TG_ID     NUMBER(4)
        constraint PHAMMANH_TACGIA_PK
            primary key,
    TG_MA     VARCHAR2(255) UNIQUE,
    TG_TEN    VARCHAR2(255),
    TG_SDT    VARCHAR2(15),
    TG_DIACHI VARCHAR2(500),
    TG_MOTA   VARCHAR2(500)
);
CREATE SEQUENCE PHAMMANH_TACGIA_SEQ
    START WITH 1
    INCREMENT BY 1
;

INSERT INTO SCOTT.PHAMMANH_TACGIA (TG_ID, TG_MA, TG_TEN, TG_SDT, TG_DIACHI, TG_MOTA)
VALUES (PHAMMANH_TACGIA_SEQ.nextval, 'TG1', 'MANHTG', '09823768', 'QN', 'DEP ZAI');
INSERT INTO SCOTT.PHAMMANH_TACGIA (TG_ID, TG_MA, TG_TEN, TG_SDT, TG_DIACHI, TG_MOTA)
VALUES (PHAMMANH_TACGIA_SEQ.nextval, 'TG2', 'MANHTG2', '098237683', 'QNN', 'DEP ZAI2');


DROP TABLE PHAMMANH_TACGIA;
DROP SEQUENCE PHAMMANH_TACGIA_SEQ;

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table PHAMMANH_SACH
(
    S_ID    NUMBER(4)
        constraint PHAMMANH_SACH_PK
            primary key,
    S_MA    VARCHAR2(255) UNIQUE,
    S_TEN   VARCHAR2(255),
    ID_NXB  NUMBER(4),
    ID_TG   NUMBER(4),
    S_CHUDE VARCHAR2(100),
    S_NAMXB DATE,
    S_MOTA  VARCHAR2(500),
    S_SLCL  INT,
    S_SLDM  INT,
    S_TOTAL INT
);
CREATE SEQUENCE PHAMMANH_SACH_SEQ
    START WITH 1
    INCREMENT BY 1
;
INSERT INTO SCOTT.PHAMMANH_SACH (S_ID, S_MA, S_TEN, ID_NXB, ID_TG, S_CHUDE, S_MOTA, S_SLCL, S_SLDM, S_TOTAL)
VALUES (PHAMMANH_SACH_SEQ.nextval, 'S1', 'CODE', 1, 1, 'CNTT', 'CODE LU', 10, 5, 15);
INSERT INTO SCOTT.PHAMMANH_SACH (S_ID, S_MA, S_TEN, ID_NXB, ID_TG, S_CHUDE, S_NAMXB, S_MOTA, S_SLCL, S_SLDM, S_TOTAL)
VALUES (PHAMMANH_SACH_SEQ.nextval, 'S2', 'CODE', 2, 2, 'CNTT', '2022-FEB-12', 'CODE LU', 10, 5, 15);
INSERT INTO SCOTT.PHAMMANH_SACH (S_ID, S_MA, S_TEN, ID_NXB, ID_TG, S_CHUDE, S_MOTA, S_SLCL, S_SLDM, S_TOTAL)
VALUES (PHAMMANH_SACH_SEQ.nextval, 'S3', 'CODE3', 2, 2, 'CNTT', 'CODE LU', 10, 5, 13);
SELECT *
FROM PHAMMANH_SACH;
alter table PHAMMANH_SACH
    add constraint PHAMMANH_SACH
        foreign key (ID_NXB) references PHAMMANH_NHAXUATBAN

alter table PHAMMANH_SACH
    add constraint PHAMMANH_SACH_TG
        foreign key (ID_TG) references PHAMMANH_TACGIA


DROP TABLE PHAMMANH_SACH;
DROP SEQUENCE PHAMMANH_SACH_SEQ;
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table PHAMMANH_BANDOC
(
    BD_ID       NUMBER(4)
        constraint PHAMMANH_BANDOC_PK
            primary key,
    BD_MA       VARCHAR2(255) UNIQUE,
    BD_TEN      VARCHAR2(255),
    BD_SDT      VARCHAR2(15),
    BD_DIACHI   VARCHAR2(500),
    BD_NGAYSINH DATE,
    BD_NGAYTAO  DATE,
    BD_HANG     INT
);
CREATE SEQUENCE PHAMMANH_BANDOC_SEQ
    START WITH 1
    INCREMENT BY 1
;
INSERT INTO SCOTT.PHAMMANH_BANDOC (BD_ID, BD_MA, BD_TEN, BD_SDT, BD_DIACHI, BD_NGAYSINH, BD_NGAYTAO, BD_HANG)
VALUES (PHAMMANH_BANDOC_SEQ.nextval, 'BD1', 'ANH', '097876575', 'VP',
        TO_DATE('2022-06-12 15:55:24', 'YYYY-MM-DD HH24:MI:SS'),
        TO_DATE('2022-08-12 15:55:32', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO SCOTT.PHAMMANH_BANDOC (BD_ID, BD_MA, BD_TEN, BD_SDT, BD_DIACHI, BD_NGAYSINH, BD_NGAYTAO, BD_HANG)
VALUES (PHAMMANH_BANDOC_SEQ.nextval, 'BD2', 'ANH', '097876575', 'VP',
        TO_DATE('2022-06-12 15:55:24', 'YYYY-MM-DD HH24:MI:SS'),
        TO_DATE('2022-08-12 15:55:32', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO SCOTT.PHAMMANH_BANDOC (BD_ID, BD_MA, BD_TEN, BD_SDT, BD_DIACHI, BD_NGAYSINH, BD_NGAYTAO, BD_HANG)
VALUES (PHAMMANH_BANDOC_SEQ.nextval, 'BD3', 'ANH', '097876575', 'VP',
        TO_DATE('2002-06-12 15:55:24', 'YYYY-MM-DD HH24:MI:SS'),
        TO_DATE('2002-08-12 15:55:32', 'YYYY-MM-DD HH24:MI:SS'), 2);


DROP TABLE PHAMMANH_BANDOC;
DROP SEQUENCE PHAMMANH_BANDOC_SEQ;
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
create table PHAMMANH_MUONSACH
(
    TG_ID          NUMBER(4)
        constraint PHAMMANH_MUONSACH_PK
            primary key,
    ID_BD          NUMBER(4),
    ID_S           NUMBER(4),
    MS_SL          INT,
    MS_NGAYGIOMUON DATE,
    MS_NGAYGIOTRA  DATE,
    MS_TRANGTHAI   INT,
    MS_GHICHU      VARCHAR2(500)
);
CREATE SEQUENCE PHAMMANH_MUONSACH_SEQ
    START WITH 1
    INCREMENT BY 1
;
INSERT INTO SCOTT.PHAMMANH_MUONSACH (TG_ID, ID_BD, ID_S, MS_SL, MS_NGAYGIOMUON, MS_NGAYGIOTRA, MS_TRANGTHAI, MS_GHICHU)
VALUES (PHAMMANH_MUONSACH_SEQ.nextval, 1, 1, 1, TO_DATE('2022-08-12 15:57:38', 'YYYY-MM-DD HH24:MI:SS'),
        TO_DATE('2022-08-13 15:57:46', 'YYYY-MM-DD HH24:MI:SS'), 0, null);
INSERT INTO SCOTT.PHAMMANH_MUONSACH (TG_ID, ID_BD, ID_S, MS_SL, MS_NGAYGIOMUON, MS_NGAYGIOTRA, MS_TRANGTHAI, MS_GHICHU)
VALUES (PHAMMANH_MUONSACH_SEQ.nextval, 1, 1, 1, TO_DATE('2022-08-12 15:57:38', 'YYYY-MM-DD HH24:MI:SS'),
        TO_DATE('2022-08-13 15:57:46', 'YYYY-MM-DD HH24:MI:SS'), 0, null);


DROP TABLE PHAMMANH_MUONSACH;
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE INDEX PHAMMANH_BANDOC_IDX_ID ON PHAMMANH_BANDOC (BD_ID);
CREATE INDEX PHAMMANH_SACH_IDX_ID ON PHAMMANH_SACH (S_ID);

--BAI5
SELECT DISTINCT TG.TG_MA, TG.TG_TEN, S.S_CHUDE, S.S_TOTAL
FROM PHAMMANH_TACGIA TG
         LEFT JOIN
     PHAMMANH_SACH S ON TG.TG_ID = S.ID_TG
ORDER BY S_TOTAL DESC;

--BAI6
SELECT S.S_MA,
       S.S_TEN,
       NXB.NXB_TEN,
       TG.TG_TEN,
       S.S_CHUDE,
       S.S_NAMXB,
       S.S_SLCL,
       S.S_SLDM,
       S.S_TOTAL
FROM PHAMMANH_SACH S
         LEFT JOIN PHAMMANH_NHAXUATBAN NXB ON S.ID_NXB = NXB.NXB_ID
         INNER JOIN PHAMMANH_TACGIA TG ON S.ID_TG = TG.TG_ID
WHERE ROWNUM < 10;

--BAI7
select BD_MA,bandoc.BD_TEN,S_MA,sach.S_TEN,MS_NGAYGIOMUON,S_SLDM from PHAMMANH_MUONSACH muonsach
                                                                         join PHAMMANH_BANDOC bandoc on muonsach.ID_BD = bandoc.BD_ID
                                                                         join PHAMMANH_SACH sach on muonsach.ID_S = sach.S_ID
order by MS_NGAYGIOMUON desc ;

--BAI 8.Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất tính từ đầu năm 2022
select S.S_MA, S.S_TEN, SUM(S.S_SLDM)
from PHAMMANH_SACH S join PHAMMANH_MUONSACH on S.S_ID = PHAMMANH_MUONSACH.ID_S
where ROWNUM<11 and to_char(PHAMMANH_MUONSACH.MS_NGAYGIOMUON,'yyyy')>=2022
group by S.S_MA, S.S_TEN
order by sum(S.S_SLDM) desc;

SELECT *
FROM PHAMMANH_MUONSACH


--10.Hiển thị thông tin bạn đọc gồm có:

SELECT B.BD_MA, B.BD_TEN, (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(B.BD_NGAYSINH, 'YYYY')) AS TUOI
FROM PHAMMANH_BANDOC B;

--11.Thống kê tổng số bạn đọc theo độ tuổi
SELECT (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(B.BD_NGAYSINH, 'YYYY')) AS TUOI,COUNT(B.BD_ID) AS SLBD
FROM PHAMMANH_BANDOC B
group by (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(B.BD_NGAYSINH, 'YYYY'));

--12.Thống kê số lượng sách được xuất bản theo Nhà Xuất Bản, Theo năm xuất bản.
SELECT S.S_NAMXB,X.NXB_MA,X.NXB_TEN,SUM(S.S_TOTAL) AS SLS
FROM PHAMMANH_SACH S INNER JOIN PHAMMANH_NHAXUATBAN X ON S.ID_NXB=X.NXB_ID
group by X.NXB_TEN, X.NXB_MA, S.S_NAMXB
ORDER BY S.S_NAMXB DESC ,X.NXB_TEN ASC;

--13.Hiển thị 5 quyển sách được các bạn đọc có độ tuổi từ 18 đến 25 mượn nhiều nhất tính từ đầu năm 2022. (Tính theo trường số lượng mượn của sách)
select BD_MA,bandoc.BD_TEN,S_MA,sach.S_TEN,MS_NGAYGIOMUON,S_SLDM from PHAMMANH_MUONSACH muonsach
                                                                          join PHAMMANH_BANDOC bandoc on muonsach.ID_BD = bandoc.BD_ID
                                                                          join PHAMMANH_SACH sach on muonsach.ID_S = sach.S_ID
WHERE (TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(bandoc.BD_NGAYSINH, 'YYYY')) BETWEEN 18 AND 25;

--14.Hiển thị toàn bộ bạn đọc và sách mà bạn đọc đấy mượn, sẽ có bạn chưa mượn vẫn cần hiển thị và tên sách để là null.
SELECT B.BD_MA,B.BD_TEN,S.S_TEN
    FROM PHAMMANH_BANDOC B JOIN PHAMMANH_MUONSACH M ON M.ID_BD=B.BD_ID
    RIGHT JOIN PHAMMANH_SACH S ON S.S_ID=M.ID_S;
