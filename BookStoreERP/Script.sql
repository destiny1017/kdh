--<ScriptOptions statementTerminator=";"/>

CREATE TABLE total_sale (
	isbn VARCHAR(50) NOT NULL,
	salesVolume INT,
	PRIMARY KEY (isbn)
) ENGINE=InnoDB;

CREATE TABLE books (
	ISBN VARCHAR(50) NOT NULL,
	classification VARCHAR(50),
	title VARCHAR(100),
	publisher VARCHAR(50),
	writer VARCHAR(300),
	price INT,
	PRIMARY KEY (ISBN)
) ENGINE=InnoDB;

CREATE TABLE order_detail (
	no INT,
	isbn VARCHAR(50),
	quantity INT
) ENGINE=InnoDB;

CREATE TABLE books_order (
	no INT NOT NULL,
	TS TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
	publisher VARCHAR(50),
	PRIMARY KEY (no)
) ENGINE=InnoDB;

CREATE TABLE books_stock (
	isbn VARCHAR(50) NOT NULL,
	stock INT,
	PRIMARY KEY (isbn)
) ENGINE=InnoDB;

CREATE TABLE test (
	ts TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL
) ENGINE=InnoDB;

