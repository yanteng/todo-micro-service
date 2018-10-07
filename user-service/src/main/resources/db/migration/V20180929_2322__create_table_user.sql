CREATE TABLE IF NOT EXISTS `user`(
    `id` bigint(20) AUTO_INCREMENT,
    `name` VARCHAR(30),
    `password` VARCHAR(30),
    PRIMARY KEY(`id`)
)