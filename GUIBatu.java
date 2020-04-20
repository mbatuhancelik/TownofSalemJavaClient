
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * @author MUHAMMET SEN
 */

public class GUI extends JFrame implements KeyListener // ActionListener
{
	private int WIDTH = 500, HEIGHT = 500;
	private static String Name;
	static JFrame f = new JFrame("wWwampire");
	static JTextField t;
	static JTextField chat;
	boolean hasName = false;
	JLabel fancyLabel = new JLabel("Please enter your userName: ");
	// JFrame

	// JButton
	static JButton b;

	// label to display text
	static JLabel l;

	LinkedList<String> queue = new LinkedList<>();

	void send() {
		
	}
	GUI() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		f.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		for (int i = 0; i < 20; i++) {
			push("");
		}
		push("Please enter your userName");
		// create a new button
		// b = new JButton("submit");
		
		// create a object of the text class
		// b.setLocation(250, 250);
		
		// addActionListener to button
		// b.addActionListener(this);
		
		// create a object of JTextField with 16 columns
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constr = new GridBagConstraints();
		constr.insets = new Insets(5, 5, 5, 5);     
		//constr.anchor = GridBagConstraints.WEST;
		constr.gridx=0;
        constr.gridy=0;
        constr.anchor = GridBagConstraints.SOUTH;
		
		t = new JTextField(10);
		t.setLocation(new Point(10, f.getHeight() + 580));
		t.setSize(f.getWidth() - 30, 30);
		t.addKeyListener(this);
		fancyLabel.setBounds(20, 20, 300, 300);
		fancyLabel.setLocation(100, 120);
		panel.add(fancyLabel, constr);
		constr.gridy =1;
		panel.add(t, constr);
		f.add(panel);
		f.setLocation(100, 50);
		f.setVisible(true);
		
		// f.add(chat);
		

		
	}
	
	
	public static void main(String[] args) {
		new GUI();
		//		        final JFrame frame = new JFrame();
		//		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		        frame.setSize(new Dimension(450, 400));
		//		        frame.setLocation(new Point(400, 300));
		//		        frame.setLayout(new BorderLayout());
		//
		//		        final JLabel question = new JLabel("<html>Question:<br>What is love?<br>Baby don't hurt me<br>Don't hurt me<br>No more</html>");
		//		        question.setFont(new Font("Serif", Font.BOLD, 15));
//		        question.setHorizontalAlignment(JLabel.CENTER);
//
//		        frame.add(question);
//
//		        frame.setVisible(true);
//		    

}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

String writer() {
	String m = "<html>";
	for (String line : queue) {
		String color = "red"; /**TODO RENK EKLENECEK */
		m += "<div style=  \"padding-left: 13;color:"+color+"\">" +  line + "</div>";
	}
	return   m + "</html>";
}
public void push(String s ){
	queue.add(s);
	if(queue.size() > 20)
		queue.removeFirst(); 
	fancyLabel.setText(writer());

}
@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if (k == 10) {
			String incoming = t.getText();
			
			try {
				Client.client.WriteThread.SendToServer(incoming);
			} catch (InterruptedException e1) {
				System.out.println("Error" + e1.getMessage());
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("Error" + e1.getMessage());
				e1.printStackTrace();
			}
			
			if(!hasName){
			hasName = true;
			//push(t.getText()); 
			/**TODO:GET NAME */
			t.setText("");
			System.out.println("debug");
			fancyLabel.setText("");

			queue.removeLast();

			
		}
		else{
			//push(incoming); 
			//System.out.println(e.getKeyCode());
			t.setText("");
		}}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

//	public void actionPerformed(ActionEvent e) {
//		 String s = e.getActionCommand(); 
//	        if (s.equals("submit")) { 
//	            // set the text of the label to the text of the field 
//	            l.setText(t.getText()); 
//	  
//	            // set the text of field to blank 
//	            t.setText("  "); 
//		
//	}
//}

}
