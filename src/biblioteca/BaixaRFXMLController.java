/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import util.MaskTextField;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */

public class BaixaRFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private MaskTextField idr;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idr.setMask("N!");
        idr.setPromptText("Insira o Id da Reserva");
    }
    @FXML
    private void ri (ActionEvent ri){
        Integer qtde = 0, di = 0,idl = 0;
        try{
         contest conn = new contest();
         Statement sel = conn.conectar1().createStatement();
         Statement selx = conn.conectar1().createStatement();
         Statement selxx = conn.conectar1().createStatement();
         Statement rin = conn.conectar1().createStatement();
         Statement rinx = conn.conectar1().createStatement();

         ResultSet sl = sel.executeQuery("Select id_livro from itens where id_reserva = '"+idr.getText()+"';");
         while(sl.next()){
            idl = sl.getInt("id_livro");
         }
         ResultSet slx = selx.executeQuery("Select qtdelivro, disponivel from livro where idlivro = '"+idl.toString()+"';");
         while(slx.next()){
            qtde = slx.getInt("qtdelivro");
            di = slx.getInt("disponivel");
         }
         String r = "Delete from itens where id_reserva = '"+idr.getText()+"'";
         rin.executeUpdate(r);
         String rr = "Delete from reserva where idreserva = '"+idr.getText()+"';";
         rinx.executeUpdate(rr);
         qtde ++;
         di = 1;
         String rl = "Update livro set qtdelivro ='"+qtde.toString()+"', disponivel = '"+di.toString()+"' where idlivro = '"+idl.toString()+"'";
         selxx.executeUpdate(rl);
         Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
         dialogoInfo.setTitle("Excluir Reserva");
         dialogoInfo.setHeaderText("Operação finalizada");
         dialogoInfo.setContentText("Reserva excluida com sucesso !!!");
         dialogoInfo.showAndWait();
         idr.setText(null);
        }catch(SQLException e){}
    }
    
}
