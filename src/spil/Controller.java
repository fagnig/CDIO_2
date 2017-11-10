package spil;

import java.util.Random;

import desktop_codebehind.Car;

import java.awt.Color;
import java.io.Console;

import desktop_resources.GUI;

public class Controller {
	private Spiller[] player = new Spiller[2];
	private int currentTurn;
	
	private boolean extraTurn = false;
	
	
	
	public void go() {
		
		while(true) {
			
			GUI.getUserButtonPressed(Language.newTurn(player[currentTurn].getNavn()), Language.newTurnConfirm());
			
			int kast = player[currentTurn].playTurn();
			switch(kast) {
			//Tower, +250
			case 2:
				player[currentTurn].addPoints(250);
				
				break;
			
			//Crater, -100
			case 3:
				player[currentTurn].addPoints(-100);
				
				break;
				
			//Palace gates, +100
			case 4:
				player[currentTurn].addPoints(100);
				
				break;
			
			//Cold desert, -20
			case 5:
				player[currentTurn].addPoints(-20);
				
				break;
				
			//Walled city, +180
			case 6:
				player[currentTurn].addPoints(180);
				
				break;
				
			//Monastery, +0
			case 7:
				
				break;
				
			//Black cave, -70
			case 8:
				player[currentTurn].addPoints(-70);
				
				break;
				
			//Huts in the mountain, +60
			case 9:
				player[currentTurn].addPoints(60);
				
				break;
				
			//Werewall, -80 + ekstra tur
			case 10:
				player[currentTurn].addPoints(-80);
				extraTurn = true;
				break;
				
			//The pit, -50
			case 11:
				player[currentTurn].addPoints(-50);
				break;
			
			//Goldmine, +650
			case 12:
				player[currentTurn].addPoints(650);
				break;
			}
			
			//Hvis spilleren gik fallit, vinder den næste spiller 
			if(player[currentTurn].getBankrupt()) {
				playerWon(player[(currentTurn+1) % player.length].getNavn());
				break;
			}
			if(player[currentTurn].getPoints()>=3000) {
				playerWon(player[currentTurn].getNavn());
				break;
			}
			

			GUI.removeAllCars(player[currentTurn].getNavn());
			GUI.setCar(kast, player[currentTurn].getNavn());
			
			
			GUI.setChanceCard(Language.fieldInfo(kast));
			GUI.displayChanceCard();
			
			
			
			
			
			
			if(extraTurn)
				extraTurn = false;
			else
				currentTurn = (currentTurn+1) % player.length;
		}
	}

	
	public void playerWon(String navn) {
		GUI.displayChanceCard(Language.playerWon(navn));
		if(GUI.getUserLeftButtonPressed(Language.replay(), Language.replayConfirm(), Language.replayDecline())) {
			init();
		} else {
			System.exit(0);
		}
	}
	
	public Controller() {

	}
	
	public void init() {
		Board.init();
		player[0] = new Spiller("Kaj");
		player[1] = new Spiller("Børge");
		currentTurn = 0;
		Car car1 = new Car.Builder()
			    .primaryColor(Color.MAGENTA)
			    .secondaryColor(Color.BLUE)
			    .typeTractor() 
			    .patternDotted() 
			    .build();
		Car car2 = new Car.Builder()
			    .primaryColor(Color.RED)
			    .secondaryColor(Color.GREEN)
			    .typeTractor() 
			    .patternDotted() 
			    .build();
	
		
		GUI.addPlayer(player[0].getNavn(), 1000, car1);
		GUI.addPlayer(player[1].getNavn(), 1000, car2);
		
		go();
	}
	
	public static void main(String [] args) {
		Random g = new Random();
		Controller c = new Controller();
		c.init();
		
	}
	
	public void setFields() {
		
	}
	
}
