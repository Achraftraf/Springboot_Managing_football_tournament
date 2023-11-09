package m2i.tp1.repositories;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import m2i.tp1.entities.Match;



@Repository
public interface MatchRepositories extends JpaRepository<Match, Long> {
	@Query("SELECT m FROM Match m WHERE m.dateMatch = :targetDate")
	List<Match> findMatchesByDateMatch(@Param("targetDate") LocalDate targetDate);

    
    // Add a new method to delete matches by dateMatch and heureMatch less than a given date and time
<<<<<<< HEAD
	void deleteByDateMatchBeforeAndHeureMatchBefore(LocalDate dateMatch, String heureMatch);

=======
    void deleteByDateMatchBefore(LocalDate dateMatch);
>>>>>>> branch 'main' of https://github.com/Achraftraf/Springboot_Managing_football_tournament.git
}
