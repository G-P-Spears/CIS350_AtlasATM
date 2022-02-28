package atm;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	public JFrame frmAtm;
	private JTextField acctField;
	private JTextField pinField;
	private JButton btnNewButton;
	private JLabel WelcomeBanner, acctLbl, pinLbl;
	private User[] users = new User[3];
	private User currentUser = null;
	private int index;
	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmAtm = new JFrame();
		frmAtm.getContentPane().setBackground(UIManager.getColor("EditorPane.disabledBackground"));
		frmAtm.setTitle("ATLAS ATM");
		frmAtm.setBounds(100, 100, 508, 398);
		frmAtm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAtm.getContentPane().setLayout(null);
		frmAtm.setResizable(false);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(192, 199, 89, 23);
		btnNewButton.addActionListener(new ButtonListener());
		frmAtm.getContentPane().add(btnNewButton);
		
		WelcomeBanner = new JLabel("Please enter credentials");
		WelcomeBanner.setFont(new Font("Tahoma", Font.PLAIN, 21));
		WelcomeBanner.setLabelFor(frmAtm);
		WelcomeBanner.setForeground(Color.BLACK);
		WelcomeBanner.setBackground(Color.WHITE);
		WelcomeBanner.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeBanner.setBounds(99, 58, 273, 52);
		frmAtm.getContentPane().add(WelcomeBanner);
		
		acctField = new JTextField();
		acctField.setBounds(198, 121, 152, 20);
		frmAtm.getContentPane().add(acctField);
		acctField.setColumns(10);
		
		pinField = new JTextField();
		pinField.setBounds(198, 152, 152, 20);
		frmAtm.getContentPane().add(pinField);
		pinField.setColumns(10);
		
		acctLbl = new JLabel("Account #:");
		acctLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		acctLbl.setBounds(99, 123, 79, 17);
		frmAtm.getContentPane().add(acctLbl);
		
		pinLbl = new JLabel("PIN #:");
		pinLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		pinLbl.setBounds(99, 154, 79, 17);
		frmAtm.getContentPane().add(pinLbl);
		
		users[0] = new User("Caleb", "Roe", 1111, 1400, 1001);
		users[1] = new User("Grant", "Spears", 1112, 1500, 1002);
		users[2] = new User("Jessica", "Kressner", 1113, 1600, 1003);
		
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == btnNewButton) {
				int acctNum = Integer.parseInt(acctField.getText());
				int pin = Integer.parseInt(pinField.getText());
				//JOptionPane.showMessageDialog(null, "Please enter account credentials");
			
				if(acctField.getText().equals("") || pinField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please enter account credentials");
				}
				else {
				//loop through user array list, find user with matching account and pin	
					for(int i=0; i < users.length; i++) {
						if(acctNum == users[i].getAccountNumber()) {
							if(pin == users[i].getPin()) {
								currentUser = users[i];
								//new Main(users,currentUser).setVisible(true);
								//frmAtm.dispose();	
							}
						}
					}
					if(currentUser == null) {
						JOptionPane.showMessageDialog(null, "Please enter account credentials");
					}
					else {
					new Main(users,currentUser).setVisible(true);
					frmAtm.dispose();
					}
				}
				}	
			}
		}				
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAtm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

