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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class OkAFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button ok;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void close (ActionEvent ev){
    Stage stage = (Stage) ok.getScene().getWindow();
    stage.close();
    }
    
}
