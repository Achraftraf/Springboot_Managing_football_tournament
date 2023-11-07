package m2i.tp1.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m2i.tp1.entities.Arbitre;



@Repository
public interface ArbitreRepositories extends  JpaRepository<Arbitre, Long>{

	
}
