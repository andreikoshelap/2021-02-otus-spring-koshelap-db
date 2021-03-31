DROP TABLE IF EXISTS AUTHOR;
CREATE TABLE AUTHOR(ID BIGINT PRIMARY KEY, FIRST_NAME VARCHAR(50), LAST_NAME VARCHAR(50) NOT NULL);

DROP TABLE IF EXISTS GENRE;
CREATE TABLE GENRE(ID BIGINT PRIMARY KEY, GENRE_NAME VARCHAR(50) NOT NULL);

DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK(ID BIGINT PRIMARY KEY, NAME VARCHAR(255) NOT NULL, AUTHOR_ID bigint not null, GENRE_ID bigint not null,
FOREIGN key (AUTHOR_ID) REFERENCES AUTHOR(ID),  FOREIGN key (GENRE_ID) REFERENCES GENRE(ID));

DROP TABLE IF EXISTS COMMENT;
CREATE TABLE COMMENT(ID BIGINT PRIMARY KEY, BOOK_ID bigint not null, COMMENT_TEXT VARCHAR2(1000) NOT NULL,
FOREIGN key (BOOK_ID) REFERENCES BOOK(ID));

CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;