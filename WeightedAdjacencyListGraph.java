import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner; 


public class WeightedAdjacencyListGraph {

	ArrayList<LinkedList<Vertex>> vertexAdjLists = new ArrayList<>();
	private LinkedList<Vertex> vertexList = new LinkedList<>();
	private LinkedList<Edge> edgeList = new LinkedList<>();
	
	public WeightedAdjacencyListGraph(Scanner iF, int n) { // creates and Adjacency List Graph from the input data
		
		for(int i = 0; i < n; i++) {
			
			Vertex v = new Vertex(i);
			vertexList.add(v);
			
		}
		
		while((iF.hasNextLine() == true) && (iF.hasNextInt() == true)) {
			
			int a = iF.nextInt();
			int b = iF.nextInt();
			int w = iF.nextInt();

			vertexList.get(a).addToAdjList(vertexList.get(b));
			vertexList.get(b).addToAdjList(vertexList.get(a));
			
			Edge e = new Edge(vertexList.get(a), vertexList.get(b), w);
			
			edgeList.add(e);
		
		}
		
		for(int i = 0; i < n; i++) {
			
			vertexAdjLists.add(vertexList.get(i).getAdjList());
			
		}
		
	}
	
	public int weightFunction(Vertex u, Vertex v) { //
		
		int result = Integer.MAX_VALUE;
		
		for(Edge e : edgeList) {
			
			if(((e.getVertexA().equals(u)) && (e.getVertexB().equals(v)))) {
				result = e.getWeight();
				break;
			}
			
		}
		
		return result;
		
	}

	public int getTotalEdgeWeight() {
		
		int result = 0;
		
		for(int i = 0; i < edgeList.size(); i++) {
			
			result = result + edgeList.get(i).getWeight();
			
		}
		
		return result;
	
	}
	
	public ArrayList<LinkedList<Vertex>> getGraph() {
		return vertexAdjLists;
	}
	
	public LinkedList<Vertex> getVertexList() {
		return vertexList;
	}	
	
	public LinkedList<Edge> getEdgeList() {
		return edgeList;
	}
	
}
