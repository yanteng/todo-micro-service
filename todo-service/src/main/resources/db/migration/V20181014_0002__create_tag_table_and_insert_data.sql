CREATE TABLE IF NOT EXISTS `tag`(
    `id` bigint(20) AUTO_INCREMENT,
    `name` VARCHAR(30),
    `user_id` bigint(20),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tag (name,user_id) VALUES('meeting',1);
INSERT INTO tag (name,user_id) VALUES('learing',1);
INSERT INTO tag (name,user_id) VALUES('Java',1);
INSERT INTO tag (name,user_id) VALUES('homework',1);
INSERT INTO tag (name,user_id) VALUES('coding',2);
INSERT INTO tag (name,user_id) VALUES('learing',2);
INSERT INTO tag (name,user_id) VALUES('Cpp',2);
INSERT INTO tag (name,user_id) VALUES('reading',2);