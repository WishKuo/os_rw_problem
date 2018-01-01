package rw_problem;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

import rw_problem.Reader;
import rw_problem.Writer;
import rw_problem.Database;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;



public class MainApp extends Application {

	private Stage primaryStage;
    public BorderPane rootLayout;
        
    public startController _start = new startController();  
   
    @Override
    public void start(Stage primaryStage) throws Exception {
       
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle("reader_and_writer");
        
        this.primaryStage.setWidth(1200);
        this.primaryStage.setHeight(700);
        
        
        initRootLayout();
    
        startOverview();
           		
        
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the start overview inside the root layout.
     */
    public void startOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Startview.fxml"));          
            loader.setController(_start);
            
            AnchorPane personOverview = (AnchorPane) loader.load();
            
            personOverview.setStyle(
            		"-fx-background-image: url(" + "'@../../image/background.png'" +
            		"); " +
            	    "-fx-background-size: cover;"	
            	);
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * startController controls the button event.
     */
    public class startController implements Initializable{

	    	@FXML
	    	private Button startButton;
        
        @Override
        public void initialize(URL url,ResourceBundle rb) {
        	
        }
        
        @FXML protected void handleSubmitButtonAction(ActionEvent event) {
            try {
                // Load person overview.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/Mainview.fxml"));          
                //loader.setController(table);
                
                AnchorPane personOverview = (AnchorPane) loader.load();
                
                // Set person overview into the center of root layout.
                rootLayout.setCenter(personOverview);
                
                Media media = new Media(getClass().getResource("/music/BGM.mp3").toURI().toString());      
                MediaPlayer player = new MediaPlayer(media);  
                player.setOnEndOfMedia(new Runnable() {
                    public void run() {
                      player.seek(Duration.ZERO);
                    }
                });
                player.play();
                
	        		//System.out.print("Table now has: ");
	
                	final int READERS = 10;
                	final int WRITERS = 10;
                	Database database = new Database();
                	for (int i = 0; i < READERS; i++){
                		new Reader(database).start();
                	}
                	for (int i = 0; i < WRITERS; i++){
                		new Writer(database).start();
                	}
                
                
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
    	
    }
    

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
