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


public class Reader extends Thread{
	private static int readers = 0; // number of readers
	 
	private int number;
  	private Database database;
	 
  	/**
    	Creates a Reader for the specified database.
    	@param database database from which to be read.
  	*/
  	public Reader(Database database){
  		this.database = database;
  		this.number = Reader.readers++;
  	}
 
  	/* Read */
  	public void run(){
  		while (true){
  			final int DELAY = 5000;
  			try{
  				Thread.sleep((int) (Math.random() * DELAY));
  			}
  			catch (InterruptedException e) {}
  			this.database.read(this.number);
  		}
  	}
}