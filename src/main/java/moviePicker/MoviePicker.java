package moviePicker;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class MoviePicker {
	
	public static AIGui gui;
	
    public static final void main(String[] args) {
        try {
            
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
    	
    	 
    	private static final Logger LOGGER = Logger.getLogger( Question.class.getName() );

    	
    	private String content; // pytanie
    	private String[] answers; // odpowiedzi
    	private String chosen; // odpowiedz wybrana przez uzytkownika

		
    	public Question(String [] args) {
    		this.setChosen("");
    		try {
	    		this.setContent(args[0]);
	    		this.setAnswers(Arrays.copyOfRange(args, 1, args.length));
	    		
    		}
    		catch(ArrayIndexOutOfBoundsException exception) {
    			LOGGER.log(Level.FINE, "Not enough arguments in Question()", exception);
    		}
    	}
    	
    	public void Ask() {
    		// request input from user
    		System.out.println("asking question: " + this.content);
    		int pickIndex = gui.showQuestion(this);
    		this.setChosen(this.getAnswers()[pickIndex]);
    		System.out.println("response: " + this.getAnswers()[pickIndex]);
    		
    	}
    	public void setResult(String movieName) {
    		System.out.println("result movie: " + movieName);
    		gui.showResult(movieName);		
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
