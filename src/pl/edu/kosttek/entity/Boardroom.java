package pl.edu.kosttek.entity;




public class Boardroom implements BaseObject {

	private int id;

	private String title;

	private String name;

	private String description;
	
	public Boardroom( String title,String name, String description){
		
		setTitle(title);
		setName(name);
		setDescription(description);
	}
	
	public Boardroom(){
		
	}
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
}
