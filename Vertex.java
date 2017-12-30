import java.util.LinkedList;

public class Vertex {

	private int vNumber;
	private String color;
	private Vertex parent;
	private int distance;
	private int key;
	private LinkedList<Vertex> adjList = new LinkedList<>();
	
	public Vertex(int vN) {
		
		vNumber = vN;
		color = null;
		parent = null;
		distance = 0;
		key = 0;
		
	}
	
	public String getColor() {
		return color;
	}
	
	public Vertex getParent() {
		return parent;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public LinkedList<Vertex> getAdjList() {
		return this.adjList;
	}
	
	public int getVNumber() {
		return this.vNumber;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public void setColor(String c) {
		color = c;
	}
	
	public void setParent(Vertex p) {
		parent = p;
	}
	
	public void setDistance(int d) {
		distance = d;
	}
	
	public void setVNumber(int i) {
		vNumber = i;
	}
	
	public void addToAdjList(Vertex v) {
		this.adjList.add(v);	
	}
	
	public void removeFromAdjList(Vertex v) {
		adjList.remove(v);
	}
	
	public void setKey(int k) {
		key = k;
	}
	
}
