
package com.mycompany.a2;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class Game extends Form {
	private GameWorld gw;
	// A boolean containing whether or not the user is attempting to quit the game
	private boolean isQuitting;
	private Container statusView;
	private Container mapView;
	private Container command;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		statusView = new Container(new BoxLayout(BoxLayout.X_AXIS));
		mapView = new Container();
		command = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, statusView);
		add(BorderLayout.WEST, command);
		add(BorderLayout.CENTER, mapView);
		this.show();
		//play();
		
	}
	/*
	private void play() {
		Label myLabel = new Label("Enter a command: ");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt) {
				
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				// If the user types more than one character, don't process it
				if(sCommand.length() != 1)
				{
					System.out.println("Warning: unknown command \"" + sCommand + "\"");
					return;
				}
				if(isQuitting)
				{
					switch(sCommand.charAt(0))
					{
						case 'y':
						case 'Y':
							System.out.println("Game exiting, goodbye!");
							quitGame();
							return;
						default:
							System.out.println("Quitting aborted, resuming game.");
							isQuitting = false;
							return;
					}
				}
				switch (sCommand.charAt(0)) {
					case 's':
						gw.addPlayerShip();
						break;
					case 'a':
						gw.addNewAsteroid();
						break;
					case 'y':
						gw.addNonPlayerShip();
						break;
					case 'b':
						gw.addSpaceStation();
						break;
					case 'i':
						gw.increaseSpeed();
						break;
					case 'd':
						gw.decreaseSpeed();
						break;
					case 'l':
						gw.turnLeft();
						break;
					case 'r':
						gw.turnRight();
						break;
					case '<':
						gw.rotateLauncher();
						break;
					case 'f':
						gw.firePlayerMissile();
						break;
					case 'L':
						gw.fireNonPlayerMissile();
						break;
					case 'n':
						gw.restockMissiles();
						break;
					case 'k':
						gw.asteroidKillShot();
						break;
					case 'e':
						gw.npsKillShot();
						break;
					case 'E':
						gw.playerKillShot();
						break;
					case 'j':
						gw.hyperspace();
						break;
					case 'c':
						gw.playerCrash();
						break;
					case 'h':
						gw.playerNPSCrash();
						break;
					case 'x':
						gw.asteroidCollision();
						break;
					case 't':
						gw.tick();
						break;
					case 'p':
						gw.playerStatus();
						break;
					case 'm':
						gw.map();;
						break;
					case 'q':
						System.out.println("Are you sure you wish to quit? (y / n)");
						isQuitting = true;
						break;
					default:
						System.err.println("Error: Not a valid command.");
				}//end switch
			}//end actionPerformed
		}//end new ActionListener
		);//end addActionListener
	}*/
	// Quits the game
	private void quitGame()
	{
		System.exit(0);
	}	
}
