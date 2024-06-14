-- table_cleaner.sql

DROP TABLE IF EXISTS account;

-- table_builder.sql

CREATE TABLE account (
    account_id serial PRIMARY KEY,
    login varchar(50) NOT NULL,
    password varchar(200) NOT NULL,
    email varchar(50) NOT NULL UNIQUE
);

-- test_data_inserter.sql

INSERT INTO account (login, password) VALUES
    ('Vlad', 'bn4gve91n', 'user.1@example.com'),
    ('NotDeveloper', 'ybkn65eamd1i', 'user.2@example.com'),
    ('Ninga352', 'n7b4,btuzg3r', 'user.3@example.com'),
    ('Artem', 'kbu87rn4tyxn', 'user.4@example.com'),
    ('QuickPencil', '1yke30mby6nrm', 'user.5@example.com');
