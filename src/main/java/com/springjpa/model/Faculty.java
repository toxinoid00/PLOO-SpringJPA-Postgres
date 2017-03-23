package com.springjpa.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "established_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date established_date;
    private List<Staff> staffs;
    
    public Faculty(){
    	
    }
    
    public Faculty(String name, Date established_date){
    	this.name = name;
    	this.established_date = established_date;
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
    
    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    public List<Staff> getStaff() {
        return staffs;
    }

    public void setStaff(List<Staff> staffs) {
        this.staffs = staffs;
    }
    
    @Override
    public String toString() {
        String result = String.format(
                "Faculty[id=%d, name='%s', established_date='%s']%n",
                id, name, established_date);
        if (staffs != null) {
            for(Staff staff : staffs) {
                result += String.format(
                        "Staff[id=%d, name='%s', address='%s', position='%s']%n",
                        staff.getId(), staff.getName(), staff.getAddress(), staff.getPosition());
            }
        }

        return result;
    }

	public Date getEstablished_date() {
		return established_date;
	}

	public void setEstablished_date(Date established_date) {
		this.established_date = established_date;
	}

}
