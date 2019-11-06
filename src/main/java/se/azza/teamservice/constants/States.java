package se.azza.teamservice.constants;

public class States {

	public enum userState {
		ACTIVE, INACTIVE
	}

	public enum userRole {
		ADMIN, USER, DEVELOPER, SCRUM_MASTER, TEAM_MANAGER
	}

	public enum teamState {
		NEW, ACTIVE, INACTIVE
	}
}