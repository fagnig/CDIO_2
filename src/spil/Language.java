package spil;

import desktop_resources.GUI;

public class Language {
	

	public static String score(int score) {
		return "kassebeholdning: " + score;
	}
	
	public static String newTurn(String navn) {
		return navn + ", ryst terningerne!";
	}
	
	public static String newTurnConfirm() {
		return "Lad os rulle!";
	}
	
	
	public static String fieldInfo(int id) {
		String txt = "ab";
		switch(id) {
			//Tower, +250
			case 2:
				txt = "Du lander på tårnet og det er flot, +250 point!";
				break;
			
			//Crater, -100
			case 3:
				txt = "Du faldt i hullet, øv hva? -100";
				
				break;
				
			//Palace gates, +100
			case 4:
				txt = "Du fandt porten til paladset, +100";
				
				break;
			
			//Cold desert, -20
			case 5:
				txt = "En meget kold ørken, og du fryser 20 point væk :(";
				
				break;
				
			//Walled city, +180
			case 6:
				txt = "Mur til byen gi'r 180 dolar i lommen";
				
				break;
				
			//Monastery, +0
			case 7:
				txt = "Ingen kan lide en monk, men de straffes heller ikke";
				break;
				
			//Black cave, -70
			case 8:
				txt = "En mørk grotte spiser 70 point fra dig";
				
				break;
				
			//Huts in the mountain, +60
			case 9:
				txt = "Hytter i bjergene tjener 60 dolar til dig idag";
				
				break;
				
			//Werewall, -80 + ekstra tur
			case 10:
				txt = "En varemur tager 80 point fra dig, men giver dig en ekstra tur!";
				break;
				
			//The pit, -50
			case 11:
				txt = "Du faldt i hullet, og mister 50 danske dolars";
				break;
			
			//Goldmine, +650
			case 12:
				txt = "Du fandt en guldmine og tjente 650 points :D";
				break;
		}
		return txt;
	}
	
	public static String replay() {
		return "Start et nyt spil?";
	}

	public static String replayConfirm() {
		return "ja tak!";
	}
	
	public static String replayDecline() {
		return "nej, det var rigtig dårligt :(";
	}
	
	public static String playerWon(String navn) {
		return "Spilleren " + navn + " vandt spillet!";
	}
	
	public static Field[] getFields() {
		Field[] tempFields = new Field[11];
		tempFields[0] = new Field(2, "Tower", "+250 Point");
		tempFields[1] = new Field(3, "Crater", "-100 Point");
		tempFields[2] = new Field(4, "Palace gates", "+100 Point");
		tempFields[3] = new Field(5, "Cold desert", "-20 Point");
		tempFields[4] = new Field(6, "Walled city", "+180 Point");
		tempFields[5] = new Field(7, "Monastery", "+0 Point");
		tempFields[6] = new Field(8, "Black cave", "-70 Point");
		tempFields[7] = new Field(9, "Huts in the mountain", "+60 Point");
		tempFields[8] = new Field(10, "Werewall", "-80 Point, ekstra tur");
		tempFields[9] = new Field(11, "The pit", "-50 Point");
		tempFields[10] = new Field(12, "Goldmine", "+650 Point");
		return tempFields;
	}
}
