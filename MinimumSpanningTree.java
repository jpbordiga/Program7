import java.util.LinkedList;

public class MinimumSpanningTree implements MinimumSpanningTreeInterface {

	private LinkedList<Edge> edgeSet; //
	private MSTMinPriorityQueue mSTMPQ;
	private LinkedList<Vertex> queue;
	private int totalWeight = 0;
	private LinkedList<Edge> MST = new LinkedList<>();
	
	
	public MinimumSpanningTree() {
		edgeSet = new LinkedList<>();
		mSTMPQ = new MSTMinPriorityQueue();
		queue = new LinkedList<>();
	}
	
	@Override
	public void genericMST(WeightedAdjacencyListGraph wALG, int weight) {
		//
	}

	@Override
	public void mstPrim(WeightedAdjacencyListGraph wALG, Vertex root) {
		
		for(Vertex u : wALG.getVertexList()) {
			
			u.setKey(Integer.MAX_VALUE);
			u.setParent(null);
			
		}
		
		root.setKey(0);
		
		for(Vertex v : wALG.getVertexList()) {
			
			mSTMPQ.minHeapInsert(queue, v);
			
		}
		
		while(queue.size() != 0) {
			
			Vertex u = mSTMPQ.heapExtractMin(queue);
			
//			MST.add(new Edge(u, u.getParent(), wALG.weightFunction(u, u.getParent())));
			
			for(Vertex v : u.getAdjList()) {
				
				if((queue.contains(v) == true) && (wALG.weightFunction(u, v) < v.getKey())) {
					
					v.setParent(u);
					v.setKey(wALG.weightFunction(u, v));
					
					MST.add(new Edge(u, v, wALG.weightFunction(u, v)));	
					
				}
				
			}
			
		}
		
	}
	
	public int getTotalWeight() {
		
		int result = 0;
		
		for(Edge e : MST) {
			result += e.getWeight();
		}
		
		return result;
		
	}
	
	public LinkedList<Edge> getMST() {
		return MST;
	}

}
