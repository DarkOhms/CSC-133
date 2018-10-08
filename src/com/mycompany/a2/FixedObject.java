package com.mycompany.a2;

public class FixedObject extends GameObject {
	static int ID =0;
	private int id;
	
	public FixedObject() {
		this.id = ID;
		ID++;
	}

	public int getId() {
		return id;
	}
	
	
}
