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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class ProcurarAFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField mpAluno;
    @FXML
    private TextField mAluno;
    @FXML
    private TextField noAluno;
    @FXML
    private TextField nuCPF;
    @FXML
    private TextField teAluno;
    @FXML
    private TextField idA;
    @FXML
    private ComboBox por;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        liMN = FXCollections.observableArrayList();
        liMN.add("Por Matricula");
        liMN.add("Por Nome");
        por.setItems(liMN);
    }    
        private ObservableList liMN;
        @FXML
        private void pesq(){
        String opc = por.getValue().toString();
        String mp = mpAluno.getText();

        
        if("Por Matricula".equals(opc)){
            try{
            contest conn = new contest();
            Statement pesq = conn.conectar1().createStatement();
            ResultSet pes = pesq.executeQuery("select * from aluno where matriculaAluno = '"+mp+"';");
            while(pes.next()){
             idA.setText(pes.getString("idaluno"));
             mAluno.setText(pes.getString("matriculaaluno"));
             noAluno.setText(pes.getString("nomeAluno"));
             nuCPF.setText(pes.getString("nCPF"));
             teAluno.setText(pes.getString("telefone"));
            
            }
        }catch(SQLException e){
            System.out.println(e);
        }}
        if( "Por Nome".equals(opc)){
            try{
            contest conn = new contest();
            Statement pesq = conn.conectar1().createStatement();
            ResultSet pes = pesq.executeQuery("select * from aluno where nomeAluno = '"+mp+"';");
            while(pes.next()){
             idA.setText(pes.getString("idaluno"));
             mAluno.setText(pes.getString("matriculaaluno"));
             noAluno.setText(pes.getString("nomeAluno"));
             nuCPF.setText(pes.getString("nCPF"));
             teAluno.setText(pes.getString("telefone"));
            
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        }
        
        
        
    }
}
