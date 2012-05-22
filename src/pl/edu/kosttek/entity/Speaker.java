package pl.edu.kosttek.entity;





public class Speaker {

	private int id;

	private String name;

	private String lastName;

	private String description;
//	@OneToOne(fetch=FetchType.LAZY, mappedBy="speaker")
//	private Presentation presentation;
	
	public Speaker(){
		
	}
	public Speaker(final String name,final String lastName,final String description){
		
		setName(name);
		setLastName(lastName);
		setDescription(description);
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
