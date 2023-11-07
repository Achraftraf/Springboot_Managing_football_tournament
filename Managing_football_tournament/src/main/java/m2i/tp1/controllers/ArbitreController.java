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
import m2i.tp1.repositories.ArbitreRepositories;
import m2i.tp1.repositories.MatchRepositories;



@RestController
public class ArbitreController {
	
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

@DeleteMapping("arbitres/{id}")
public void deleteArbitresById(@PathVariable Long id)
{
arbitreRepositorires.deleteById(id);
}

@GetMapping("arbitres/{id}")
public Optional<Arbitre> getArbitreById(@PathVariable Long id)
{
	return arbitreRepositorires.findById(id);
}



}
