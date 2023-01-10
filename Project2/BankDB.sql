/*
 * create tables
 */
create table status(
  id SERIAL PRIMARY KEY,
  status_type varchar(50) not null
);

CREATE TABLE account_type (
  id SERIAL PRIMARY KEY,
  account_type_name VARCHAR(50) NOT NULL
);

CREATE TABLE transaction_types (
  id SERIAL PRIMARY KEY,
  transaction_types_name VARCHAR(50) NOT null
);


CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  user_name VARCHAR(255) NOT NULL UNIQUE,
  user_password VARCHAR(255) NOT NULL,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  address VARCHAR(255),
  email VARCHAR(255)
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
  FOREIGN KEY (from_account_id) REFERENCES accounts(id),
  FOREIGN KEY (to_account_id) REFERENCES accounts(id)
);

create table requests(
  id serial primary key,
  from_account_id integer,
  from_user_id integer,
  to_account_id integer,
  to_user_id integer,
  amount decimal(10,2),
  reason varchar(255),
  status_id integer,
  foreign key (from_account_id) references accounts(id),
  foreign key (to_account_id) references accounts(id),
  foreign key (from_user_id) references users(id),
  foreign key (to_user_id) references users(id),
  foreign key (status_id) references status(id)
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
drop table requests cascade;