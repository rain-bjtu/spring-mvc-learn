CREATE DATABASE IF NOT EXISTS test
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE test;

SET foreign_key_checks = 0;

CREATE TABLE IF NOT EXISTS groups (
  id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL UNIQUE,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS authorities (
  id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
  authority VARCHAR(30) NOT NULL UNIQUE,
  PRIMARY KEY (id)
) AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS group_authorities (
  group_id TINYINT UNSIGNED NOT NULL,
  authority_id TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (group_id, authority_id),
  CONSTRAINT fk_ga_group FOREIGN KEY (group_id)
    REFERENCES groups (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_ga_authority FOREIGN KEY (authority_id)
    REFERENCES authorities (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL UNIQUE,
  password CHAR(100) NOT NULL,
  regist_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  group_id TINYINT UNSIGNED,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_group FOREIGN KEY (group_id)
    REFERENCES groups (id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS token (
  series VARCHAR(64) NOT NULL,
  username VARCHAR(50) NOT NULL,
  token VARCHAR(64) NOT NULL,
  last_used TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (series),
  CONSTRAINT fk_token_user FOREIGN KEY (username)
    REFERENCES users (name)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


TRUNCATE group_authorities;
TRUNCATE groups;
TRUNCATE authorities;
TRUNCATE users;

SET foreign_key_checks = 1;

INSERT INTO groups(name) VALUES ('Users');
INSERT INTO groups(name) VALUES ('Administrators');

INSERT INTO authorities(authority) VALUES ('ROLE_USER');
INSERT INTO authorities(authority) VALUES ('ROLE_ADMIN');

INSERT INTO users(name, password) VALUES ('admin','10:c065497d28282e6e3bc7e6fe4f2bd765df6a8b0637585862:fbb43f6cedcddcd9eefb22e5a84284f92aca29d74aa40f47');
INSERT INTO users(name, password) VALUES ('guest','10:c065497d28282e6e3bc7e6fe4f2bd765df6a8b0637585862:fbb43f6cedcddcd9eefb22e5a84284f92aca29d74aa40f47');

UPDATE users SET group_id=(SELECT id FROM groups WHERE name='Users') WHERE name='guest';
UPDATE users SET group_id=(SELECT id FROM groups WHERE name='Administrators') WHERE name='admin';

INSERT INTO group_authorities(group_id, authority_id) SELECT g.id,a.id FROM groups g, authorities a WHERE g.name='Users' AND a.authority='ROLE_USER';
INSERT INTO group_authorities(group_id, authority_id) SELECT g.id,a.id FROM groups g, authorities a WHERE g.name='Administrators' AND a.authority='ROLE_USER';
INSERT INTO group_authorities(group_id, authority_id) SELECT g.id,a.id FROM groups g, authorities a WHERE g.name='Administrators' AND a.authority='ROLE_ADMIN';

