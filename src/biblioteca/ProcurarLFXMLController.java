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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class ProcurarLFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tiLivro;
    @FXML
    private TextField noAutor;
        // Table de Livros
    @FXML
    private TableView <Livro> tabela;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn titulo;
    @FXML
    private TableColumn autor;
    @FXML
    private TableColumn qtde;
    
    private ObservableList<Livro> Livros;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void pl(ActionEvent pl){
        
        try {
           // Tabela Livros
            contest conn = new contest();
            Livros = FXCollections.observableArrayList();
            assert tabela != null :"fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
            Statement st = conn.conectar1().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `Livro` where nomeLivro = '"+tiLivro.getText()+"' or nomeAutor = '"+noAutor.getText()+"';");
           while(rs.next()){
               Livro l = new Livro(0,"","",0,0);
                l.setIdlivro(rs.getInt("idlivro"));
                l.setTiLivro(rs.getString("nomeLivro"));
                l.setNoAutor(rs.getString("nomeAutor"));
                l.setQtdeLivro(rs.getInt("qtdelivro"));
                l.setOk(rs.getInt("disponivel"));

                System.out.println(rs.getString("idlivro"));   
                System.out.println(rs.getString("nomelivro"));
                System.out.println(rs.getString("nomeautor"));
                System.out.println(rs.getString("qtdelivro"));   
                Livros.add(l); 
            }

            id.setCellValueFactory( new PropertyValueFactory("idlivro"));
            titulo.setCellValueFactory( new PropertyValueFactory("tiLivro"));
            autor.setCellValueFactory( new PropertyValueFactory("noAutor"));
            qtde.setCellValueFactory( new PropertyValueFactory("qtdeLivro"));
            tabela.setItems(null);
            tabela.setItems(Livros);}
            catch(SQLException e){}
            /////////////////////////////////////////////////////////////////
    }
}
