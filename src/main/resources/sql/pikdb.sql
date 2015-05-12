CREATE TABLE users
(
  id BIGINT UNSIGNED NOT NULL,
  name VARCHAR(40) NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE groups
(
  id BIGINT UNSIGNED NOT NULL,
  name VARCHAR(40),
  user_name VARCHAR(40) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE products
(
  id BIGINT UNSIGNED NOT NULL,
  name VARCHAR(40),
  price INT,
  info VARCHAR(140),
  category VARCHAR(20),
  rating DOUBLE,
  PRIMARY KEY (id)
);

CREATE TABLE orders
(
  id BIGINT UNSIGNED NOT NULL,
  creation_date DATE,
  status VARCHAR(20),
  total INT,
  user_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id)
  REFERENCES users(id)
);

CREATE TABLE carts
(
  items_number INT,
  total INT,
  user_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (user_id)
  REFERENCES users(id)
);

CREATE TABLE items
(
  quantity INT,
  cart_id BIGINT UNSIGNED NOT NULL,
  product_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (cart_id)
  REFERENCES carts(user_id),
  FOREIGN KEY (product_id)
  REFERENCES products(id)
);

CREATE TABLE opinions
(
  rating INT,
  comment VARCHAR(140),
  user_id BIGINT UNSIGNED NOT NULL,
  product_id BIGINT UNSIGNED NOT NULL,
  FOREIGN KEY (user_id)
  REFERENCES users(id),
  FOREIGN KEY (product_id)
  REFERENCES products(id)
);
