/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class CadastroRController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField nAluno;
    @FXML
    private TextField mAluno;
    @FXML
    private TextField tLivro;
    @FXML
    private TextField aLivro;
    @FXML
    private DatePicker datSaida;
    @FXML
    private DatePicker datEntrega;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        

        
        
    }

    @FXML
    public int res() throws IOException{
             Integer idr = 0, idI = 0, idA = 0;

             try{
             contest conn = new contest();
             Statement insert = conn.conectar1().createStatement();
             Statement select = conn.conectar1().createStatement();
             Statement seItens = conn.conectar1().createStatement();
             Statement inItens = conn.conectar1().createStatement();
             Statement idres = conn.conectar1().createStatement();
             ResultSet rs = select.executeQuery("Select idAluno From Aluno Where matriculaAluno = '"+mAluno.getText()+"';");
             while(rs.next()){
                 idA = rs.getInt("idAluno");
             }

            ResultSet seI = seItens.executeQuery("Select idlivro From livro Where livro.nomelivro = '"+tLivro.getText()+"' and Livro.nomeautor = '"+aLivro.getText()+"'; ");
            while(seI.next()){
                 idI = seI.getInt("idLivro");
             }
           String in = "Insert into reserva Values (null, '"+idA.toString()+"','"+datSaida.getValue()+"', '"+datEntrega.getValue()+"');";
           insert.executeUpdate(in);
           ResultSet idR = idres.executeQuery("Select idreserva From reserva Where Reserva.idaluno = '"+idA.toString()+"' and Reserva.dataretirada = '"+datSaida.getValue()+"';");
            while(idR.next()){
                 idr = idR.getInt("idreserva");
             }
           String inI = "Insert into itens Values (null,'"+idI.toString()+"','"+idr.toString()+"');";

           mAluno.setText(null);
           tLivro.setText(null);
           aLivro.setText(null);
           datSaida.setValue(null);
           datEntrega.setValue(null);
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OkRFXML.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));  
           stage.initStyle(StageStyle.UNDECORATED);
           stage.show();
           return(inItens.executeUpdate(inI));
           }catch(SQLException e){
               System.out.println("Problema com o SQL"+ e);
           }
        return 0;
    }
    
    @FXML
    public void nal(){
        String na = null;
        try{
             contest conn = new contest();
             Statement select = conn.conectar1().createStatement();
             ResultSet rs = select.executeQuery("Select nomeAluno From Aluno Where matriculaAluno = '"+mAluno.getText()+"';");
             while(rs.next()){
                 na = rs.getString("nomeAluno");
             }
                 
             }catch(SQLException e){}
             nAluno.setText(na); 
        
    }

    }

