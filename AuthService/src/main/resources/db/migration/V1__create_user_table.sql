CREATE TABLE users (
    id UUID PRIMARY KEY,
  	username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
  	email VARCHAR(100) NOT NULL UNIQUE,
    status INTEGER NOT NULL,
    type INTEGER NOT NULL,
    birthdate DATE NOT NULL,
    date_insert TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
