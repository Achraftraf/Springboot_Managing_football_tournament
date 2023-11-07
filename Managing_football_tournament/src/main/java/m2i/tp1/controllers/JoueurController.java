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

import m2i.tp1.entities.Equipe;
import m2i.tp1.repositories.EquipeRepositories;
import m2i.tp1.repositories.JoueurRepositories;



@RestController
public class JoueurController {
	
	@Autowired EquipeRepositories joueurRepositorires;
	@Autowired JoueurRepositories matchRepositorires;
	
	@GetMapping("joueurs")
	public List<Equipe> getAlljoueurs() {
		return joueurRepositorires.findAll();
	}
	
@PostMapping("joueurs")
public Equipe addEquipe(@RequestBody Equipe joueur) {
	return joueurRepositorires.save(joueur);
}

@DeleteMapping("joueurs/{id}")
public void deleteEquipesById(@PathVariable Long id)
{
joueurRepositorires.deleteById(id);
}

@GetMapping("joueurs/{id}")
public Optional<Equipe> getEquipeById(@PathVariable Long id)
{
	return joueurRepositorires.findById(id);
}



}
