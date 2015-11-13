/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import util.MaskTextField;

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
    private MaskTextField datSaida;
    @FXML
    private MaskTextField datEntrega;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        datSaida.setMask("NNNN-NN-NN");
        datSaida.setPromptText("Ex: 25/12/15");
        datEntrega.setMask("NNNN-NN-NN");
        datEntrega.setPromptText("EX: 26/12/15");
        
        
    }
    @FXML
    public void masktest(){
        System.out.println(datSaida.getText());
    }
    @FXML
    public int res(){
             Integer idr = 0, idI = 0, idA = 0;
             try{
             contest conn = new contest();
             Statement insert = conn.conectar1().createStatement();
             Statement select = conn.conectar1().createStatement();
             Statement seItens = conn.conectar1().createStatement();
             Statement inItens = conn.conectar1().createStatement();
             Statement idres = conn.conectar1().createStatement();
             ResultSet rs = select.executeQuery("Select idAluno From Aluno Where matriculaAluno = '"+mAluno.getText()+"' and nomealuno = '"+nAluno.getText()+"';");
             while(rs.next()){
                 idA = rs.getInt("idAluno");
             }
            ResultSet seI = seItens.executeQuery("Select idlivro From livro Where livro.nomelivro = '"+tLivro.getText()+"' and Livro.nomeautor = '"+aLivro.getText()+"'; ");
            while(seI.next()){
                 idI = seI.getInt("idLivro");
             }
           String in = "Insert into reserva Values (null, '"+idA.toString()+"','"+datSaida.getText()+"', '"+datEntrega.getText()+"');";
           insert.executeUpdate(in);
           ResultSet idR = idres.executeQuery("Select idreserva From reserva Where Reserva.idaluno = '"+idA.toString()+"' and Reserva.dataretirada = '"+datSaida.getText()+"';");
            while(idR.next()){
                 idr = idR.getInt("idreserva");
             }
           String inI = "Insert into itens Values (null,'"+idI.toString()+"','"+idr.toString()+"');";
           nAluno.setText(null);
           mAluno.setText(null);
           tLivro.setText(null);
           aLivro.setText(null);
           datSaida.setText(null);
           datEntrega.setText(null);
           return(inItens.executeUpdate(inI));
           }catch(SQLException e){
               System.out.println("Problema com o SQL"+ e);
           }
        return 0;
    }

    }

