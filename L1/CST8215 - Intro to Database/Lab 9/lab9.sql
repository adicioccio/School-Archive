---------------------------------------------------------------------------------[DDL FILE]---------------------------------------------------------------------------------

-- object: public."Book" | type: TABLE --
DROP TABLE IF EXISTS public.Book CASCADE;
CREATE TABLE public.Book(
	book_ID smallint NOT NULL,
	book_title varchar(30),
	author text,
	publisher text,
	CONSTRAINT Book_pk PRIMARY KEY (book_ID)

);
-- ddl-end --
ALTER TABLE public.Book OWNER TO postgres;
-- ddl-end --

-- object: public."Author" | type: TABLE --
DROP TABLE IF EXISTS public.Author CASCADE;
CREATE TABLE public.Author(
	author_name text NOT NULL,
	CONSTRAINT Author_pk PRIMARY KEY (author_name)

);
-- ddl-end --
ALTER TABLE public.Author OWNER TO postgres;
-- ddl-end --

-- object: public.publisher | type: TABLE --
DROP TABLE IF EXISTS public.publisher CASCADE;
CREATE TABLE public.publisher(
	publisher_name text NOT NULL,
	CONSTRAINT publisher_pk PRIMARY KEY (publisher_name)

);
-- ddl-end --
ALTER TABLE public.publisher OWNER TO postgres;
-- ddl-end --

-- object: public."Borrower" | type: TABLE --
DROP TABLE IF EXISTS public.Borrower CASCADE;
CREATE TABLE public.Borrower(
	borrower_name text NOT NULL,
	CONSTRAINT Borrower_pk PRIMARY KEY (borrower_name)

);
-- ddl-end --
ALTER TABLE public.Borrower OWNER TO postgres;
-- ddl-end --

-- object: "Author_fk" | type: CONSTRAINT --
ALTER TABLE public.Book DROP CONSTRAINT IF EXISTS Author_fk CASCADE;
ALTER TABLE public.Book ADD CONSTRAINT Author_fk FOREIGN KEY (author)
REFERENCES public.Author (author_name) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: publisher_fk | type: CONSTRAINT --
ALTER TABLE public.Book DROP CONSTRAINT IF EXISTS publisher_fk CASCADE;
ALTER TABLE public.Book ADD CONSTRAINT publisher_fk FOREIGN KEY (publisher)
REFERENCES public.publisher (publisher_name) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: public."Borrowed_book" | type: TABLE --
DROP TABLE IF EXISTS public.Borrowed_book CASCADE;
CREATE TABLE public.Borrowed_book(
	transaction_ID smallint NOT NULL,
	book_ID smallint,
	borrower_name text,
	book_copy_number smallint,
	CONSTRAINT Borrowed_book_pk PRIMARY KEY (transaction_ID)

);
-- ddl-end --
ALTER TABLE public.Borrowed_book OWNER TO postgres;
-- ddl-end --

-- object: "Book_fk" | type: CONSTRAINT --
ALTER TABLE public.Borrowed_book DROP CONSTRAINT IF EXISTS Book_fk CASCADE;
ALTER TABLE public.Borrowed_book ADD CONSTRAINT Book_fk FOREIGN KEY (book_ID)
REFERENCES public.Book (book_ID) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: "Borrower_fk" | type: CONSTRAINT --
ALTER TABLE public.Borrowed_book DROP CONSTRAINT IF EXISTS Borrower_fk CASCADE;
ALTER TABLE public.Borrowed_book ADD CONSTRAINT Borrower_fk FOREIGN KEY (borrower_name)
REFERENCES public.Borrower (borrower_name) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

---------------------------------------------------------------------------------[DML FILE]---------------------------------------------------------------------------------

--Author inserts
INSERT INTO Author VALUES ('J.K Rowling');
INSERT INTO Author VALUES ('Suzanne Collins');

--publisher inserts
INSERT INTO publisher VALUES ('Bloomsberg Publishing');
INSERT INTO publisher VALUES ('Scholastic Corporation');

--Borrower inserts
INSERT INTO Borrower VALUES ('Adam Di Cioccio');
INSERT INTO Borrower VALUES ('Osman Dirane');
INSERT INTO Borrower VALUES ('John Smith');

--Book inserts
INSERT INTO Book VALUES ('001', 'Harry Potter', 'J.K Rowling', 'Bloomsberg Publishing');
INSERT INTO Book VALUES ('002', 'The Hunger Games', 'Suzanne Collins', 'Scholastic Corporation');

--Borrowed_book inserts
INSERT INTO Borrowed_book VALUES ('1001', '001', 'John Smith', '01');
INSERT INTO Borrowed_book VALUES ('1002', '001', 'Adam Di Cioccio', '02');
INSERT INTO Borrowed_book VALUES ('1003', '002', 'Osman Dirane', '01');

--Select statements
SELECT * FROM Book;
SELECT * FROM Author;
SELECT * FROM publisher;
SELECT * FROM Borrower;
SELECT * FROM Borrowed_book;

--Join on statement
SELECT transaction_ID, Borrowed_book.borrower_name, Book.book_ID, book_title, book_copy_number, publisher, author FROM Borrowed_book 
LEFT JOIN Borrower ON Borrowed_book.borrower_name = Borrower.borrower_name
LEFT JOIN Book ON Borrowed_book.book_ID = Book.book_ID;

