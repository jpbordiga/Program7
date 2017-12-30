import java.util.LinkedList;

public class MSTMinPriorityQueue implements MSTMinPriorityQueueInterface {

	public MSTMinPriorityQueue() {
		//
	}
	
	@Override
	public Vertex heapMin(LinkedList<Vertex> A) {
		return A.get(0);
	}

	@Override
	public void minHeapInsert(LinkedList<Vertex> A, Vertex key) {
		
		Vertex maxPlaceHolder = new Vertex(Integer.MAX_VALUE);
		
		if(A.size() == 0) {
			A.add(maxPlaceHolder);
			heapDecreaseKey(A, 0, key);
		} else {
			A.set(A.size() - 1, maxPlaceHolder);
			heapDecreaseKey(A, A.size() - 1, key);
		}
		
		
	}

	@Override
	public Vertex heapExtractMin(LinkedList<Vertex> A) {
		
		Vertex min = null;
		
		if(A.size() < 1) {
			System.out.println("ERROR: heap underflow");
			//return;
		} else {
			
			min = A.get(0);
			//A.set(0, A.get(A.size() - 1));
			A.remove(min);
			minHeapify(A, 0);
			
		}
		
		return min;
		
	}

	@Override
	public void heapDecreaseKey(LinkedList<Vertex> A, int i, Vertex key) {
		
		if(key.getVNumber() > A.get(i).getVNumber()) { // lost in translation...
			System.out.println("ERROR: new key > current key");
		} else {
			
			A.add(i, key); //
			
			while((i > 0) && (A.get(parent(i)).getVNumber() > A.get(i).getVNumber())) {
				
				
				int vNPlaceHolder = A.get(i).getVNumber();
				Vertex placeHolder = A.get(i);
				
				A.get(i).setVNumber(A.get(parent(i)).getVNumber());
				A.get(parent(i)).setVNumber(vNPlaceHolder);
				A.set(i, A.get(parent(i)));
				A.set(parent(i), placeHolder);
				i = parent(i);
				
			}
		}
		
	}

	@Override
	public void minHeapify(LinkedList<Vertex> A, int i) {
		
		int left = left(i);
		int right = right(i);
		int smallest = 0;
		
		if((left < A.size()) && (A.get(left).getVNumber() < A.get(i).getVNumber())) {
			smallest = left;
		} else {
			smallest = i;
		}
		
		if((right < A.size()) && (A.get(right).getVNumber() < A.get(smallest).getVNumber())) {
			smallest = right;
		}
		
		if(smallest != i) {
			
			int vNPlaceHolder = A.get(i).getVNumber();
			Vertex placeHolder = A.get(i);
			
			A.get(i).setVNumber(A.get(smallest).getVNumber());
			A.get(smallest).setVNumber(vNPlaceHolder);
			A.set(i, A.get(smallest));
			A.set(smallest, placeHolder);
			minHeapify(A, smallest);
			
		}
		
	}

	@Override
	public int parent(int i) {
		
		int result = 0;
		
		if(i % 2 != 0) {
			result = i / 2;
		} else if(i % 2 == 0) {
			result = (i / 2) - 1;
		}
		
		return result;
	
	}

	@Override
	public int left(int i) {
		
		return (2 * i) + 1;
		
	}

	@Override
	public int right(int i) {
	
		return (2 * i) + 2;
	
	}

	@Override
	public void enqueue(LinkedList<Vertex> q, Vertex v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vertex dequeue(LinkedList<Vertex> q) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
