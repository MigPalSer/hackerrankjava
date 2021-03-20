package retos.java1.visitorpattern;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Scanner;

/*https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 *WARNING: for code reuse, with this design the visitor instances can be used
 *only one time with the conditions of challenge (visit the root and getResult) 
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

	int result;

	public ProductOfRedNodesVisitor() {
		result = 1;
	}

	public int getResult() {
		result %= (Math.pow(10, 9) + 7);
		return result;
	}

	public void visitNode(TreeNode node) {
		if (node.getColor() == Color.RED) {
			result *= node.getValue();
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.RED) {
			result *= leaf.getValue();
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

	public static Tree solve() {
		Scanner scan = new Scanner(System.in);
		int nodes=scan.nextInt();
		
		int values[]=new int[nodes];
		for (int i = 0; i < nodes; i++) {
			values[i]=scan.nextInt();
		}
		
		Color colors[]=new Color[nodes];
		for (int i = 0; i < nodes; i++) {
			colors[i]=scan.nextInt()==0?Color.RED:Color.GREEN;
		}
		
		
		Tree tree_elements[]=new Tree[nodes];
		
		tree_elements[0]=new TreeNode(values[0],colors[0], 0);
		
		HashMap<Integer, ArrayList<Integer>> relations=new HashMap<Integer, ArrayList<Integer>>(nodes);
		
		for (int i = 0; i < nodes; i++) {
			relations.put(i, new ArrayList<Integer>());
		}
		
		boolean elements_instanced[]=new boolean[nodes];
		for (int i = 0; i < nodes; i++) {
			elements_instanced[i]=false;
		}
		
		for (int i = 0; i < nodes-1; i++) {
			Integer parent=scan.nextInt()-1;
			Integer child=scan.nextInt()-1;
			relations.get(parent).add(child);
		}
		
		for (int i = 0; i < nodes; i++) {
			int newdepth=tree_elements[i].getDepth()+1;
			for (Integer j : relations.get(i)) {
				if(relations.get(j).size()==0) {
					tree_elements[j]=new TreeLeaf(values[i], colors[i], newdepth);
					}else {
						tree_elements[j]=new TreeNode(values[i], colors[i], newdepth);
					}
				TreeNode tn=(TreeNode) tree_elements[i];
				tn.addChild(tree_elements[j]);
			}
		}
		
		/*
		int[][] relations=new int[nodes-1][2];
		
		for (int i = 0; i < nodes-1; i++) {
			relations[i][0]=scan.nextInt();
			relations[i][1]=scan.nextInt();
		}
		for (int i = 1; i < nodes; i++) {
			boolean leaf=true;
			for (int j = 0; j < nodes-1; j++) {
				if(relations[j][0]==i+1)leaf=false;
			}
			int parent_index=relations[i-1][0]-1;
			if(leaf) {
				tree_elements[i]=new TreeLeaf(values[i], colors[i], tree_elements[parent_index].getDepth()+1);
				TreeNode p=(TreeNode) tree_elements[parent_index];
				p.addChild(tree_elements[i]);
			}else {
				tree_elements[i]=new TreeNode(values[i], colors[i], tree_elements[parent_index].getDepth()+1);
				TreeNode p=(TreeNode) tree_elements[parent_index];
				p.addChild(tree_elements[i]);
			}
		}*/
		
		scan.close();
		
		return tree_elements[0];
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