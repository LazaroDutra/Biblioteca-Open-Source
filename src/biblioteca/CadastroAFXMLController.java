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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class CadastroAFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField nomeAluno;
    @FXML
    private TextField cpfAluno;
    @FXML
    private TextField telefoneAluno;
    @FXML
    private TextField matriculaAluno;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void cadA (ActionEvent cadA){
       try{
            Aluno a = new Aluno("","", "", 0);
            String nA = nomeAluno.getText();
            String cA = cpfAluno.getText();
            String tA = telefoneAluno.getText();
            a.setNoAluno(nA);
            a.setCpf(cA);
            a.setTelefone(tA);
            a.setMatricula(Integer.parseInt(matriculaAluno.getText()));
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Cadastrar Aluno");
            dialogoInfo.setHeaderText("Cadastro concluido");
            dialogoInfo.setContentText("Aluno cadastrado com sucesso !!!");
            dialogoInfo.showAndWait();
            nomeAluno.setText(null);
            cpfAluno.setText(null);
            telefoneAluno.setText(null);
            matriculaAluno.setText(null);
            ena(a);
        }catch(NumberFormatException | SQLException e){}
    }
    
    private static int ena(Aluno a) throws SQLException{
            
        try{
            contest conn = new contest();
            Statement insert = conn.conectar1().createStatement();
            String in = "INSERT INTO aluno VALUES (NULL,'"+a.getMatricula()+"','"+a.getNoAluno()+"','"+a.getCpf()+"','"+a.getTelefone()+"');";
            
            return(insert.executeUpdate(in));
        }catch(SQLException e){
            System.out.println("Problema com o SQL");
        }
        return 0;    
    }
    
    
}
