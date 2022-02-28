package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import atm.Login.ButtonListener;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Main extends JFrame {
	private JFrame mainFrame;
	private JPanel contentPane;
	private JButton btnLogOut, depositButton, withdrawButton, transferButton;
	private JLabel welcomeUser;
	private static User[] users;
	private static User currentUser;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Main(User users[], User currentUser) {
		setBackground(Color.LIGHT_GRAY);
		setTitle("ATLAS ATM Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(135, 44, 299, 58);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Atlas ATM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(62, 10, 151, 36);
		contentPane.add(lblNewLabel_2);
		
		depositButton = new JButton("Deposit");
		depositButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		depositButton.setBounds(106, 137, 140, 45);
		depositButton.addActionListener(new ButtonListener());
		contentPane.add(depositButton);
		
		withdrawButton = new JButton("Withdrawal");
		withdrawButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		withdrawButton.setBounds(319, 137, 140, 45);
		withdrawButton.addActionListener(new ButtonListener());
		contentPane.add(withdrawButton);
		
		transferButton = new JButton("Transfer");
		transferButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		transferButton.setBounds(106, 241, 140, 45);
		transferButton.addActionListener(new ButtonListener());
		contentPane.add(transferButton);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogOut.setBounds(319, 241, 140, 45);
		btnLogOut.addActionListener(new ButtonListener());
		contentPane.add(btnLogOut);
		
		welcomeUser = new JLabel("s");
		welcomeUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		welcomeUser.setBounds(331, 17, 230, 25);
		welcomeUser.setText("Welcome back " + currentUser.getFirstName() + " " + currentUser.getLastName());
		contentPane.add(welcomeUser);
		
		//assigning parameters
		Main.users = users; //= Main.users;
		Main.currentUser = currentUser;  //= Main.currentUser;
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == btnLogOut) {
				Login window = new Login();
				window.frmAtm.setVisible(true);
				dispose();
			}
			else if(event.getSource() == depositButton) {
				new Deposit(users,currentUser).setVisible(true);
				dispose();
			}
			else if(event.getSource() == withdrawButton) {
				new Withdrawal(users,currentUser).setVisible(true);
				dispose();
			}
			else if(event.getSource() == transferButton) {
				new Transfer(users,currentUser).setVisible(true);
				dispose();
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main mainFrame = new Main(users,currentUser);
					mainFrame.setVisible(true);
					mainFrame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
