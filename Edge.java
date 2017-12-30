import java.util.LinkedList;

public class Edge {

	private Vertex vertexA;
	private Vertex vertexB;
	private int weight;
	private LinkedList<Edge> edgeList = new LinkedList<>();
	
	public Edge(Vertex vA, Vertex vB, int w) {
		
		vertexA = vA;
		vertexB = vB;
		weight = w;
		
	}
	
	public Vertex getVertexA() {
		return this.vertexA;
	}
	
	public Vertex getVertexB() {
		return this.vertexB;
	}
	
	public int getWeight() {
		return this.weight;	
	}
	
}
