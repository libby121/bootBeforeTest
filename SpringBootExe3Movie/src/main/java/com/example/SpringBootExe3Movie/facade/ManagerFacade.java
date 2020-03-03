package com.example.SpringBootExe3Movie.facade;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootExe3Movie.beans.Cinema;
import com.example.SpringBootExe3Movie.beans.Director;
import com.example.SpringBootExe3Movie.beans.GenreType;
import com.example.SpringBootExe3Movie.beans.Movie;
import com.example.SpringBootExe3Movie.db.CinemaRepository;
import com.example.SpringBootExe3Movie.db.DirectorRepository;
import com.example.SpringBootExe3Movie.db.MovieRepository;

@Service
public class ManagerFacade {

	@Autowired
	private CinemaRepository cinemarepo;
	@Autowired
	private DirectorRepository directorepo;
	@Autowired
	private MovieRepository movierepo;
	
	public void addCinema(Cinema cinema) {
		cinemarepo.save(cinema);
	}
	
	
	public void addDirector(Director director) {
		directorepo.save(director);
	}
	
	
	public void addMovie(Movie movie) {
		movierepo.save(movie);
	}
	
	
	public void updateCinema(Cinema cinema) {
		if(cinemarepo.existsById(cinema.getId()))cinemarepo.save(cinema);
		
	}
	public void updateMovie(Movie movie) {
		if(movierepo.existsById(movie.getId()))movierepo.save(movie);
		
	}
	public void updateDirector(Director director) {
		if(directorepo.existsById(director.getId()))directorepo.save(director);
		
	}
	
	public void deleteCinema(int id) {
		
		cinemarepo.deleteById(id);
	}
	
	public void deleteDirector(int id) {
		for (Movie movie : movierepo.findAll()) {
			if(movie.getDirector().getId()==id)movierepo.delete(movie);;
		}
		directorepo.deleteById(id);
	}
	
	public void deleteMovie(int id) {
		
		movierepo.deleteById(id);
	}
	
	
	public List<Cinema>getAllCinemas(){
		return cinemarepo.findAll();
	}
	public List<Director>getAllDirectors(){
		return directorepo.findAll();
	}
	public List<Movie>getAllMovies(){
		return movierepo.findAll();
	}
	
	public Cinema getOneCinema(int id) {
		return cinemarepo.findById(id).orElse(null);
	}
	
	public Director getOneDirector(int id) {
		return directorepo.findById(id).orElse(null);
	}
	
	public Movie getOneMovie(int id) {
		return movierepo.findById(id).orElse(null);
	}
	
	public List<Movie>moviesByGenre(GenreType type){
		return movierepo.findByGenreLike(type);
	}
	public List<Movie>moviesByDate(Date date){
		return movierepo.findByShowTimeLike(date);
	}
	public List<Movie>moviesByTimes(Date one,Date two){
		return movierepo.findByShowTimeBetween(one, two);
	}
	
	public List <Cinema>cinemasByCity(String city){
		return cinemarepo.findByCityLike(city);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
