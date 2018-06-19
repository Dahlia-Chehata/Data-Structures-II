package eg.edu.alexu.csd.filestructure.graphs;

public class Edge {

	private int src, wgh, dest;
	
	public Edge(int src, int wgh, int dest){
		this.src = src;
		this.wgh = wgh;
		this.dest = dest;
	}
	
	public int getSource(){
		return this.src;
	}
	
	public int getWeight(){
		return this.wgh;
	}
	
	public int getDest(){
		return this.dest;
	}
}
