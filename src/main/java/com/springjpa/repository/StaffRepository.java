package com.springjpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.model.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Integer>{
	List<Staff> findByName(String name);
}
