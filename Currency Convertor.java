import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class task1
    {
    public static void currencyconverter()
    { 
        JFrame f = new JFrame(" CURRENCY CONVERTER");
        JLabel l1, l2;
        JTextField t11, t22;
        JButton b1, b2, b3;
        l1 = new JLabel("Rupees:");
        l1.setBounds(20, 40, 60, 30);
        l2 = new JLabel("Dollars:");
        l2.setBounds(170, 40, 60, 30);
        t11 = new JTextField("0");
        t11.setBounds(80, 40, 50, 30);
        t22 = new JTextField("0");
        t22.setBounds(240, 40, 50, 30);
        b1 = new JButton("INR");
        b1.setBounds(50, 80, 60, 15);
        b2 = new JButton("Dollar");
        b2.setBounds(190, 80, 60, 15);
        b3 = new JButton("closed");
        b3.setBounds(150, 150, 60, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double d = Double.parseDouble(t11.getText());
                double d1 = (d / 65.25);
                String str11 = String.valueOf(d1);
                t22.setText(str11);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                double d2 = Double.parseDouble(t22.getText());
                double d3 = (d2 * 65.25);
                String str12 = String.valueOf(d3);
                t11.setText(str12);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
            }
        });
  
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        f.add(l1);
        f.add(t11);
        f.add(l2);
        f.add(t22);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setLayout(null);
        f.setSize(400, 300);
        f.setVisible(true);
    }
    public static void main(String args[])
    {
     currencyconverter();
    }
}
