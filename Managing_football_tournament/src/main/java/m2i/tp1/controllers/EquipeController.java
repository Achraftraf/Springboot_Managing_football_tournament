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

import m2i.tp1.entities.Equipe;
import m2i.tp1.repositories.EquipeRepositories;
import m2i.tp1.services.EquipeService;




@RestController
public class EquipeController {
	
	@Autowired EquipeRepositories equipeRepositorires;

	 @Autowired
	    private EquipeService equipeService;
	
	
	@GetMapping("equipes")
	public List<Equipe> getAllequipes() {
		return equipeRepositorires.findAll();
	}
	
@PostMapping("equipes")
public Equipe addEquipe(@RequestBody Equipe equipe) {
	return equipeRepositorires.save(equipe);
}

/*
 * @DeleteMapping("equipes/{id}") public void deleteEquipesById(@PathVariable
 * Long id) { equipeRepositorires.deleteById(id); }
 */


@DeleteMapping("equipes/{id}")
public void deleteEquipesById(@PathVariable Long id) {
    equipeService.deleteEquipeById(id);
}

// we need to use the service because we need to costimize the method of delete the equipe we don't need to use the repositories methods and cascade.all to force the delete because if we delete the equipe we need to delete the matchs because 

@GetMapping("equipes/{id}")
public Optional<Equipe> getEquipeById(@PathVariable Long id)
{
	return equipeRepositorires.findById(id);
}

@PutMapping("equipes/{id}")
public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe updatedEquipe) {
    return equipeService.updateEquipe(id, updatedEquipe);
}


@GetMapping("equipes/maroc")
public List<Equipe> getEquipesWithPaysMaroc() {
    return equipeRepositorires.findEquipesByPaysMaroc();
}

}
