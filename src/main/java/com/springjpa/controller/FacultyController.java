package com.springjpa.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Faculty;
import com.springjpa.repository.FacultyRepository;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {
	@Autowired
	FacultyRepository repository;
	
	@RequestMapping("/save")
	public String process(){
		repository.save(new Faculty("FacultyA", new Date()));
		repository.save(new Faculty("FacultyB", new Date()));
		return "Done";
	}
	
	@RequestMapping("/findbyid")
	public Faculty findById(@RequestParam("id") Integer id) {
		return repository.findOne(id);
	}
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Faculty faculty : repository.findAll()){
			result += "<div>" + faculty.toString() + "</div>";
		}		
		return result + "</html>";
	}
}
