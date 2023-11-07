package m2i.tp1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data

@Entity
@Table(name = "football_match")
public class Match {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long idMatch;
String dateMatch;
String heureMatch;
@ManyToOne
@JoinColumn(name = "idArbitre")
private Arbitre arbitre;


}
