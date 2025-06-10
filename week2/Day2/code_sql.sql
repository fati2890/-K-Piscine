-- Library Management System Database Implementation
-- Create Database
CREATE DATABASE LibraryManagementSystem;
USE LibraryManagementSystem;

-- Table: PERSON (Base table for all users)
CREATE TABLE PERSON (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Table: MEMBER
CREATE TABLE MEMBER (
    member_id VARCHAR(20) PRIMARY KEY,
    person_id INT NOT NULL,
    membership_date DATE NOT NULL,
    membership_type ENUM('STANDARD', 'PREMIUM', 'STUDENT') DEFAULT 'STANDARD',
    status ENUM('ACTIVE', 'SUSPENDED', 'EXPIRED') DEFAULT 'ACTIVE',
    FOREIGN KEY (person_id) REFERENCES PERSON(person_id) ON DELETE CASCADE
);

-- Table: LIBRARIAN
CREATE TABLE LIBRARIAN (
    employee_id VARCHAR(20) PRIMARY KEY,
    person_id INT NOT NULL,
    hire_date DATE NOT NULL,
    department VARCHAR(50),
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
    FOREIGN KEY (person_id) REFERENCES PERSON(person_id) ON DELETE CASCADE
);

-- Table: ADMIN
CREATE TABLE ADMIN (
    admin_id VARCHAR(20) PRIMARY KEY,
    person_id INT NOT NULL,
    access_level INT DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES PERSON(person_id) ON DELETE CASCADE
);


-- Table: BOOK
CREATE TABLE BOOK (
    book_id VARCHAR(20) PRIMARY KEY,
    isbn VARCHAR(17) UNIQUE NOT NULL,
    title VARCHAR(200) NOT NULL,
    publisher VARCHAR(100),
    publish_year INT,
    genre VARCHAR(50),
    total_copies INT NOT NULL DEFAULT 1,
    available_copies INT NOT NULL DEFAULT 1,
    location VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CHECK (available_copies <= total_copies AND available_copies >= 0)
);

-- Table: BORROW
CREATE TABLE BORROW (
    borrow_id VARCHAR(20) PRIMARY KEY,
    member_id VARCHAR(20) NOT NULL,
    book_id VARCHAR(20) NOT NULL,
    borrow_date DATE NOT NULL,
    due_date DATE NOT NULL,
    return_date DATE NULL,
    status ENUM('ACTIVE', 'RETURNED', 'OVERDUE', 'RENEWED') DEFAULT 'ACTIVE',
    fine_amount DECIMAL(10,2) DEFAULT 0.00,
    processed_by VARCHAR(20),
    FOREIGN KEY (member_id) REFERENCES MEMBER(member_id),
    FOREIGN KEY (book_id) REFERENCES BOOK(book_id),
    FOREIGN KEY (processed_by) REFERENCES LIBRARIAN(employee_id)
);
