create table if not exists tb_group (
	id                  bigint not null,
	name                varchar(255) not null,
	constraint product_type_pk primary key (id)
);
create sequence if not exists group_sequence start 1 increment 1;

create table if not exists tb_user (
	id                  bigint not null,
	name                varchar(255) not null,
	email               varchar(255) not null,
	constraint user_pk primary key (id)
);
create sequence if not exists user_sequence start 1 increment 1;

create table if not exists tb_role (
	id                  bigint not null,
	name                varchar(255) not null,
	constraint role_pk primary key (id)
);
create sequence if not exists role_sequence start 1 increment 1;

create table if not exists tb_category (
	id                  bigint not null,
	name                varchar(255) not null,
	description         varchar(255) not null,
	group_id            bigint not null,
	constraint category_pk primary key (id),
	constraint category_group_id_fk foreign key (group_id) references tb_group(id)
);
create sequence if not exists category_sequence start 1 increment 1;

create table if not exists tb_category_user_role (
	category_id         bigint not null,
	user_id             bigint not null,
	role_id             bigint not null,
	constraint category_user_role_category_fk foreign key (category_id) references tb_category(id),
	constraint category_user_role_user_fk foreign key (user_id) references tb_user(id),
	constraint category_user_role_role_fk foreign key (role_id) references tb_role(id),
	UNIQUE(category_id, user_id, role_id)
);