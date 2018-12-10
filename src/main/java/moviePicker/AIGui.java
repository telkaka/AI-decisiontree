package moviePicker;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import moviePicker.MoviePicker.Question;



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

		this.radioButtons = new JRadioButton[8];
		this.next = false;
		this.frame = new JFrame("Family Movie Flowchart");
		this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.questionLabel = new Label("question here");
		this.questionLabel.setMaximumSize(new Dimension(10000,50));
		this.nextButton = new JButton("Next");
		
		
		this.frame.setSize(600, 600);
		this.frame.setResizable(false);
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(0,1));
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
		this.nextButton.setText("Next");
		this.next = false;
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
				e.printStackTrace();
			}
		}
	}
	public int showResult(String movieName) {
		this.panel.removeAll();
		Label result = new Label("The result is: " + movieName);
		this.panel.add(result);
		this.nextButton.setEnabled(true);
		this.next = false;
		nextButton.setText("See next result");
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
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
	}
}
