package com.sample;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
	
	public static AIGui gui;
	
    public static final void main(String[] args) {
        try {
            // load up the knowledge base
        	gui = new AIGui();
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


    public static class Question{
    	/** TODO
    	 * 
    	 * use STATES for questions
    	 * define actions after question is answered
    	 * make an question-example to get rid of message example
    	 * 
		 */
    	 
    	
    	private static final Logger LOGGER = Logger.getLogger( Question.class.getName() );

    	
    	private String content;
    	private String[] answers;
    	private String chosen;
		
		
    	
    	public Question(String [] args) {
    		// todo 
    		// set status
    		
    		try {
	    		this.setContent(args[0]);
	    		this.setAnswers(Arrays.copyOfRange(args, 1, args.length));
	    		
	    		this.setChosen("");
	    		
	    		
    		}
    		catch(ArrayIndexOutOfBoundsException exception) {
    			LOGGER.log(Level.FINE, "Not enough arguments in Question()", exception);
    		}
    	}
    	
    	public void Ask() {
    		// todo
    		// request answer from input, print the pick and change state
    		int pickIndex = gui.showQuestion(this);
    		this.setChosen(this.getAnswers()[pickIndex]);
    		
    		
    	}
    	public void setResult(String movieName) {
    		gui.addMovie(movieName);
    	}
    	public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String[] getAnswers() {
			return answers;
		}

		public void setAnswers(String[] answers) {
			this.answers = answers;
		}
		public String getChosen() {
			return chosen;
		}

		public void setChosen(String chosen) {
			this.chosen = chosen;
		}

    	
    }

}
