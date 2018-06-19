import javax.swing.*;
import java.awt.*;
/**
Create the GUI window for the sort application.
This class also runs the program using the methods from other classes
*/
@SuppressWarnings("serial")
public class SortApplication extends JFrame {
	
 	SortPanel panelA = new SortPanel();
 	
	public SortApplication() {
		this.add(panelA);
	}
	public static void main( String[] args ) {
		SortApplication sortApp  = new SortApplication();
 
		sortApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sortApp.setSize(550,700);
		sortApp.setLayout(new GridLayout(1,2));
		sortApp.setTitle("Sorting Animation");
		sortApp.setVisible(true);
		sortApp.setResizable(true);
		
		
	}
}


	