import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.border.EmptyBorder;

public class Calculator implements ActionListener {
	JFrame frame;
	JTextField textfield;
	JPanel panel;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[5];
	JButton[] panelButtons = new JButton[9];
	JButton decButton, addButton, subButton, mulButton, divButton, equButton;
	JButton delButton, clrButton, negButton;
	JButton perButton, absButton, piButton, sqrButton, srootButton;
	Font myFont = new Font("Helvetica", Font.BOLD, 30);
	Font textFont = new Font("Helvetica", Font.BOLD, 35);
	double num1, num2, result = 0;
	char operator;
	int height = 630;
	int width = 520;
	Color functionColor = new Color(255, 149, 0);
	Color numberColor = new Color(80, 80, 80);
	Color top = new Color(212, 212, 210);

	Calculator() {

		JFrame frame = new JFrame("Calculator");
		frame.setLayout(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\shres\\eclipse-workspace\\Project\\src\\icons8-calculator-100 (1).png");
		frame.setIconImage(icon);

		textfield = new JTextField();
		textfield.setFont(textFont);
		textfield.setEditable(false);
		textfield.setBorder(null);
		textfield.setForeground(Color.BLACK);
		textfield.setHorizontalAlignment(JTextField.TRAILING);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("÷");
		equButton = new JButton("=");
		clrButton = new JButton("AC");
		negButton = new JButton("+/-");
		perButton = new JButton("%");
		absButton = new JButton("|x|");
		piButton = new JButton("𝝅");
		sqrButton = new JButton("x²");
		srootButton = new JButton("√x");
		decButton = new JButton(".");
		decButton.setBackground(numberColor);
		decButton.setForeground(Color.WHITE);
		Icon delete = new ImageIcon("C:\\Users\\shres\\eclipse-workspace\\Project\\src\\remove_icon.png");
		delButton = new JButton(delete);

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = equButton;
		panelButtons[0] = delButton;
		panelButtons[1] = clrButton;
		panelButtons[2] = negButton;
		panelButtons[3] = perButton;
		panelButtons[4] = piButton;
		panelButtons[5] = absButton;
		panelButtons[6] = sqrButton;
		panelButtons[7] = srootButton;
		panelButtons[8] = decButton;

		for (int i = 0; i < 5; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(functionColor);
			functionButtons[i].setForeground(Color.BLACK);
		}

		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

		JPanel contentPane = new JPanel(new GridBagLayout());
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.setContentPane(contentPane);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = gbc.REMAINDER;
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.weightx = 1;

		frame.add(textfield, gbc);

		for (int i = 0; i < 9; i++) {
			panelButtons[i].addActionListener(this);
			panelButtons[i].setFont(myFont);
			panelButtons[i].setFocusable(false);
		}

		for (int i = 0; i < 8; i++) {
			panelButtons[i].setBackground(top);
			panelButtons[i].setForeground(Color.BLACK);
		}

		JPanel centerPan = new JPanel();
		centerPan.setLayout(new GridLayout(6, 4, 10, 10));
		centerPan.add(negButton);
		centerPan.add(absButton);
		centerPan.add(clrButton);
		centerPan.add(delButton);
		centerPan.add(piButton);
		centerPan.add(perButton);
		centerPan.add(sqrButton);
		centerPan.add(srootButton);
		centerPan.add(numberButtons[7]);
		centerPan.add(numberButtons[8]);
		centerPan.add(numberButtons[9]);
		centerPan.add(mulButton);
		centerPan.add(numberButtons[4]);
		centerPan.add(numberButtons[5]);
		centerPan.add(numberButtons[6]);
		centerPan.add(subButton);
		centerPan.add(numberButtons[1]);
		centerPan.add(numberButtons[2]);
		centerPan.add(numberButtons[3]);
		centerPan.add(addButton);
		centerPan.add(numberButtons[0]);
		centerPan.add(decButton);
		centerPan.add(equButton);
		centerPan.add(divButton);

		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i].setBackground(numberColor);
			numberButtons[i].setForeground(Color.WHITE);
		}

		gbc.weighty = 1;
		frame.add(centerPan, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.weightx = 0.3;
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}

		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			DecimalFormat decimalFormat = new DecimalFormat("#.#############");
			String formattedResult = decimalFormat.format(result);
			textfield.setText(formattedResult);
			num1 = result;
		}
		if (e.getSource() == clrButton) {
			textfield.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
		if (e.getSource() == perButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			num1 *= 0.01;
			textfield.setText("");
		}
		if (e.getSource() == piButton) {
			double pi = Math.PI;
			textfield.setText(String.valueOf(pi));
		}
		if (e.getSource() == absButton) {
			double temp = Double.parseDouble(textfield.getText());
			double abs = Math.abs(temp);
			textfield.setText(String.valueOf(abs));
		}
		if (e.getSource() == sqrButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= temp;
			textfield.setText(String.valueOf(temp));

		}
		if (e.getSource() == srootButton) {
			double temp = Double.parseDouble(textfield.getText());
			double sqrt = Math.sqrt(temp);
			textfield.setText(String.valueOf(sqrt));
		}

	}

}
