-- Name: sql_example_solutions.sql
-- Author: Edges For Training
-- Description: SQL Examples Solution
-- 1. Create a new database called 'car_store' and switch to it
CREATE DATABASE car_store;
USE car_store;

-- 2. Create a table called 'countries' to hold country names and their currencies
CREATE TABLE countries (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
country_name VARCHAR(30) NOT NULL,
currency VARCHAR(15) NOT NULL
);

-- 3. Insert some sample countries and currencies
INSERT INTO countries (country_name, currency) VALUES
('USA', 'USD'),
('Germany', 'Euro'),
('Japan', 'Yen');

-- 4. Create a table called 'car' with price, stock, country, name, and model
CREATE TABLE car (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(20) NOT NULL,
model VARCHAR(20) NOT NULL,
price DECIMAL(10,2) NOT NULL,
stock INT NOT NULL,
country_id INT NOT NULL,
FOREIGN KEY (country_id) REFERENCES countries(id)
);

-- 5. Insert some car entries
INSERT INTO car (name, model, price, stock, country_id) VALUES
('Toyota', 'Corolla', 20000.00, 10, 3),
('Ford', 'Mustang', 35000.00, 5, 1),
('BMW', 'X5', 60000.00, 3, 2);

-- 6. Show all cars with their country and currency (using INNER JOIN)
SELECT
car.id,
car.name,
car.model,
car.price,
car.stock,
countries.country_name,
countries.currency
FROM car
INNER JOIN countries ON car.country_id = countries.id;

-- 7. Retrieve cars with price above 30000 and show country info (INNER JOIN + WHERE)
SELECT
car.name,
car.model,
car.price,
countries.country_name,
countries.currency
FROM car
INNER JOIN countries ON car.country_id = countries.id
WHERE car.price > 30000;

-- 8. Count cars stocked per country (GROUP BY + JOIN)
SELECT
countries.country_name,
COUNT(car.id) AS car_count,
SUM(car.stock) AS total_stock
FROM countries
INNER JOIN car ON car.country_id = countries.id
GROUP BY countries.country_name;

-- 9. List all countries even if they don't have car entries (LEFT JOIN)
SELECT
countries.country_name,
car.name,
car.model
FROM countries
LEFT JOIN car ON car.country_id = countries.id;

-- 10. Find car models and their currency (JOIN for currency info)
SELECT
car.name,
car.model,
countries.currency
FROM car
INNER JOIN countries ON car.country_id = countries.id;