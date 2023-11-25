package m2i.tp1.controllers;

import java.util.List;
import java.util.Optional;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import m2i.tp1.entities.Arbitre;
import m2i.tp1.entities.Match;
import m2i.tp1.repositories.ArbitreRepositories;
import m2i.tp1.repositories.MatchRepositories;
import m2i.tp1.services.ArbitreService;
@CrossOrigin(origins = "*")
@RestController
public class ArbitreController {

	@Autowired
	private ArbitreService arbitreService;
	@Autowired
	ArbitreRepositories arbitreRepositorires;
	@Autowired
	MatchRepositories matchRepositorires;

	@GetMapping("arbitres")
	public List<Arbitre> getAllarbitres() {
		return arbitreRepositorires.findAll();
	}

	// Controller method
	@PostMapping("arbitres")
	public Arbitre addArbitre(
	    @RequestParam Long idarbitre,
	    @RequestParam String name,
	    @RequestParam String nationality,
	    @RequestParam MultipartFile file) throws IllegalStateException, IOException {

	    return arbitreService.addArbire(idarbitre, name, nationality, file);
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
	public Optional<Arbitre> getArbitreById(@PathVariable Long id) {
		return arbitreRepositorires.findById(id);
	}

	@PutMapping("arbitres/{idarbitre}")
	public Arbitre updateArbitre(@PathVariable Long idarbitre, @RequestBody Arbitre updatedArbitre) {
		return arbitreService.updateArbitre(idarbitre, updatedArbitre);
	}

}
