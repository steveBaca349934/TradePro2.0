package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class Scene1Controller implements Initializable{


	@FXML
	private AnchorPane introScene;

	@FXML
	private ImageView imageBackground;

	@FXML
	private Button yourStockInfo;

	@FXML
	private Button yourPortfolio;

	@FXML
	private TextField sandp500Shower;

	@FXML
	private TextField djiaShower;

	/**
	 * Initalizes this scene
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Button1Listener();
		Button2Listener();
		
		try {
			setDJIAandSandPText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Adding functionality to the buttons on the front page, launches RAT
	 */
	public void Button1Listener() {


		yourStockInfo.setOnAction((ActionEvent e)->{

			try {

				Parent part = FXMLLoader.load(getClass().getResource("RiskAssessmentTest.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(part);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			}
			catch (Exception e1) {
				// TODO: handle exception
			}

		});



	}
	
	/**
	 * Launches portfolio builder
	 */
	public void Button2Listener() {

		yourPortfolio.setOnAction((ActionEvent e)->{

			try {

				Parent part = FXMLLoader.load(getClass().getResource("/application/Portfolio.fxml"));
				Stage stage = new Stage();
				Scene scene = new Scene(part);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			}
			catch (Exception e1) {
				// TODO: handle exception
			}

		});



	}
	
	/**
	 * sets the SandP500 and DJIA values 
	 * @throws IOException
	 */
	public void setDJIAandSandPText() throws IOException {
		ScrapeForSandPandDJIA sp = new ScrapeForSandPandDJIA();

		djiaShower.setEditable(false);
		sandp500Shower.setEditable(false);
		djiaShower.setText(sp.DJIAReader());
		sandp500Shower.setText(sp.SandPReader());
		sandp500Shower.centerShapeProperty();

	}


}
