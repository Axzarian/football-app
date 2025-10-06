package org.axzarian.footballtestapp.core.player;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axzarian.footballtestapp.core.player.enums.Leg;
import org.axzarian.footballtestapp.core.player.enums.Position;
import org.axzarian.footballtestapp.core.player_skills.PlayerSkills;

@Data
@Entity
@Builder
@Table(name = "players")
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Position position;

    @Enumerated(EnumType.STRING)
    private Leg leg;

    @Column(name = "is_captain")
    private boolean isCaptain;

    @JsonManagedReference
    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    private PlayerSkills playerSkills;

}
