CREATE TABLE IF NOT EXISTS user_role
(
    username  VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    PRIMARY KEY (username, role)
);

ALTER TABLE user_role
    ADD CONSTRAINT user_fk
        FOREIGN KEY (username)
            REFERENCES application_user;

ALTER TABLE user_role
    ADD CONSTRAINT role_fk
        FOREIGN KEY (role)
            REFERENCES role;