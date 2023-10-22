-- !Ups

CREATE TABLE `users` (
  `user_id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL
);

INSERT INTO `users` (`name`) VALUES ('lyoz');

-- !Downs

DROP TABLE `users`;
