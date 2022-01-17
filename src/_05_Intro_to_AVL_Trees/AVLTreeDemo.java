package _05_Intro_to_AVL_Trees;

import _03_Intro_to_Binary_Trees.BinaryTree;
import _03_Intro_to_Binary_Trees.BinaryTreeDemo;
import _03_Intro_to_Binary_Trees.Node;

public class AVLTreeDemo {

	/*
	 * An AVLTree is a special BinaryTree that is capable of balancing itself. With
	 * a regular binary bt, depending on the elements inserted, you might have a
	 * root with one very long right branch and one very long left branch with
	 * nothing else in between.
	 * 
	 * 1.) Read through the AVLNode and AVLTree. Notice that the methods are similar
	 * to those in BinaryTree with two important distinctions:
	 * 
	 * a) Each Node has a balance factor that keeps track of how many levels "down"
	 * it is relative to the rest of the bt.
	 * 
	 * b) There are "rotate" helper methods used when a given node gets too
	 * unbalanced(> 1 level out of sync with the rest of the bt) to rotate
	 * branches back into place.
	 * 
	 * 2.) Create a BinaryTree and an AVLTree.
	 * 
	 * 3.) Insert the same values into both bts and observe how they differ using
	 * the print method. Make sure the values you pick unbalance the binary bt.
	 * 
	 * 4.) Try removing elements from both and see how they change using one of the
	 * print methods.
	 */
	BinaryTree<Integer> bt = new BinaryTree<Integer>();
	AVLTree<Integer> at = new AVLTree<Integer>();

	
	public static void main(String[] args) {

		AVLTreeDemo runner = new AVLTreeDemo();
		runner.run();
	}

	void run() {
		bt.insert(5);
		bt.insert(10);
		bt.insert(4);
		//bt.insert(1);
		bt.insert(2);
		bt.insert(55);
		bt.insert(54);
		bt.insert(56);
		bt.printVertical();
		
		
		at.insert(5);
		at.insert(10);
		at.insert(4);
		//at.insert(1);
		at.insert(2);
		at.insert(55);
		at.insert(54);
		at.insert(56);
		at.printVertical();
		

	}
	
}
