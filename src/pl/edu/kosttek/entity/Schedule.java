package pl.edu.kosttek.entity;

import java.util.Date;


public class Schedule {

	private int id;

	private Date startDate;

	private Date endDate;

	private Presentation presentation;

	private Panel panel;

	private Conference conference;

	private Boardroom boardroom;
	
	
	public Date getStartDate() {
		return startDate;
	}
	public Schedule(){
		
	}
	
	public Schedule(Date startDate, Date endDate, Presentation presentation,
			Panel panel, Conference conference, Boardroom boardroom) {
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.presentation = presentation;
		this.panel = panel;
		this.conference = conference;
		this.boardroom = boardroom;
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

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public Boardroom getBoardroom() {
		return boardroom;
	}

	public void setBoardroom(Boardroom boardroom) {
		this.boardroom = boardroom;
	}
}
