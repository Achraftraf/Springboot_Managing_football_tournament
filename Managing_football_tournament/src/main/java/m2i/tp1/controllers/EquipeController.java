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




@RestController
public class EquipeController {
	
	@Autowired EquipeRepositories equipeRepositorires;

	
	@GetMapping("equipes")
	public List<Equipe> getAllequipes() {
		return equipeRepositorires.findAll();
	}
	
@PostMapping("equipes")
public Equipe addEquipe(@RequestBody Equipe equipe) {
	return equipeRepositorires.save(equipe);
}

@DeleteMapping("equipes/{id}")
public void deleteEquipesById(@PathVariable Long id)
{
equipeRepositorires.deleteById(id);
}

@GetMapping("equipes/{id}")
public Optional<Equipe> getEquipeById(@PathVariable Long id)
{
	return equipeRepositorires.findById(id);
}

}
