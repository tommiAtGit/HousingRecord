-- Do clean up
DROP TABLE IF EXISTS CustomerLevel;
DROP TABLE IF EXISTS UserAddress;
DROP TABLE IF EXISTS UserInformation;
DROP TABLE IF EXISTS HousingCooperative;
DROP TABLE IF EXISTS UserHousing;
DROP TABLE IF EXISTS UserElectricity;
DROP TABLE IF EXISTS UserAqua;
DROP TABLE IF EXISTS UserDefect;

-- Create user table
CREATE TABLE CustomerLevel
(
	-- id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	id INT NOT NULL,
	SecurityLevel        INT(1)      NOT NULL,
	LevelName  CHAR(10)	NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE UserAddress
(
	id INT NOT NULL,
	FirstName		CHAR(25)    NOT NULL,
	LastName        CHAR(50)    NOT NULL,
	eMail      		CHAR(80)	NOT NULL,
	PhoneNumber		CHAR(50)	NOT NULL,
	PRIMARY KEY (Id)
)ENGINE=INNODB;

CREATE TABLE UserInformation
(
	Id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	UserName        CHAR(25)	    NOT NULL,
	UserPwd        	CHAR(25)	NOT NULL,
	CustomerLevelId       INT,
	UserAddressId		INT,
	MessageNotice		INT(1)		NOT NULL,
	PRIMARY KEY (Id),
	INDEX user_ind(UserAddressId),
            FOREIGN KEY (UserAddressId) REFERENCES UserAddress(id)
              ON DELETE NO ACTION
              ON UPDATE NO ACTION,
	INDEX par_ind (CustomerLevelId),
            FOREIGN KEY (CustomerLevelId) REFERENCES CustomerLevel(id)
              ON DELETE NO ACTION
              ON UPDATE NO ACTION
	
)ENGINE=INNODB;


CREATE TABLE HousingCooperative
(
	Id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Name 		CHAR(80)    NOT NULL,
	Address		CHAR(50)    NOT NULL,
	PostNumber	CHAR(10)    NOT NULL,	
	City		CHAR(50)    NOT NULL,
	PRIMARY KEY (Id)
)ENGINE=INNODB;


CREATE TABLE UserHousing
(
	Id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	UserId					INT UNSIGNED NOT NULL,
	HousingId   			INT UNSIGNED NOT NULL,
	Apartment		CHAR(10)    NOT NULL,
	PRIMARY KEY (Id),
	INDEX housing_ind(HousingId),
            FOREIGN KEY (HousingId) REFERENCES HousingCooperative(Id)
              ON DELETE NO ACTION
              ON UPDATE NO ACTION,
	INDEX user_ind(UserId),
            FOREIGN KEY (UserId) REFERENCES UserInformation(Id)
              ON DELETE NO ACTION
              ON UPDATE NO ACTION
)
ENGINE=INNODB;

CREATE TABLE UserElectricity
(
	Id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	UserId			INT UNSIGNED NOT NULL,
	CouldWater		DOUBLE NOT NULL,
	HotWater		DOUBLE NOT NULL,
	MeasureDate 	DATE,
	PRIMARY KEY (Id),
	INDEX user_ind(UserId),
            FOREIGN KEY (UserId) REFERENCES UserInformation(Id)
              ON DELETE NO ACTION
              ON UPDATE NO ACTION
)
ENGINE=INNODB;

CREATE TABLE UserAqua
(
	Id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	UserId			INT UNSIGNED NOT NULL,
	CouldWater		DOUBLE NOT NULL,
	HotWater		DOUBLE NOT NULL,
	MeasureDate 	DATE,
	PRIMARY KEY (Id),
	INDEX user_ind(UserId),
            FOREIGN KEY (UserId) REFERENCES UserInformation(Id)
              ON DELETE NO ACTION
              ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- -----------------------------------------------------------------------------------
-- ************** Populate needed database tables with testdata *********************
-- -----------------------------------------------------------------------------------

SELECT * FROM CustomerLevel;
INSERT INTO CustomerLevel (id,SecurityLevel, LevelName)
  VALUES (1,10, "writer");
INSERT INTO CustomerLevel (id,SecurityLevel, LevelName)
  VALUES (2,20, "admin");
INSERT INTO CustomerLevel (id,SecurityLevel, LevelName)
  VALUES (3,30, "Super user");


SELECT * FROM UserAddress;
INSERT INTO UserAddress(id,FirstName,LastName,eMail,PhoneNumber)
  VALUES (1,"Tommi","Korteikko","tommi@kotona.fi","12345");

SELECT * FROM UserAddress;
INSERT INTO UserAddress(id,FirstName,LastName,eMail,PhoneNumber)
  VALUES (2,"Marianne","Korteikko","mari@kotona.fi","54321");

SELECT * FROM UserAddress;
INSERT INTO UserAddress(id,FirstName,LastName,eMail,PhoneNumber)
  VALUES (3,"Pirjo","Petrescu","pirjo@naapurissa.com","040-1234567");

SELECT * FROM UserInformation;
INSERT INTO UserInformation(UserName,UserPwd,CustomerLevelId,UserAddressId,MessageNotice)
  VALUES ("tommi","tommi_1",3,1,1);

SELECT * FROM UserInformation;
INSERT INTO UserInformation(UserName,UserPwd,CustomerLevelId,UserAddressId,MessageNotice)
  VALUES ("Marianne","mari",2,2,1);

SELECT * FROM UserInformation;
INSERT INTO UserInformation(UserName,UserPwd,CustomerLevelId,UserAddressId,MessageNotice)
  VALUES ("pirjo","pirjo",1,3,1);
  
SELECT * FROM HousingCooperative;
INSERT INTO HousingCooperative(Name,Address,PostNumber,City)
  VALUES ("As Oy Jyväskylän Mäntylehto","Koukonkuja 12","40420","Jyväskylä");

SELECT * FROM UserHousing;
INSERT INTO UserHousing(UserId,HousingId,Apartment)
  VALUES (1,1,"B12");
