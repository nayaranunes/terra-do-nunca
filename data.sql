INSERT INTO championships VALUES(nextval('championship_seq'), '2021', 'ChampionsLeague',0);

INSERT INTO teams VALUES
(nextval('teams_seq'), 'Marga', '70680671000126', 'Milan', 1, 0),
(nextval('teams_seq'), 'Ryan', '13802786000102', 'Para', 1, 0),
(nextval('teams_seq'), 'Ana', '99528250000166', 'America', 1, 0),
(nextval('teams_seq'), 'Julio', '21874964000139', 'Paris', 1, 0),
(nextval('teams_seq'), 'Jose', '60003120000174', 'German', 1, 0),
(nextval('teams_seq'), 'Arnaldo', '62804281000192', 'Santos', 1, 0),
(nextval('teams_seq'), 'James', '52657954000175', 'Inter', 1, 0),
(nextval('teams_seq'), 'Sergio', '40045128000196', 'Hills', 1, 0);

INSERT INTO players VALUES
(nextval('players_seq'), 'Dede', '44438018048', 1),
(nextval('players_seq'), 'Cassio', '21637229020', 2),
(nextval('players_seq'), 'Marta', '83096500002', 3),
(nextval('players_seq'), 'Rogerio', '45810770010', 4),
(nextval('players_seq'), 'Cristian', '67538146040', 5),
(nextval('players_seq'), 'Dado', '87422432039', 6),
(nextval('players_seq'), 'Lucas', '16690070069', 7),
(nextval('players_seq'), 'Fabio', '26647756000', 8);
