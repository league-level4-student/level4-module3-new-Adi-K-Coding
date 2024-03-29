package _02_Rainbow_Zombie_Conga_Line;

import java.util.ArrayList;
import java.util.Iterator;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;
import _01_Spies_On_A_Train.TrainCar;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct them
	 * through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can start
	 * the party by running the main method in RainbowZombieDanceParty and typing
	 * how many rounds you want in the console to see if they followed your
	 * choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5 rounds
	 * the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {
		dancer = congaLine.getHead().getValue();
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		dancer = congaLine.getTail().getValue();
	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		int positionCounter = 0;
		Node<Zombie> current = congaLine.getHead();
		while (current != null) {
			if (positionCounter == position) {
				congaLine.add(dancer);
			}
			current = current.getNext();
			positionCounter += 1;
		}
	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		int positionCounter = 0;
		ZombieHatColor dancerHatColor = dancer.getZombieHatColor();
		Node<Zombie> current = congaLine.getHead();
		while (current != null) {
			if (current.getValue().getZombieHatColor().equals(dancerHatColor)) {
				congaLine.remove(positionCounter);
			}
			current = current.getNext();
			positionCounter += 1;
		}
	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		int positionCounter = 0;
		ZombieHatColor dancerHatColor = dancer.getZombieHatColor();
		Node<Zombie> current = congaLine.getHead();
		while (current != null) {
			if (current.getValue().getZombieHatColor().equals(dancerHatColor)) {
				congaLine.remove(positionCounter);
				break;
			}
			current = current.getNext();
			positionCounter += 1;
		}
	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		int counter = 0;
		Zombie dancer1 = new Zombie(dancer.getZombieHatColor());
		Zombie dancer2 = new Zombie(dancer.getZombieHatColor());
		congaLine.add(dancer2);
		Node<Zombie> head = new Node<Zombie>(dancer1);
		Node<Zombie> soonToBeOldHead = congaLine.getHead();
		soonToBeOldHead.setPrev(head);
		head.setNext(soonToBeOldHead);
		congaLine.setHead(head);
		Node<Zombie> current = head;
		while (current != null) {
			counter += 1;
			current = current.getNext();
		}
		int middle = counter / 2;
		current = head;
		for (int i = 0; i < middle; i++) {
			current = current.getNext();
		}
		Node<Zombie> middleZombie = new Node<Zombie>(dancer);
		Node<Zombie> current1 = current.getPrev();
		current.setPrev(middleZombie);
		middleZombie.setNext(current);
		middleZombie.setPrev(current1);
		current1.setNext(middleZombie);
	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */
	public void rainbowBrains(Zombie dancer) {
		Node<Zombie> head = new Node<Zombie>(dancer);
		Node<Zombie> current = head;
		congaLine.setHead(current);
		ArrayList<Zombie> zombiesList = new ArrayList<Zombie>();
		zombiesList.add(new Zombie(ZombieHatColor.R));
		zombiesList.add(new Zombie(ZombieHatColor.O));
		zombiesList.add(new Zombie(ZombieHatColor.Y));
		zombiesList.add(new Zombie(ZombieHatColor.G));
		zombiesList.add(new Zombie(ZombieHatColor.B));
		zombiesList.add(new Zombie(ZombieHatColor.I));
		zombiesList.add(new Zombie(ZombieHatColor.V));
		for (int i = 0; i < 7; i++) {
			congaLine.add(zombiesList.get(i));

		}
	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}
