package pl.edu.kosttek.entity;

import java.io.Serializable;
import java.util.Date;


public class Conference implements Serializable{
	

	private int id;

	private String title;

	private String description;

	private Date startDate;

	private Date endDate;
	
	public Conference(){	
	}
	
	public Conference( String title, String description, Date startDate, Date endDate){
		
		setTitle(title);
		setDescription(description);
		setStartDate(startDate);
		setEndDate(endDate);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
