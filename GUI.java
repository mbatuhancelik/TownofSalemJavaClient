package trying;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class vampire extends JFrame implements KeyListener // ActionListener
{
	private int WIDTH = 500, HEIGHT = 500;
	private static String Name;
	static JFrame f = new JFrame("wWwampire");
	static JTextField t;
	static JTextField chat;
	JLabel fancyLabel = new JLabel();
	// JFrame

	// JButton
	static JButton b;

	// label to display text
	static JLabel l;

	LinkedList<String> queue = new LinkedList<>();

	String writer() {
		String m = "<html>";
		for (String line : queue) {
			m += "<t>" +  line + "<br>";
		}
		return   m + "</html>";
	}
	void push(String s ){
		queue.add(s);
		if(queue.size() > 20)
			queue.removeFirst(); 
	}
	void send() {
		
	}
	vampire() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		f.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		for (int i = 0; i < 20; i++) {
			push("");
		}
		// create a new button
		// b = new JButton("submit");

		// create a object of the text class
		// b.setLocation(250, 250);

		// addActionListener to button
		// b.addActionListener(this);

		// create a object of JTextField with 16 columns
		t = new JTextField(10);
		t.setLocation(new Point(10, f.getHeight() - 80));
		t.setSize(f.getWidth() - 30, 30);
		t.addKeyListener(this);
		fancyLabel.setBounds(20, 20, 300, 300);
		fancyLabel.setLocation(20, 20);
		f.add(t);
		f.add(fancyLabel);

		// f.add(chat);

		f.setLocation(100, 50);

		f.setVisible(true);

	}

	public void paint(Graphics g) {

	}

	public static void main(String[] args) {
		new vampire();
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

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		System.out.println(e.getKeyCode());
		if (k == 10) {

			push(t.getText()); 
			fancyLabel.setText(writer());
			t.setText("");
		}

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
