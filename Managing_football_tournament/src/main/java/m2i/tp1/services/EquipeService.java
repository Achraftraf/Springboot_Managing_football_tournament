package m2i.tp1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import m2i.tp1.entities.Equipe;
import m2i.tp1.entities.Match;
import m2i.tp1.repositories.EquipeRepositories;
import m2i.tp1.repositories.MatchRepositories;

@Service
public class EquipeService {
    @Autowired
    private EquipeRepositories equipeRepositorires;

    @Autowired
    private MatchRepositories matchRepositorires;

    public void deleteEquipeById(Long idequipe) {
        Optional<Equipe> equipeOptional = equipeRepositorires.findById(idequipe);

        if (equipeOptional.isPresent()) {
            Equipe equipe = equipeOptional.get();

            // Update the related Match records where the Equipe is either equipe1 or equipe2
            for (Match match : equipe.getMatchesAsEquipe1()) {
                match.setEquipe1(null);
                matchRepositorires.save(match);
            }

            for (Match match : equipe.getMatchesAsEquipe2()) {
                match.setEquipe2(null);
                matchRepositorires.save(match);
            }

            // Delete the Equipe
            equipeRepositorires.deleteById(idequipe);
        }
    }
}
