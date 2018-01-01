package rw_problem;

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


public class Writer extends Thread{
	private static int writers = 0; // number of writers
	 
	private int number;
	private Database database;
	 
    /**
	    Creates a Writer for the specified database. 
	    @param database database to which to write.
	*/
	public Writer(Database database){
		this.database = database;
		this.number = Writer.writers++;
	}
	 
	/* Write */
	public void run(){
		while (true){
	        final int DELAY = 5000;
	        try{
	        	Thread.sleep((int) (Math.random() * DELAY));
	        }
	        catch (InterruptedException e) {}
	        this.database.write(this.number);
	    }
	}
}
