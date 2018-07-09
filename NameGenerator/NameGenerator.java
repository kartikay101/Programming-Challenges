/**
 * @Author: Kartikay Shandil <hunter>
 * @Date:   2018-07-09T10:43:28+05:30
 * @Last modified by:   hunter
 * @Last modified time: 2018-07-09T18:21:28+05:30
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.Scanner;
import java.io.File;


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

		final ToggleGroup tg=new ToggleGroup();
		final ToggleGroup tg2=new ToggleGroup();

		// radio buttons to select origin

		RadioButton indian=new RadioButton();
		indian.setText("Indian");
		indian.setUserData(1);
		indian.setFont(new Font(18));
		indian.setTextAlignment(TextAlignment.LEFT);
		indian.setTranslateX(40);
		indian.setTranslateY(150);
		indian.setToggleGroup(tg);
		indian.setSelected(true);

		RadioButton foreign=new RadioButton();
		foreign.setFont(new Font(18));
		foreign.setText("Foreign");
		foreign.setUserData(2);
		foreign.setTextAlignment(TextAlignment.LEFT);
		foreign.setTranslateX(160);
		foreign.setTranslateY(150);
		foreign.setToggleGroup(tg);

		RadioButton both=new RadioButton();
		both.setFont(new Font(18));
		both.setText("Both");
		both.setUserData(3);
		both.setTextAlignment(TextAlignment.LEFT);
		both.setTranslateX(280);
		both.setTranslateY(150);
		both.setToggleGroup(tg);

		// radio button to select sex

		RadioButton male=new RadioButton();
		male.setText("Male");
		male.setUserData(1);
		male.setFont(new Font(18));
		male.setTextAlignment(TextAlignment.LEFT);
		male.setTranslateX(40);
		male.setTranslateY(250);
		male.setToggleGroup(tg2);
		male.setSelected(true);


		RadioButton female=new RadioButton();
		female.setText("Female");
		female.setUserData(2);
		female.setFont(new Font(18));
		female.setTextAlignment(TextAlignment.LEFT);
		female.setTranslateX(160);
		female.setTranslateY(250);
		female.setToggleGroup(tg2);

		RadioButton both2=new RadioButton();
		both2.setFont(new Font(18));
		both2.setText("Both");
		both2.setUserData(3);
		both2.setTextAlignment(TextAlignment.LEFT);
		both2.setTranslateX(280);
		both2.setTranslateY(250);
		both2.setToggleGroup(tg2);

		final Button startButton=new Button("START");
		startButton.setFont(new Font(20));
		startButton.setScaleX(1.2);
		startButton.setScaleY(1.2);
		startButton.setTranslateY(40);


		final Text name=new Text();

		startButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				name.setText(nameGen(tg,tg2));
				name.setFont(new Font(40));
				name.setTextAlignment(TextAlignment.CENTER);
				name.setFill(Color.RED);
				name.setTranslateY(-50);
				startButton.setText("REGENERATE");
    	}
		});

		NameGenerator.name=name;

		sp.getChildren().addAll(title,origin,gender,indian,foreign,both,male,female,both2,startButton,NameGenerator.name);

		// Alignment Changes

		StackPane.setAlignment(title, Pos.TOP_CENTER);
		StackPane.setAlignment(origin, Pos.TOP_LEFT);
		StackPane.setAlignment(gender, Pos.TOP_LEFT);
		StackPane.setAlignment(indian, Pos.TOP_LEFT);
		StackPane.setAlignment(foreign, Pos.TOP_LEFT);
		StackPane.setAlignment(both, Pos.TOP_LEFT);
		StackPane.setAlignment(male, Pos.TOP_LEFT);
		StackPane.setAlignment(female, Pos.TOP_LEFT);
		StackPane.setAlignment(both2, Pos.TOP_LEFT);
		StackPane.setAlignment(startButton, Pos.CENTER);
		StackPane.setAlignment(NameGenerator.name,Pos.BOTTOM_CENTER);
		scene=new Scene(sp,600,600);

	}

	private static String nameGen(ToggleGroup tg,ToggleGroup tg2){

		Toggle t1=tg.getSelectedToggle();
		Toggle t2=tg2.getSelectedToggle();

		int race=(Integer) t1.getUserData();
		int gender=(Integer) t2.getUserData();
		String name="";

		Scanner sc;
		try{
			sc=new Scanner(new File("res/ind_fnames.txt"));
			for(int i=0;i<(int)1000*Math.random();i++){
				name=sc.nextLine();
			}
		}catch(Exception e){
			System.out.println("filenotfound");
		}
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
