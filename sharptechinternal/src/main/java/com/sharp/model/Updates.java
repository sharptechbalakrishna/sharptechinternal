package com.sharp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "updates")
public class Updates {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String Description;
    private Date ReleaseDate;
    private String CreatedBy;
    private Date createdDate;
    private boolean visible;
    private String url;
    
    
    
	public Updates() {
		super();
	}
	public Updates(Long id, String title, String description, Date releaseDate, String createdBy, Date createdDate,
			boolean visible, String url) {
		super();
		this.id = id;
		this.title = title;
		Description = description;
		ReleaseDate = releaseDate;
		CreatedBy = createdBy;
		this.createdDate = createdDate;
		this.visible = visible;
		this.url = url;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
    
    
    
    
	
    
	}
