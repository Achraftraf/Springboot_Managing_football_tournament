package m2i.tp1.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import m2i.tp1.entities.Equipe;



@Repository
public interface EquipeRepositories extends JpaRepository<Equipe, Long> {
    @Query("SELECT e FROM Equipe e WHERE e.pays = 'maroc'")
    List<Equipe> findEquipesByPaysMaroc();
}
