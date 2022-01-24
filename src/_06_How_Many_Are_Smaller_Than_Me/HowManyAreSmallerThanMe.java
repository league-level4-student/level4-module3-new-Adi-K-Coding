package _06_How_Many_Are_Smaller_Than_Me;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

	/*
	 * Given an AVLTree filled with the random numbers from 1 to 20, and a single
	 * number within the AVL Tree, figure out how many numbers in the AVLTree are
	 * bigger than the provided number and return the result.
	 * 
	 * You may want to create a helper method to search through the AVLTree and
	 * count iteratively or recursively.
	 */

	public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
		AVLNode<Integer> root = avlTree.getRoot();
		return search(root, me);

	}

	int search(AVLNode<Integer> treeNode, int me) {
		int counter = 0;
		if (treeNode.getValue() < me) {
			counter += 1;
		}
		counter += search(treeNode.getLeft(), me);
		counter += search(treeNode.getRight(), me);
		return counter;
	}

}
