package eg.edu.alexu.csd.filestructure.graphs;

 class Node implements Comparable<Object> {
	int node;
	double distance;
	
	public Node(int node,double distance){
		this.node=node;
		this.distance=distance;
	}

	@Override
	public int compareTo(Object o) {
		return (int)(distance-((Node)o).distance);
	}

}
