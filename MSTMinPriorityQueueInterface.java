import java.util.LinkedList;

public interface MSTMinPriorityQueueInterface {

	public void enqueue(LinkedList<Vertex> q, Vertex v);
	public Vertex dequeue(LinkedList<Vertex> q);	
	public Vertex heapMin(LinkedList<Vertex> A);
 	public void minHeapInsert(LinkedList<Vertex> A, Vertex key);
	public Vertex heapExtractMin(LinkedList<Vertex> A);
 	public void heapDecreaseKey(LinkedList<Vertex> A, int i, Vertex key); // perhaps an edge instead
	public void minHeapify(LinkedList<Vertex> A, int i);
	public int parent(int i);
	public int left(int i);
	public int right(int i);
	
	
	
	
}
