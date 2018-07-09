/**
 * @Author: Kartikay Shandil <hunter>
 * @Date:   2018-07-09T10:43:28+05:30
 * @Last modified by:   hunter
 * @Last modified time: 2018-07-09T23:28:19+05:30
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class NameGenerator extends Application {

	private static Scene scene;
	private static TextField name;
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


		final TextField name=new TextField();
		name.setVisible(false);
		name.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY,Insets.EMPTY)));

		startButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String n=nameGen(tg,tg2);
				name.setText(n);
				name.setFont(new Font(40));
				name.setAlignment(Pos.CENTER);
				name.autosize();
				name.setTranslateY(-100);
				name.setVisible(true);
				name.setEditable(false);
				startButton.setText("REGENERATE");
    	}
		});

		NameGenerator.name=name;

		sp.getChildren().addAll(title,origin,gender,indian,foreign,both,male,female,both2,startButton,NameGenerator.name);
		sp.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY,Insets.EMPTY)));
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
		// ind_fname , ind_mnames , ind_surname , eng_fname , eng_mnames , eng_surname ,
		int len[]={14210,13906,100,4275,1219,1000}; //fixed for now, needs better method

		Scanner sc;
		int index=0;
		int rand;
		String file="res/";
		String name="";
		boolean flag=false; // true for indian surname else foreign surname
		if(race==1){
			file+="ind_";
		}
		else if(race==2){
			file+="eng_";
			index=3;
			flag=true;
		}
		else if(race==3){
			rand=(int)(100*Math.random());
			if(rand>50){
				file+="eng_";
				flag=true;
				index=3;
			}
			else{
				file+="ind_";
			}
		}

		if(gender==1){
			file+="mnames.txt";
			index+=1;
		}
		else if(gender==2){
			file+="fnames.txt";
		}
		else if(gender==3){
			rand=(int)(100*Math.random());
			if(rand>50){
				file+="fnames.txt";
			}
			else{
				file+="mnames.txt";
				index+=1;
			}
		}

		//generating name below

		int num=0;
		try{
			sc=new Scanner(new File(file));
			num=(int)(len[index]*Math.random());
			for (int i=0;i<num;i++){
				name=sc.nextLine();
			}
			sc.close();
		}catch(FileNotFoundException e){
			return "File Not Found Check res folder for correct files";
		}
		catch(Exception e){
			System.out.println("Fatal Error Occoured Please Restart The Code After Checking Integrety Of Files");//Display fatal error and exit
			System.exit(0);
		}

		//generating surname

		if(flag){
			file="res/eng_surnames.txt";
			index=5;
		}
		else{
			file="res/ind_surnames.txt";
			index=2;
		}
		String surname="";

		try{
			sc=new Scanner(new File(file));

			num=(int)(len[index]*Math.random());
			for (int i=0;i<num;i++){
				surname=sc.nextLine();
			}
			sc.close();
		}catch(FileNotFoundException e){
			return "File Not Found Check res folder";
		}
		catch(Exception e){
			System.out.println("Fatal Error Occoured Please Restart The Code After Checking Integrety Of Files");	//Display a fatal error and exit;
			System.exit(0);
		}

		name=name+" "+surname;

		return name.toUpperCase();
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
