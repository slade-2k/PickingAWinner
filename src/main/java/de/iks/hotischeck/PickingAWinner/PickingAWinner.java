package de.iks.hotischeck.PickingAWinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PickingAWinner {

	public static void main(String args[]) {
		PickingAWinner pickAWinner = new PickingAWinner();
		pickAWinner.setUp();
	}
	
	public void setUp() {
		try {
			String winner = this.getRandomWinner(registerContestants());
			System.out.println("The winner is " + winner + "!");
		} catch (IOException e) {
			System.out.println("Error! Something went wrong");
			e.printStackTrace();
		}
	}
	
	public List<String> registerContestants() throws IOException {
		List<String> contestantList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String registeredPlayer = null;
		boolean isBlank = false;
		
		while(!isBlank) {
			System.out.print("Enter a name: ");
			registeredPlayer = br.readLine();
			
			if (registeredPlayer.isEmpty()) {
				isBlank = true;
			} else {
				contestantList.add(registeredPlayer);
			}
		}
		return contestantList;
	}
	
	public String getRandomWinner(List<String> contestantList) {
		Random rand = new Random();
		return contestantList.get(rand.nextInt(contestantList.size()));
	}
}
