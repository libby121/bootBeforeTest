package com.example.SpringBootExe3Movie.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cinemas")
public class Cinema {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String city;
	
	@Column
	private int numOfScreens;
	@ManyToMany
	@JoinTable(name="movies_vs_cinemas", joinColumns=@JoinColumn(name="cinema"),inverseJoinColumns=@JoinColumn(name="movie"))
	private Set<Movie>movies;
	public Cinema() {
		super();
	}
	public Cinema(String name, String city, int numOfScreens) {
		super();
		this.name = name;
		this.city = city;
		this.numOfScreens = numOfScreens;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNumOfScreens() {
		return numOfScreens;
	}
	public void setNumOfScreens(int numOfScreens) {
		this.numOfScreens = numOfScreens;
	}
	public int getId() {
		return id;
	}
	public Set<Movie> getMovies() {
		return movies;
	}
	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", city=" + city + ", numOfScreens=" + numOfScreens + ", movies="
				+ movies + "]";
	}
	
	
	
}
