package spil;

public class Field {
	private int id;
	private String titleText;
	private String subText;
	
	public Field(int id, String tt, String st) {
		this.id = id;
		this.titleText = tt;
		this.subText = st;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return titleText;
	}
	
	public String getSubtext() {
		return subText;
	}
	
}
