#!/bin/sh
mysqladmin -u root --password=mySQLjgqb#19 create housingdb
mysql -u root --password=mySQLjgqb#19 housingdb < ./housing.sql
mysqlshow -u root --password=mySQLjgqb#19
mysqlshow -u root --password=mySQLjgqb#19 housingdb
mysql -u root --password=mySQLjgqb#19 -e "SELECT *FROM UserInformation"; housingdb
mysql -u root --password=mySQLjgqb#19 -e "SELECT *FROM UserAddress"; housingdb
mysql -u root --password=mySQLjgqb#19 -e "SELECT *FROM HousingCooperative"; housingdb
