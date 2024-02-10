create table if not exists group (
	id                  bigint not null,
	name                varchar(255) not null,
	constraint product_type_pk primary key (id)
);
create sequence if not exists group_sequence start 1 increment 1;

create table if not exists user (
	id                  bigint not null,
	name                varchar(255) not null,
	email               varchar(255) not null,
	constraint user_pk primary key (id)
);
create sequence if not exists user_sequence start 1 increment 1;

create table if not exists role (
	id                  bigint not null,
	name                varchar(255) not null,
	constraint role_pk primary key (id)
);
create sequence if not exists role_sequence start 1 increment 1;

create table if not exists category (
	id                  bigint not null,
	name                varchar(255) not null,
	description         varchar(255) not null,
	group_id            bigint not null,
	constraint category_pk primary key (id),
	constraint category_group_id_fk foreign key (group_id) references group(id),
);
create sequence if not exists category_sequence start 1 increment 1;

create table if not exists category_user_role (
	category_id         bigint not null,
	user_id             bigint not null,
	role_id             bigint not null,
	UNIQUE(category_id, user_id, role_id)
);