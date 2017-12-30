import java.util.LinkedList;

public class QueueTest {

	
	
	public static void main(String[] args) {

		int iter = 19;
		
		MSTMinPriorityQueue mSTMPQ = new MSTMinPriorityQueue();
		
		LinkedList<Vertex> vertexList = new LinkedList<>();
	
		for(int i = 0; i < 20; i++) {
			
			Vertex v = new Vertex(i);
			vertexList.add(v);
			
		}
		
		LinkedList<Vertex> queue = new LinkedList<>();
		
		for(int i = 0; i < iter; i++) {	
			mSTMPQ.minHeapInsert(queue, vertexList.get(i));
		}
		
		for(int i = 0; i < iter; i++) {	
			System.out.print(queue.get(i).getVNumber() + ", ");
		}
		
		mSTMPQ.minHeapify(queue, mSTMPQ.heapMin(queue).getVNumber());
		System.out.println();
		
		for(int i = 0; i < iter; i++) {	
			System.out.print(queue.get(i).getVNumber() + ", ");
		}
		
		
		
	
	}
}
