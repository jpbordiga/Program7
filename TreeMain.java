import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

// JEFF BORDIGA
// PROGRAM07
// 11/6/17


public class TreeMain {

	private static final String OUTPUT = "output.txt";
	
	public static void main(String[] args) {
	
		int inputSize = 0;
		boolean correctFile = false;
		boolean withinRange  = false;
		int sourceNumber = 0;
		Vertex sourceVertex = null;
		Vertex endVertex = null;
		String chosenFile = null;
		Scanner keyboard = new Scanner(System.in);
		Scanner inFile = null;
		
		String[] files = new String[3]; // list of input files is used for whole output file
		
		files[0] = "graph23_5w.txt"; // storing files as a group
		files[1] = "graph50w.txt";
		files[2] = "graph100w.txt";
		
		PrintWriter outputStream = null;
		
		try{
		
			outputStream = new PrintWriter(new FileOutputStream(OUTPUT));
			correctFile = false;
			withinRange = false;
			chosenFile = null;
				
			WeightedAdjacencyListGraph wALG = null;
			
			while(correctFile == false) { // user input phase
					
				System.out.println("Choose a file to use: ");
					
				chosenFile = keyboard.next();
					
				for(int b = 0; b < files.length; b++) {
					if(chosenFile.equals(files[b])) {
						correctFile = true;
					}
				}
					
				if(correctFile == false) {
					System.out.println("ERROR: the file \"" + chosenFile + "\" could not be found" + "\n");
				}
					
			}
				
			try{ // file input phase
						
				inFile = new Scanner(new FileInputStream(chosenFile));
				inputSize = inFile.nextInt(); // reading input size
				wALG = new WeightedAdjacencyListGraph(inFile, inputSize);
					
			} catch(FileNotFoundException e){
				System.out.println("ERROR: unable to open file " + chosenFile);
				System.exit(0);
			}
			
			while(withinRange == false) {
					
				System.out.println("Choose a source vertex (counting from 0 to " + (inputSize - 1) + "): ");
				
				sourceNumber = keyboard.nextInt();
					
				if((sourceNumber< 0) || (sourceNumber > inputSize)) {
					System.out.println("ERROR: no such vertex exists" + "\n");
				} else {
					sourceVertex = wALG.getVertexList().get(sourceNumber);
					withinRange = true;
				}
					
			}
				
			MinimumSpanningTree mST = new MinimumSpanningTree();
			
			mST.mstPrim(wALG, sourceVertex);
				
			for(int c = 0; c < inputSize; c++) { // printing results
				
				if(wALG.getVertexList().get(c).getParent() == null) {
					outputStream.println(wALG.getVertexList().get(c).getVNumber() + " " + wALG.getVertexList().get(c).getKey() + " " + -1);
				} else {
					outputStream.println(wALG.getVertexList().get(c).getVNumber() + " " + wALG.getVertexList().get(c).getKey() + " " + wALG.getVertexList().get(c).getParent().getVNumber());
				}
				
				
				
//				if(mST.getMST().get(c).getVertexA().getParent() == null) {
//					outputStream.println(mST.getMST().get(c).getVertexB().getVNumber() + " " + mST.getMST().get(c).getVertexB().getKey() + " " + -1);
//				} else {
//					outputStream.println(mST.getMST().get(c).getVertexB().getVNumber() + " " + mST.getMST().get(c).getVertexB().getKey() + " " + mST.getMST().get(c).getVertexB().getParent().getVNumber());
//				}	
			}
			
			outputStream.println(mST.getTotalWeight());
				
			outputStream.println();
			outputStream.close();
			
		} catch(FileNotFoundException e){
			System.out.println("ERROR: unable to open file " + OUTPUT);
			System.exit(0);
		}

	}

}
