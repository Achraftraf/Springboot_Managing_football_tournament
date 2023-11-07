package m2i.tp1.entities;






import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data

@Entity
public class Equipe {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long idequipe;
String name_equipe;
String pays;

@OneToMany(mappedBy = "equipe1")
@JsonIgnore
private List<Match> matchesAsEquipe1;

@OneToMany(mappedBy = "equipe2")
@JsonIgnore
private List<Match> matchesAsEquipe2;



@OneToMany(mappedBy = "equipe")
@JsonIgnore
private List<Joueur> joueurs;

}
