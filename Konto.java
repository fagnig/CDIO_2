package spil;

import desktop_resources.GUI;

public class Konto {
	private int amount;
	
	public Konto() {
		amount = 1000;
	}
	
	public String toString() {
		return Language.score(amount);
	}
	
	public int getAmount() {
		return amount;
	}
	
	public boolean addAmount(int i) {
		amount += i;
		if(amount<0) {
			amount = 0;
			return false;
		}
		return true;
	}
}


