
package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.a2.commands.AboutCommand;
import com.mycompany.a2.commands.AddAsteroidCommand;
import com.mycompany.a2.commands.AddNonPlayerShipCommand;
import com.mycompany.a2.commands.AddPlayerShipCommand;
import com.mycompany.a2.commands.AsteroidCollisionCommand;
import com.mycompany.a2.commands.AsteroidKillShotCommand;
import com.mycompany.a2.commands.DecreaseSpeedCommand;
import com.mycompany.a2.commands.FireNonPlayerMissileCommand;
import com.mycompany.a2.commands.FirePlayerMissileCommand;
import com.mycompany.a2.commands.HyperspaceCommand;
import com.mycompany.a2.commands.IncreaseSpeedCommand;
import com.mycompany.a2.commands.NPSKillShotCommand;
import com.mycompany.a2.commands.NewCommand;
import com.mycompany.a2.commands.PlayerCrashCommand;
import com.mycompany.a2.commands.PlayerKillShotCommand;
import com.mycompany.a2.commands.PlayerNPSCrashCommand;
import com.mycompany.a2.commands.QuitCommand;
import com.mycompany.a2.commands.RestockMissilesCommand;
import com.mycompany.a2.commands.RotateLauncherCommand;
import com.mycompany.a2.commands.SaveCommand;
import com.mycompany.a2.commands.SoundCommand;
import com.mycompany.a2.commands.TickCommand;
import com.mycompany.a2.commands.TurnLeftCommand;
import com.mycompany.a2.commands.TurnRightCommand;
import com.mycompany.a2.commands.UndoCommand;

public class Game extends Form {
	
	private GameWorld gw;
	// A boolean containing whether or not the user is attempting to quit the game
	//private boolean isQuitting;
	
	//views
	private PointsView statusView;
	private MapView mapView;
	
	//command panel
	private CommandPanel command;
	
	//overflow commands
	private NewCommand newC;
	private SaveCommand savC;
	private UndoCommand unC;
	private AboutCommand abC;
	private SoundCommand soundC;
	private QuitCommand	quitC;
	
	//main commands
	private AddPlayerShipCommand 		addPlayerShip ;
	private AddAsteroidCommand 			addAsteroid;
	private AddNonPlayerShipCommand 	addNonPlayerShip;
	private IncreaseSpeedCommand 		increaseSpeed;
	private DecreaseSpeedCommand 		decreaseSpeed;
	private TurnLeftCommand 			turnLeft;
	private TurnRightCommand 			turnRight;
	private RotateLauncherCommand 		rotateLauncher;
	private FirePlayerMissileCommand	firePlayerMissile;
	private FireNonPlayerMissileCommand	fireNonPlayerMissile;
	private RestockMissilesCommand		restockMissiles;
	private AsteroidKillShotCommand		asteroidKillShot;
	private NPSKillShotCommand 			nPSKillShot;
	private PlayerKillShotCommand 		playerKillShot;
	private HyperspaceCommand			hyperspace;
	private PlayerCrashCommand			playerCrash;
	private PlayerNPSCrashCommand		playerNPSCrash;
	private AsteroidCollisionCommand	asteroidCollision;
	private TickCommand 				tick;
	
	
	
	
	
	public Game() {
		
		//make GameWorld
		gw = new GameWorld();
		
		
		//make views
		statusView = new PointsView();
		mapView = new MapView();
		
		//make command panel
		command = new CommandPanel(gw);
		
		//make overflow commands
		newC = new NewCommand(this);
		savC = new SaveCommand(this);
		unC = new UndoCommand(this);
		abC = new AboutCommand(this);
		soundC = new SoundCommand(this);
		quitC = new QuitCommand(this);
		
		//make main commands
		addPlayerShip = new AddPlayerShipCommand(gw);
		addAsteroid = new AddAsteroidCommand(gw);
		addNonPlayerShip = new AddNonPlayerShipCommand(gw);
		increaseSpeed = new IncreaseSpeedCommand(gw);
		decreaseSpeed = new DecreaseSpeedCommand(gw);
		turnLeft = new TurnLeftCommand(gw);
		turnRight = new TurnRightCommand(gw);
		rotateLauncher = new RotateLauncherCommand(gw);
		firePlayerMissile = new FirePlayerMissileCommand(gw);
		fireNonPlayerMissile = new FireNonPlayerMissileCommand(gw);
		restockMissiles = new RestockMissilesCommand(gw);
		asteroidKillShot = new AsteroidKillShotCommand(gw);
		nPSKillShot = new NPSKillShotCommand(gw);
		playerKillShot = new PlayerKillShotCommand(gw);
		hyperspace = new HyperspaceCommand(gw);
		playerCrash = new PlayerCrashCommand(gw);
		playerNPSCrash = new PlayerNPSCrashCommand(gw);
		asteroidCollision = new AsteroidCollisionCommand(gw);
		tick = new TickCommand(gw);
		
		
		//set layout and add views and command panel
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, statusView);
		add(BorderLayout.WEST, command);
		add(BorderLayout.CENTER, mapView);
		
		//adding observers
		gw.addObserver(mapView);
		gw.addObserver(statusView);
		
		
		//create command objects
		
		//add keylisteners
		addKeyListener('s', addPlayerShip);
		addKeyListener('a', addAsteroid);
		addKeyListener('y', addNonPlayerShip);
		addKeyListener(-91, increaseSpeed);
		addKeyListener(-92, decreaseSpeed);
		addKeyListener(-93, turnLeft);
		addKeyListener(-94, turnRight);
		addKeyListener('<', rotateLauncher);
		addKeyListener(-90, firePlayerMissile);
		addKeyListener('L', fireNonPlayerMissile);
		addKeyListener('n', restockMissiles);
		addKeyListener('k', asteroidKillShot);
		addKeyListener('e', nPSKillShot);
		addKeyListener('E', playerKillShot);
		addKeyListener('j', hyperspace);
		addKeyListener('c', playerCrash);
		addKeyListener('h', playerNPSCrash);
		addKeyListener('x', asteroidCollision);
		addKeyListener('t', tick);
		
		//initialize the gameworld then show it
		gw.init();
		this.show();
		//play();
		
		//==============================================================================
		//make tool bars
		
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		myToolbar.setTitle("Luke's Super Cool Asteroids");
		
		//overflow
		myToolbar.addCommandToOverflowMenu(newC);
		myToolbar.addCommandToOverflowMenu(savC);
		myToolbar.addCommandToOverflowMenu(unC);
		myToolbar.addCommandToOverflowMenu(soundC);
		myToolbar.addCommandToOverflowMenu(abC);
		myToolbar.addCommandToOverflowMenu(quitC);
		
		//left side menu
		myToolbar.addCommandToLeftSideMenu(addPlayerShip);
		myToolbar.addCommandToLeftSideMenu(addAsteroid);
		myToolbar.addCommandToLeftSideMenu(addNonPlayerShip);
		myToolbar.addCommandToLeftSideMenu(fireNonPlayerMissile);
		myToolbar.addCommandToLeftSideMenu(restockMissiles);
		myToolbar.addCommandToLeftSideMenu(asteroidKillShot);
		myToolbar.addCommandToLeftSideMenu(asteroidCollision);
		myToolbar.addCommandToLeftSideMenu(tick);
		myToolbar.addCommandToLeftSideMenu(quitC);
		
		
		
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
	
	public void quitGame()
	{
		System.exit(0);
	}	
}
