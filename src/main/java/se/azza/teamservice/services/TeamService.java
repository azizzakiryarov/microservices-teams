package se.azza.teamservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.azza.teamservice.model.Team;
import se.azza.teamservice.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository userRepository;

	public Team createUser(Team user) {
		return userRepository.save(user);
	}
}