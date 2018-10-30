package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.Game;

public class SoundCommand extends Command {
	private Game g;
	public SoundCommand(Game g) {
		
		super("Sound");
		this.g = g;
		// TODO Auto-generated constructor stub
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("SoundCommand invoked.");
		
	}
}

