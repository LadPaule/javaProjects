import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculator {

	private JFrame frame;
	private JTextField screen;
	
	double num1;
	double num2;
	double result;
	String answer;
	String operations;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 128));
		frame.setBounds(100, 100, 296, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		screen = new JTextField();
		screen.setHorizontalAlignment(SwingConstants.RIGHT);
		screen.setBounds(10, 0, 263, 53);
		frame.getContentPane().add(screen);
		screen.setColumns(10);
		//.................this is my row 1.................
		
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = screen.getText() + seven.getText();
				screen.setText(number);
			}
		});
		seven.setForeground(new Color(0, 0, 128));
		seven.setFont(new Font("Tahoma", Font.BOLD, 13));
		seven.setBackground(new Color(192, 192, 192));
		seven.setBounds(10, 69, 50, 40);
		frame.getContentPane().add(seven);
		
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + eight.getText();
				screen.setText(number);
			}
		});
		eight.setForeground(new Color(0, 0, 128));
		eight.setFont(new Font("Tahoma", Font.BOLD, 13));
		eight.setBackground(new Color(192, 192, 192));
		eight.setBounds(82, 69, 50, 40);
		frame.getContentPane().add(eight);
		
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + nine.getText();
				screen.setText(number);
			}
		});
		nine.setForeground(new Color(0, 0, 128));
		nine.setFont(new Font("Tahoma", Font.BOLD, 13));
		nine.setBackground(new Color(192, 192, 192));
		nine.setBounds(147, 69, 50, 40);
		frame.getContentPane().add(nine);
		
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(screen.getText());
				screen.setText("");
				operations ="+";
			}
		});
		plus.setForeground(new Color(0, 0, 128));
		plus.setFont(new Font("Tahoma", Font.BOLD, 13));
		plus.setBackground(new Color(192, 192, 192));
		plus.setBounds(213, 69, 50, 40);
		frame.getContentPane().add(plus);
		//................This is my row 2............................
		
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + four.getText();
				screen.setText(number);
			}
		});
		four.setForeground(new Color(0, 0, 128));
		four.setFont(new Font("Tahoma", Font.BOLD, 13));
		four.setBackground(new Color(192, 192, 192));
		four.setBounds(10, 135, 50, 40);
		frame.getContentPane().add(four);
		
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + five.getText();
				screen.setText(number);
			}
		});
		five.setForeground(new Color(0, 0, 128));
		five.setFont(new Font("Tahoma", Font.BOLD, 13));
		five.setBackground(new Color(192, 192, 192));
		five.setBounds(82, 135, 50, 40);
		frame.getContentPane().add(five);
		
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + six.getText();
				screen.setText(number);
			}
		});
		six.setForeground(new Color(0, 0, 128));
		six.setFont(new Font("Tahoma", Font.BOLD, 13));
		six.setBackground(new Color(192, 192, 192));
		six.setBounds(147, 135, 50, 40);
		frame.getContentPane().add(six);
		
		JButton subtruct = new JButton("-");
		subtruct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(screen.getText());
				screen.setText("");
				operations ="-";	
			}
		});
		subtruct.setForeground(new Color(0, 0, 128));
		subtruct.setFont(new Font("Tahoma", Font.BOLD, 13));
		subtruct.setBackground(new Color(192, 192, 192));
		subtruct.setBounds(213, 135, 50, 40);
		frame.getContentPane().add(subtruct);
		//.........................This is my row 3.........................
		
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + one.getText();
				screen.setText(number);
			}
		});
		one.setForeground(new Color(0, 0, 128));
		one.setFont(new Font("Tahoma", Font.BOLD, 13));
		one.setBackground(new Color(192, 192, 192));
		one.setBounds(10, 203, 50, 40);
		frame.getContentPane().add(one);
		
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + two.getText();
				screen.setText(number);
			}
		});
		two.setForeground(new Color(0, 0, 128));
		two.setFont(new Font("Tahoma", Font.BOLD, 13));
		two.setBackground(new Color(192, 192, 192));
		two.setBounds(82, 203, 50, 40);
		frame.getContentPane().add(two);
		
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + three.getText();
				screen.setText(number);
			}
		});
		three.setForeground(new Color(0, 0, 128));
		three.setFont(new Font("Tahoma", Font.BOLD, 13));
		three.setBackground(new Color(192, 192, 192));
		three.setBounds(147, 203, 50, 40);
		frame.getContentPane().add(three);
		
		JButton divide = new JButton("/");
		divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(screen.getText());
				screen.setText("");
				operations ="/";
			}
		});
		divide.setForeground(new Color(0, 0, 128));
		divide.setFont(new Font("Tahoma", Font.BOLD, 13));
		divide.setBackground(new Color(192, 192, 192));
		divide.setBounds(213, 203, 50, 40);
		frame.getContentPane().add(divide);
		//...............this is my row 4...........................
		
		JButton decimal = new JButton(".");
		decimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + decimal.getText();
				screen.setText(number);
			}
		});
		decimal.setForeground(new Color(0, 0, 128));
		decimal.setHorizontalAlignment(SwingConstants.TRAILING);
		decimal.setFont(new Font("Tahoma", Font.BOLD, 22));
		decimal.setBackground(new Color(192, 192, 192));
		decimal.setBounds(10, 275, 50, 40);
		frame.getContentPane().add(decimal);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = screen.getText() + zero.getText();
				screen.setText(number);
			}
		});
		zero.setForeground(new Color(0, 0, 128));
		zero.setFont(new Font("Tahoma", Font.BOLD, 13));
		zero.setBackground(new Color(192, 192, 192));
		zero.setBounds(82, 275, 50, 40);
		frame.getContentPane().add(zero);
		
		JButton clear = new JButton("CL");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.setText(null);
			}
		});
		clear.setForeground(new Color(0, 0, 128));
		clear.setFont(new Font("Tahoma", Font.BOLD, 13));
		clear.setBackground(new Color(192, 192, 192));
		clear.setBounds(147, 275, 50, 40);
		frame.getContentPane().add(clear);
		
		JButton multiply = new JButton("X");
		multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(screen.getText());
				screen.setText("");
				operations ="*";
			}
		});
		multiply.setForeground(new Color(0, 0, 128));
		multiply.setFont(new Font("Tahoma", Font.BOLD, 13));
		multiply.setBackground(new Color(192, 192, 192));
		multiply.setBounds(213, 275, 50, 40);
		frame.getContentPane().add(multiply);
		
		// --------------This is my row five-------------
		
		JButton delete = new JButton("DE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Bkspace = null;
				if(screen.getText().length() > 0) {
					StringBuilder strB = new StringBuilder(screen.getText());
					strB.deleteCharAt(screen.getText().length() -1);
					Bkspace = strB.toString();
					screen.setText(Bkspace);
				}
			}
		});
		delete.setForeground(new Color(0, 0, 128));
		delete.setFont(new Font("Tahoma", Font.BOLD, 13));
		delete.setBackground(new Color(192, 192, 192));
		delete.setBounds(10, 346, 50, 40);
		frame.getContentPane().add(delete);
		
		JButton pm = new JButton("+/-");
		pm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double plusMinus = Double.parseDouble(String.valueOf(screen.getText()));
				plusMinus = plusMinus * (-1);
				screen.setText(String.valueOf(plusMinus));
			}
		});
		pm.setForeground(new Color(0, 0, 128));
		pm.setFont(new Font("Tahoma", Font.BOLD, 9));
		pm.setBackground(new Color(192, 192, 192));
		pm.setBounds(82, 346, 50, 40);
		frame.getContentPane().add(pm);
		
		JButton modulus = new JButton("%");
		modulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Double.parseDouble(screen.getText());
				screen.setText("");
				operations ="%";
			}
		});
		modulus.setForeground(new Color(0, 0, 128));
		modulus.setFont(new Font("Tahoma", Font.BOLD, 13));
		modulus.setBackground(new Color(192, 192, 192));
		modulus.setBounds(147, 346, 50, 40);
		frame.getContentPane().add(modulus);
		
		JButton equal = new JButton("=");
		equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String answer;
				num2 =Double.parseDouble(screen.getText());
				if(operations =="+") {
					result =num1 + num2;
					answer = String.format("%.2f", result);
					screen.setText(answer);
					
				}
				else if(operations =="-") {
					result =num1 - num2;
					answer = String.format("%.2f", result);
					screen.setText(answer);
				}
				else if(operations =="*") {
					result =num1 * num2;
					answer = String.format("%.2f", result);
					screen.setText(answer);
				}
				else if(operations =="/") {
					result =num1 / num2;
					answer = String.format("%.2f", result);
					screen.setText(answer);
				}
				else if(operations =="%") {
					result =num1 % num2;
					answer = String.format("%.2f", result);
					screen.setText(answer);
					
				}
			}
		});
		equal.setForeground(new Color(0, 0, 128));
		equal.setFont(new Font("Tahoma", Font.BOLD, 13));
		equal.setBackground(new Color(192, 192, 192));
		equal.setBounds(213, 346, 50, 40);
		frame.getContentPane().add(equal);
	}
}
