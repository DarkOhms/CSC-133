package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddSpaceStationCommand extends Command{
	private GameWorld gw;
	public AddSpaceStationCommand(GameWorld gw) {
		
		super("Add Space Station");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e) {
		gw.addSpaceStation();
		
	}

	
}
