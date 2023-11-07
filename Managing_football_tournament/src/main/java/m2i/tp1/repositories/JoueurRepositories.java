package m2i.tp1.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import m2i.tp1.entities.Joueur;



@Repository
public interface JoueurRepositories extends  JpaRepository<Joueur, Long>{


	
}
