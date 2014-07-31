create table users(
username varchar (50) not null primary key,
password varchar (50) not null,
enabled bit not null);

create table authorities (
username varchar (50) not null,
authority varchar(50) not null,
constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

create table groups (
id int IDENTITY(1,1)  primary key,
group_name varchar(50) not null);


create table group_authorities (
group_id int not null,
authority varchar(50) not null,
constraint fk_group_authorities_group foreign key(group_id) references groups(id));

create table group_members (
id int identity(1,1) primary key,
username varchar(50) not null,
group_id int not null,
constraint fk_group_members_group foreign key(group_id) references groups(id));

create table persistent_logins (
username varchar(64) not null,
series varchar(64) primary key,
token varchar(64) not null,
last_used timestamp not null);

create table acl_sid (
id int identity(100,10) not null primary key,
principal bit  not null,
sid varchar(100) not null,
constraint unique_uk_1 unique(sid,principal) );

create table acl_class (
id int identity(100,10) not null primary key,
class varchar(100) not null,
constraint unique_uk_2 unique(class) );



create table acl_object_identity (
id int identity(100,10) not null primary key,
object_id_class int not null,
object_id_identity int not null,
parent_object int,
owner_sid int not null,
entries_inheriting bit not null,
constraint unique_uk_3 unique(object_id_class,object_id_identity),
constraint foreign_fk_1 foreign key(parent_object)references acl_object_identity(id),
constraint foreign_fk_2 foreign key(object_id_class)references acl_class(id),
constraint foreign_fk_3 foreign key(owner_sid)references acl_sid(id) );


create table acl_entry (
id int  identity(100,10) not null primary key,
acl_object_identity int not null,ace_order int not null,sid int not null,
mask integer not null,granting bit not null,audit_success bit not null,
audit_failure bit not null,
constraint unique_uk_4 unique(acl_object_identity,ace_order),
constraint foreign_fk_4 foreign key(acl_object_identity)
references acl_object_identity(id),
constraint foreign_fk_5 foreign key(sid) references acl_sid(id) );