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
            a.setnCpF(cA);
            a.setnTel(tA);
            a.setnMatricula(Integer.parseInt(matriculaAluno.getText()));
            a.imprimeL(a);
        }catch(Exception e){}
    }
    
    
}
