package com.example.SpringBootExe3Movie.db;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootExe3Movie.beans.GenreType;
import com.example.SpringBootExe3Movie.beans.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	List<Movie>findByGenreLike(GenreType type);
	List<Movie>findByShowTimeLike(Date showTime);
	List<Movie>findByShowTimeBetween(Date one, Date two);
	
	
}
