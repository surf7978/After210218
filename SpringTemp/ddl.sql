create table PRODUCT_TBL_10 (
	product_id           number(6) not null primary key,
	product_name       varchar2(20),
	product_price       number,
	product_info        varchar2(2000),
	product_date       date,
	company	            varchar2(50),
	manager_id          varchar2(12)
);

create table SALE_TBL_10 (
	SALE_SEQ                       number,
	SALE_DATE                      date,
	PRODUCT_ID                    number,
	SALE_QTY                       number,
	SALE_PRICE                      number,
	MEMBER_ID                     varchar2(12),
	primary key(SALE_SEQ)
);

insert into PRODUCT_TBL_10 (product_id,product_name,product_price,product_info ,product_date ,company,manager_id  )
                         values (1001, 'TVU45',4000, '삼성 45인치 UHD TV', '20/01/10', '삼성', 'E201');
insert into PRODUCT_TBL_10 (product_id,product_name,product_price,product_info ,product_date ,company,manager_id  )
                         values (1002, 'TVU45_LG', 3500, 'LG 45인치 UHD TV', '20/02/10', 'LG', 'E202');
insert into PRODUCT_TBL_10 (product_id,product_name,product_price,product_info ,product_date ,company,manager_id  )
                         values (1003, 'IPHON9', 2500, '스마트폰 아이폰 9', '20/03/15', '애프', 'E201');
insert into PRODUCT_TBL_10 (product_id,product_name,product_price,product_info ,product_date ,company,manager_id  )
                         values (1004, 'SMNOTE9', 3000, '스마트폰 삼성노트9', '20/04/10', '삼성', 'E201');


insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (3001, '18/09/04', 1004, 4, 12000, '홍길동');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30002, '18/09/05', 1003, 2, 5000, '김유신');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30003, '18/09/05', 1001, 1, 4000, '이기자');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30004, '18/09/06', 1002, 1, 35000, '이순신');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30005, '18/09/06', 1001, 4, 12000, '홍길동');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30006, '18/09/06', 1002, 3, 10500, '김유신');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30007, '18/09/07', 1003, 2, 5000, '이순신');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30008, '18/09/07', 1001, 5, 20000, '이기자');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30009, '18/09/07', 1002, 4, 14000, '김유신');
insert into SALE_TBL_10 (SALE_SEQ, SALE_DATE, PRODUCT_ID, SALE_QTY, SALE_PRICE ,MEMBER_ID  )
                         values (30010, '18/09/07', 1003, 4, 10000, '홍길동');
