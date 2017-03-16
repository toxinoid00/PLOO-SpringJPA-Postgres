package com.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Faculty;
import com.springjpa.model.Staff;
import com.springjpa.repository.FacultyRepository;
import com.springjpa.repository.StaffRepository;

@RestController
@RequestMapping(value = "/staff")
public class StaffController {
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@RequestMapping("/save")
	public String process(){
		staffRepository.save(new Staff("Adjie", "Sarijadi", "PM", facultyRepository.findByName("FacultyA").get(0)));
		return "Done";
	}
	
	@RequestMapping("/findbyid")
	public Staff findById(@RequestParam("id") Integer id) {
		return staffRepository.findOne(id);
	}
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "<html>";
		
		for(Staff staff : staffRepository.findAll()){
			result += "<div>" + staff.toString() + "</div>";
		}		
		return result + "</html>";
	}
	
	@RequestMapping("/create")
	public Staff create(@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("position") String position,
			@RequestParam("faculty") String faculty_name) {
		Faculty faculty = facultyRepository.findByName(faculty_name).get(0);
		
		return staffRepository.save(new Staff(name, address, position, faculty));
	}
}
