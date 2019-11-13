/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Raphael Mathuba
 */

import java.util.LinkedList;

public class Graph {

   
    int vertices;
LinkedList<Integer>adjList[];

public Graph(int vertices){

	this.vertices = vertices;
	adjList = new LinkedList[vertices];
	for(int i=0; i < vertices; i++){
		adjList[i] = new LinkedList<>();
	}
}

public void addEdge(int source,int destination){

	adjList[source].add(destination);
	adjList[destination].add(source);

}

public void deleteEdge(int source,int destination){

                      System.out.println("INSIDE delete Edge method part 1 " );

 adjList[source].removeFirstOccurrence(destination);
                       System.out.println("INSIDE delete Edge method part 3 " + destination );
//adjList[source].
 adjList[destination].removeFirstOccurrence(source);

}


public void insertTown(int town,int connectedTown)
{

	 addEdge(town,connectedTown);
}

public void deleteTown(int town){
         System.out.println(" size of " + town + " is " + adjList[town].size());

	 if( adjList[town].size() > 0 ){
       int count = adjList[town].size();
       
	for(int i= 0; i< count; i++){
                             System.out.println("IN" );

         int destination = adjList[town].pop();
                  System.out.println("Calling delete Edge method " );
                  System.out.println("DESTINATION IS " + destination);

         deleteEdge(town,destination);
                          System.out.println("i = " + i );

 
	}
}
}
    
    
    public void displayGraph(){

	for(int i=0; i < vertices; i++){

      if( adjList[i].size() > 0 ){

         System.out.println("Vertex " + i + " is connected to:-");
         
         for(int j = 0; j < adjList[i].size(); j++){

         	System.out.print(adjList[i].get(j) + " ");

         }

         System.out.println();

      }

	}
}
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Graph graph = new Graph(16);

	graph.addEdge(0,1);
	graph.addEdge(1,2);
	graph.addEdge(2,0);
        graph.addEdge(6,0);
	graph.addEdge(2,5);
	graph.addEdge(7,6);
	graph.addEdge(7,0);
	graph.displayGraph();
        graph.deleteTown(1);
       graph.displayGraph();
       
       graph.insertTown(9, 3);
       graph.addEdge(9, 0);
       graph.displayGraph();


    }
    
}
