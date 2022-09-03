/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AndOrSearch;

/**
 *
 * @author ganesh
 */
public class AndOrSearch {

	public static void main(String[] args) {
		
		AndOrGraph graph = new AndOrGraph();
		
		
		String[] x = {"ab", "cY"};
		String[] y = {"a", "c"};
		String[] z = {"Yc"};
		Node.setRule("X", x);
		Node.setRule("Y", y);
		Node.setRule("Z", z);
		
		
		graph.setRoot("XYZ");
		
		graph.setSolution("c");
		
		graph.search();
		
		System.out.println("obtained string:" + graph.getSolution());	
	}

}