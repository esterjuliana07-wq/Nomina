CREATE DATABASE secure_login_db2;
USE secure_login_db2;

CREATE TABLE users1 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password_hash VARCHAR(255)
);

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';
FLUSH PRIVILEGES;


select * from users1
