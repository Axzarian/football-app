package org.axzarian.footballtestapp.core.player_skills;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axzarian.footballtestapp.core.player.Player;

@Data
@Table(name = "player_skills")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "player_id")
    Player player;

    @Column(name = "passing")
    Integer passing;

    @Column(name = "shooting")
    Integer shooting;

    @Column(name = "ball_control")
    Integer ballControl;
}
