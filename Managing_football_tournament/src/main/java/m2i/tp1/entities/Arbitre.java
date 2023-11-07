package m2i.tp1.entities;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data

@Entity
public class Arbitre {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long idArbitre;
String name;
String Nationality;

@OneToMany(mappedBy = "arbitre")
@JsonIgnore
private List<Match> matches;
}
