package spil;

import java.util.Random;
import desktop_resources.GUI;




public class Cup2 {

	private Random randGen;
	public Cup2() {
		randGen = new Random();
	}
	private int t1 = 0;
	private int t2 = 0;
	public int kast() {
		t1 = 1;
		t2 = 2;
		GUI.setDice(t1, t2);
		return getSum();
	}
	
	public int getSum() {
		return t1 + t2;
	}
	
	public boolean getEns() {
		return (t1==t2);
	}
}