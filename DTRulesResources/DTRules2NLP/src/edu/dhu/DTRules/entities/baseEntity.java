package edu.dhu.DTRules.entities;

public class baseEntity {

	public static int id_counter = 1;
	public int id;
	
	public baseEntity(){
		id = id_counter++;
	}

	public static int getId_counter() {
		return id_counter;
	}

	public static void setId_counter(int id_counter) {
		baseEntity.id_counter = id_counter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
