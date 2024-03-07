create database NBK;
use NBK;
CREATE TABLE Customers (
  id BIGINT PRIMARY KEY not null   ,
  first_name VARCHAR(77) NOT NULL
);

INSERT INTO Customers VALUES (1,'sohaila'),(2,'mohamed'),(3,'nour'),(4,'shrouk'),(5,'marianne');

CREATE TABLE Global_Limits (
  channelid VARCHAR(255) PRIMARY KEY NOT NULL,
  Min_TXN_Limit int NOT NULL,
  Max_TXN_LIMIT int NOT NULL,
  Daily_Limit int NOT NULL,
  Weekly_Limit int NOT NULL,
  Monthly_Limit int NOT NULL,
  debit_limit DECIMAL(10,2) NOT NULL,
  credit_limit DECIMAL(10,2) NOT NULL 
);
INSERT INTO global_limits VALUES ('IPN', 1, 120000, 570000, 40000, 330000, 70000, 50000),
       ('Teller (Branch)',1, 30000, 50000, 70000, 170000, 100000, 300000),
       ('ATM', 1, 15000, 77000, 90000, 15000, 200000, 2300000),
       ('Digital', 1, 33000, 50000, 70000, 90000, 13000, 17000),
       ('Cash', 1, 15000, 25000, 55000, 350000, 370000,57000);

CREATE TABLE Customer_Limits (
  id BIGINT not null ,
  channel VARCHAR(255) NOT NULL ,
  current_daily_txn int Not null,
  current_weekly_txn int Not null,
  current_monthly_txn int Not null,
  PRIMARY KEY (id, channel),
  FOREIGN KEY (id) REFERENCES Customers(id),
  FOREIGN KEY (channel) REFERENCES Global_Limits(channelid)
);  

CREATE TABLE Transactions (
  id BIGINT NOT NULL,
  channelid VARCHAR(255) NOT NULL,
  amount DECIMAL(10,2) NOT NULL,
  currency VARCHAR(255) NOT NULL,
  transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  FOREIGN KEY (id) REFERENCES Customers(id),
  FOREIGN KEY (channelid) REFERENCES Customer_Limits(channel)
);
