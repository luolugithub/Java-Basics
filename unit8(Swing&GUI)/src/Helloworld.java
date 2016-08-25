import javax.swing.*;

//import java.awt.Frame;
//import java.awt.event.*;
public class Helloworld {
	public static void main(String[] args){
		JFrame frame=new JFrame("helloworld");
		final JLabel label =new JLabel("hello,world!");
		frame.getContentPane().add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,70);
		frame.setVisible(true);
	}
}
