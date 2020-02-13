package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    // create a frame
    static JFrame frame;

    // create a textfield
    static JTextField monitor;

    // store oprerator and operands
    String s0, s1, s2;

    int errors = 0;
    // default constrcutor
    Main()
    {
        s0 = s1 = s2 = "";
    }
    public static void main(String[] args) {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        monitor = new JTextField(16);
        monitor.setEditable(false);
        Main c = new Main();
        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // equals button
        beq1 = new JButton("=");

        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");

        // create . button
        be = new JButton(".");

        // create a panel
        JPanel p = new JPanel();


        //action listeners
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);

        // add elements to panel
        p.add(monitor);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);

        // set Background of panel
        p.setBackground(Color.black);

        // add panel to frame
        frame.add(p);

        frame.setSize(200, 220);
        frame.setVisible(true);
    }
  @Override
    public void actionPerformed(ActionEvent a) {
        String s = a.getActionCommand();
        if(errors>0) {
            reset();
            errors = 0;
        }
      monitor.setText(monitor.getText() + s);
        if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("0") || s.equals("."))
        {
            if(s1.equals(""))
                s0 += s;
            else
                s2 += s;
        }
        else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
        {
            s1 = s;
        }
        else if(s.equals("C"))
        {
            reset();
        }
        else if(s.equals("="))
        {
            double result = Double.valueOf(s0) + Double.valueOf(s2);

            if(s1.equals("+")) {
                result = Double.valueOf(s0) + Double.valueOf(s2);
            }
            else if(s1.equals("-")) {
                result = Double.valueOf(s0) - Double.valueOf(s2);
            }
            else if(s1.equals("/")) {
                if(s2.equals("0"))
                {
                    monitor.setText("Dividend can not be zero!");
                    errors++;
                    return;
                }
                result = Double.valueOf(s0) / Double.valueOf(s2);
            }
            else if(s1.equals("*")) {
                result = Double.valueOf(s0) * Double.valueOf(s2);
            }
            s0 = String.valueOf(result);
            s2 = "";
            monitor.setText(s0);
        }

    }

    public void reset()
    {
        s0=s1=s2="";
        monitor.setText("");
    }
}
