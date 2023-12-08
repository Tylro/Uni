CREATE DATABASE IF NOT EXISTS QL_Thuvien;
USE QL_Thuvien;

-- Drop tables if they exist
DROP TABLE IF EXISTS Written_by;
DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Authors;

-- Create Authors table
CREATE TABLE Authors (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    birth INT NOT NULL
);

-- Create Books table
CREATE TABLE Books (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    author_ID INT NOT NULL,
    release_year INT NOT NULL,
    FOREIGN KEY (author_ID) REFERENCES Authors(ID)
);

-- Create Written_by table
CREATE TABLE Written_by (
    book_ID INT,
    author_ID INT,
    PRIMARY KEY (book_ID, author_ID),
    FOREIGN KEY (book_ID) REFERENCES Books(ID),
    FOREIGN KEY (author_ID) REFERENCES Authors(ID)
);

-- Insert data into the "Authors" table
INSERT INTO Authors (name, birth) VALUES
    ('J.K. Rowling', 1965),
    ('George R.R. Martin', 1948),
    ('Haruki Murakami', 1949),
    ('Jane Austen', 1775),
    ('Stephen King', 1947),
    ('Agatha Christie', 1890);

-- Insert data into the "Books" table
INSERT INTO Books (name, author_ID, release_year) VALUES
    ('Harry Potter and the Sorcerer''s Stone', 1, 1997),
    ('A Game of Thrones', 2, 1996),
    ('Norwegian Wood', 3, 1987),
    ('Pride and Prejudice', 4, 1813),
    ('The Shining', 5, 1977),
    ('Murder on the Orient Express', 6, 1934);

-- Insert data into the "Written_by" table
INSERT INTO Written_by (book_ID, author_ID) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6);


--Procedure 
-- 1 List all authors
DELIMITER //
CREATE PROCEDURE ListAllAuthors()
BEGIN
    SELECT * FROM Authors;
END //
DELIMITER ;
-- CALL ListAllAuthors();


-- 2 Add an author
DELIMITER //
CREATE PROCEDURE AddAuthor(IN author_name_param VARCHAR(255), IN birth_param INT)
BEGIN
    INSERT INTO Authors (name, birth) VALUES (author_name_param, birth_param);
END //
DELIMITER ;
-- CALL AddAuthor('New Author', 1990);


-- 3 Update author's details
DELIMITER //
CREATE PROCEDURE UpdateAuthorDetails(IN author_id_param INT, IN new_name_param VARCHAR(255), IN new_birth_param INT)
BEGIN
    UPDATE Authors SET name = new_name_param, birth = new_birth_param WHERE ID = author_id_param;
END //
DELIMITER ;
-- CALL UpdateAuthorDetails(2, 'Updated Author Name', 1985);

-- 4 Delete an author
DELIMITER //
CREATE PROCEDURE DeleteAuthor(IN author_id_param INT)
BEGIN
    DELETE FROM Authors WHERE ID = author_id_param;
END //
DELIMITER ;
-- CALL DeleteAuthor(4);


-- 5 FInd Author by ID
DELIMITER //
CREATE PROCEDURE FindAuthorById(IN author_id_param INT)
BEGIN
    SELECT * FROM Authors WHERE ID = author_id_param;
END //
DELIMITER ;
-- CALL FindAuthorById(1);


-- 6 Find Author by birth year
DELIMITER //
CREATE PROCEDURE FindAuthorByBirthYear(IN birth_year_param INT)
BEGIN
    SELECT * FROM Authors WHERE birth = birth_year_param;
END //
DELIMITER ;
-- CALL FindAuthorByBirthYear(1949);

-- List all Book
DELIMITER //
CREATE PROCEDURE ListAllBooks()
BEGIN
    SELECT * FROM Books;
END //
DELIMITER ;

-- Find book by ID
DELIMITER //
CREATE PROCEDURE FindBookByID(IN bookID INT)
BEGIN
    SELECT * FROM Books WHERE ID = bookID;
END //
DELIMITER ;

--Find book by year
DELIMITER //
CREATE PROCEDURE FindBookByYear(IN releaseYear INT)
BEGIN
    SELECT * FROM Books WHERE release_year = releaseYear;
END //
DELIMITER ;

-- Procedure to add a new book
DELIMITER //
CREATE PROCEDURE AddNewBook(
    IN bookName VARCHAR(255),
    IN authorID INT,
    IN releaseYear INT
)
BEGIN
    INSERT INTO Books (name, author_ID, release_year) VALUES (bookName, authorID, releaseYear);
END //
DELIMITER ;

-- Procedure to update book details
DELIMITER //
CREATE PROCEDURE UpdateBookDetails(
    IN bookID INT,
    IN newBookName VARCHAR(255),
    IN newAuthorID INT,
    IN newReleaseYear INT
)
BEGIN
    UPDATE Books 
    SET name = newBookName, author_ID = newAuthorID, release_year = newReleaseYear 
    WHERE ID = bookID;
END //
DELIMITER ;

-- Procedure to delete a book
DELIMITER //
CREATE PROCEDURE DeleteBook(
    IN bookID INT
)
BEGIN
    DELETE FROM Books WHERE ID = bookID;
END //
DELIMITER ;

-- CALL ListAllBooks();
-- CALL FindBookByID(1);
-- CALL AddNewBook('New Book', 2, 2023);
-- CALL UpdateBookDetails(1, 'Updated Book', 3, 2024);
-- CALL DeleteBook(1);
