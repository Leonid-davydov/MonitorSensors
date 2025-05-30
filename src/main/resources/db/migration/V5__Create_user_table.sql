CREATE TABLE IF NOT EXISTS application_user
(
    username         VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
)