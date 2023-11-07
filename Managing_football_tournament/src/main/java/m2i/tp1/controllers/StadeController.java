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

import m2i.tp1.entities.Stade;
import m2i.tp1.repositories.StadeRepositories;
import m2i.tp1.repositories.MatchRepositories;



@RestController
public class StadeController {
	
	@Autowired StadeRepositories stadeRepositorires;
	@Autowired MatchRepositories matchRepositorires;
	
	@GetMapping("stades")
	public List<Stade> getAllstades() {
		return stadeRepositorires.findAll();
	}
	
@PostMapping("stades")
public Stade addStade(@RequestBody Stade stade) {
	return stadeRepositorires.save(stade);
}

@DeleteMapping("stades/{id}")
public void deleteStadesById(@PathVariable Long id)
{
stadeRepositorires.deleteById(id);
}

@GetMapping("stades/{id}")
public Optional<Stade> getStadeById(@PathVariable Long id)
{
	return stadeRepositorires.findById(id);
}



}
