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
				restTemplate.getForObject("http://microservices-users-deployment-0.microservices-users.microservices.svc.cluster.local:8081/users/getAllUsersFor/" + teamId, User[].class));
	}
}