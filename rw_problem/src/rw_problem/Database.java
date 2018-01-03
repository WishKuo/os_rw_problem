/* RW Problem(b):
 * reader preference
 * */
package rw_problem;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


public class Database {
	private int readers; // number of active readers
	public Database(){ // initialize database
		this.readers = 0;
    }
	ExponentialDistribution ed = new ExponentialDistribution(8); // mean = 8
	
	@FXML
	private Label ShowNumber;
	@FXML
	private Label readerDia1;
	@FXML
	private Label readerDia2;
	@FXML
	private Label writerDia;
	@FXML
	private Label readerImg;
	@FXML
	private Label writerImg;
	
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
	  		move(this.readers);
	  	}
	 
    	final int DELAY = 5000;
    	try{
    		Thread.sleep( waitingTime );
    	}
    	catch (InterruptedException e) {}
	 
    	synchronized(this){
    		System.out.println("Reader " + number + " stops reading.");
    		move(this.readers);
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
    	move(this.readers);
	 
    	final int DELAY = 5000;
    	try{
    		Thread.sleep( waitingTime );
    	}
    	catch (InterruptedException e) {}
	 
    	System.out.println("Writer " + number + " stops writing.");
    	move(this.readers);
    	this.notifyAll();
    }
	
	public void move(int reader) {
		int readerNum=reader;
		
		if(readerNum!=0){
			
				Timeline timeline = new Timeline();
				timeline.setDelay(Duration.seconds(1));
				timeline.play();

				Path path = new Path();
				path.getElements().add(new MoveTo(-120.0f, -120.0f));
				path.getElements().add(new LineTo(630.0f, 150.0f));
			
				PathTransition transition = new PathTransition();
				transition.setNode(readerImg);
				transition.setDuration(Duration.seconds(3));
				transition.setPath(path);
				transition.setCycleCount(10);
				transition.play();
			
				readerDia1.setText("There are ");
				ShowNumber.setText(Integer.toString(readerNum));
				readerDia2.setText("of us are still reading now!");
				writerDia.setText("Ok, I'll wait.");
				//System.out.println(readerNum);
				
		}
		else{
			readerDia1.setText("There are ");
			ShowNumber.setText(Integer.toString(readerNum));
			readerDia2.setText("of us are still reading now!");
			ShowNumber.setText(Integer.toString(readerNum));
			writerDia.setText("Oh yeah~ Now it's my turn!");

			
			Circle circlePath = new Circle(10);
			PathTransition transition2 = new PathTransition();
			transition2.setNode(writerImg);
			transition2.setDuration(Duration.seconds(3));
			transition2.setPath(circlePath);
			transition2.setCycleCount(2);
			transition2.play();
		}
	
	}
}
