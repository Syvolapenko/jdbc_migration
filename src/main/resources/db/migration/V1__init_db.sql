CREATE TABLE IF NOT EXISTS worker
(
id int primary key auto_increment,
name varchar(1000) not null,
birthday DATE CHECK (birthday > '1900-12-31'),
level varchar  not null CHECK (level IN ('Trainee','Junior','Middle','Senior')),
salary int CHECK (salary>=100 AND salary<=100000)
);



CREATE TABLE IF NOT EXISTS client
(
id int primary key auto_increment,
name varchar(1000) not null
);


CREATE TABLE IF NOT EXISTS project
(
id int primary key auto_increment,
client_id int not null,
start_date DATE ,
finish_date DATE,
FOREIGN KEY(client_id) REFERENCES client(id)
);



CREATE TABLE IF NOT EXISTS project_worker
(
project_id int NOT NULL,
worker_id int NOT NULL,
PRIMARY KEY (project_id, worker_id),
FOREIGN KEY (project_id) REFERENCES project(id),
FOREIGN KEY (worker_id) REFERENCES worker(id)
);