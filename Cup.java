package spil;

import java.util.Random;
import desktop_resources.GUI;




public class Cup {

	private Random randGen;
	public Cup() {
		randGen = new Random();
	}
	private int t1 = 0;
	private int t2 = 0;
	public int kast() {
		t1 = randGen.nextInt(6)+1;
		t2 = randGen.nextInt(6)+1;
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