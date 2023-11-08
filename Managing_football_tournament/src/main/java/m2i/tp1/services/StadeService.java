package m2i.tp1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.tp1.entities.Stade;
import m2i.tp1.entities.Match;
import m2i.tp1.repositories.MatchRepositories;
import m2i.tp1.repositories.StadeRepositories;

@Service
public class StadeService {
    @Autowired
    private StadeRepositories stadeRepositorires;

    @Autowired
    private MatchRepositories matchRepositorires;

    public void deleteStadeById(Long id) {
        Optional<Stade> stadeOptional = stadeRepositorires.findById(id);

        if (stadeOptional.isPresent()) {
            Stade stade = stadeOptional.get();

            // Update the related Match records
            for (Match match : stade.getMatches()) {
                match.setStade(null);  // Set idstade to NULL
                matchRepositorires.save(match);  // Save the updated Match
            }

            stadeRepositorires.deleteById(id);
        }
    }
    
    public Stade updateStade(Long id, Stade updatedStade) {
        Optional<Stade> existingStadeOptional = stadeRepositorires.findById(id);

        if (existingStadeOptional.isPresent()) {
            Stade existingStade = existingStadeOptional.get();
            existingStade.setNamestade(updatedStade.getNamestade());
            existingStade.setVille(updatedStade.getVille());
            // You can update other fields as needed

            return stadeRepositorires.save(existingStade);
        } else {
            // Handle the case where the Stade with the given ID is not found
            // You can throw an exception or return an appropriate response
            // For simplicity, returning null in case of not found
            return null;
        }
    }
}
