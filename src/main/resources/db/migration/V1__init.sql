drop table if exists spring.account;
create table spring.account (id bigint not null auto_increment, password varchar(255), username varchar(255), primary key (id));
