package m2i.tp1.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import m2i.tp1.entities.Joueur;



@Repository
public interface JoueurRepositories extends JpaRepository<Joueur, Long> {
    @Query("SELECT j FROM Joueur j JOIN j.equipe e WHERE e.name_equipe = 'ATL MADRID'")
    List<Joueur> findJoueursByEquipeName();
    
    @Query("SELECT j FROM Joueur j JOIN j.equipe e WHERE j.poste = 'attaquant' AND e.name_equipe = 'PSG'")
    List<Joueur> findAttaquantsForPSG();
}
