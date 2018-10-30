package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnLeftCommand extends Command{
	private GameWorld gw;
	public TurnLeftCommand(GameWorld gw) {
		
		super("Turn Left");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e) {
		gw.turnLeft();
		
	}

	
}
