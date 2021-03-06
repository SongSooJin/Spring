drop table if exists product;

create table product (
	product_id bigint identity not null primary key,
	product_name varchar(40),
	product_price bigint,
	product_deliveryCharge varchar(40),
	product_image varchar(40),
	product_detail text,
	product_seller varchar(40),
	product_size varchar(40),
	product_color varchar(40),
	product_count bigint,
	hit_count bigint default 0
);
