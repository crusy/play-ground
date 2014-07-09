# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table list (
  id                        bigint auto_increment not null,
  name                      varchar(255) not null,
  constraint pk_list primary key (id))
;

create table task (
  id                        bigint auto_increment not null,
  text                      varchar(255) not null,
  list_id                   bigint,
  done                      tinyint(1) default 0,
  constraint pk_task primary key (id))
;

alter table task add constraint fk_task_list_1 foreign key (list_id) references list (id) on delete restrict on update restrict;
create index ix_task_list_1 on task (list_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table list;

drop table task;

SET FOREIGN_KEY_CHECKS=1;

