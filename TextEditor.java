import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
class task5 extends JFrame implements ActionListener 
{
JTextArea t;
JFrame f;
task5()
{
f = new JFrame("Text Editor");
try {
UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
MetalLookAndFeel.setCurrentTheme(new OceanTheme());
}
catch (Exception e)
{
}
t = new JTextArea();
JMenuBar mb = new JMenuBar();
JMenu m1 = new JMenu("File");
JMenuItem m11 = new JMenuItem("New");
JMenuItem m12 = new JMenuItem("Open");
JMenuItem m13 = new JMenuItem("Save");
JMenuItem m19 = new JMenuItem("Print");
m11.addActionListener(this);
m12.addActionListener(this);
m13.addActionListener(this);
m19.addActionListener(this);
m1.add(m11);
m1.add(m12);
m1.add(m13);
m1.add(m19);
JMenu m2 = new JMenu("Edit");
JMenuItem m14 = new JMenuItem("cut");
JMenuItem m15 = new JMenuItem("copy");
JMenuItem m16 = new JMenuItem("paste");
m14.addActionListener(this);
m15.addActionListener(this);
m16.addActionListener(this);
m2.add(m14);
m2.add(m15);
m2.add(m16);
JMenuItem tx = new JMenuItem("close");
tx.addActionListener(this);
mb.add(m1);
mb.add(m2);
mb.add(tx);
f.setJMenuBar(mb);
f.add(t);
f.setSize(500, 500);
f.show();
}
public void actionPerformed(ActionEvent e)
{
String s = e.getActionCommand();
if (s.equals("cut"))
{
t.cut();
}
else if (s.equals("copy")) 
{
t.copy();
}
else if (s.equals("paste")) 
{
t.paste();
}
else if (s.equals("Save"))
{
JFileChooser j = new JFileChooser("f:");
int r = j.showSaveDialog(null);
if (r == JFileChooser.APPROVE_OPTION)
{
File fi = new File(j.getSelectedFile().getAbsolutePath());
try
{
FileWriter wr = new FileWriter(fi, false);
BufferedWriter w = new BufferedWriter(wr);
w.write(t.getText());
w.flush();
w.close();
}
catch (Exception evt)
{
JOptionPane.showMessageDialog(f, evt.getMessage());
}
}
else
JOptionPane.showMessageDialog(f, "the user cancelled the operation");
}
else if (s.equals("Print")) 
{
try 
{
t.print();
}
catch (Exception evt) {
JOptionPane.showMessageDialog(f, evt.getMessage());
}
}
else if (s.equals("Open")) 
{
JFileChooser j = new JFileChooser("f:");
int r = j.showOpenDialog(null);
if (r == JFileChooser.APPROVE_OPTION)
{
File fi = new File(j.getSelectedFile().getAbsolutePath());
try 
{
String s1 = "", sl = "";
FileReader fr = new FileReader(fi);
BufferedReader br = new BufferedReader(fr);
sl = br.readLine();
while ((s1 = br.readLine()) != null)
{
sl = sl + "\n" + s1;
}
t.setText(sl);
}
catch (Exception evt)
{
JOptionPane.showMessageDialog(f, evt.getMessage());
}
}
else
JOptionPane.showMessageDialog(f, "the user cancelled the operation");
}
else if (s.equals("New"))
{
t.setText("");
}
else if (s.equals("close")) 
{
f.setVisible(false);
}
}
public static void main(String args[])
{
task5 ed = new task5();
}
}
