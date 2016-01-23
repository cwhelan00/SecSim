import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class BankPanel extends JPanel{
	
	private final int WIDTH = 200, HEIGHT = 250;
	private double balance = 0;
	private JLabel depositLabel, resultLabel, withdrawLabel, exceptionLabel;
	private JTextField deposit;
	private JTextField withdraw;
	
	public BankPanel(){
	
		depositLabel = new JLabel("Deposit");
		withdrawLabel = new JLabel("Withdraw");
		resultLabel = new JLabel(" ");		
		exceptionLabel = new JLabel(" ");
		
		deposit = new JTextField(10);
		withdraw = new JTextField(10);
		
		NumberListener listener = new NumberListener();
		deposit.addActionListener(listener);
		withdraw.addActionListener(listener);
		
		add(depositLabel);
		add(deposit);
		add(withdrawLabel);
		add(withdraw);
		add(resultLabel);
		add(exceptionLabel);
		
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.LIGHT_GRAY);
	}
	private class NumberListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == deposit){
				double dAmount;
				String sAmount = deposit.getText();
				try{
				dAmount = Double.parseDouble(sAmount);
				}
				catch(NumberFormatException e){
					exceptionLabel.setText("ERROR");
					dAmount = 0;
				}
				balance += dAmount;
				NumberFormat fmt = NumberFormat.getCurrencyInstance();
				resultLabel.setText("Balance: " + fmt.format(balance));
			}
			if(event.getSource() == withdraw){
				double dAmount;
				String sAmount = withdraw.getText();
				try{
				dAmount = Double.parseDouble(sAmount);
				}
				catch(NumberFormatException e){
					exceptionLabel.setText("ERROR");
					dAmount = 0;
				}
				balance -= dAmount;
				NumberFormat fmt = NumberFormat.getCurrencyInstance();
				resultLabel.setText("Balance: " + fmt.format(balance));
			}
		}
	}		

}
