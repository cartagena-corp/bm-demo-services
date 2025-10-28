-- TABLA 1: users
CREATE TABLE users(
    numero_documento BIGINT NOT NULL PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL,
    password VARCHAR(500) NOT NULL
);
