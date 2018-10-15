CREATE TABLE IF NOT EXISTS `todo_tag`(
    `todo_id` bigint(20),
    `tag_id` bigint(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO todo_tag (todo_id,tag_id) VALUES (1,4);
INSERT INTO todo_tag (todo_id,tag_id) VALUES (2,1);
INSERT INTO todo_tag (todo_id,tag_id) VALUES (3,2);
INSERT INTO todo_tag (todo_id,tag_id) VALUES (3,3);
INSERT INTO todo_tag (todo_id,tag_id) VALUES (4,1);
INSERT INTO todo_tag (todo_id,tag_id) VALUES (5,6);
INSERT INTO todo_tag (todo_id,tag_id) VALUES (5,7);
INSERT INTO todo_tag (todo_id,tag_id) VALUES (6,5);
INSERT INTO todo_tag (todo_id,tag_id) VALUES (7,8);