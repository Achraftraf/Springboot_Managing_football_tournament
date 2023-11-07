package m2i.tp1.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import m2i.tp1.entities.Joueur;
import m2i.tp1.repositories.JoueurRepositories;



@RestController
public class JoueurController {
	
	@Autowired JoueurRepositories joueurRepositorires;

	
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

}
