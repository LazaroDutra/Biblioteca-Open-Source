/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;


import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.MaskTextField;

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
    private MaskTextField qtdeL;
    
    private int val;
    private String qtde;
 /*@FXML
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
        
    }*/
     @FXML
    public void cadL(ActionEvent cad){
        try{
            Livro l = new Livro("","",0);
            String tL = nomeLivro.getText();
            String nA = nomeAutor.getText();
            int ok =Integer.parseInt(qtdeL.getText());
            l.setTiLivro(tL);
            l.setNoAutor(nA);
            l.setQtdeLivro(ok);
            if( ok!= 0){ok = 1;}
            l.setOk(ok);
            l.imprimeL(l);
            
            
            enl(l);
        }catch(Exception e){}
    }
       private static int enl(Livro l) throws SQLException{
           
           try{
             contest conn = new contest();
             Statement insert = conn.conectar1().createStatement();
             String in = "INSERT INTO livro VALUES (NULL,'"+l.getTiLivro()+"','"+l.getNoAutor()+"','"+l.getQtdeLivro()+"',"+l.getOk()+");";
             return(insert.executeUpdate(in));
           }catch(SQLException e){
               System.out.println("Problema com o SQL");
           }
        return 0;
       }
            
            
           
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        qtdeL.setMask("N!");
        qtdeL.setPromptText("Quantidade de Livros");
    }    
    
}
