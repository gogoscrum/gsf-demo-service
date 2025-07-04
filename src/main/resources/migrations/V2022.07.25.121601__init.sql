CREATE TABLE `user` (
  `id` SERIAL,
  `username` VARCHAR(50) NOT NULL COMMENT 'Global unique username',
  `nickname` VARCHAR(50) NOT NULL COMMENT 'User nickname',
  `password` VARCHAR(256) NOT NULL COMMENT 'Encrypted password',
  `avatar` VARCHAR(256) NULL COMMENT 'Avatar image URL',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Account enabled?',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created time',
  `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Updated time',
  `created_by_user_id` BIGINT(20) NULL COMMENT 'User ID of creator',
  `updated_by_user_id` BIGINT(20) NULL COMMENT 'User ID of updater',
  PRIMARY KEY (`id`)
) COMMENT='User table';

INSERT INTO `user` (`id`, `username`, `nickname`, `password`)
VALUES (1, 'admin', 'admin', '$2a$04$a1a4/L6yERVNoBdu.PJxCOUKnxAGJE8Y5reneFdMcrBP.noUiu6CK');

CREATE TABLE `book` (
  `id` SERIAL,
  `title` VARCHAR(200) NOT NULL COMMENT 'Book title',
  `subtitle` VARCHAR(200) NOT NULL COMMENT 'Subtitle',
  `isbn` VARCHAR(50) NULL COMMENT 'ISBN',
  `author` VARCHAR(100) NULL COMMENT 'Author',
  `intro` VARCHAR(2048) NULL COMMENT 'Brief introduction',
  `price` FLOAT(8,2) NULL COMMENT 'Price',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Created time',
  `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Updated time',
  `created_by_user_id` BIGINT(20) NULL COMMENT 'User ID of creator',
  `updated_by_user_id` BIGINT(20) NULL COMMENT 'User ID of updater',
  PRIMARY KEY (`id`)
) COMMENT='Book table';

INSERT INTO `book` (title, subtitle, isbn, author, intro, price, created_by_user_id, updated_by_user_id) VALUES
('Learn Java in 7 Days','You should never miss this','J2948472-99847','Jimmy Lu','A wonderful journey',22.50, 1, 1),
('JavaScript in Action','Best JavaScript book for Starters','T948272-Y9472','Jimmy Lu','Start coding from JavaScript',35.00, 1, 1),
('Fishing 101','From newbie to expert in 3 days','J-9894732-948R86','Tom Smith','Teach you how to fish like an expert',55.00, 1, 1);
