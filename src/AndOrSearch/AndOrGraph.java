/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AndOrSearch;

/**
 *
 * @author ganesh
 */
import java.util.*;

public class AndOrGraph {

	ArrayList<Node>	nodes = new ArrayList<Node>();		
	Node	current;							
	String	solution;							
	
	public void setRoot(String st){
		if(!nodes.isEmpty()){
                    System.out.println("delete current chart");
			nodes.clear();
		}
		current = new Node(0, st, 0, 0);
		nodes.add(current);
	}
	
	public void setSolution(String st){
		solution = st;
	}
	
	
	public void deleteNode(int idx){
		
		nodes.get(nodes.get(idx).getFrom()).removeTo(idx);
		nodes.remove(idx);
	}
	
	
	public void setNodeState(Node nd){
		if(nd.isUnknown()){
			if(nd.isNodeLeaf()){
				
				if(nd.getStr().equals(solution)){
					nd.setSolved();
					System.out.println("\"" + solution +"\" is found");
				}else{
					nd.setUnsolved();
				}
			}else if(nd.isNodeAND()){
				int i;
				
				for(i=0; i<nd.getTo().size(); i++){
					if(nodes.get(nd.getTo().get(i)).isUnsolved()){
						nd.setUnsolved();
						break;
					}
				}
				if(nd.isNodeExpanded() && i == nd.getTo().size())
					nd.setSolved();
			}else if(nd.isNodeOR()){
				int i;
				
				for( i=0; i<nd.getTo().size(); i++){
					if(nodes.get(nd.getTo().get(i)).isSolved()){
						nd.setSolved();
						break;
					}
				}
				if(nd.isNodeExpanded() && i == nd.getTo().size())
					nd.setUnsolved();
			}
		}
	}
	
	
	public void printNodes(){
		System.out.println("Print Nodes(current idx = " + current.getIdx() + ")");
		for(int i=0; i<nodes.size(); i++){
			nodes.get(i).printStatus();
		}
		System.out.println("End");
	}
	
	
	public void search(){
		
		while(nodes.get(0).isUnknown()){
			
			while(current.isUnknown()){
				try{
					printNodes();
					
					current = current.generateNextNode(nodes.size());
					System.out.println("Generated node: ");
					current.printStatus();
					System.out.println();
					nodes.add(current);
				}catch(RuntimeException e){
					System.out.println("Error");
				}
				
				setNodeState(current);
			}
			System.out.println("Return to parent node:" + current.getFrom());
			
			current = nodes.get(current.getFrom());
			setNodeState(current);
			
			
		}
                System.out.println("search end\n solution graph");		
                printNodes();
		
		if(!nodes.isEmpty() && nodes.get(0).isSolved()){
                        System.out.println("search success\n solution graph nodes obtained");		
                }else{
                        System.out.println("search failed");
		}		
	}
	
	
	public String getSolution(){
		String result = "";
		
		if(nodes.isEmpty() || !nodes.get(0).isSolved()){
                    System.out.println("this graph hasn't been solved");
			return result;
		}
		
		for(int i=0; i<nodes.size(); i++){
			if(nodes.get(i).isNodeLeaf() && nodes.get(i).isSolved()){
				result += nodes.get(i).getStr();
			}
		}
		return result;
	}
}