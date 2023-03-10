package Calculator1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener
{
    private Button b1, b2,b3,b4,b5,b6,b7,b8,b9,b0;
    private Button bmult,bsub,bcount, bdiv,bsum , bclear;
    private TextField text;
    private  JPanel p;
    private String num1, operator, num2;
    Calculator()
    {
        num1 = operator = num2 = "";

        b0=new Button("0");
        b1=new Button("1");
        b2=new Button("2");
        b3=new Button("3");
        b4=new Button("4");
        b5=new Button("5");
        b6=new Button("6");
        b7=new Button("7");
        b8=new Button("8");
        b9=new Button("9");

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        bcount=new Button("+");
        bsub= new Button("-");
        bmult = new Button("*");
        bdiv= new Button("/");
        bsum= new Button("=");
        bclear = new Button("C");

        bcount.addActionListener(this);
        bsub.addActionListener(this);
        bmult.addActionListener(this);
        bdiv.addActionListener(this);
        bsum.addActionListener(this);
        bclear.addActionListener(this);

        bcount.setBackground(Color.pink);
        bsub.setBackground(Color.pink);
        bmult.setBackground(Color.pink);
        bdiv.setBackground(Color.pink);
        bsum.setBackground(Color.pink);
        bclear.setBackground(Color.pink);

        text = new TextField(16);
        text.setEditable(false);

        p = new JPanel();

        p.add(text);
        p.add(b0);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bcount);
        p.add(bsub);
        p.add(bmult);
        p.add(bdiv);
        p.add(bsum);
        p.add(bclear); 

        p.setBackground(Color.lightGray);
        this.add(p);

        this.setTitle("Calculator");
        this.setSize(300,300);
        this.setResizable(false);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String bt = e.getActionCommand();
        if((bt.charAt(0)>='0' && bt.charAt(0)<='9'))
        {
            if (!operator.equals(""))
            {
				num2 = num2 + bt;
            }
			else
            {
				num1 = num1 + bt;
            }

            text.setText(num1 + operator + num2);    
        }
        else if (bt.charAt(0) == '=') {

			double te;

			// store the value in 1st
			if (operator.equals("+"))
            {
				te = (Double.parseDouble(num1) + Double.parseDouble(num2));
            }
			else if (operator.equals("-"))
            {
				te = (Double.parseDouble(num1) - Double.parseDouble(num2));
            }
			else if (operator.equals("/"))
            {
				te = (Double.parseDouble(num1) / Double.parseDouble(num2));
            }
			else
            {
				te = (Double.parseDouble(num1) * Double.parseDouble(num2));
            }


            text.setText((num1 + operator + num2 + "=" + te));
			num1 = Double.toString(te);
			operator = num2 = "";
		}
        else if(bt.charAt(0)=='C')
        {
            num1 = operator = num2 = "" ;
            text.setText(num1 + operator + num2);
        }
		else 
        {
			if (operator.equals("") || num2.equals(""))
            {
                operator = bt;
            }
			else 
            {
				double te;
				if (operator.equals("+"))
                {
                    te = (Double.parseDouble(num1) + Double.parseDouble(num2));
                }
				else if (operator.equals("-"))
                {
					te = (Double.parseDouble(num1) - Double.parseDouble(num2));
                }
				else if (operator.equals("/"))
                {
					te = (Double.parseDouble(num1) / Double.parseDouble(num2));
                }
				else
                {
					te = (Double.parseDouble(num1) * Double.parseDouble(num2));
                }

				num1 = Double.toString(te);
				operator = bt;
				num2 = "";

			}
			text.setText(num1 + operator + num2);
		}

    }
    
}
