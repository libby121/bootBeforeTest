package com.example.SpringBootExe3Movie.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootExe3Movie.beans.Director;


public interface DirectorRepository extends JpaRepository<Director, Integer> {

}
