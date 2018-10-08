package com.mycompany.a2;

public class SpaceStation extends FixedObject{
	
	private int blinkRate;
	
	public SpaceStation() {
		blinkRate = (this.getRandom()).nextInt(4);
	}

	public int getBlinkRate() {
		return blinkRate;
	}

}
