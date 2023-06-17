import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class App implements ActionListener{
    JButton one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, multiply, div, clear, back, equal;
    JLabel error_msg, title;
    JTextField main_field;
    String num1 = "", num2 = "";
    Integer number1 = 0, number2 = 0;
    Boolean isNumber1Complete = false, isNumber2Complete = false;
    String str_concat = "";
    App(){
        JFrame jf = new JFrame("Calculator");

        // layouts
        title = new JLabel("Calculator");
        title.setBounds(13, 10, 305, 30);
        main_field = new JTextField();
        main_field.setBounds(13, 50, 260, 30);

        // button layouts
        one = new JButton("1");
        one.setBounds(13, 90, 50, 50);
        two = new JButton("2");
        two.setBounds(80, 90, 50, 50);
        three = new JButton("3");
        three.setBounds(150, 90, 50, 50);
        four = new JButton("4");
        four.setBounds(13, 150, 50, 50);
        five = new JButton("5");
        five.setBounds(80, 150, 50, 50);
        six = new JButton("6");
        six.setBounds(150, 150, 50, 50);
        seven = new JButton("7");
        seven.setBounds(13, 212, 50, 50);
        eight = new JButton("8");
        eight.setBounds(80, 212, 50, 50);
        nine = new JButton("9");
        nine.setBounds(150, 212, 50, 50);
        zero = new JButton("0");
        zero.setBounds(13, 277, 50, 50);

        equal = new JButton("=");
        equal.setBounds(80, 277, 50, 50);
        clear = new JButton("C");
        clear.setBounds(150, 277, 50, 50);

        plus = new JButton("+");
        plus.setBounds(220, 90, 50, 50);
        minus = new JButton("-");
        minus.setBounds(220, 150, 50, 50);
        multiply = new JButton("*");
        multiply.setBounds(220, 212, 50 ,50);
        div = new JButton("/");
        div.setBounds(220, 277, 50, 50);

        error_msg = new JLabel("Note! : Only work with two number!");
        error_msg.setForeground(Color.RED);
        error_msg.setBounds(33, 330, 305, 30);

        // put together to frame;
        jf.add(title);
        jf.add(main_field);

        jf.add(one); jf.add(two); jf.add(three); jf.add(four); jf.add(five); jf.add(six); jf.add(seven);
        jf.add(eight); jf.add(nine); jf.add(zero); jf.add(equal); jf.add(clear);
        jf.add(plus); jf.add(minus); jf.add(div); jf.add(multiply); jf.add(error_msg);

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        plus.addActionListener(this);
        multiply.addActionListener(this);
        minus.addActionListener(this);
        div.addActionListener(this);
        equal.addActionListener(this);
        clear.addActionListener(this);

        jf.setSize(300, 400);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        
        if(isNumber1Complete == false){
            if(e.getSource() == one){num1 += "1"; main_field.setText("1");}
            if(e.getSource() == two){num1 += "2"; main_field.setText(num1);}
            if(e.getSource() == three){num1 += "3"; main_field.setText(num1);}
            if(e.getSource() == four){num1 += "4"; main_field.setText(num1);}
            if(e.getSource() == five){num1 += "5"; main_field.setText(num1);}
            if(e.getSource() == six){num1 += "6"; main_field.setText(num1);}
            if(e.getSource() == seven){num1 += "7"; main_field.setText(num1);}
            if(e.getSource() == eight){num1 += "8"; main_field.setText(num1);}
            if(e.getSource() == nine){num1 += "9"; main_field.setText(num1);}
            if(e.getSource() == zero){num1 += "0"; main_field.setText(num1);}

            if(e.getSource() == plus || e.getSource() == minus || e.getSource() == multiply || e.getSource() == div){
                number1 += Integer.parseInt(num1);
                isNumber1Complete = true;
            }
        }

        if(e.getSource() == plus) { str_concat += num1 += " + ";main_field.setText(str_concat);}
        if(e.getSource() == minus) { str_concat += num1 += " - ";main_field.setText(str_concat);}
        if(e.getSource() == multiply) { str_concat += num1 += " * ";main_field.setText(str_concat);}
        if(e.getSource() == div) { str_concat += num1 += " / ";main_field.setText(str_concat);}

        if(isNumber2Complete == false && isNumber1Complete == true){
            if(e.getSource() == one){num2 += "1"; main_field.setText(str_concat + num2);}
            if(e.getSource() == two){num2 += "2"; main_field.setText(str_concat + num2);}
            if(e.getSource() == three){num2 += "3"; main_field.setText(str_concat + num2);}
            if(e.getSource() == four){num2 += "4"; main_field.setText(str_concat + num2);}
            if(e.getSource() == five){num2 += "5"; main_field.setText(str_concat + num2);}
            if(e.getSource() == six){num2 += "6"; main_field.setText(str_concat + num2);}
            if(e.getSource() == seven){num2 += "7"; main_field.setText(str_concat + num2);}
            if(e.getSource() == eight){num2 += "8"; main_field.setText(str_concat + num2);}
            if(e.getSource() == nine){num2 += "9"; main_field.setText(str_concat + num2);}
            if(e.getSource() == zero){num2 += "0"; main_field.setText(str_concat + num2);}

            if(e.getSource() == equal){
                number2 += Integer.parseInt(num2);
                isNumber2Complete = true;
            }
        }


        if(isNumber1Complete && isNumber2Complete){
            if(e.getSource() == equal && main_field.getText().contains("+")) {
                int res = number1 + number2; String str_res = String.valueOf(res) ;main_field.setText(str_res); 
            }
            if(e.getSource() == equal &&  main_field.getText().contains("-")) {
                int res = number1 - number2; String str_res = String.valueOf(res) ;main_field.setText(str_res); 
            }
            if(e.getSource() == equal && main_field.getText().contains("*")) {
                int res = number1 * number2; String str_res = String.valueOf(res) ;main_field.setText(str_res); 
            }
            if(e.getSource() == equal && main_field.getText().contains("/")) {
                int res = number1 / number2; String str_res = String.valueOf(res) ;main_field.setText(str_res); 
            }
        }

        if(e.getSource() == clear){
            isNumber1Complete = false;
            isNumber2Complete = false;
            num1 = "";
            num2 = "";
            number1 = 0;
            number2 = 0;
            str_concat = "";
            main_field.setText(" ");
        }

    }

    public static void main(String[] args){
        new App();
    }
}