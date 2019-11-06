package se.azza.teamservice.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import se.azza.teamservice.constants.States.teamState;
import se.azza.teamservice.model.Team;
import se.azza.teamservice.repository.TeamRepository;
import se.azza.teamservice.services.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamResources {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	TeamService teamService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/add")
	public ResponseEntity<Team> addTeam(@RequestParam(value = "teamName") String teamName,
			@RequestParam(value = "teamDescription") String teamDescription) {
		Team newTeam = teamService.createTeam(new Team(teamName, teamDescription));
		return new ResponseEntity<Team>(newTeam, HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> getTeam(@PathVariable(value = "id") Long id) {
		Optional<Team> team = teamService.getTeamById(id);
		return new ResponseEntity<Team>(team.get(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> updateTeam(@PathVariable(value = "id") Long id,
			@RequestParam(value = "teamName") String teamName,
			@RequestParam(value = "teamDescription") String teamDescription,
			@RequestParam(value = "teamState") teamState teamState) {
		Optional<Team> currentTeam = teamService.getTeamById(id);
		Team updatedTeam = new Team(currentTeam.get().getId(), teamName, teamDescription, teamState);
		teamRepository.save(updatedTeam);
		return new ResponseEntity<Team>(updatedTeam, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Team>> getAllTeams() {
		List<Team> teams = teamService.getAllTeams();
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteTeam(@PathVariable(value = "id") Long id) {
		return teamService.deleteById(id, restTemplate);
	}
}