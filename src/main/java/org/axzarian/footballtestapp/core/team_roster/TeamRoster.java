package org.axzarian.footballtestapp.core.team_roster;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axzarian.footballtestapp.core.player.Player;
import org.axzarian.footballtestapp.core.season.Season;
import org.axzarian.footballtestapp.core.team.Team;

@Data
@Entity
@Builder
@Table(name = "team_roster")
@NoArgsConstructor
@AllArgsConstructor
public class TeamRoster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

}
