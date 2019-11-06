package se.azza.teamservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import se.azza.teamservice.model.Team;
import se.azza.teamservice.model.User;
import se.azza.teamservice.repository.TeamRepository;
import se.azza.teamservice.resttemplates.RestTemplates;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public Team createTeam(Team team) {
		return teamRepository.save(team);
	}

	public Optional<Team> getTeamById(Long id) {
		return teamRepository.findById(id);
	}

	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	public ResponseEntity<String> deleteById(Long id, RestTemplate restTemplate) {
		List<User> usersForTeam = RestTemplates.getAllUsersFor(restTemplate, id);
		if (usersForTeam.isEmpty()) {
			teamRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return ResponseEntity.badRequest()
				.body("You need to delete all users first... then you available to delete team");
	}
}