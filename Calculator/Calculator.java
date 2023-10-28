package calc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator implements ActionListener {
	
	JFrame window;
	JTextField txt;
	JButton[] button = new JButton[19]; // numbers 0-9 + operations (-*/+=)
	JPanel panel;
	char operator;
	double num1 = 0, num2 = 0, result;
	
	public void run() {
		
		window = new JFrame("Calculator Application");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(420,550);
		window.setLayout(null);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
		txt = new JTextField();
		txt.setBounds(50,25,300,50);
		txt.setEditable(false);
		
		button[0] = new JButton("+");
		button[1] = new JButton("-");
		button[2] = new JButton("*");
		button[3] = new JButton("/");
		button[4] = new JButton(".");
		button[5] = new JButton("=");
		
		// For reference:
		// buttons[6 - 15] = numbers : 0 - 9
		//
		for(short i = 0; i < button.length-3; i++) {
			if(i >= 6) {
				button[i] = new JButton(String.valueOf(i-6));
			}
			button[i].addActionListener(this);
			button[i].setFocusable(false); // gets rid of outline after clicking a button
		}
		//Button 13 + 14
		button[16] = new JButton("Delete");
		button[16].addActionListener(this);
		button[16].setFocusable(false);
		
		button[17] = new JButton("Clear");
		button[17].addActionListener(this);
		button[17].setFocusable(false);
		
		button[16].setBounds(150,430,100,50);
		button[17].setBounds(250,430,100,50);
		
		button[18] = new JButton("(-)");
		button[18].setBounds(50,430,100,50);
		button[18].addActionListener(this);
		button[18].setFocusable(false);
		//----------------------------------
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.gray);
		
		//num 1 - 3
		panel.add(button[7]); // num 1:
		panel.add(button[8]); // num 2:
		panel.add(button[9]); // num 3:
		panel.add(button[0]); // +
		
		panel.add(button[10]); // num 4
		panel.add(button[11]); // num 5
		panel.add(button[12]); // num 6
		panel.add(button[1]);  // num -
		
		panel.add(button[13]); // num 7
		panel.add(button[14]); // num 8
		panel.add(button[15]); // num 9
		panel.add(button[2]);  // num *
		
		panel.add(button[4]); // num .
		panel.add(button[6]); // num 0 
		panel.add(button[3]); // num /
		panel.add(button[5]); // num =

		window.add(panel);
		window.add(button[16]);
		window.add(button[17]);
		window.add(button[18]);
		window.add(txt);
		window.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		for(short i = 0; i < 10; i++) {
			if(e.getSource() == button[i+6]) {
				txt.setText(txt.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == button[4]) {
			txt.setText(txt.getText().concat("."));
		}
		//If add
		if(e.getSource() == button[0]) {
			num1 = Double.parseDouble(txt.getText());
			operator = '+';
			txt.setText("");
		}
		//If subtract
		if(e.getSource() == button[1]) {
			num1 = Double.parseDouble(txt.getText());
			operator = '-';
			txt.setText("");
		}
		if(e.getSource() == button[2]) {
			num1 = Double.parseDouble(txt.getText());
			operator = '*';
			txt.setText("");
		}
		if(e.getSource() == button[3]) {
			num1 = Double.parseDouble(txt.getText());
			operator = '/';
			txt.setText("");
		}
		if(e.getSource() == button[5]) {
			num2=Double.parseDouble(txt.getText());
			switch(operator) {
			case '+': result=num1+num2;  break;
			case '-': result=num1-num2;  break;
			case '*': result=num1*num2;  break;
			case '/': result=num1/num2; break;
			}
			txt.setText(String.valueOf(result));
			num1 = result;
		}
		//Clear
		if(e.getSource() == button[17]) {
			txt.setText("");
		}
		//Delete
		if(e.getSource() == button[16]) {
			if(txt.getText().isBlank()) {
			}
			else {
				String str = txt.getText();
				str = str.substring(0,str.length()-1);
				txt.setText(str);
			}
		}
		if(e.getSource() == button[18]) {
			double temp = Double.parseDouble(txt.getText());
			temp *= -1;
			txt.setText(String.valueOf(temp));
		}
	}
}
