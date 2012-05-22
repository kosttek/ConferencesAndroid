package pl.edu.kosttek.entity;






public class Presentation {

	private int id;

	private String title;

	private String description;

	private Speaker speaker;
	
	public Presentation() {
	
	}
	public Presentation(final String title,final String description,final Speaker speaker){
		
		setTitle(title);
		setDescription(description);
		setSpeaker(speaker);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
}
