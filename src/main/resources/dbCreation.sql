create table user(
  id int auto_increment primary key,
  first_name varchar(25),
  last_name varchar(25),
  email varchar(30),
  password varchar(30),
  li_password varchar(30)
);

create table connections(
  connection_id int auto_increment primary key,
  connection_user_id int,
  linkedin_id int,
  first_name varchar(30),
  last_name varchar(30),
  number_connections int,
  is_updated boolean,
  constraint FK_connection_user_id foreign key (connection_user_id)
  references user(id)
  on update CASCADE
  on delete CASCADE
);

create index FK_connection_user_id ON connections (user_id);

create table connection_job(
  job_id int auto_increment primary key,
  job_connection_id int,
  job_name varchar(30),
  company_name varchar(30),
  job_start date,
  job_end date,
  job_description text,
  constraint FK_job_connection_id foreign key (job_connection_id)
  references connections(id)
);

create table connection_detail(
  id int primary key,
  detail_connection_id int not null,
  headline varchar(255),
  location varchar(30),
  industry varchar(30),
  summary text,
  specialties text,
  profile varchar(50),
  constraint FK_detail_connection_id foreign key (detail_connection_id)
  references connections(id)
);

create table connection_updates(
  update_id int primary key,
  updates_connection_id int,
  relationship varchar(50),
  shared_interests varchar(255),
  background varchar(255),
  notes text,
  constraint FK_updates_connection_id foreign key (updates_connection_id)
  references connections(id)
);

create table action_items(
  action_item_id int auto_increment primary key,
  item_connection_id int,
  item_user_id int,
  action_item_name varchar(30),
  date_created date,
  status varchar(15),
  is_complete boolean,
  date_completed date,
  constraint FK_item_connectionid foreign key (item_connection_id)
  references connections(id),
  constraint FK_item_user_id foreign key (item_user_id)
  references user(id)
);