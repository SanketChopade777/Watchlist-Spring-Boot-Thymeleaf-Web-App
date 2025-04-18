package com.example.demo.watchlist.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.watchlist.entity.Movie;
import com.example.demo.watchlist.service.DatabaseService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;


@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
		
		String viewName="watchlistItemForm";
		Map<String,Object>model = new HashMap<>();
		
		if(id==null) {
			model.put("watchlistItem",new Movie());
		}
		else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
	    		
	    return new ModelAndView(viewName,model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("watchlistItemForm");
		}
		
		Integer id=movie.getId();
		if(id==null) {
			databaseService.create(movie);
		}
		else {
			databaseService.update(movie,id);
		}
		
		RedirectView rd=new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		String viewName="watchlist";
		Map<String, Object> model=new HashMap<>();
		List<Movie> movieList=databaseService.getAllMovies();
		System.out.println(movieList);
		model.put("watchlistrows", movieList);
		model.put("noofmovies", movieList.size());
		return new ModelAndView(viewName,model);
	}
	
	@GetMapping("/deleteMovie/{id}")
	public ModelAndView deleteById(@PathVariable(value="id") Integer id) {
		databaseService.delete(id);
		RedirectView rd=new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
}
