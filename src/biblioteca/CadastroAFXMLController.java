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
import util.MaskTextField;

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
    private MaskTextField cpfAluno;
    @FXML
    private MaskTextField telefoneAluno;
    @FXML
    private MaskTextField matriculaAluno;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cpfAluno.setMask("NNN.NNN.NNN-NN");
        cpfAluno.setPromptText("000-000-000-00");
        telefoneAluno.setMask("NN-NNNN-NNNN");
        telefoneAluno.setPromptText("00-0000-0000");
        matriculaAluno.setMask("N!");
        matriculaAluno.setPromptText("Insira a matrícula do aluno");
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
            nomeAluno.setText("");
            cpfAluno.setText("");
            telefoneAluno.setText("");
            matriculaAluno.setText("");
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
