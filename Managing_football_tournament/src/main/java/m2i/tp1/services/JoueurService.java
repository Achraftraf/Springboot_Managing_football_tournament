package m2i.tp1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import m2i.tp1.entities.Joueur;
import m2i.tp1.repositories.JoueurRepositories;

import java.util.Optional;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepositories joueurRepositories;

    public Joueur updateJoueur(Long id, Joueur updatedJoueur) {
        Optional<Joueur> existingJoueurOptional = joueurRepositories.findById(id);

        if (existingJoueurOptional.isPresent()) {
            Joueur existingJoueur = existingJoueurOptional.get();
            existingJoueur.setNamejoueur(updatedJoueur.getNamejoueur());
            existingJoueur.setPoste(updatedJoueur.getPoste());
            existingJoueur.setEquipe(updatedJoueur.getEquipe()); // Update the equipe association
            // You can update other fields as needed

            return joueurRepositories.save(existingJoueur);
        } else {
            // Handle the case where the Joueur with the given ID is not found
            // You can throw an exception or return an appropriate response
            // For simplicity, returning null in case of not found
            return null;
        }
    }
}
