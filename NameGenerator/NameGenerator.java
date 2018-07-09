/**
 * @Author: Kartikay Shandil <hunter>
 * @Date:   2018-07-08T21:10:04+05:30
 * @Last modified by:   hunter
 * @Last modified time: 2018-07-09T10:43:28+05:30
 */



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class NameGenerator extends Application {

	private static Scene scene;
	private static Text name;
	private static void sceneGenerator(){

		StackPane sp=new StackPane();

		Text title=new Text("NAME GENERATOR");
		title.setFont(new Font(40));
		title.setFill(Color.RED);
		title.setTextAlignment(TextAlignment.CENTER);
		title.setTranslateY(30);

		//Name text

		Text origin =new Text("Name Origin:");
		origin.setFont(new Font(25));
		origin.setTextAlignment(TextAlignment.CENTER);
		origin.setFill(Color.RED);
		origin.setTranslateY(100);
		origin.setTranslateX(20);

		Text gender =new Text("Sex:");
		gender.setFont(new Font(25));
		gender.setFill(Color.RED);
		gender.setTextAlignment(TextAlignment.CENTER);
		gender.setTranslateY(200);
		gender.setTranslateX(20);






		Button startButton=new Button("START");
		startButton.setFont(new Font(20));
		startButton.setScaleX(1.2);
		startButton.setScaleY(1.2);
		startButton.setTranslateY(40);
		final Text name=new Text();


		startButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				name.setText(nameGen());
				name.setFont(new Font(25));
				name.setTextAlignment(TextAlignment.CENTER);
				name.setFill(Color.RED);
				name.setTranslateY(-50);
				System.out.println("Clicked");
    	}
		});

		NameGenerator.name=name;


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



		sp.getChildren().addAll(title,origin,gender,indian,foreign,male,female,startButton,NameGenerator.name);


	    // Alignment Changes

		StackPane.setAlignment(title, Pos.TOP_CENTER);
		StackPane.setAlignment(origin, Pos.TOP_LEFT);
		StackPane.setAlignment(gender, Pos.TOP_LEFT);
		StackPane.setAlignment(indian, Pos.TOP_LEFT);
		StackPane.setAlignment(foreign, Pos.TOP_LEFT);
		StackPane.setAlignment(male, Pos.TOP_LEFT);
		StackPane.setAlignment(female, Pos.TOP_LEFT);
		StackPane.setAlignment(startButton, Pos.CENTER);
		StackPane.setAlignment(NameGenerator.name,Pos.BOTTOM_CENTER);
		scene=new Scene(sp,600,600);

	}

	private static String nameGen(){
		String name="KARTIKAY";

		return name;
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
