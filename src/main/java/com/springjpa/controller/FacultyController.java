package com.springjpa.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.springjpa.model.Faculty;
import com.springjpa.repository.FacultyRepository;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
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
	
    @RequestMapping(value="/form", method=RequestMethod.GET)
    public String facultyForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "form";
    }

    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String facultySubmit(@ModelAttribute Faculty faculty, Model model) {
        model.addAttribute("faculty", faculty);
        //faculty.setEstablished_date(new Date());
        String info = String.format("Faculty Submission: Faculty Name = %s, Established Date = %s", 
        								faculty.getName(), faculty.getEstablished_date());
        log.info(info);
        repository.save(faculty);
                
        return "result";
    }
    
    @RequestMapping(value="/load", method=RequestMethod.GET)
    public String facultySubmit(@RequestParam("id") int id, Model model) { 	
        Faculty faculty = repository.findOne(id);
        model.addAttribute("faculty", faculty);
        
        return "load";
    }
}
