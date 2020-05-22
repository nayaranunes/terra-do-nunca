CREATE TABLE IF NOT EXISTS championships (
    id     INTEGER         NOT NULL    PRIMARY KEY,
    year   INTEGER         NOT NULL,
    name   VARCHAR(255)    NOT NULL,
    phase  INTEGER
);

CREATE SEQUENCE IF NOT EXISTS championship_seq
    START with 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

INSERT INTO championships VALUES(nextval('championship_seq'), '2021', 'Libertadores',0);

CREATE TABLE IF NOT EXISTS teams (
    id                  INTEGER         NOT NULL    PRIMARY KEY,
    coach               VARCHAR(255)    NOT NULL,
    cnpj                VARCHAR(255)    NOT NULL,
    name                VARCHAR(255)    NOT NULL,
    championship_id     INTEGER         NOT NULL,
    status              INTEGER,
    FOREIGN KEY (championship_id) REFERENCES championships
);

CREATE SEQUENCE IF NOT EXISTS teams_seq
    START with 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

INSERT INTO teams VALUES(nextval('teams_seq'), 'Murici', '54545', 'Coxa', 1, 0);
INSERT INTO teams VALUES(nextval('teams_seq'), 'Celso', '12345', 'Para', 1, 0);
INSERT INTO teams VALUES(nextval('teams_seq'), 'Portiole', '15453', 'America', 1, 0);
INSERT INTO teams VALUES(nextval('teams_seq'), 'Joao', '09812', 'Cruzeiro', 1, 0);
INSERT INTO teams VALUES(nextval('teams_seq'), 'Jose', '78907', 'Gremio', 1, 0);
INSERT INTO teams VALUES(nextval('teams_seq'), 'Arnaldo', '34523', 'Santos', 1, 0);
INSERT INTO teams VALUES(nextval('teams_seq'), 'Casa', '64352', 'Inter', 1, 0);
INSERT INTO teams VALUES(nextval('teams_seq'), 'Sergio', '34523', 'Galo', 1, 0);

CREATE TABLE IF NOT EXISTS players (
    id       INTEGER     NOT NULL    PRIMARY KEY,
    name     CHAR(255)   NOT NULL,
    cpf      CHAR(255)   NOT NULL,
    team_id  INTEGER     NOT NULL,
    FOREIGN KEY (team_id) REFERENCES teams
);

CREATE SEQUENCE IF NOT EXISTS players_seq
    START with 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

INSERT INTO players VALUES(nextval('players_seq'), 'Dede', '87946', 1);
INSERT INTO players VALUES(nextval('players_seq'), 'Cassio', '17075', 2);
INSERT INTO players VALUES(nextval('players_seq'), 'Ronaldo', '15075', 3);
INSERT INTO players VALUES(nextval('players_seq'), 'Rogerio', '15194', 4);
INSERT INTO players VALUES(nextval('players_seq'), 'Melo', '19075', 5);
INSERT INTO players VALUES(nextval('players_seq'), 'Dado', '15775', 6);
INSERT INTO players VALUES(nextval('players_seq'), 'Lucas', '17075', 7);
INSERT INTO players VALUES(nextval('players_seq'), 'Fabio', '37065', 8);
