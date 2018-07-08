/**
 * @Author: Kartikay Shandil <kartikay101>
 * @Date:   2018-07-08T17:03:33+05:30
 * @Last modified by:   kartikay101
 * @Last modified time: 2018-07-08T17:52:33+05:30
 */

 import javafx.application.Application;
 import javafx.geometry.Pos;
 import javafx.scene.Scene;
 import javafx.scene.control.RadioButton;
 import javafx.scene.layout.StackPane;
 import javafx.scene.text.Font;
 import javafx.scene.text.Text;
 import javafx.scene.text.TextAlignment;
 import javafx.stage.Stage;


 public class NameGenerator extends Application {

 	private static Scene scene;


 	private static void sceneGenerator(){
 		StackPane sp=new StackPane();


 		//Name text

 		Text origin =new Text("Name Origin:");
 		origin.setFont(new Font(25));
 		origin.setTextAlignment(TextAlignment.CENTER);
 		origin.setTranslateY(100);
 		origin.setTranslateX(20);

 		Text gender =new Text("Sex:");
 		gender.setFont(new Font(25));
 		gender.setTextAlignment(TextAlignment.CENTER);
 		gender.setTranslateY(200);
 		gender.setTranslateX(20);




 		// radio buttons to select origin

 		RadioButton indian=new RadioButton();
 		indian.setText("Indian");
 		indian.setFont(new Font(18));
 		indian.setTextAlignment(TextAlignment.LEFT);
 		indian.setTranslateX(40);
 		indian.setTranslateY(150);

 		RadioButton foreign=new RadioButton();
 		foreign.setFont(new Font(18));
 		foreign.setText("Foreign");
 		foreign.setTextAlignment(TextAlignment.LEFT);
 		foreign.setTranslateX(160);
 		foreign.setTranslateY(150);


 		// radio button to select sex

 		RadioButton male=new RadioButton();
 		male.setText("Male");
 		male.setFont(new Font(18));
 		male.setTextAlignment(TextAlignment.LEFT);
 		male.setTranslateX(40);
 		male.setTranslateY(250);

 		RadioButton female=new RadioButton();
 		female.setText("Female");
 		female.setFont(new Font(18));
 		female.setTextAlignment(TextAlignment.LEFT);
 		female.setTranslateX(160);
 		female.setTranslateY(250);



 		sp.getChildren().addAll(origin,gender,indian,foreign,male,female);


 		StackPane.setAlignment(origin, Pos.TOP_LEFT);
 		StackPane.setAlignment(gender, Pos.TOP_LEFT);
 		StackPane.setAlignment(indian, Pos.TOP_LEFT);
 		StackPane.setAlignment(foreign, Pos.TOP_LEFT);
 		StackPane.setAlignment(male, Pos.TOP_LEFT);
 		StackPane.setAlignment(female, Pos.TOP_LEFT);

 		scene=new Scene(sp,600,600);

 	}


 	@Override
 	public void start(Stage mainStage) throws Exception {
 		mainStage.setTitle("Name Generator");
 		sceneGenerator();
 		mainStage.setScene(scene);
 		mainStage.show();
 	}

 	public static void main(String args[]){
 		launch(args);

 	}
 }
