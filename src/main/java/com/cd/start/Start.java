package com.cd.start;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Start {
	
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String Title;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="Artist")
	private List<artist> artists;
	
	
	
	

	public Start() {

	}
	
	public Start(String Title, List<Start> artist) {
		this.Title = Title;
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	
	
	
}
