insert into hquer (firstname, lastname, username, email, password) values ('张', '三', 'zhangsan', 'craig@habuma.com', '8888');
insert into hquer (firstname, lastname, username, email, password) values ('李', '四', 'lisi', 'lisi@163.com', '8888');

insert into message(username,message,postedTime) values('zhangsan','这是测试消息1来自用户1发表','2018-06-09 22:00:00Z');
insert into message(username,message,postedTime) values('zhangsan','这是测试消息2来自用户1发表','2017-06-09 22:00:00Z');
insert into message(username,message,postedTime) values('lisi','这是测试消息1来自用户2发表','2016-06-09 22:00:00Z');
insert into message(username,message,postedTime) values('lisi','这是测试消息2来自用户2发表','2019-06-09 22:00:00Z');

INSERT INTO user VALUES ('1', 'admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '管理员', 'admin@liuyanzhao.com', null, null, null, 'normal'), ('2', 'saysky', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '言曌', '847064370@qq.com', null, null, null, 'normal'), ('3', 'lockuser', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '锁定账号', 'locked@qq.com', null, null, null, 'locked');

insert INTO authority VALUES ('1', 'ROLE_ADMIN'), ('2', 'ROLE_USER');
INSERT INTO user_authority VALUES ('1', '1'), ('2', '2'), ('1', '2');
--
-------
---- Create the Groups
--insert into groups(group_name) values ('Users');
--insert into groups(group_name) values ('Administrators');
--
-------
---- Map the Groups to Roles
--insert into group_authorities(group_id, authority) select id,'ROLE_USER' from groups where group_name='Users';
---- Administrators are both a ROLE_USER and ROLE_ADMIN
--insert into group_authorities(group_id, authority) select id,'ROLE_USER' from groups where group_name='Administrators';
--insert into group_authorities(group_id, authority) select id,'ROLE_ADMIN' from groups where group_name='Administrators';
--
-------
---- Map the users to Groups
--insert into group_members(group_id, username) select id,'user1@example.com' from groups where group_name='Users';
--insert into group_members(group_id, username) select id,'admin1@example.com' from groups where group_name='Administrators';
--insert into group_members(group_id, username) select id,'user2@example.com' from groups where group_name='Users';
--insert into group_members(group_id, username) select id,'disabled1@example.com' from groups where group_name='Users';
--
--
----insert into users (username,password,enabled) values ('user1@example.com','user1',1);
----insert into users (username,password,enabled) values ('admin1@example.com','admin1',1);
----insert into users (username,password,enabled) values ('user2@example.com','admin1',1);
----insert into users (username,password,enabled) values ('disabled1@example.com','disabled1',0);
