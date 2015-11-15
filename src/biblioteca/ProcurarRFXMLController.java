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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class ProcurarRFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //Tabela de Reservas
    @FXML
    private TableView<Reserva>tabelaR;
    @FXML
    private TableColumn idR;
    @FXML
    private TableColumn idL;
    @FXML
    private TableColumn Aluno;
    @FXML
    private TableColumn datSaida;
    @FXML
    private TableColumn datEntrega;
    private ObservableList<Reserva>Reservas;
    ////////////////////////////////////////
    @FXML
    private DatePicker dataRi;
    @FXML
    private DatePicker dataRf;
    @FXML
    private DatePicker dataEi;
    @FXML
    private DatePicker dataEf;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void pR(ActionEvent pr){
        try{
            contest conn = new contest();
            Statement stR = conn.conectar1().createStatement();
            Reservas = FXCollections.observableArrayList();
            ResultSet rsr = stR.executeQuery("SELECT * FROM `reservas` WHERE DataSaida between '"+dataRi.getValue()+"' and '"+dataRf.getValue()+"'and DataEntrega between '"+dataEi.getValue()+"' and '"+dataEf.getValue()+"'");
            while(rsr.next()){
                Reserva r = new Reserva(0,0,"",0,"","","");
                
               r.setIdItem(rsr.getInt("Item"));
                r.setIdReserva(rsr.getInt("Reserva"));
                r.setNoAluno(rsr.getString("Aluno"));
                r.setIdLivro(rsr.getInt("Livro"));
                r.setNoLivro(rsr.getString("NomeLivro"));
                r.setDaSaida(rsr.getString("DataSaida"));
                r.setDaEntrada(rsr.getString("DataEntrega"));
                
               /*System.out.println(rsa.getInt("Item"));   
                System.out.println(rsa.getInt("Reserva"));
                System.out.println(rsa.getString("Aluno"));
                System.out.println(rsa.getInt("Livro"));   
                System.out.println(rsa.getString("DataSaida")); 
                System.out.println(rsa.getString("DataEntrega"));*/
                Reservas.add(r);

            }
            idR.setCellValueFactory(new PropertyValueFactory("idReserva"));
            idL.setCellValueFactory( new PropertyValueFactory("noLivro"));
            Aluno.setCellValueFactory( new PropertyValueFactory("noAluno"));
            datSaida.setCellValueFactory( new PropertyValueFactory("daSaida"));
            datEntrega.setCellValueFactory( new PropertyValueFactory("daEntrada"));
            tabelaR.setItems(Reservas);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
