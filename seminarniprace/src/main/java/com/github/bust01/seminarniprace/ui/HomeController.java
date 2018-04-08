package com.github.bust01.seminarniprace.ui;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import com.github.bust01.seminarniprace.logika.IHra;
import com.github.bust01.seminarniprace.logika.Postava;
import com.github.bust01.seminarniprace.logika.Prisera;
import com.github.bust01.seminarniprace.logika.Prostor;
import com.github.bust01.seminarniprace.logika.Vec;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Bušek Tomáš
 *
 */
@SuppressWarnings("deprecation")
public class HomeController extends GridPane implements Observer {
	
	@FXML private TextField textVstup;
	@FXML private TextArea textVypis;
	@FXML private Button odesli;
	@FXML private ListView<Prostor> seznamMistnosti;
	@FXML private ListView<Vec> seznamVeci;
	@FXML private ListView<Postava> seznamPostav;
	@FXML private ListView<Prisera> seznamPriser;
	@FXML private MenuBar menuLista;
	@FXML private Menu menuSoubor;
	@FXML private Menu dalsiMenu;
	@FXML private MenuItem napovedaHry;
	@FXML private MenuItem novaHra;
	@FXML private MenuItem konecHry;
	@FXML private MenuItem oProgramu;
	@FXML private WebView napovedaHTML;
	@FXML private AnchorPane napovedaOkno;
	@FXML private ImageView mapaImageView;
	@FXML private ImageView img1;
	@FXML private ImageView img2;
	@FXML private ImageView img3;
	@FXML private ImageView img4;
	@FXML private ImageView img5;
	
	
	private IHra hra;
	
	private List<Vec> batohObsah;
	private ImageView imgView;
	
	ImageView[] imageArray = new ImageView[] { img1, img2 ,img3 ,img4 ,img5 };
	
	
	/**
	 * Metoda, která inicializuje hru.
	 * Načítá mapu, která označuje začínající prostor
	 */
	
	public void inicializuj(IHra hra)
	{
		this.hra = hra;
		textVypis.setText(hra.vratUvitani());
		seznamMistnosti.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		seznamVeci.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getSeznamVeci());
		seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getSeznamPostav());
		seznamPriser.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getSeznamPriser());
		
		Image image = new Image("/Harryho_mistnost.png");
		mapaImageView.setImage(image);
		hra.getHerniPlan().addObserver(this);
	}
	
	/**
	 * Metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho...
	 */
	
	
	public void odesliPrikaz() {
		
		String vypis = hra.zpracujPrikaz(textVstup.getText());
		textVypis.appendText("\n--------\n"+textVstup.getText()+"\n--------\n");
		textVypis.appendText(vypis);
		textVstup.setText("");
		
		if(hra.konecHry()) {
			textVypis.appendText("\n\n Konec hry \n");
			textVstup.setDisable(true);
			odesli.setDisable(true);
		}
		
		seznamVeci.getItems().clear();				
		seznamVeci.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getSeznamVeci());
		seznamPostav.getItems().clear();				
		seznamPostav.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getSeznamPostav());
		seznamPriser.getItems().clear();				
		seznamPriser.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getSeznamPriser());
		Image image = new Image("/" + hra.getHerniPlan().getAktualniProstor() + ".png");
		mapaImageView.setImage(image);
		
		obsahBatohu();
	}
	
	/**
	 * Metoda, která zobrazuje věci, které máme v batohu, pomocí obrázků.
	 */
	
	private void obsahBatohu() 
	{			
		batohObsah = hra.getHerniPlan().getBatoh().getObsahBatohu();
		
		if(batohObsah.size() != 0) 
		{				
			for ( int i = 0 ; i < batohObsah.size(); i++ ) 
			{
				if(i == 0)
				{
					imgView = img1;
				}
				else if(i == 1) 
				{
					imgView = img2;
				}
				else if(i == 2) 
				{
					imgView = img3;
				}
				else if(i == 3) 
				{
					imgView = img4;
				}
				else if(i == 4) 
				{
					imgView = img5;
				}		
					
				Image image = new Image ("/" + batohObsah.get(i).toString() + ".jpg");	
				imgView.setImage(image);
			}						
		}
		
		
		

		if (batohObsah.size() == 0)
		{
			img1.setImage(null);
		}
		else if (batohObsah.size() == 1)
		{				
			img2.setImage(null);
		}
		else if (batohObsah.size() == 2) 
		{
			img3.setImage(null);
		}
		else if (batohObsah.size() == 3) 
		{			
			img4.setImage(null);
		}
		else if (batohObsah.size() == 4) 
		{			
			img5.setImage(null);
		}
	}
	
	/**
	 * Metoda, která načítá HTML soubor s nápovědou.
	 * Nápověda se zobrazí v novém okně.
	 */
	
	public void zobrazNapovedu(ActionEvent event) 
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/napovedaHTML.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			
			stage.setTitle("Nápověda");
			stage.setScene(new Scene(root1)); 
			stage.show();
			WebView wv = (WebView) root1.lookup("#napovedaHTML");			
			WebEngine webEngine = wv.getEngine();			
			File napoveda = new File("resources/napoveda.html");
			webEngine.load(napoveda.toURI().toString());
		}
		catch (Exception e){}
	}
	
	/**
	 * Metoda, která ukončuje hru.
	 * Spouští se po stisknutí možnosti Ukončit v hernim menu.
	 */
	
	public void exitGame (ActionEvent event)
	{
		Platform.exit();
		System.exit(0);
	}
	
	/**
	 * Metoda, která spouští novou hru.
	 * Spouští se po stisknutí možnosti Nová hra v hernim menu.
	 */
	public void newGame (ActionEvent event)
	{
		try 
		{
				Runtime.getRuntime().exec("java -jar seminarniprace.jar");
				System.exit(0);
		} 
		catch (IOException e) {}
	}
	
	/**
	 * Metoda, která zobrazuje info o programu.
	 * Spouští se po stisknutí možnosti O programu v hernim menu.
	 */
	public void infoOProgramu (ActionEvent event) 
	{
		JOptionPane.showMessageDialog(null,
					"<html><body><h2>Harry Lustter</h2>" +
					"<p>Předmět: 4it115 - Softwarové inženýrství</p>" +
					"<p>Autor: Tomáš Bušek</p>" +
					"<p><i>Duben 2018</i></p>" +
					"</body></html>");
	}	

	/**
	 * Metoda, která updatuje hru.
	 */
	
	@Override
	public void update(Observable o, Object arg) 
	{
		seznamMistnosti.getItems().clear();
		seznamMistnosti.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());		
	}
}
