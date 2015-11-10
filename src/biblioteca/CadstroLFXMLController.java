/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class CadstroLFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button mL;
    @FXML
    private Button lL;
    @FXML
    private TextField nomeLivro;
    @FXML
    private TextField nomeAutor;
    @FXML
    private TextField qtdeL;
    
    private int val;
    private String qtde;
    @FXML
    public void more(ActionEvent more ) {
       qtde = qtdeL.getText();
       val = Integer.parseInt(qtde);
       val++;
       qtdeL.setText(null);
       qtdeL.setText(String.valueOf(val));
       System.out.println(val +"");
    }
    
    @FXML
    public void less(ActionEvent less){
       qtde = qtdeL.getText();
       val = Integer.parseInt(qtde);
       val--;
       if(val<0){
           val = 0;
       }
       qtdeL.setText(null);
       qtdeL.setText(String.valueOf(val));
       System.out.println(val +"");
        
    }
     @FXML
    public void cadL(ActionEvent cad){
        try{
            Livro l = new Livro("","",0);
            String tL = nomeLivro.getText();
            String nA = nomeAutor.getText();
            l.setTiLivro(tL);
            l.setNoAutor(nA);
            l.setQtdeLivro(Integer.parseInt(qtdeL.getText()));
            l.imprimeL(l);
        }catch(Exception e){}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
