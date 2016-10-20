package pixelmon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	// private data members
	private JPanel contentPane;	
	private JTextArea textArea;
	JButton btnStartStop;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStartStop = new JButton("Start/Stop");
		btnStartStop.setBounds(172, 178, 89, 23);
		contentPane.add(btnStartStop);
		
		JLabel lblPixelmonScript = new JLabel("Pixelmon Script");
		lblPixelmonScript.setBounds(181, 25, 72, 14);
		contentPane.add(lblPixelmonScript);
		
		textArea = new JTextArea();
		textArea.setBounds(56, 59, 321, 108);
		contentPane.add(textArea);
	}
	
	public void updateTextbox(String updateText) {
		textArea.setText(textArea.getText() + "\n" + updateText);
		//contentPane.add(textArea);
	}
	
}
