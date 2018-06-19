package eg.edu.alexu.csd.filestructure.graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Graph implements IGraph {

	private ArrayList<Integer> visited;
	private ArrayList<ArrayList<Edge>> edges;
	private ArrayList<Edge> edgeList;
	 int V, E;

	public Graph() {
		this.edgeList = new ArrayList<Edge>();
	}

	@Override
	public void readGraph(File file) {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;
			String[] split;
			br = new BufferedReader(new FileReader(file));
			if ((line = br.readLine()) != null) {
				split = line.split(" ");
				V = Integer.parseInt(split[0]);
				E = Integer.parseInt(split[1]);
			}
			edges = new ArrayList<ArrayList<Edge>>(V);
			for (int i = 0; i < V; i++)
				edges.add(new ArrayList<Edge>());
			while ((line = br.readLine()) != null) {
				split = line.split(" ");
				int src = Integer.parseInt(split[0]);
				Edge edge= new Edge(src,Integer.parseInt(split[2]),	Integer.parseInt(split[1]));
				edges.get(src).add(edge);
				edgeList.add(edge);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public int size() {
		return E;
	}

	@Override
	public ArrayList<Integer> getVertices() {
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		for (int i = 0; i < V; i++)
			vertices.add(i);
		return vertices;
	}

	@Override
	public ArrayList<Integer> getNeighbors(int v) {
		int length = edges.get(v).size();
		ArrayList<Integer> neighbors = new ArrayList<Integer>(length);
		for (int i = 0; i < length; i++) {
			neighbors.add(edges.get(v).get(i).getDest());
		}
		return neighbors;
	}

	@Override
	public void runDijkstra(int src, int[] distances) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Arrays.fill(distances, Integer.MAX_VALUE);
		pq.add(new Node(src, 0));
		distances[src] = 0;
		Node temp;
		visited = new ArrayList<Integer>();
		while (!pq.isEmpty()) {
			temp = pq.poll();
			if (!visited.contains(temp.node))
				visited.add(temp.node);
			int length = edges.get(temp.node).size();
			for (int i = 0; i < length; i++) {
				int to = edges.get(temp.node).get(i).getDest();
				int w = edges.get(temp.node).get(i).getWeight();
				if (distances[to] > distances[temp.node] + w) {
					distances[to] = distances[temp.node] + w;
					pq.add(new Node(to, distances[to]));
				}
			}
		}
	}

	@Override
	public ArrayList<Integer> getDijkstraProcessedOrder() {
		return visited;
	}

	@Override
	public boolean runBellmanFord(int src, int[] dist) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		for (int i = 0; i < V - 1; i++) {
			for (Edge curEdge : edgeList) {
				if (dist[curEdge.getSource()] != Integer.MAX_VALUE &&
						dist[curEdge.getSource()] < dist[curEdge.getDest()] - curEdge.getWeight()) {
					dist[curEdge.getDest()] = curEdge.getWeight() + dist[curEdge.getSource()];
				}
			}
		}
		for (Edge curEdge : edgeList) {
			if (dist[curEdge.getSource()] != Integer.MAX_VALUE &&
					dist[curEdge.getSource()]  < dist[curEdge.getDest()] - curEdge.getWeight()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int getNodeCount(){
		return V;
	}
}
