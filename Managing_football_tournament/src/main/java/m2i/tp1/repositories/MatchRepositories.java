package m2i.tp1.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m2i.tp1.entities.Match;



@Repository
public interface MatchRepositories extends  JpaRepository<Match, Long>{



}
