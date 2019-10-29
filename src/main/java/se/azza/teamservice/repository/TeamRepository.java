package se.azza.teamservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se.azza.teamservice.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	
}
