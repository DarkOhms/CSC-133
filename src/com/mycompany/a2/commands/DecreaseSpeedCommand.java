package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class DecreaseSpeedCommand extends Command{
	private GameWorld gw;
	public DecreaseSpeedCommand(GameWorld gw) {
		
		super("Decrease Speed");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e) {
		gw.decreaseSpeed();
		
	}

	
}
