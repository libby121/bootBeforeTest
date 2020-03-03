package com.example.SpringBootExe3Movie.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id // PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AI properties
	private int id;

	@Column
	private String title;

	@Column
	private GenreType genre;

	@Column
	private int duration;

	@Column
	private Date showTime;

	@ManyToOne
	private Director director;

	public Movie() {//Hibernate select*
		super();
		
		
		
	}

	public Movie(String title, GenreType genre, int duration, Date showTime, Director director) {
		super();
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.showTime = showTime;
		this.director = director;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public GenreType getGenre() {
		return genre;
	}

	public void setGenre(GenreType genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getShowTime() {
		return showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", genre=" + genre + ", duration=" + duration + ", showTime="
				+ showTime + ", director=" + director + "]";
	}

	
	
}
