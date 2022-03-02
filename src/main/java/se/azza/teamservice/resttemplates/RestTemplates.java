package se.azza.teamservice.resttemplates;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.web.client.RestTemplate;
import se.azza.teamservice.model.User;

import static se.azza.teamservice.constants.Urls.GET_ALL_USERS_FOR;

public class RestTemplates {

	public RestTemplates() {
		super();
	}

	public static List<User> getAllUsersFor(RestTemplate restTemplate, Long teamId) {
		return Arrays.asList(
				Objects.requireNonNull(restTemplate.getForObject(GET_ALL_USERS_FOR + teamId, User[].class)));
	}
}