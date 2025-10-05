------------------------------------------------
-- Name: sql_assignment_solutions.sql
-- Auther: Edges For Training
-- Description: SQL Labs Solution
------------------------------------------------

-- 1. Create a new database called 'blog' and switch to it
CREATE DATABASE blog;
USE blog;

-- 2. Create a table called 'users' with required fields
CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(15) NOT NULL,
    username VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL
);

-- 3. Insert two users into the 'users' table
INSERT INTO users (first_name, last_name, username, email) VALUES
('Edges', 'Training', 'edges', 'edges@edges.com'),
('John', 'Doe', 'john', 'john@edges.com');

-- 4. Retrieve all users to confirm data insertion
SELECT * FROM users;

-- 5. Create a 'posts' table with a foreign key to the 'users' table
CREATE TABLE posts (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 6. Insert a post written by user with id = 1
INSERT INTO posts (content, user_id) VALUES
('Kindly fill the course’s feedback form', 1);

-- 7. Create a 'comments' table with foreign keys to 'users' and 'posts'
CREATE TABLE comments (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (post_id) REFERENCES posts(id)
);

-- 8. Insert a comment written by user 2 on post 1
INSERT INTO comments (content, user_id, post_id) VALUES
('will do!', 2, 1);

-- 9. Select all posts with their associated users
SELECT
    users.id AS user_id,
    users.username,
    posts.id AS post_id,
    posts.content AS post_content
FROM users
INNER JOIN posts ON users.id = posts.user_id;

-- 10. Select all posts with their users and any comments on those posts
SELECT
    users.id AS user_id,
    users.username,
    posts.id AS post_id,
    posts.content AS post_content,
    comments.content AS comment_content
FROM posts
INNER JOIN users ON users.id = posts.user_id
INNER JOIN comments ON comments.post_id = posts.id;
