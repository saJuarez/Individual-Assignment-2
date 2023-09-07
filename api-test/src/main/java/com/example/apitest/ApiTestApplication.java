package com.example.apitest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
		jokeAPI();
		System.exit(0);
	}

	/**
	 * Retrieves, reads, and prints JSON data collected from joke API.
	 */
	public static void jokeAPI() {
		try {
			String url = "https://official-joke-api.appspot.com/random_joke";
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();

			String jSonJoke = restTemplate.getForObject(url, String.class);
			JsonNode root = mapper.readTree(jSonJoke);

			//gets setup
			String setup = root.findValue("setup").asText();
			//gets punchline
			String punchline = root.findValue("punchline").asText();
			//print vals
			System.out.println(setup + " " + punchline);
		} catch (JsonProcessingException ex) {
			System.out.println("error in ravenPrice");
		}
	}
}