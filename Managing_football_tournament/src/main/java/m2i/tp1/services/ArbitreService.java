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
    
    
    
    public Arbitre updateArbitre(Long idarbitre, Arbitre updatedArbitre) {
        Optional<Arbitre> existingArbitre = arbitreRepositorires.findById(idarbitre);

        if (existingArbitre.isPresent()) {
            Arbitre arbitre = existingArbitre.get();
            arbitre.setName(updatedArbitre.getName());
            arbitre.setNationality(updatedArbitre.getNationality());

            // You can update other fields as well

            return arbitreRepositorires.save(arbitre);
        } else {
            // Handle the case where the Arbitre with the given idarbitre does not exist.
            // You can return null or throw an exception to indicate the error.
            return null;
        }
    }
}
