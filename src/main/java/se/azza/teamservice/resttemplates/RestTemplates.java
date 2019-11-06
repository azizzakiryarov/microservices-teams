package se.azza.teamservice.resttemplates;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import se.azza.teamservice.model.User;

public class RestTemplates {

	public RestTemplates() {
		super();
	}

	public static List<User> getAllUsersFor(RestTemplate restTemplate, Long teamId) {
		return Arrays.asList(
				restTemplate.getForObject("http://microservices-users/users/getAllUsersFor/" + teamId, User[].class));
	}
}