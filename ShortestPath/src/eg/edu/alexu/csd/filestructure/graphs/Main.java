package eg.edu.alexu.csd.filestructure.graphs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public void writeDijkstraResult(String fileName, ArrayList<String> dist, ArrayList<String> vertices) throws Throwable {
		FileWriter writer = new FileWriter(fileName);
		for (String str : dist) {
			writer.write(str);
			writer.write(" ");
		}
		writer.write("\r\n");
		for (String str : vertices) {
			writer.write(str);
			writer.write(" ");
		}
		writer.close();

	}

	public void solveDijkstra(String input, String output) {
		Graph g = new Graph();
		ArrayList<String> dist = new ArrayList<String>();
		ArrayList<String> vertices = new ArrayList<String>();
		File f1 = new File(input);
		g.readGraph(f1);
		int[] distances = new int[g.V];
		g.runDijkstra(0, distances);
		for (int i = 0; i < distances.length; i++)
			dist.add(Integer.toString(distances[i]));
		ArrayList<Integer> v = g.getDijkstraProcessedOrder();
		for (int i = 0; i < v.size(); i++)
			vertices.add(Integer.toString(v.get(i)));
		try {
			writeDijkstraResult(output, dist, vertices);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void solveBellman(String input, String output) {
		IGraph g = new Graph();
		File inputFile = new File(input);
		g.readGraph(inputFile);
		int[] dist = new int[g.getNodeCount()];
		boolean hasNegCyc = !g.runBellmanFord(0, dist);
		try{
		writeBellmanResult(output, hasNegCyc, dist);}
		catch(Exception e){
			System.out.println("Error occured while writing data to the file.\n" + e.getMessage());
		}
	}

	private void writeBellmanResult(String output, boolean hasNegCyc, int[] dist) throws IOException{
		FileWriter outputWriter = new FileWriter(output);
		outputWriter.write(Boolean.toString(hasNegCyc));
		outputWriter.write("\r\n");
		outputWriter.write(Integer.toString(dist[0]));
		for(int i = 1; i < dist.length; i++){
			outputWriter.write(" " + Integer.toString(dist[i]));
		}
		outputWriter.write("\r\n");
		outputWriter.close();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		
		m.solveDijkstra("dijkstra_1.txt", "dijkstra_1_output.txt");
		m.solveDijkstra("dijkstra_2.txt", "dijkstra_2_output.txt");
		m.solveDijkstra("dijkstra_3.txt", "dijkstra_3_output.txt");
		m.solveBellman("belman_ford_1.txt", "belman_ford_1_output.txt");
		m.solveBellman("belman_ford_2.txt", "belman_ford_2_output.txt");
		m.solveBellman("belman_ford_3.txt", "belman_ford_3_output.txt");
	}
}
