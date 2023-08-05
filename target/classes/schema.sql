create table author
(
    full_name varchar(255) null,
    id        int auto_increment
        primary key
);

create table book
(
    id          int auto_increment
        primary key,
    title       varchar(255) not null,
    n_pages     int          not null,
    price       int          not null,
    copies_sold int          not null,
    year        int          not null
);

create table author_book
(
    author_id int null,
    book_id   int null,
    constraint author_book_author_id_fk
        foreign key (author_id) references author (id),
    constraint author_book_book_id_fk
        foreign key (book_id) references book (id)
);

