INSERT INTO account (login, password) VALUES
    ('Vlad', 'bn4gve91n'),
    ('NotDeveloper', 'ybkn65eamd1i'),
    ('Ninga352', 'n7b4,btuzg3r'),
    ('Artem', 'kbu87rn4tyxn'),
    ('QuickPencil', '1yke30mby6nrm');

INSERT INTO team (admin, project_name) VALUES
    (1, 'flettask');

INSERT INTO team_role (team, label,
        manage_team, manage_board, consulting) VALUES
    (1, 'manager', 'true', 'true', 'true');

INSERT INTO team_role (team, label, manage_board, consulting) VALUES
    (1, 'tech lead', 'true', 'true');

INSERT INTO team_role (team, label) VALUES
    (1, 'developer'),
    (1, 'designer');

INSERT INTO team_member (account, team_role) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 3),
    (5, 4);

INSERT INTO board (team, title) VALUES
    (1, 'MVP');

INSERT INTO stage (title) VALUES
    ('Todo'),
    ('In progress'),
    ('Done');

INSERT INTO board_stage (stage, board) VALUES
    (1, 1),
    (2, 1),
    (3, 1);

INSERT INTO task (title, description) VALUES
    ('Develop a database structure', 'Select a prototype for the project, based on the analysis of methodologies. After that, develop tables and relationships between them.'),
    ('Prepare test data', 'Fill the tables in the database.'),
    ('Write the server part', 'Write requests to the database and server api.'),
    ('Develop application design', 'Prepare a figma file with the future design.'),
    ('Coordinate the design with the customer', 'Prepare the interface presentation with the designer');

INSERT INTO board_task (task, board_stage, performer, duration, starting, ending) VALUES
    (1, 3, 2, '1 12:00', '2024-01-29', '2024-02-03'),
    (2, 3, 3, '7:00', '2024-02-04', '2024-02-04');

INSERT INTO board_task (task, board_stage, performer, duration, starting) VALUES
    (3, 2, 4, '1 00:00', '2024-02-05'),
    (4, 2, 5, '1 12:00', '2024-02-05');

INSERT INTO board_task (task, board_stage, performer, duration) VALUES
    (5, 1, 1, '01:30');

INSERT INTO task_specification (task, submiter, target, registration, value) VALUES
    (3, 4, 2, '2024-02-06 9:15', 'Will we use JDBC or Spring JPA?');

INSERT INTO task_specification (task, submiter, registration, value) VALUES
    (3, 2, '2024-02-06 9:20', 'jpa');