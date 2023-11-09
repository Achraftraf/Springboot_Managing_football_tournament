package m2i.tp1.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import m2i.tp1.entities.Stade;



@Repository
public interface StadeRepositories extends  JpaRepository<Stade, Long>{

	
}
