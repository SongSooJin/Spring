drop table if exists product;

create table product (
	product_id bigint identity not null primary key,
	product_name varchar(40),
	product_price bigint,
	product_image varchar(40),
	product_detail text,
	WRITER VARCHAR(100) DEFAULT NULL,
	TITLE VARCHAR(255) DEFAULT NULL,
	CONTENT CLOB DEFAULT NULL,
	REG_DATE TIMESTAMP DEFAULT NULL,
	HIT_COUNT BIGINT DEFAULT 0
--	product_deliveryCharge int,
--	product_seller varchar(40),
--	product_courier varchar(40),
--	product_size varchar(10),
--	product_color varchar(20),
);