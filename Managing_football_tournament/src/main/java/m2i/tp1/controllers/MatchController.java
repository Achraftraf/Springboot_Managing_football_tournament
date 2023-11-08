package m2i.tp1.controllers;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import m2i.tp1.entities.Equipe;
import m2i.tp1.entities.Match;
import m2i.tp1.entities.Stade;
import m2i.tp1.repositories.ArbitreRepositories;
import m2i.tp1.repositories.MatchRepositories;
import m2i.tp1.services.MatchService;


@CrossOrigin(origins = "*")
@RestController
public class MatchController {
	@Autowired ArbitreRepositories arbitreRepositorires;
	@Autowired MatchRepositories matchRepositorires;
	
	@Autowired
    private MatchService matchService;
	
	@GetMapping("matchs")
	public List<Match> getAllmatchs() {
		return matchRepositorires.findAll();
	}
	
	@PostMapping("matchs")
	public Match addMatch(@RequestBody Match match) {
		return matchRepositorires.save(match);


}

	
//in the match delete method we don't have the problem of foreign keys	
	
@DeleteMapping("matchs/{id}")
public void deleteMatchsById(@PathVariable Long id)
{
matchRepositorires.deleteById(id);
}



@GetMapping("matchs/{id}")
public Optional<Match> getMatchById(@PathVariable Long id)
{
	return matchRepositorires.findById(id);
}

@PutMapping("matchs/{id}")
public Match updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
    return matchService.updateMatch(id, updatedMatch);
}


@GetMapping("matchs/matchs-by-date")
public List<Match> getMatchesByDate() {
    return matchRepositorires.findMatchesByDateMatch();
}

@GetMapping("matchs/{id}/stade")
public Stade getStadeForMatch(@PathVariable Long id) {
    return matchService.getStadeForMatch(id);
}
/*
 * @GetMapping("matchs/{id}/equipes") public Pair<Equipe, Equipe>
 * getEquipesForMatch(@PathVariable Long id) { return
 * matchService.getEquipesForMatch(id); }
 */


@GetMapping("matchs/{id}/equipes")
public List<Equipe> getEquipesForMatch(@PathVariable Long id) {
    return matchService.getEquipesForMatch(id);
}

}
