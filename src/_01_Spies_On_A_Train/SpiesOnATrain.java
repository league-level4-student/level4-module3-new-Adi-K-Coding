package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency! You
	 * know the spy is somewhere on this train(LinkedList). Your job is to find the
	 * suspect that matches the description given to you by the list of clues(the
	 * array).
	 * 
	 * Walk through the train, questioning each of the passengers about what they
	 * have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */

	String findIntel(LinkedList<TrainCar> train, String[] clues) {
		HashMap<String, Integer> names = new HashMap<String, Integer>();
		for (int i = 0; i < clues.length; i++) {
			System.out.println(clues[i]);
		}
		Node<TrainCar> current = train.getHead();
		String spyName = "bob";
		while (current != null) {
			System.out.println(current.getValue().questionPassenger());
			for (int i = 0; i < clues.length; i++) {
				if (current.getValue().questionPassenger().contains(clues[i])) {
					int indexClue = current.getValue().questionPassenger().indexOf(clues[i]) - 1;
					String leadingIntoClue = current.getValue().questionPassenger().substring(0, indexClue);
					int nameIndex = leadingIntoClue.lastIndexOf(" ") + 1;
					spyName = leadingIntoClue.substring(nameIndex, indexClue);
					if (names.containsKey(spyName)) {
						names.put(spyName, names.get(spyName) + 1);
					} else {
						names.put(spyName, 1);
					}
				}
			}
			current = current.getNext();
		}
		for (String name : names.keySet()) {
			if (names.get(name) == 3) {
				spyName = name;
			}
		}
		System.out.println(spyName);
		return spyName;

	}

}
