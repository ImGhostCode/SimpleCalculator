import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

public class Calculator implements Action{

    JFrame frame;
    JTextField field;
    JPanel panel;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalButton, delButton, clrButton, negButton;
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    Font myFont = new Font("Ink Free", Font.ITALIC, 25);

    Calculator (){

        field = new JTextField();
        field.setBounds(50, 25, 300, 50);
        field.setEditable(false);
        field.setFont(myFont);
        field.setForeground(Color.GREEN);
        field.setBackground(Color.BLACK);

        //
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");
       
        //
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equalButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        //
        for (int i = 0; i < 9; i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }
        
        //
        for (int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        //
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(155, 430, 100, 50);
        clrButton.setBounds(265, 430, 100, 50);

        //
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
      
        // 
        panel.add(numberButtons[9]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[7]);
        panel.add(addButton);

        panel.add(numberButtons[6]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[4]);
        panel.add(subButton);
        
        panel.add(numberButtons[3]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[1]);
        panel.add(mulButton);
        

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);



        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(field);
        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++){
            if (e.getSource() == numberButtons[i]){
                field.setText(field.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            field.setText(field.getText().concat((".")));
        }

        if (e.getSource() == delButton){
            field.setText(field.getText().substring(0, field.getText().length()-1));
        }

        if (e.getSource() == clrButton){
            field.setText("");
        }

        if (e.getSource() == addButton){
            num1 = Double.parseDouble(field.getText());
            operator = '+';
            field.setText("");
        }

        if (e.getSource() == subButton){
            num1 = Double.parseDouble(field.getText());
            operator = '-';
            field.setText("");
        }

        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(field.getText());
            operator = '*';
            field.setText("");
        }

        if (e.getSource() == divButton){
            num1 = Double.parseDouble(field.getText());
            operator = '/';
            field.setText("");
        }

        if (e.getSource() == equalButton){
            num2 = Double.parseDouble(field.getText());
            switch (operator){
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            num1 = result;
            field.setText(String.valueOf(result));
        }

        if (e.getSource() == negButton){
            double temp = Double.parseDouble(field.getText());
            temp *= -1;
            field.setText(String.valueOf(temp));
        }

    }
 
}
