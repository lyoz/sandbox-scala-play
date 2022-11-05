-- !Ups

ALTER TABLE users MODIFY user_id INT AUTO_INCREMENT;

-- !Downs

ALTER TABLE users MODIFY user_id INT;
