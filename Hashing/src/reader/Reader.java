package reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {

	private String strLine;
	private FileInputStream fstream;
	private BufferedReader br;
	private String fileName;	
	private ArrayList<Integer> keys;
	
	public Reader(String fileName) {
		this.fileName = fileName + ".txt";
		keys = new ArrayList<>();
		try {
			fstream = new FileInputStream(this.fileName);
			br = new BufferedReader(new InputStreamReader(fstream));

		} catch (FileNotFoundException e) {}
	}
			
	public void readFile() throws IOException {
		//Read File Line By Line
		try {
			while ((strLine = br.readLine()) != null)   {
				String[] numbers = strLine.split("\\s*,\\s*");
				
				for (int i = 0; i < numbers.length; i++)
				    keys.add(Integer.parseInt(numbers[i]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		br.close();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<Integer> getKeys() {
		return keys;
	}

}