import javax.swing.*;

import java.awt.*;
public class FlowLayout_���ֹ����� extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FlowLayout_���ֹ�����(){
		setLayout(new FlowLayout());
		add(new JLabel("Buttons:"));
		add(new JButton("Button1"));
		add(new JButton("2"));
		add(new JButton("Button3"));
		add(new JButton("Long_Named Button4"));
		add(new JButton("Button5"));
	}
	public static void main(String[] args){
		FlowLayout_���ֹ����� window=new FlowLayout_���ֹ�����();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("��ť���ڴ���");
		window.pack();	//��������Ϊ�ʺ��������ѳߴ�Ͳ�������Ŀռ�
		window.setVisible(true);
	}
}
