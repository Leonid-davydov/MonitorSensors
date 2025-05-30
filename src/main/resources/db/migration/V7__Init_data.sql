INSERT INTO type (name)
VALUES ('Pressure'),
       ('Voltage'),
       ('Temperature'),
       ('Humidity');

INSERT INTO unit (name)
VALUES ('bar'),
       ('voltage'),
       ('°C'),
       ('%');

INSERT INTO role (name)
VALUES ('Administrator'),
       ('Viewer');

INSERT INTO application_user (username, password)
VALUES ('admin', '{noop}admin'),
       ('user', '{noop}user');

INSERT INTO user_role (username, role)
VALUES ('admin', 'Administrator'),
       ('user', 'Viewer');