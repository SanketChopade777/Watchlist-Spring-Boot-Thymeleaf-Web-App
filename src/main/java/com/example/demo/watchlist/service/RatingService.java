package com.example.demo.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
	
	String apiUrl="https://www.omdbapi.com/?apikey=9b49409f&t=";
	
	public String getMovieRating(String title) {
		
		try {
			RestTemplate template=new RestTemplate();
			ResponseEntity<ObjectNode> response=template.getForEntity(apiUrl+title, ObjectNode.class);
			
			ObjectNode jsonObject = response.getBody();
			System.out.println(jsonObject.path("imdbRating").asText());
			
			return jsonObject.path("imdbRating").asText();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Either Movie name not Available or API is Down!"+e.getMessage());
			return null;
		}
	}
}
