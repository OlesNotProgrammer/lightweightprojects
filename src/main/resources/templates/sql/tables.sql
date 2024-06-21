DROP TABLE IF EXISTS task_specification;
DROP TABLE IF EXISTS board_task;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS board_stage;
DROP TABLE IF EXISTS stage;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS team_member;
DROP TABLE IF EXISTS team_role;
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS account;

CREATE TABLE account (
    account_id serial PRIMARY KEY,
    login varchar(50) NOT NULL,
    password varchar(200) NOT NULL
);

CREATE TABLE team (
    team_id serial PRIMARY KEY,
    admin integer NOT NULL REFERENCES account(account_id),
    project_name varchar(50) NOT NULL
);

CREATE TABLE team_role (
    team_role_id serial PRIMARY KEY,
    team integer NOT NULL REFERENCES team(team_id),
    label varchar(50) NOT NULL,
    manage_team BOOLEAN NOT NULL DEFAULT 'false',
    manage_board BOOLEAN NOT NULL DEFAULT 'false',
    consulting BOOLEAN NOT NULL DEFAULT 'false'
);

CREATE TABLE team_member (
    team_member_id serial PRIMARY KEY,
    account integer NOT NULL REFERENCES account(account_id),
    team_role integer REFERENCES team_role(team_role_id),
    UNIQUE(account, team_role)
);

CREATE TABLE board (
    board_id serial PRIMARY KEY,
    team integer NOT NULL REFERENCES team(team_id),
    title varchar(50) NOT NULL
);

CREATE TABLE stage (
    stage_id serial PRIMARY KEY,
    title varchar(50) NOT NULL UNIQUE
);

CREATE TABLE board_stage (
    board_stage_id serial PRIMARY KEY,
    stage integer NOT NULL REFERENCES stage(stage_id),
    board integer NOT NULL REFERENCES board(board_id),
    position integer,
    UNIQUE(stage, board)
);

CREATE TABLE task (
    task_id serial PRIMARY KEY,
    title varchar(50) NOT NULL,
    description TEXT
);

CREATE TABLE board_task (
    board_task_id serial PRIMARY KEY,
    task integer NOT NULL UNIQUE REFERENCES task(task_id),
    board_stage integer NOT NULL REFERENCES board_stage(board_stage_id),
    performer integer REFERENCES team_member,
    duration interval NOT NULL,
    starting TIMESTAMP,
    ending TIMESTAMP,
    UNIQUE(task, board_stage)
);

CREATE TABLE task_specification (
    task_specification_id serial PRIMARY KEY,
    task integer NOT NULL,
    submiter integer NOT NULL REFERENCES team_member(team_member_id),
    target integer REFERENCES team_member(team_member_id),
    registration TIMESTAMP NOT NULL,
    value TEXT NOT NULL
);
