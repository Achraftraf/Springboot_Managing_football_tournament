package m2i.tp1.entities;





import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data

@Entity
public class Joueur {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long idjoueur;
String namejoueur;
String poste;

@ManyToOne
@JoinColumn(name = "idequipe")
@JsonIgnore
private Equipe equipe;
}
