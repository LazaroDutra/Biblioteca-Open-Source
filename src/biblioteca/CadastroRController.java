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
import javafx.scene.control.Alert;
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
             Integer idr = 0, idI = 0, idA = 0, diSv = 0, qtde = 0;

             try{
             contest conn = new contest();
             Statement insert = conn.conectar1().createStatement();
             Statement select = conn.conectar1().createStatement();
             Statement seItens = conn.conectar1().createStatement();
             Statement inItens = conn.conectar1().createStatement();
             Statement idres = conn.conectar1().createStatement();
             Statement disV = conn.conectar1().createStatement();
             Statement disS = conn.conectar1().createStatement();
             
             ResultSet rs = select.executeQuery("Select idAluno From Aluno Where matriculaAluno = '"+mAluno.getText()+"';");
             while(rs.next()){
                 idA = rs.getInt("idAluno");
             }

             ResultSet seI = seItens.executeQuery("Select idlivro From livro Where livro.nomelivro = '"+tLivro.getText()+"' and Livro.nomeautor = '"+aLivro.getText()+"'; ");
             while(seI.next()){
                 idI = seI.getInt("idLivro");
             }
             ResultSet disv = disV.executeQuery("Select disponivel, qtdelivro from livro where idlivro = '"+idI.toString()+"';");
             while(disv.next()){
                 diSv = disv.getInt("disponivel");
                 qtde = disv.getInt("qtdelivro");
                 
             }
             if(diSv > 0){
            String in = "Insert into reserva Values (null, '"+idA.toString()+"','"+datSaida.getValue()+"', '"+datEntrega.getValue()+"');";
            insert.executeUpdate(in);
            ResultSet idR = idres.executeQuery("Select idreserva From reserva Where Reserva.idaluno = '"+idA.toString()+"' and Reserva.dataretirada = '"+datSaida.getValue()+"';");
            while(idR.next()){
                 idr = idR.getInt("idreserva");
             }
            qtde --;
            if(qtde == 0){
                diSv =0;
            }
            String disset = "UPDATE `Livro` SET disponivel = '"+diSv.toString()+"', qtdelivro = '"+qtde.toString()+"' where idlivro = '"+idI.toString()+"'";
            disS.executeUpdate(disset);
            String inI = "Insert into itens Values (null,'"+idI.toString()+"','"+idr.toString()+"');";
            
           
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Realizar Reserva");
            dialogoInfo.setHeaderText("Reserva realizada");
            dialogoInfo.setContentText("Livro reservado com sucesso !!!");
            dialogoInfo.showAndWait();
            nAluno.setText(null);
            mAluno.setText(null);
            tLivro.setText(null);
            aLivro.setText(null);
            datSaida.setValue(null);
            datEntrega.setValue(null);
            
            return(inItens.executeUpdate(inI));
             }else{
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("Realizar Reserva");
                dialogoInfo.setHeaderText("A Reserva não foi realizada");
                dialogoInfo.setContentText("Livro indisponivel no momento");
                dialogoInfo.showAndWait();
             }
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

