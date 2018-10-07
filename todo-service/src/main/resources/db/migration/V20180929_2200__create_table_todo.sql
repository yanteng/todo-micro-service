CREATE TABLE IF NOT EXISTS `todo`(
    `id` bigint(20) AUTO_INCREMENT,
    `name` VARCHAR(30),
    `status` VARCHAR(30),
    `due_date` TIMESTAMP,
    `user_id` bigint(20),
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;