package spil;

import desktop_resources.GUI;

public class Spiller {
	private int id;
	private String navn;
	private static int playerCount;
	private Cup cup;
	
	private Konto account;
	private boolean bankrupt = false;
	
	public Spiller(String navn) {
		this.navn = navn;
		id = playerCount;
		cup = new Cup();
		account = new Konto();
		playerCount++;
	}
	
	public int getPlayerCount() {
		return playerCount;
	}
	
	public int kast() {
		return cup.kast();
	}
	
	public int getPoints() {
		return account.getAmount();
	}
	
	public boolean addPoints(int p) {
		//Add amount returnerer false, hvis saldoen sættes under 0
		if(!account.addAmount(p)) {
			bankrupt = true;
		}
		GUI.setBalance(navn, getPoints());

		return bankrupt;
	}
	
	public boolean getBankrupt() {
		return bankrupt;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public int[] getValues() {
		return cup.getValues();
	}
}
