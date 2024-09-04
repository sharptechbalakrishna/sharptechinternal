package com.sharp.dto;

import com.sharp.model.Updates;

import java.sql.Date;
import java.util.List;

public class UpdatesReqRes {

	private Long id;
	private String title;
	private String Description;
	private Date ReleaseDate;
	private String CreatedBy;
	private Date createdDate;
	private boolean visible;
	private String url;
	private int statusCode;
	private String message;
	private List<Updates> updatesList;
	
	
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
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Updates> getUpdatesList() {
		return updatesList;
	}
	public void setUpdatesList(List<Updates> updatesList) {
		this.updatesList = updatesList;
	}

	
}
