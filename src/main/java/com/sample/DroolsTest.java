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

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
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
    	public static final int UNAVAILABLE = 0;
    	public static final int AVAILABLE = 1;
    	public static final int ANSWERED = 2;
    	
    	private String content;
    	private String[] answers;
    	
		private int status;
    	
    	public Question(String [] args) {
    		// todo 
    		// set status
    		
    		try {
	    		this.setContent(args[0]);
	    		this.setAnswers(Arrays.copyOfRange(args, 1, args.length));
	    		this.setStatus(UNAVAILABLE);
    		}
    		catch(ArrayIndexOutOfBoundsException exception) {
    			LOGGER.log(Level.FINE, "Not enough arguments in Question()", exception);
    		}
    	}
    	
    	public void Ask() {
    		// todo
    		// request answer from input, print the pick and change state
    		System.out.println(this.getContent());
    		String [] answers = this.getAnswers();
    		int count = answers.length;
    		for (int i=0;i< count ;i++) {
    			System.out.println(i+1 + ") " + answers[i]);
    		}
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

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

    	
    }

}
