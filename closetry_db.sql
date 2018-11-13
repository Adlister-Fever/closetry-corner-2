CREATE database closet_db;

CREATE USER closet_user@localhost IDENTIFIED BY '1234';
GRANT ALL ON closet_db.* TO closet_user@localhost;

-- CREATE TABLE users (
--     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--     username VARCHAR(50),
--     password VARCHAR(100),
--     email VARCHAR(30),
--      PRIMARY KEY (id)
-- );
--
-- CREATE TABLE garments (
--     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--     garment_type VARCHAR(100),
--     image VARCHAR(100),
--     date_last_worn VARCHAR(15)
-- );
--
-- CREATE TABLE category (
--     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--     name VARCHAR(100)
-- );
--
-- CREATE TABLE outfit (
--     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--     description VARCHAR(100),
--     date_planned VARCHAR(15)
-- );

