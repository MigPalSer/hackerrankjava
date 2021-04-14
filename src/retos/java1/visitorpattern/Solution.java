package retos.java1.visitorpattern;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



import java.util.ArrayList;
import java.util.Scanner;

/*https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 *Very traumatic challenge, the horrible explain and examples don't make you
 *to figure the undirectional edges between nodes. Worst hackerrank challenge.
 * */

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

	int result;

	public SumInLeavesVisitor() {
		result = 0;
	}

	public int getResult() {
		return result;
	}

	public void visitNode(TreeNode node) {
	}

	public void visitLeaf(TreeLeaf leaf) {
		result += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {

		long result = 1;
	    int modulo = 1000000007;

	    public int getResult() {
	        return (int) result;
	    }

	    public void visitNode(TreeNode node) {
	        if (node.getColor() == Color.RED) {
	            result = (result * node.getValue()) % modulo;
	        }
	    }

	    public void visitLeaf(TreeLeaf leaf) {
	        if (leaf.getColor() == Color.RED) {
	            result = (result * leaf.getValue()) % modulo;
	        }
	    }
}

class FancyVisitor extends TreeVis {

	int evenNonLeaf, greenLeaf;

	public FancyVisitor() {
		evenNonLeaf = 0;
		greenLeaf = 0;
	}

	public int getResult() {
		return Math.abs(evenNonLeaf - greenLeaf);
	}

	public void visitNode(TreeNode node) {
		if (node.getDepth() % 2 == 0) {
			evenNonLeaf += node.getValue();
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.GREEN) {
			greenLeaf += leaf.getValue();
		}
	}
}

public class Solution {

	static int values[];
	static Color colors[];
	static HashMap<Integer, HashSet<Integer>> relations;
	
	public static Tree solve() {
		Scanner scan = new Scanner(System.in);
		// Scan number of nodes of the tree
		int nodes = scan.nextInt();

		// Create an array to store the value of every node
		values = new int[nodes];
		for (int i = 0; i < nodes; i++) {
			values[i] = scan.nextInt();
		}

		// Create an array to store the color of every node
		colors = new Color[nodes];
		for (int i = 0; i < nodes; i++) {
			colors[i] = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
		}

		// Create an structure to store the relation parent-child of the nodes
		relations = new HashMap<Integer, HashSet<Integer>>(nodes);
		for (int i = 0; i < nodes; i++) {
			relations.put(i, new HashSet<Integer>());
		}

		// Fill with relations, so the ArrayList of the parent node contain the index of
		// all the child nodes
		// since the challenge structure give the nodes with a 1-start, we change with a
		// -1 to adjust with our arrays
		for (int i = 0; i < nodes - 1; i++) {
			Integer parent = scan.nextInt() - 1;
			Integer child = scan.nextInt() - 1;
			relations.get(parent).add(child);
			//Since the nodes are not directional, we duplicate the relations
			relations.get(child).add(parent);
		}

		scan.close();

		return buildTree(0, 0);

	}
	
	public static Tree buildTree(int id, int depth) {
		//Method for recursive instance of the Tree
		
		Tree tree=null;
		if(relations.get(id).isEmpty()) {
			tree= new TreeLeaf(values[id], colors[id], depth);
		}else {
			TreeNode node= new TreeNode(values[id], colors[id], depth);
			HashSet<Integer> childs=relations.get(id);
			for (Integer childId : childs) {
				relations.get(childId).remove(id);
				Tree child=buildTree(childId, depth+1);
				node.addChild(child);
			}
			tree=node;
		}
		return tree;
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		
	}
}