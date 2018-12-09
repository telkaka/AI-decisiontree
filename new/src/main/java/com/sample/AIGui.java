package com.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import com.sample.DroolsTest.Question;

import java.awt.event.KeyEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AIGui extends JFrame implements ActionListener
{
	JFrame frame = new JFrame("Family Movie Flowchart");
	JPanel mainPanel = new JPanel();
	JButton bStart = new JButton("Start");
	ButtonGroup buttonGroup = new ButtonGroup();
	
	public AIGui ()
	{
		frame.setSize(600, 600);
		frame.add(mainPanel);
		mainPanel.add(bStart);
		mainPanel.setVisible(true);

		bStart.setVisible(true);
		bStart.addActionListener(this);
		
		
		/*for (int i = 0; i < Question.getAnswers().length; i++)
		{
			JRadioButton button = new JRadioButton("i");
			buttonGroup.add(button);
			mainPanel.add(button);
			
		}*/
		//po odkomentowaniu sie odpala, ale wyrzuca bledy i nie wlacza okienka
		
		/*for (int i = 0; i < 5; i++)
		{
			JRadioButton button = new JRadioButton("i");
			buttonGroup.add(button);
			mainPanel.add(button);
			
		}*/
		//na sztywno w kodzie dziala, wiec cos musi byc zle z getAnswers
		
		
		frame.setVisible(true);
		
		

	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object e_source = e.getSource();
		if (e_source == bStart)
		{
			mainPanel.removeAll();
			//tak se tylko usuwam bo nie mam jak ruszyc dalej
			//tu teraz powinno sie ladowac nowe pytanie, mozna wyczyscic ekran wlasnie tym sposobem i naniesc na niego nowe elementy
			mainPanel.revalidate();
			mainPanel.repaint();
			
		}
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
