package com.mycompany.a2;

import java.util.Iterator;

public interface IGameWorld {

	public Iterator<GameObject> getIterator();
	
	public int getPlayerScore();

	public int getPlayerLives();
	
	public int getElapsedGameTime();
	
	public int getMissiles();

	
}
