package GUI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import Data.FileIO;
import java.awt.SystemColor;

public class DepositAcc extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private static boolean isOpen = false;

	public DepositAcc() {
		if(isOpen) {
			JOptionPane.showMessageDialog(null, "Window is already open");
			return;
		}
		isOpen = true;
		setTitle("Deposit To Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDepositToAccount = new JLabel("Deposit To Account");
		lblDepositToAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepositToAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositToAccount.setBounds(10, 11, 414, 36);
		contentPane.add(lblDepositToAccount);
		
		JLabel lblName = new JLabel("Account Number:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(0, 86, 111, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(121, 83, 211, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblHolderName = new JLabel("Account Holder Name:");
		lblHolderName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHolderName.setBounds(0, 116, 111, 14);
		contentPane.add(lblHolderName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 113, 211, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBankBranch = new JLabel("Bank Branch:");
		lblBankBranch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBankBranch.setBounds(0, 146, 111, 14);
		contentPane.add(lblBankBranch);
		
		textField_2 = new JTextField();
		textField_2.setBounds(121, 143, 211, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblIfscCode = new JLabel("IFSC Code:");
		lblIfscCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIfscCode.setBounds(0, 176, 111, 14);
		contentPane.add(lblIfscCode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 173, 211, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(0, 206, 111, 14);
		contentPane.add(lblAmount);
		
		textField_4 = new JTextField();
		textField_4.setBounds(121, 203, 211, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aacountNum;
				double amt;
				aacountNum=textField.getText();
				amt=Double.parseDouble(textField_4.getText());
				int a=JOptionPane.showConfirmDialog(getComponent(0), "Confirm?");
				if(a==0)
				{
				try {
						FileIO.bank.deposit(aacountNum, amt);
						JOptionPane.showMessageDialog(getComponent(0),"Deposit Successful");
						dispose();
						isOpen = false;
				} 
				catch (InvalidAmount e1) {
					JOptionPane.showMessageDialog(getComponent(0), "Sorry! Deposit Amount is Invalid");
					
				} catch (AccNotFound e1) {
					JOptionPane.showMessageDialog(getComponent(0), "Sorry! Account is Not Found");
					
				}
				finally
				{
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
				}
				
					
				}
				else
				{
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
				}
				
					
					
				
			}
		});
		btnDeposit.setBounds(73, 234, 89, 23);
		contentPane.add(btnDeposit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(243, 234, 89, 23);
		contentPane.add(btnReset);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
			}
		});
	}
}
