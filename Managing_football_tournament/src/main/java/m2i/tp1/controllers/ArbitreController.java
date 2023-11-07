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

import m2i.tp1.entities.Arbitre;
import m2i.tp1.entities.Match;
import m2i.tp1.repositories.ArbitreRepositories;
import m2i.tp1.repositories.MatchRepositories;
import m2i.tp1.services.ArbitreService;



@RestController
public class ArbitreController {
	
	
	 @Autowired
	 private ArbitreService arbitreService;
	@Autowired ArbitreRepositories arbitreRepositorires;
	@Autowired MatchRepositories matchRepositorires;
	
	@GetMapping("arbitres")
	public List<Arbitre> getAllarbitres() {
		return arbitreRepositorires.findAll();
	}
	
@PostMapping("arbitres")
public Arbitre addArbitre(@RequestBody Arbitre arbitre) {
	return arbitreRepositorires.save(arbitre);
}

/*
 * @DeleteMapping("arbitres/{idarbitre}") public void
 * deleteArbitresById(@PathVariable Long idarbitre) {
 * arbitreRepositorires.deleteById(idarbitre); }
 */

//i use this method to delete arbitre and keep the match by update the id and make it null 

@DeleteMapping("arbitres/{idarbitre}")
public void deleteArbitresById(@PathVariable Long idarbitre) {
    arbitreService.deleteArbitreById(idarbitre);
}


@GetMapping("arbitres/{idarbitre}")
public Optional<Arbitre> getArbitreById(@PathVariable Long id)
{
	return arbitreRepositorires.findById(id);
}


}
