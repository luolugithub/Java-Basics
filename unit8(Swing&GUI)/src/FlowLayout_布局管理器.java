import javax.swing.*;

import java.awt.*;
public class FlowLayout_布局管理器 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FlowLayout_布局管理器(){
		setLayout(new FlowLayout());
		add(new JLabel("Buttons:"));
		add(new JButton("Button1"));
		add(new JButton("2"));
		add(new JButton("Button3"));
		add(new JButton("Long_Named Button4"));
		add(new JButton("Button5"));
	}
	public static void main(String[] args){
		FlowLayout_布局管理器 window=new FlowLayout_布局管理器();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("按钮窗口创建");
		window.pack();	//窗口设置为适合组件的最佳尺寸和布局所需的空间
		window.setVisible(true);
	}
}
