create table season_team_player
(
    id        bigint primary key generated by default as identity,

    season_id bigint not null,
    team_id   bigint not null,
    player_id bigint not null,

    constraint fk_season foreign key (season_id) references season (id),
    constraint fk_team foreign key (team_id) references teams (id),
    constraint fk_player foreign key (player_id) references players (id)
);