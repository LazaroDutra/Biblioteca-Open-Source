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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import util.MaskTextField;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */
public class AlterarLFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private MaskTextField textPesquisa;
    @FXML
    private TextField tiLivro;
    @FXML
    private TextField auLivro;
    @FXML
    private MaskTextField qtdeLivro;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textPesquisa.setMask("N!");
        textPesquisa.setPromptText("Insira o ID do Livro");
        qtdeLivro.setMask("N!");
        qtdeLivro.setPromptText("Quantidade de exemplares disponiveis");
    }
     @FXML
    private void pesq(){
        String mp = textPesquisa.getText();
        
        try{
            contest conn = new contest();
            Statement pesq = conn.conectar1().createStatement();
            ResultSet pes = pesq.executeQuery("select * from livro where livro.idLivro = '"+mp+"'");
            while(pes.next()){
                tiLivro.setText(pes.getString("nomeLivro"));
                auLivro.setText(pes.getString("nomeAutor"));
                qtdeLivro.setText(pes.getString("qtdeLivro"));
            
            }
        }catch(SQLException e){}
    }
    
    @FXML
    private void sAl(){
        try{
        contest conn = new contest();
        Statement sal = conn.conectar1().createStatement();
        String in = "UPDATE `Livro` SET `nomeLivro`='"+tiLivro.getText()+"',`nomeAutor`='"+auLivro.getText()+"',`qtdeLivro`='"+qtdeLivro.getText()+"' WHERE livro.idLivro = '"+textPesquisa.getText()+"';";
        sal.executeUpdate(in);
        }catch(SQLException e){
            System.out.println(e);
        }
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Alterar Livro");
            dialogoInfo.setHeaderText("Alteração Concluida");
            dialogoInfo.setContentText("Livro alterado com sucesso !!!");
            dialogoInfo.showAndWait();
        
    }
    @FXML
    private void exL(){
        Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
            dialogoAviso.setTitle("Excluir Livro");
            dialogoAviso.setHeaderText("Atenção livro sendo excluido");
            dialogoAviso.setContentText("Essa ação não podera ser revertida!");
            ButtonType ok = new ButtonType("Ok");
            ButtonType cancelar = new ButtonType("Cancelar");
            dialogoAviso.getButtonTypes().setAll(cancelar,ok);
            dialogoAviso.showAndWait().ifPresent(b -> {
            if (b == ok){
        try{
        contest conn = new contest();
        Statement exi = conn.conectar1().createStatement();
        Statement ex = conn.conectar1().createStatement();
        String exil = "Delete from itens where id_livro = '"+textPesquisa.getText()+"';";
        String exl = "Delete from livro where idlivro = '"+textPesquisa.getText()+"';";
        exi.executeUpdate(exil);
        ex.executeUpdate(exl);
        textPesquisa.setText(null);
        tiLivro.setText(null);
        auLivro.setText(null);
        qtdeLivro.setText(null);
        }catch(SQLException e){
            System.out.println(e);
        }}});
    }
    
}
