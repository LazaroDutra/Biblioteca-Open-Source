/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Lazaro
 */
public class BibliotecaFXMLController implements Initializable {
    
    @FXML
    public void nL(ActionEvent nl) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadstroLFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Novo Livro");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    @FXML
    public void nA(ActionEvent na) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadastroAFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Novo Aluno");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    @FXML
    public void nR(ActionEvent nr) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadastroR.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Novo Aluno");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
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
        Connection conn;
         conn =  conn = new contest().conectar1();
         
        }  
     @FXML
    public void adt(){
        Livros = FXCollections.observableArrayList();
       contest conn = new contest();
       assert tabela != null :"fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
      
        try {
            Statement st = conn.conectar1().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `Livro`;");
           while(rs.next()){
               
               Livro l = new Livro(0,"a","a",0,0);
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
            tabela.setItems(Livros);

            
        } catch (SQLException ex) {
            Logger.getLogger(BibliotecaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        }    
   }    
    
