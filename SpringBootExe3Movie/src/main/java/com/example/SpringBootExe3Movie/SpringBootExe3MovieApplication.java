package com.example.SpringBootExe3Movie;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.SpringBootExe3Movie.beans.Cinema;
import com.example.SpringBootExe3Movie.beans.Director;
import com.example.SpringBootExe3Movie.beans.GenreType;
import com.example.SpringBootExe3Movie.beans.Movie;
import com.example.SpringBootExe3Movie.facade.ManagerFacade;

@SpringBootApplication
public class SpringBootExe3MovieApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=SpringApplication.run(SpringBootExe3MovieApplication.class, args);
	ManagerFacade meni=ctx.getBean(ManagerFacade.class);
//	meni.addCinema(new Cinema("la cinema", "holon", 5));
//	meni.addCinema(new Cinema("cinema2", "bat-yam", 3));
//	meni.addCinema(new Cinema("cinema3", "herzliya", 4));
//	meni.addCinema(new Cinema("cinema4", "givatayim", 7));
	
//	meni.addDirector(new Director("yoram malull", 12));
//	
//	meni.addDirector(new Director("yiftach ben asher", 20));
//	
//	meni.addDirector(new Director("meni amar", 25));
//	
//	meni.addDirector(new Director("efrat shabtai", 8));

	
	meni.addMovie(new Movie("movie1",GenreType.comedy,120,Date.valueOf("2020-03-20",meni.getOneDirector(1))));
	
	}
	
}
