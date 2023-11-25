package m2i.tp1.entities;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
Long idarbitre;
String name;
String Nationality;
String photos;


/*
 * @OneToMany(mappedBy = "arbitre", cascade = CascadeType.ALL) private
 * List<Match> matches;   if i use this i will delete also the match from the table match
 */



@OneToMany(mappedBy = "arbitre")
@JsonIgnore
private List<Match> matches;
}
