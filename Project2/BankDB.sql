/*
 * create tables
 */

CREATE TABLE user_types (
  id SERIAL PRIMARY KEY,
  user_role VARCHAR(255) NOT NULL
);

CREATE TABLE account_type (
  id SERIAL PRIMARY KEY,
  account_type_name VARCHAR(255) NOT NULL
);

CREATE TABLE transaction_types (
  id SERIAL PRIMARY KEY,
  transaction_types_name VARCHAR(255) NOT null
);


CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  user_name VARCHAR(255) NOT NULL UNIQUE,
  user_password VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  user_type_id INTEGER NOT NULL,
  FOREIGN KEY (user_type_id) REFERENCES user_types(id)
);

CREATE TABLE accounts (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  account_type_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (account_type_id) REFERENCES account_type(id)
);

CREATE TABLE transactions (
  id SERIAL PRIMARY KEY,
  account_id INTEGER NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  description VARCHAR(255),
  type_id INTEGER NOT NULL,
  FOREIGN KEY (account_id) REFERENCES accounts(id),
  FOREIGN KEY (type_id) REFERENCES transaction_types(id)
);

CREATE TABLE inner_transfer_logs (
  id SERIAL PRIMARY KEY,
  from_account_id INTEGER NOT NULL,
  to_account_id INTEGER NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (form_account_id) REFERENCES accounts(id),
  FOREIGN KEY (to_account_id) REFERENCES accounts(id)
);

/*
 *  Drop tables
 */

drop table user_types cascade;
drop table users cascade;
drop table accounts cascade;
drop table account_type cascade;
drop table inner_transfer_logs cascade;
drop table transactions cascade;
