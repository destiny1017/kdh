CREATE TABLE bbs_review (
	bbsId INT DEFAULT 0 NOT NULL,
	bbsTitle VARCHAR(50),
	userId VARCHAR(20),
	bbsDate DATETIME,
	bbsContent VARCHAR(2048),
	bbsCategories VARCHAR(20),
	img VARCHAR(50),
	star VARCHAR(20),
	PRIMARY KEY (bbsId)
) 

CREATE TABLE bbs_qa (
	bbsId INT DEFAULT 0 NOT NULL,
	bbsTitle VARCHAR(50),
	userId VARCHAR(20),
	bbsDate DATETIME,
	bbsContent VARCHAR(2048),
	bbsCategories VARCHAR(20),
	reply INT DEFAULT 0,
	renum INT,
	PRIMARY KEY (bbsId)
)

CREATE TABLE bbs_notice (
	bbsId INT DEFAULT 0 NOT NULL,
	bbsTitle VARCHAR(50),
	userId VARCHAR(20),
	bbsDate DATETIME,
	bbsContent VARCHAR(2048),
	bbsCategories VARCHAR(20),
	reply INT DEFAULT 0,
	renum INT,
	PRIMARY KEY (bbsId)
)

CREATE TABLE bbs_news (
	bbsId INT DEFAULT 0 NOT NULL,
	bbsTitle VARCHAR(50),
	userId VARCHAR(20),
	bbsDate DATETIME,
	bbsContent VARCHAR(2048),
	bbsCategories VARCHAR(20),
	reply INT DEFAULT 0,
	renum INT,
	PRIMARY KEY (bbsId)
)