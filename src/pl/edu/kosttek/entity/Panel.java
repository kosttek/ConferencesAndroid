package pl.edu.kosttek.entity;



public class Panel implements BaseObject {


	private int id;

	private String name;

	private String description;
	
	public Panel( String name, String description){
		
		setName(name);
		setDescription(description);
	}
	
	public Panel(){
		
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
	
}
