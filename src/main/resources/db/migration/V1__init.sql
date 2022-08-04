drop table if exists spring.account;
drop table if exists spring.hibernate_sequence;
create table spring.account (id bigint not null, password varchar(255), username varchar(255), primary key (id));
create table spring.hibernate_sequence (next_val bigint);
insert into spring.hibernate_sequence values ( 1 );