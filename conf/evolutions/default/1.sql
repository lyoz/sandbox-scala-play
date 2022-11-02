-- !Ups

CREATE TABLE users (
  user_id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

-- !Downs

DROP TABLE users;
