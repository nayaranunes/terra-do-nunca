CREATE TABLE IF NOT EXISTS players (
    id                  INTEGER     NOT NULL    PRIMARY KEY,
    name_player         CHARACTER   NOT NULL,
    cpf                 CHARACTER   NOT NULL,
    has_time            boolean
);
/*
CREATE TABLE IF NOT EXISTS teams (
    id_team             INT PRIMARY KEY,
    coach               VARCHAR(255) NOT NULL,
    cnpj                VARCHAR(255) NOT NULL,
    name                VARCHAR(255) NOT NULL,
    listOfPlayersCPF    VARCHAR(255),
    player_id           INT,
    FOREIGN KEY (player_id) REFERENCES players
);

CREATE TABLE IF NOT EXISTS championships (
    id_championship     INT NOT NULL PRIMARY KEY,
    qtdOfTeams          INT NOT NULL,
    year                INT NOT NULL,
    name                VARCHAR(255) NOT NULL,
    phase               VARCHAR(255) NOT NULL,

    player_id           INT,
    team_id             INT,
    FOREIGN KEY (player_id) REFERENCES players,
    FOREIGN KEY (team_id) REFERENCES team
);*/