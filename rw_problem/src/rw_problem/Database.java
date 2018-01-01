/* RW Problem(b):
 * reader preference
 * */
package rw_problem;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import javafx.scene.image.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;


public class Database {
	private int readers; // number of active readers
	public Database(){ // initialize database
		this.readers = 0;
    }
	
	ExponentialDistribution ed = new ExponentialDistribution(8); // mean = 8
	final int GUI_TRANSITION_TIME = 2000; // 2 sec
	int getGapTime() {
		int waitingTime = 0;
		// Let waitingTime in the range 3 <= time <= 5
		while(waitingTime < 3 || waitingTime > 5) {
			waitingTime = (int) ed.sample();
		}
		return waitingTime * 1000 + GUI_TRANSITION_TIME ;
	}

    /**
	   	Read from this database.
	 	@param number Number of the reader
    */
	public void read(int number){
		int waitingTime = getGapTime();

	  	synchronized(this){
	  		this.readers++;
	  		System.out.println("Reader " + number + " starts reading.");
	  	}
	 
    	final int DELAY = 5000;
    	try{
    		Thread.sleep( waitingTime );
    	}
    	catch (InterruptedException e) {}
	 
    	synchronized(this){
    		System.out.println("Reader " + number + " stops reading.");
    		this.readers--;
    		if (this.readers == 0){
	   			this.notifyAll();
	   		}
	   	}
	}
	 
	/**
	 	Writes to this database
	   	@param number Number of the writer
    */
	public synchronized void write(int number){
		int waitingTime = getGapTime();
	   	while (this.readers != 0){
    		try{
    			this.wait();
    		}
    		catch (InterruptedException e) {}
    	}
    	System.out.println("Writer " + number + " starts writing.");
	 
    	final int DELAY = 5000;
    	try{
    		Thread.sleep( waitingTime );
    	}
    	catch (InterruptedException e) {}
	 
    	System.out.println("Writer " + number + " stops writing.");
    	this.notifyAll();
    }
}
