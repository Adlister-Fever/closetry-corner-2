DROP database closet_db;
DROP USER closet_user@localhost IDENTIFIED BY '1234';

CREATE database closet_db;

CREATE USER closet_user@localhost IDENTIFIED BY '1234';
GRANT ALL ON closet_db.* TO closet_user@localhost;

-- now run application to make tables

