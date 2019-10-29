package se.azza.teamservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.azza.teamservice.repository.TeamRepository;
import se.azza.teamservice.services.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamResources {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	TeamService teamService;

}