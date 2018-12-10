package com.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import com.sample.DroolsTest.Question;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class AIGui extends JFrame implements ActionListener
{
	private JFrame frame;
	private Label questionLabel;
	private ButtonGroup group;
	private JRadioButton [] radioButtons;
	private JPanel panel;
	private JButton nextButton;
	private boolean next;
	private String question;
	private String [] answers;
	
	public AIGui ()
	{
		//TODO
		//layout
		//wrunek  stopu
		
		
		this.radioButtons = new JRadioButton[8];
		this.next = false;
		this.frame = new JFrame("Family Movie Flowchart");
		this.questionLabel = new Label("question here");
		this.questionLabel.setMaximumSize(new Dimension(10000,50));
		this.nextButton = new JButton("Next");
		
		
		this.frame.setSize(600, 600);
		this.frame.setResizable(false);
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.frame.add(panel);
		this.frame.setVisible(true);
		
	}
	
	public void present() 
	{
		this.panel.removeAll();

		this.questionLabel.setText(this.question);
		this.panel.add(this.questionLabel);
		
		for (int i=0; i<this.answers.length ;i++) {
			this.panel.add(radioButtons[i]);
		}
		this.panel.add(this.nextButton);
		this.panel.revalidate();
		this.panel.repaint();
		
	}
	
	public int showQuestion(Question q)
	{
		this.question = q.getContent();
		this.answers = q.getAnswers();
		this.nextButton.setEnabled(false);
		this.group = new ButtonGroup();
		for (int i=0; i<this.answers.length ;i++) {
			radioButtons[i] = new JRadioButton(this.answers[i]);
			radioButtons[i].addActionListener(x->{this.nextButton.setEnabled(true);});
			radioButtons[i].setActionCommand(Integer.toString(i));
			this.group.add(radioButtons[i]);
		}
		
		this.nextButton.addActionListener(x -> {this.next = true;});
		this.present();
		
		while (true) {
			
			if (this.next) 
			{
				// zwraca indeks wybranej odpowiedzi
				this.next = false;
				return Integer.parseInt(this.group.getSelection().getActionCommand());
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public int showResult(String movieName) {
		this.panel.removeAll();
		Label result = new Label("the result is: \n" + movieName);
		this.panel.add(result);
		this.nextButton.setEnabled(true);
		this.next = false;
		this.panel.add(nextButton);
		this.panel.revalidate();
		this.panel.repaint();
		
		while (true){
			if(this.next) {
				return 0;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
//		Object e_source = e.getSource();
//		if (e_source == this.nextButton)
//		{
//			
//			this.panel.revalidate();
//			this.panel.repaint();
//			
//		}
	}


	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run() {
				new AIGui();
			}
		});
	}

	

	



}
