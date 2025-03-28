create table player_skills
(
    id           bigint primary key generated by default as identity,
    player_id    bigint not null,

    passing      int    not null default 40,
    shooting     int    not null default 40,
    ball_control int    not null default 30,

    constraint fk_player foreign key (player_id) references players (id) on delete cascade
);