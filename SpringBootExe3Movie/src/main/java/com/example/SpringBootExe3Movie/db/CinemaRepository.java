package com.example.SpringBootExe3Movie.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootExe3Movie.beans.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer>{

	List<Cinema>findByCityLike(String city);
}
