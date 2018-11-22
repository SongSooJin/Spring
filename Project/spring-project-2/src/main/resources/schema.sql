drop table if exists product;

create table product (
	product_id bigint identity not null primary key,
	product_name varchar(40),
	product_price bigint
--	product_deliveryCharge int,
--	product_seller varchar(40),
--	product_courier varchar(40),
--	product_size varchar(10),
--	product_color varchar(20),
);