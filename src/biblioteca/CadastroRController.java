/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.net.URL;
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
    private MaskTextField datSaida;
    @FXML
    private MaskTextField datEntrega;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        datSaida.setMask("NNNN-NN-NN");
        datSaida.setPromptText("Ex: 2015-12-25");
        datEntrega.setMask("NNNN-NN-NN");
        datEntrega.setPromptText("EX: 2015-12-26");
        
        
    }
    @FXML
    public void masktest(){
        System.out.println(datSaida.getText());
    }
    
}
