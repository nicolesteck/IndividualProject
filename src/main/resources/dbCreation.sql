create table user(
  userId int auto_increment primary key,
  first_name varchar(25),
  last_name varchar(25),
  email varchar(30),
  password varchar(30),
  li_password varchar(30)
);

create table connections(
  connectionId int auto_increment primary key,
  userID int,
  linkedInID int,
  first_name varchar(30),
  last_name varchar(30),
  numberConnections int,
  isUpdated boolean,
  constraint FK_userId foreign key (userId)
  references user(userId)
);

create table connectionJob(
  jobId int auto_increment primary key,
  connectionId int,
  jobName varchar(30),
  companyName varchar(30),
  jobStart date,
  jobEnd date,
  jobDescription text,
  constraint FK_connectionId foreign key (connectionId)
  references connections(connectionId)
);

create table connectionDetail(
  detailId int primary key,
  connectionId int,
  headline varchar(255),
  location varchar(30),
  industry varchar(30),
  summary text,
  specialties text,
  profile varchar(50),
  constraint FK_connectionId foreign key (connectionId)
  references connections(connectionId)
);

create table connectionUpdates(
  updateId int primary key,
  connectionId int,
  relationship varchar(50),
  sharedInterests varchar(255),
  background varchar(255),
  notes text,
  constraint FK_connectionId foreign key (connectionId)
  references connections(connectionId)
);

create table actionItems(
  actionItemId int auto_increment primary key,
  connectionId int,
  userId int,
  actionItemName varchar(30),
  dateCreated date,
  status varchar(15),
  isComplete boolean,
  dateCompleted date,
  constraint FK_connectionId foreign key (connectionId)
  references connections(connectionId),
  constraint FK_userId foreign key (userId)
  references user(userId)
);