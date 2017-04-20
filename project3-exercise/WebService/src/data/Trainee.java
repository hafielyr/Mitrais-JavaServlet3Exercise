package data;
/**
 * 
 * @author trainee
 * Class trainee
 */
public class Trainee {
	private String name;
	private int id;
	/**
	 * getter for name
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter for id
	 * @return int
	 */
	public int getId() {
		return id;
	}
	/**
	 * setter for id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * constructor for trainee
	 * @param name
	 * @param id
	 */
	public Trainee(String name,int id){
		this.name=name;
		this.id=id;
	}
}
