package m2i.tp1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import m2i.tp1.entities.Match;
import m2i.tp1.entities.Stade;
import m2i.tp1.repositories.MatchRepositories;

import java.util.Optional;

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
}
