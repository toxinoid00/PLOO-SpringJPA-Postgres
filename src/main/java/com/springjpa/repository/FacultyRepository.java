package com.springjpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.model.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer>{
	List<Faculty> findByName(String name);
}
