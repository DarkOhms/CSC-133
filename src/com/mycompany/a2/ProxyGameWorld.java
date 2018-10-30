package com.mycompany.a2;

import java.util.Iterator;

public class ProxyGameWorld extends GameWorld implements IGameWorld {
	
	GameWorld gw;//Reference to the actual GameWorld
	
	public ProxyGameWorld(GameWorld gw) {
		this.gw = gw;
	}
	@Override
	public Iterator<GameObject> getIterator() {
		
		return gw.getIterator();
	}
	@Override
	public int getPlayerScore() {
		return gw.getPlayerScore();
	}
	@Override
	public int getPlayerLives() {
		return gw.getPlayerLives();
	}
	@Override
	public int getElapsedGameTime() {
		return gw.getElapsedGameTime();
	}
	@Override
	public int getMissiles() {
		
		return gw.getMissiles();
	}
}
