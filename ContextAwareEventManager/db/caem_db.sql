
create table Event
 (	id 					INT NOT NULL auto_increment,
	title 				VARCHAR(100) NOT NULL,
	event_type 			VARCHAR(20) NULL,
	start_time 			datetime,
	finish_time 		datetime,
	is_recurrent 		tinyint(1),
	recurrent_until 	datetime,

	PRIMARY KEY (id) );

create table Tag
(	id 		INT NOT NULL auto_increment,
	title 	VARCHAR (50),
	
	PRIMARY KEY(id)
);

create table Event_Tag
(	event_id 	INT NOT NULL,
	tag_id 		INT NOT NULL,
	
	PRIMARY KEY (event_id,tag_id) 
);

create table Notification
(	id 			INT NOT NULL auto_increment,
	title 		VARCHAR (50) NOT NULL,
	description VARCHAR(250) NOT NULL,

	PRIMARY KEY(id)
);

create table Photo
(
	id 			INT NOT NULL auto_increment,
	url 		VARCHAR(250) NOT NULL,
	disk_url 	VARCHAR(250) NOT NULL,
	is_owner	TINYINT(1) NOT NULL,
	place_id 	INT default NULL,
	PRIMARY KEY (id)
);
create table Place
 (	id 				INT NOT NULL auto_increment,
	name 			VARCHAR(50) NOT NULL,
	address 		VARCHAR(250),
	phone 			VARCHAR(20),
	description 	VARCHAR(250),
	open_hours 		VARCHAR(50),

	PRIMARY KEY (id) 
);
create table Place_Tag
(	place_id 	INT NOT NULL,
	tag_id 		INT NOT NULL,
	
	PRIMARY KEY (place_id,tag_id) 
);
create table User
 (	id 				INT NOT NULL auto_increment,
	name 			VARCHAR(50) NOT NULL,
	surname 		VARCHAR(50) NOT NULL,
	username 		VARCHAR(20) NOT NULL,
	password 		VARCHAR(20) NOT NULL,
	role 			VARCHAR(20) NOT NULL,

	PRIMARY KEY (id) 
);
create table User_Location
(	id 			INT NOT NULL auto_increment,
	user 		INT NOT NULL,
	place 		INT NOT NULL,
	time		DATE NOT NULL,

	PRIMARY KEY(id)	
);

create table Registration 
(	id 						INT NOT NULL auto_increment,
	event 					INT NOT NULL,
	user        			INT NOT NULL,
	time_of_registration	DATE NOT NULL,
	status					VARCHAR(50),

	PRIMARY KEY(id)
);




