package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdrawal extends JFrame {

	private JPanel contentPane, withdrawalPanel;
	private JTextField withdrawField, currBalanceField, prevBalanceField, stmtField;
	private JLabel amtBnner, towthdrwBnr, currentBnnr, previousBnnr, userInfo;
	private JButton returnButton, confirmBtn, clearBtn, oneDollarBtn, fiveDollarBtn, tenDollarBtn, twentyDollarBtn, fiftyDollarBtn, hundredDollarBtn;
	private static User[] users;
	private static User currentUser;
	private int withdrawVal;

	/**
	 * Create the frame.
	 */
	public Withdrawal(User[] users,User currentUser) {
		setTitle("ATLAS ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 582);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setResizable(false);
		
		withdrawalPanel = new JPanel();
		withdrawalPanel.setLayout(null);
		withdrawalPanel.setBackground(Color.WHITE);
		withdrawalPanel.setBounds(10, 11, 682, 363);
		contentPane.add(withdrawalPanel);
		
		oneDollarBtn = new JButton("$1");
		oneDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		oneDollarBtn.setBackground(Color.LIGHT_GRAY);
		oneDollarBtn.setBounds(50, 77, 116, 37);
		oneDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(oneDollarBtn);
		
		fiveDollarBtn = new JButton("$5");
		fiveDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		fiveDollarBtn.setBackground(Color.LIGHT_GRAY);
		fiveDollarBtn.setBounds(50, 125, 116, 37);
		fiveDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(fiveDollarBtn);
		
		tenDollarBtn = new JButton("$10");
		tenDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		tenDollarBtn.setBackground(Color.LIGHT_GRAY);
		tenDollarBtn.setBounds(50, 173, 116, 37);
		tenDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(tenDollarBtn);
		
		twentyDollarBtn = new JButton("$20");
		twentyDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		twentyDollarBtn.setBackground(Color.LIGHT_GRAY);
		twentyDollarBtn.setBounds(176, 77, 116, 37);
		twentyDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(twentyDollarBtn);
		
		fiftyDollarBtn = new JButton("$50");
		fiftyDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		fiftyDollarBtn.setBackground(Color.LIGHT_GRAY);
		fiftyDollarBtn.setBounds(176, 125, 116, 37);
		fiftyDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(fiftyDollarBtn);
		
		hundredDollarBtn = new JButton("$100");
		hundredDollarBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		hundredDollarBtn.setBackground(Color.LIGHT_GRAY);
		hundredDollarBtn.setBounds(176, 173, 116, 37);
		hundredDollarBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(hundredDollarBtn);
		
		amtBnner = new JLabel("Please Specify Amount to Withdrawal");
		amtBnner.setFont(new Font("Tahoma", Font.ITALIC, 16));
		amtBnner.setBounds(50, 30, 292, 37);
		withdrawalPanel.add(amtBnner);
		
		returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		returnButton.setBounds(10, 329, 116, 23);
		returnButton.addActionListener(new ButtonListener());
		withdrawalPanel.add(returnButton);
		
		towthdrwBnr = new JLabel("Amount to Withdrawal:");
		towthdrwBnr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		towthdrwBnr.setBounds(23, 218, 143, 37);
		withdrawalPanel.add(towthdrwBnr);
		
		withdrawField = new JTextField();
		withdrawField.setEditable(false);
		withdrawField.setColumns(10);
		withdrawField.setBounds(176, 221, 116, 31);
		withdrawField.setText("$ " +"0.00");
		withdrawalPanel.add(withdrawField);
		
		clearBtn = new JButton("Clear");
		clearBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearBtn.setBounds(176, 266, 116, 37);
		clearBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(clearBtn);
		
		confirmBtn = new JButton("Confirm");
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmBtn.setBounds(50, 266, 116, 37);
		confirmBtn.addActionListener(new ButtonListener());
		withdrawalPanel.add(confirmBtn);
		
		currentBnnr = new JLabel("Previous Account Balance:");
		currentBnnr.setFont(new Font("Tahoma", Font.BOLD, 15));
		currentBnnr.setBounds(348, 174, 251, 37);
		withdrawalPanel.add(currentBnnr);
		
		previousBnnr = new JLabel("Current Account Balance:");
		previousBnnr.setFont(new Font("Tahoma", Font.BOLD, 15));
		previousBnnr.setBounds(348, 78, 251, 37);
		withdrawalPanel.add(previousBnnr);
		
		currBalanceField = new JTextField();
		currBalanceField.setEditable(false);
		currBalanceField.setColumns(10);
		currBalanceField.setBounds(438, 225, 161, 27);
		withdrawalPanel.add(currBalanceField);
		
		prevBalanceField = new JTextField();
		prevBalanceField.setEditable(false);
		prevBalanceField.setColumns(10);
		prevBalanceField.setBounds(438, 125, 161, 27);
		prevBalanceField.setText("$  "+ currentUser.getTotalBalance() +".00");
		withdrawalPanel.add(prevBalanceField);
		
		userInfo = new JLabel("New label");
		userInfo.setBounds(426, 11, 206, 14);
		userInfo.setText("Welcome back " + currentUser.getFirstName() + " " + currentUser.getLastName());
		withdrawalPanel.add(userInfo);
		
		stmtField = new JTextField();
		stmtField.setEditable(false);
		stmtField.setFont(new Font("Tahoma", Font.ITALIC, 13));
		stmtField.setBounds(10, 385, 682, 153);
		contentPane.add(stmtField);
		
		Withdrawal.users = users;  //= Deposit.users;
		Withdrawal.currentUser = currentUser; //= Deposit.currentUser;
		//users = this.users;
		//currentUser = this.currentUser;
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == returnButton) {
				new Main(users,currentUser).setVisible(true);
				dispose();
			}
			else if(event.getSource() == confirmBtn) {
				try {
					currBalanceField.setText("$  "+currentUser.getTotalBalance()+".00");
					currentUser.withdrawlMoney(withdrawVal);
					prevBalanceField.setText("$  "+currentUser.getTotalBalance()+".00");
					stmtField.setText("The withdrawal in the amount of: $"+withdrawVal+ 
							" was successfully withdrawn from account:" + currentUser.getAccountNumber());
					withdrawVal = 0;
					withdrawField.setText("$ " + withdrawVal + ".00");
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Amount to withdraw exceeds current Balance");
				}
			}
			else if(event.getSource() == clearBtn) {
				withdrawVal = 0;
				withdrawField.setText("$ " + withdrawVal + ".00");
			}
			else if(event.getSource() == oneDollarBtn) {
				withdrawVal++;
				withdrawField.setText("$ " + withdrawVal + ".00");
				
			}
			else if(event.getSource() == fiveDollarBtn) {
				withdrawVal = withdrawVal + 5;
				withdrawField.setText("$ " + withdrawVal + ".00");
			}
			else if(event.getSource() == tenDollarBtn) {
				withdrawVal = withdrawVal + 10;
				withdrawField.setText("$ " + withdrawVal + ".00");
			}
			else if(event.getSource() == twentyDollarBtn) {
				withdrawVal = withdrawVal + 20;
				withdrawField.setText("$ " + withdrawVal + ".00");
			}
			else if(event.getSource() == fiftyDollarBtn) {
				withdrawVal = withdrawVal + 50;
				withdrawField.setText("$ " + withdrawVal + ".00");
			}
			else if(event.getSource() == hundredDollarBtn) {
				withdrawVal = withdrawVal + 100;
				withdrawField.setText("$ " + withdrawVal + ".00");
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdrawal frame = new Withdrawal(users,currentUser);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
