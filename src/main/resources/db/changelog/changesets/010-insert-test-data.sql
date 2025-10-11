insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (1, 'alexey', 'mikheyev', '1985-10-11', 'FIELD', 'RIGHT', false);
insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (2, 'ivan', 'mikheyev', '1987-10-29', 'FIELD', 'RIGHT', false);
insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (3, 'andrey', 'volkov', '1986-09-19', 'FIELD', 'RIGHT', false);
insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (4, 'timur', 'timur', '1985-10-11', 'FIELD', 'RIGHT', true);
insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (5, 'erlan', 'erlan', '1987-10-29', 'FIELD', 'RIGHT', false);
insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (6, 'ramis', 'ramis', '1986-09-19', 'FIELD', 'RIGHT', false);
insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (7, 'roma', 'roma', '1985-10-11', 'FIELD', 'RIGHT', false);
insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (8, 'alma', 'alma', '1987-10-29', 'FIELD', 'RIGHT', true);
insert into players (id, first_name, last_name, birth_date, position, leg, is_captain) values (9, 'aseka', 'aseka', '1986-09-19', 'FIELD', 'RIGHT', false);

insert into player_skills (player_id, passing, shooting, ball_control)values (1,50, 50, 50);
insert into player_skills (player_id, passing, shooting, ball_control)values (2,50, 50, 50);
insert into player_skills (player_id, passing, shooting, ball_control)values (3,50, 50, 50);
insert into player_skills (player_id, passing, shooting, ball_control)values (4,50, 50, 50);
insert into player_skills (player_id, passing, shooting, ball_control)values (5,50, 50, 50);
insert into player_skills (player_id, passing, shooting, ball_control)values (6,50, 50, 50);
insert into player_skills (player_id, passing, shooting, ball_control)values (7,50, 50, 50);
insert into player_skills (player_id, passing, shooting, ball_control)values (8,50, 50, 50);
insert into player_skills (player_id, passing, shooting, ball_control)values (9,50, 50, 50);

insert into teams (id, title) values (1, 'WHITE');
insert into teams (id, title) values (2, 'ORANGE');
insert into teams (id, title) values (3, 'RED');

insert into season (id, title, start_date, end_date) values (1, 'summer 25/26', '2025-05-01', '2025-09-30' );

insert into arbiters (id, first_name, last_name, birth_date) values (1, 'anatoly', 'popov', '1965-10-10');

insert into team_roster (season_id, team_id, player_id) values (1, 1,1);
insert into team_roster (season_id, team_id, player_id) values (1, 1,2);
insert into team_roster (season_id, team_id, player_id) values (1, 1,3);
insert into team_roster (season_id, team_id, player_id) values (1, 2,4);
insert into team_roster (season_id, team_id, player_id) values (1, 2,5);
insert into team_roster (season_id, team_id, player_id) values (1, 2,6);
insert into team_roster (season_id, team_id, player_id) values (1, 3,7);
insert into team_roster (season_id, team_id, player_id) values (1, 3,8);
insert into team_roster (season_id, team_id, player_id) values (1, 3,9);
