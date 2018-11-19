create table shoppingproduct (
	product_name varchar(40),
	product_id  int,
	primary key(product_id),
	product_price int,
	product_deliveryCharge int,
	product_seller varchar(40),
	product_courier varchar(40),
	product_size varchar(10),
	product_color varchar(20),
	product_count int
);