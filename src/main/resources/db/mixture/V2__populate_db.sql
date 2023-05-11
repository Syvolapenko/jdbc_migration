INSERT INTO worker
(name, birthday, level, salary) 
VALUES
    ('Max', '1998-11-30', 'Middle', '1500'),
	('Alex', '1996-04-16','Junior', '800'),
	('Natalia', '2000-03-06', 'Trainee', '400'),
	('Vlad', '1992-07-26', 'Senior', '3000'),
	('Valeria', '1994-10-03', 'Middle', '2000'),
	('Juriy', '2001-06-18', 'Trainee', '450'),
	('Andrej', '1993-12-13', 'Senior', '4000'),
	('Alina', '1997-09-23', 'Junior', '900'),
	('Yulia', '1995-02-10', 'Senior', '3500'),
	('Vitaly', '2000-05-20', 'Middle', '2500');
	
	
INSERT INTO client
(name) 
VALUES
    ('Vasiliy'),
	('Slava'),
	('Viktoria'),
	('Anton'),
	('Olena');
	

	
	INSERT INTO project
(client_id, start_date, finish_date) 
VALUES
    (4, '2020-05-28', '2023-02-25'),
	(2, '2016-02-16', '2020-08-04'),
	(5, '2018-10-20', '2021-06-15'),
	(3, '2014-06-04', '2018-03-10'),
	(2, '2017-10-15', '2020-05-23'),
	(5, '2021-08-09', '2022-10-12'),
	(1, '2015-03-13', '2017-04-13'),
	(4, '2019-07-22', '2023-03-06'),
	(5, '2014-11-03', '2016-09-18'),
	(1, '2022-12-03', '2023-04-15');
	

	
		INSERT INTO project_worker
(project_id, worker_id) 
VALUES
	(5,3),
	(8,4),
	(1,6),
	(6,2),
	(4,1),
	(3,6),
	(10,7),
	(2,7),
	(7,7),
	(9,7);