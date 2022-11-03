package com.swing.exam;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SimpleSwingPane extends JFrame {

	private boolean stop = false;  // start or stop the counter
    private JTextField tfCount;
    private int count = 1;
	
    SimpleSwingPane(){
    	Container cp = this.getContentPane();
	    cp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
	    cp.add(new JLabel("Counter"));
	    tfCount = new JTextField(count + "", 10);
	    tfCount.setEditable(false);
	    cp.add(tfCount);
	 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Counter");
	    setSize(300, 120);
	    setVisible(true);
    }
    
	public static void main(String args[]) {
		SimpleSwingPane ssp = new SimpleSwingPane();
	}
}
