package m2i.tp1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import m2i.tp1.entities.Equipe;
import m2i.tp1.entities.Match;
import m2i.tp1.entities.Stade;
import m2i.tp1.repositories.MatchRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;	
@Service
public class MatchService {
    @Autowired
    private MatchRepositories matchRepositories;

    public Match updateMatch(Long id, Match updatedMatch) {
        Optional<Match> existingMatchOptional = matchRepositories.findById(id);

        if (existingMatchOptional.isPresent()) {
            Match existingMatch = existingMatchOptional.get();
            existingMatch.setDateMatch(updatedMatch.getDateMatch());
            existingMatch.setHeureMatch(updatedMatch.getHeureMatch());
            existingMatch.setArbitre(updatedMatch.getArbitre());
            existingMatch.setStade(updatedMatch.getStade());
            existingMatch.setEquipe1(updatedMatch.getEquipe1());
            existingMatch.setEquipe2(updatedMatch.getEquipe2());
            // You can update other fields as needed

            return matchRepositories.save(existingMatch);
        } else {
            // Handle the case where the Match with the given ID is not found
            // You can throw an exception or return an appropriate response
            // For simplicity, returning null in case of not found
            return null;
        }
    }
    
    
    public Stade getStadeForMatch(Long id) {
        Optional<Match> matchOptional = matchRepositories.findById(id);

        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            return match.getStade();
        } else {
            // Handle the case where the Match with the given ID is not found
            // You can throw an exception or return an appropriate response
            // For simplicity, returning null in case of not found
            return null;
        }
    }
    
    
    
	/*
	 * public Pair<Equipe, Equipe> getEquipesForMatch(Long id) { Optional<Match>
	 * matchOptional = matchRepositories.findById(id);
	 * 
	 * if (matchOptional.isPresent()) { Match match = matchOptional.get(); Equipe
	 * equipe1 = match.getEquipe1(); Equipe equipe2 = match.getEquipe2(); return new
	 * ImmutablePair<>(equipe1, equipe2); } else { // Handle the case where the
	 * Match with the given ID is not found // You can throw an exception or return
	 * an appropriate response // For simplicity, returning null in case of not
	 * found return new ImmutablePair<>(null, null); } }
	 */  
    
    
    
    
    public List<Equipe> getEquipesForMatch(Long id) {
        Optional<Match> matchOptional = matchRepositories.findById(id);

        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            List<Equipe> equipes = new ArrayList<>();
            equipes.add(match.getEquipe1());
            equipes.add(match.getEquipe2());
            return equipes;
        } else {
            // Handle the case where the Match with the given ID is not found
            // You can throw an exception or return an appropriate response
            // For simplicity, returning an empty list in case of not found
            return new ArrayList<>();
        }
    }
    




    @Transactional
    public void deleteMatchesBeforeCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        matchRepositories.deleteByDateMatchBeforeAndHeureMatchBefore(currentDate, currentTime);
    }

=======
import java.time.LocalDate;	
@Service
public class MatchService {
    @Autowired
    private MatchRepositories matchRepositories;

    public Match updateMatch(Long id, Match updatedMatch) {
        Optional<Match> existingMatchOptional = matchRepositories.findById(id);

        if (existingMatchOptional.isPresent()) {
            Match existingMatch = existingMatchOptional.get();
            existingMatch.setDateMatch(updatedMatch.getDateMatch());
            existingMatch.setHeureMatch(updatedMatch.getHeureMatch());
            existingMatch.setArbitre(updatedMatch.getArbitre());
            existingMatch.setStade(updatedMatch.getStade());
            existingMatch.setEquipe1(updatedMatch.getEquipe1());
            existingMatch.setEquipe2(updatedMatch.getEquipe2());
            // You can update other fields as needed

            return matchRepositories.save(existingMatch);
        } else {
            // Handle the case where the Match with the given ID is not found
            // You can throw an exception or return an appropriate response
            // For simplicity, returning null in case of not found
            return null;
        }
    }
    
    
    public Stade getStadeForMatch(Long id) {
        Optional<Match> matchOptional = matchRepositories.findById(id);

        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            return match.getStade();
        } else {
            // Handle the case where the Match with the given ID is not found
            // You can throw an exception or return an appropriate response
            // For simplicity, returning null in case of not found
            return null;
        }
    }
    
    
    
	/*
	 * public Pair<Equipe, Equipe> getEquipesForMatch(Long id) { Optional<Match>
	 * matchOptional = matchRepositories.findById(id);
	 * 
	 * if (matchOptional.isPresent()) { Match match = matchOptional.get(); Equipe
	 * equipe1 = match.getEquipe1(); Equipe equipe2 = match.getEquipe2(); return new
	 * ImmutablePair<>(equipe1, equipe2); } else { // Handle the case where the
	 * Match with the given ID is not found // You can throw an exception or return
	 * an appropriate response // For simplicity, returning null in case of not
	 * found return new ImmutablePair<>(null, null); } }
	 */  
    
    
    
    
    public List<Equipe> getEquipesForMatch(Long id) {
        Optional<Match> matchOptional = matchRepositories.findById(id);

        if (matchOptional.isPresent()) {
            Match match = matchOptional.get();
            List<Equipe> equipes = new ArrayList<>();
            equipes.add(match.getEquipe1());
            equipes.add(match.getEquipe2());
            return equipes;
        } else {
            // Handle the case where the Match with the given ID is not found
            // You can throw an exception or return an appropriate response
            // For simplicity, returning an empty list in case of not found
            return new ArrayList<>();
        }
    }
    




    @Transactional
    public void deleteMatchesBeforeCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        matchRepositories.deleteByDateMatchBefore(currentDate);
    }
>>>>>>> branch 'main' of https://github.com/Achraftraf/Springboot_Managing_football_tournament.git
}

