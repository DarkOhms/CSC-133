package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.Game;

public class QuitCommand extends Command {
	private Game g;
	public QuitCommand(Game g) {
		
		super("Quit");
		this.g = g;
	}
	public void actionPerformed(ActionEvent e) {
		g.quitGame();
		
	}
}

