CREATE SEQUENCE IF NOT EXISTS championship_seq
    START with 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS teams_seq
    START with 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE IF NOT EXISTS players_seq
    START with 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS championships (
    id     INTEGER         NOT NULL    PRIMARY KEY,
    year   INTEGER         NOT NULL,
    name   VARCHAR(255)    NOT NULL,
    phase  INTEGER
);

CREATE TABLE IF NOT EXISTS teams (
    id                  INTEGER         NOT NULL    PRIMARY KEY,
    coach               VARCHAR(255)    NOT NULL,
    cnpj                VARCHAR(255)    NOT NULL,
    name                VARCHAR(255)    NOT NULL,
    championship_id     INTEGER         NOT NULL,
    status              INTEGER,
    FOREIGN KEY (championship_id) REFERENCES championships
);

CREATE TABLE IF NOT EXISTS players (
    id       INTEGER     NOT NULL    PRIMARY KEY,
    name     CHAR(255)   NOT NULL,
    cpf      CHAR(255)   NOT NULL,
    team_id  INTEGER     NOT NULL,
    FOREIGN KEY (team_id) REFERENCES teams
);

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
