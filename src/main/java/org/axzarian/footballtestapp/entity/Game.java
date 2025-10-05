package org.axzarian.footballtestapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axzarian.footballtestapp.entity.enums.GameResult;

@Data
@Entity
@Builder
@Table(name = "games")
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "season_id")
    Season season;

    private LocalDate gameDate;

    @ManyToOne
    @JoinColumn(name = "arbiter_id")
    private Arbiter arbiter;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @Column(name = "home_team_goals")
    private Integer homeTeamGoals;

    @Column(name = "away_team_goals")
    private Integer awayTeamGoals;

    @Column(name = "yellow_cards")
    private Integer yellowCards;

    @Column(name = "red_cards")
    private Integer redCards;

    @Column(name = "is_finished")
    private boolean isFinished;

    @Enumerated(EnumType.STRING)
    private GameResult result;
}
