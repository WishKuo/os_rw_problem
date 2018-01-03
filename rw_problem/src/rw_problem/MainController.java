package rw_problem;



import java.io.File;

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

//import java.util.Random;

public class MainController {
	
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
	
	
	public void generateRandom(ActionEvent event) throws InterruptedException{  
		
		//READER_ANIMATION
		
		int readerNum=10;
		
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
				
				readerNum-=1;
			}
			
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
