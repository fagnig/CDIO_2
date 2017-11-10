package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.Cup;

public class TestCup {

	Cup c1;
	@Before
	public void setUp() throws Exception {
		c1 = new Cup();
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRollBounds() {
		int antalTerningKast = 60000;
		
		for (int i=1; i<=antalTerningKast; i++) {
			c1.kast();
			if (c1.getSum()<2 || c1.getSum()>12) {
				fail("outside bounds");
			}
		}
		
	}

	@Test
	public void testRollAccuracy() {
		int antalTerningKast = 1000;
		int count[] = new int[12];
		int benis[] = new int[12];
		int countDouble = 0;
		int occuranceCount = 0;
		
		benis[0] = 0;
		benis[1] = (1/36)*antalTerningKast;
		benis[2] = (2/36)*antalTerningKast;
		benis[3] = (3/36)*antalTerningKast;
		benis[4] = (4/36)*antalTerningKast;
		benis[5] = (5/36)*antalTerningKast;
		benis[6] = (6/36)*antalTerningKast;
		benis[7] = (5/36)*antalTerningKast;
		benis[8] = (4/36)*antalTerningKast;
		benis[9] = (3/36)*antalTerningKast;
		benis[10] = (2/36)*antalTerningKast;
		benis[11] = (1/36)*antalTerningKast;
		
		//Rolling the dice
		for (int i=1; i<=antalTerningKast; i++) {
			c1.kast();
			count[c1.getSum()-1]++;
			if (c1.getEns()) {
				countDouble++;
			}
		}
		
		//Printing for user
		for (int i=0; i<=11; i++) {
			System.out.print((i+1)+" optræder: ");
			System.out.println(count[i]+" gange.");
		}
		//Calculates sum of occurance
		for (int i=0; i<=11; i++) {
			occuranceCount += count[i];
			
		}
		//Printing for user
		System.out.println("\n"+"vi har kastet "+ occuranceCount + " gange \n");
		System.out.println("vi slog 2 ens: "+countDouble+" gange.");
		
		
		//Ensuring it's inside legal limits
		for (int i=0; i>=11; i++) {
			assertTrue("outside threshhold", count[i]>=benis[i]+0.05*antalTerningKast);
			assertTrue("outside threshhold", count[i]<=benis[i]-0.05*antalTerningKast);
		}
		
		assertTrue("outside threshhold", countDouble>=antalTerningKast/6-0.05*antalTerningKast);
		assertTrue("outside threshhold", countDouble<=antalTerningKast/6+0.05*antalTerningKast);
		
	}


}