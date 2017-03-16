package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Staff implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private String address;
    private String position;
    private Faculty faculty;
    
    public Staff(){
    	
    }
    public Staff(String name, String address, String position, Faculty faculty){
    	this.name = name;
    	this.address = address;
    	this.position = position;
    	this.faculty = faculty;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
    @ManyToOne
    @JoinColumn(name = "faculty_id")
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	  
	@Override
	public String toString() {
		return String.format(
				"Staff[id=%d, name=%s, address=%s, position=%s, faculty=%s, faculty_name=%s, faculty_date=%s]",
				id, name, address, position, faculty.getId(), faculty.getName(), faculty.getEstablished_date());
	}
}
