package m2i.tp1.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import m2i.tp1.entities.Joueur;
import m2i.tp1.repositories.JoueurRepositories;
import m2i.tp1.services.JoueurService;



@RestController
public class JoueurController {
	
	@Autowired JoueurRepositories joueurRepositorires;

	
    @Autowired
    private JoueurService joueurService;
	
	@GetMapping("joueurs")
	public List<Joueur> getAlljoueurs() {
		return joueurRepositorires.findAll();
	}
	
@PostMapping("joueurs")
public Joueur addJoueur(@RequestBody Joueur joueur) {
	
	return joueurRepositorires.save(joueur);
}

@DeleteMapping("joueurs/{id}")
public void deleteJoueursById(@PathVariable Long id)
{
joueurRepositorires.deleteById(id);
}

@GetMapping("joueurs/{id}")
public Optional<Joueur> getJoueurById(@PathVariable Long id)
{
	return joueurRepositorires.findById(id);
}


@PutMapping("joueurs/{id}")
public Joueur updateJoueur(@PathVariable Long id, @RequestBody Joueur updatedJoueur) {
    return joueurService.updateJoueur(id, updatedJoueur);
}


@GetMapping("joueurs/joueurs-by-equipe")
public List<Joueur> getJoueursByEquipeName() {
    return joueurRepositorires.findJoueursByEquipeName();
}

@GetMapping("joueurs/attaquants-psg")
public List<Joueur> getAttaquantsForPSG() {
    return joueurRepositorires.findAttaquantsForPSG();
}

}

