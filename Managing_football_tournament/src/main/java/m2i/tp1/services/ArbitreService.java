package m2i.tp1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.tp1.entities.Arbitre;
import m2i.tp1.entities.Match;
import m2i.tp1.repositories.ArbitreRepositories;
import m2i.tp1.repositories.MatchRepositories;

@Service
public class ArbitreService {
    @Autowired
    private ArbitreRepositories arbitreRepositorires;

    @Autowired
    private MatchRepositories matchRepositorires;

    public void deleteArbitreById(Long idarbitre) {
        Optional<Arbitre> arbitreOptional = arbitreRepositorires.findById(idarbitre);
        
        if (arbitreOptional.isPresent()) {
            Arbitre arbitre = arbitreOptional.get();
            
            // Update the related Match records
            for (Match match : arbitre.getMatches()) {
                match.setArbitre(null);  // Set idarbitre to NULL
                matchRepositorires.save(match);  // Save the updated Match
            }
            
            arbitreRepositorires.deleteById(idarbitre);
        }
    }
}
