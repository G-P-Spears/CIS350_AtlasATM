package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import atm.Withdrawal.ButtonListener;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Deposit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, depositPanel;
	private JButton returnButton, confirmBtn, clearBtn, oneDollarBtn, fiveDollarBtn, tenDollarBtn, twentyDollarBtn, fiftyDollarBtn, hundredDollarBtn;
	private JTextField depositField;
	private JTextField currBalanceField;
	private JTextField prevBalanceField;
	private JLabel userInfo, amtBnner, todepositBnr, currentBnnr, previousBnnr;
	private static User[] users;
	private static User currentUser;
	private BankingSys system;
	private JTextField stmtField;
	private int depositVal;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Deposit(User[] users,User currentUser) {
		setTitle("ATLAS ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 588);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		depositPanel = new JPanel();
		depositPanel.setBounds(10, 11, 682, 363);
		depositPanel.setBackground(Color.WHITE);
		contentPane.add(depositPanel);
		depositPanel.setLayout(null);
		
		oneDollarBtn = new JButton("$1");
		oneDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		oneDollarBtn.setBackground(Color.LIGHT_GRAY);
		oneDollarBtn.setBounds(50, 77, 116, 37);
		oneDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(oneDollarBtn);
		
		fiveDollarBtn = new JButton("$5");
		fiveDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		fiveDollarBtn.setBackground(Color.LIGHT_GRAY);
		fiveDollarBtn.setBounds(50, 125, 116, 37);
		fiveDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(fiveDollarBtn);
		
		tenDollarBtn = new JButton("$10");
		tenDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		tenDollarBtn.setBackground(Color.LIGHT_GRAY);
		tenDollarBtn.setBounds(50, 173, 116, 37);
		tenDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(tenDollarBtn);
		
		twentyDollarBtn = new JButton("$20");
		twentyDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		twentyDollarBtn.setBackground(Color.LIGHT_GRAY);
		twentyDollarBtn.setBounds(176, 77, 116, 37);
		twentyDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(twentyDollarBtn);
		
		fiftyDollarBtn = new JButton("$50");
		fiftyDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		fiftyDollarBtn.setBackground(Color.LIGHT_GRAY);
		fiftyDollarBtn.setBounds(176, 125, 116, 37);
		fiftyDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(fiftyDollarBtn);
		
		hundredDollarBtn = new JButton("$100");
		hundredDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		hundredDollarBtn.setBackground(Color.LIGHT_GRAY);
		hundredDollarBtn.setBounds(176, 173, 116, 37);
		hundredDollarBtn.addActionListener(new ButtonListener());
		depositPanel.add(hundredDollarBtn);
		
		amtBnner = new JLabel("Please Specify Amount to Deposit");
		amtBnner.setFont(new Font("Tahoma", Font.ITALIC, 16));
		amtBnner.setBounds(50, 30, 292, 37);
		depositPanel.add(amtBnner);
		
		returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnButton.setBounds(10, 329, 116, 23);
		returnButton.addActionListener(new ButtonListener());
		depositPanel.add(returnButton);
		
		todepositBnr = new JLabel("Amount to Deposit:");
		todepositBnr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		todepositBnr.setBounds(34, 218, 132, 37);
		depositPanel.add(todepositBnr);
		
		depositField = new JTextField();
		depositField.setEditable(false);
		depositField.setBounds(176, 221, 116, 31);
		depositField.setText("$ " +"0.00");
		depositPanel.add(depositField);
		
		clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearBtn.setBounds(176, 266, 116, 37);
		clearBtn.addActionListener(new ButtonListener());
		depositPanel.add(clearBtn);
		
		confirmBtn = new JButton("Confirm");
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmBtn.setBounds(50, 266, 116, 37);
		confirmBtn.addActionListener(new ButtonListener());
		depositPanel.add(confirmBtn);
		
		currentBnnr = new JLabel("Previous Account Balance:");
		currentBnnr.setFont(new Font("Tahoma", Font.BOLD, 15));
		currentBnnr.setBounds(348, 174, 206, 37);
		depositPanel.add(currentBnnr);
		
		previousBnnr = new JLabel("Current Account Balance:");
		previousBnnr.setFont(new Font("Tahoma", Font.BOLD, 15));
		previousBnnr.setBounds(348, 78, 197, 37);
		depositPanel.add(previousBnnr);
		
		currBalanceField = new JTextField();
		currBalanceField.setEditable(false);
		currBalanceField.setBounds(438, 225, 161, 27);
		depositPanel.add(currBalanceField);
		currBalanceField.setColumns(10);
		
		prevBalanceField = new JTextField();
		prevBalanceField.setEditable(false);
		prevBalanceField.setColumns(10);
		prevBalanceField.setBounds(438, 125, 161, 27);
		prevBalanceField.setText("$  "+currentUser.getTotalBalance()+".00");
		depositPanel.add(prevBalanceField);
		
		userInfo = new JLabel("New label");
		userInfo.setBounds(426, 11, 206, 14);
		userInfo.setText("Welcome back " + currentUser.getFirstName() + " " + currentUser.getLastName());
		depositPanel.add(userInfo);
		
		stmtField = new JTextField();
		stmtField.setEditable(false);
		stmtField.setFont(new Font("Tahoma", Font.ITALIC, 13));
		stmtField.setBounds(10, 385, 682, 153);
		contentPane.add(stmtField);
		
		Deposit.users = users;  //= Deposit.users;
		Deposit.currentUser = currentUser; //= Deposit.currentUser;
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == returnButton) {
				new Main(users,currentUser).setVisible(true);
				dispose();
			}
			else if(event.getSource() == confirmBtn) {
				currBalanceField.setText("$  "+currentUser.getTotalBalance() + ".00");
				currentUser.depositMoney(depositVal);
				prevBalanceField.setText("$  "+currentUser.getTotalBalance()+".00");
				stmtField.setText("The deposit in the amount of: $"+depositVal+ 
						" was successfully deposited in account:" + currentUser.getAccountNumber());
				depositVal = 0;
				depositField.setText("$ " + depositVal + ".00");
			}
			else if(event.getSource() == clearBtn) {
				depositVal = 0;
				depositField.setText("$ " + depositVal + ".00");
			}
			else if(event.getSource() == oneDollarBtn) {
				depositVal++;
				depositField.setText("$ " + depositVal + ".00");
				
			}
			else if(event.getSource() == fiveDollarBtn) {
				depositVal = depositVal + 5;
				depositField.setText("$ " + depositVal + ".00");
			}
			else if(event.getSource() == tenDollarBtn) {
				depositVal = depositVal + 10;
				depositField.setText("$ " + depositVal + ".00");
			}
			else if(event.getSource() == twentyDollarBtn) {
				depositVal = depositVal + 20;
				depositField.setText("$ " + depositVal + ".00");
			}
			else if(event.getSource() == fiftyDollarBtn) {
				depositVal = depositVal + 50;
				depositField.setText("$ " + depositVal + ".00");
			}
			else if(event.getSource() == hundredDollarBtn) {
				depositVal = depositVal + 100;
				depositField.setText("$ " + depositVal + ".00");
			}
			
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit frame = new Deposit(users,currentUser);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
