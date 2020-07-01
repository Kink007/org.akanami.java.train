CREATE TABLE `aka`.`t_sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NULL,
  `birth` datetime(0) NULL,
  PRIMARY KEY (`id`)
);

insert into t_sys_user (name, birth) values ('admin', now());

CREATE TABLE `aka`.`t_sys_person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NULL,
  `birth` datetime(0) NULL,
  PRIMARY KEY (`id`)
);

insert into t_sys_person (name, birth) values ('admin', now());