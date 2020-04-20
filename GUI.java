
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.ScrollPane;
import javax.swing.ScrollPaneConstants;

public class GUI extends JFrame {
	
	public static String windowTitle = "wWwampire";
	private JPanel contentPane;
	private JTextField textField;
	public JTextArea textArea = new JTextArea(20, 20);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		super(windowTitle);
		setBackground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton button = new JButton("Send");
		//JTextArea textArea = new JTextArea(20, 20);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBounds(325, 40, 305, 186);
		contentPane.add(textArea);
		JScrollPane scrollableTextArea = new JScrollPane(textArea);
		scrollableTextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollableTextArea.setLocation(325, 40);
		scrollableTextArea.setSize(305, 200);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.getContentPane().add(scrollableTextArea);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.MOUSE_CLICKED == 500) {
					try {
						Client.client.WriteThread.SendToServer(textField.getText());
					} catch (InterruptedException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//textArea.setText(textArea.getText()+textField.getText()+"\n");
					textField.setText("");
					textField.grabFocus();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(325, 296, 305, 26);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("Write here");
		lblNewLabel.setBounds(325, 236, 91, 20);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(325, 236, 305, 14);
		contentPane.add(separator);

		String s = "lskds";// TODO get users task

		JLabel lblNewLabel_1 = new JLabel("You are a\u015Flskds");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\90506\\Desktop\\fen bilgisi\\vampire-clipart-cute-3.jpg"));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(34, 40, 251, 260);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					try {
						Client.client.WriteThread.SendToServer(textField.getText());
					} catch (InterruptedException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textArea.setText(textArea.getText()+textField.getText()+"\n");
					textField.setText("");
					textField.grabFocus();
					//push(textArea.getText()+textField.getText()+"\n");

					
				}
			}
		});
		textField.setBounds(325, 260, 305, 26);
		contentPane.add(textField);
		textField.setColumns(10);

	}
	
	
	public void push(String s) {
		this.textArea.setText(this.textArea.getText() +s+"\n");

	}
}
