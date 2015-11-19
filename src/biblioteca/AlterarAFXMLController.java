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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import util.MaskTextField;

/**
 * FXML Controller class
 *
 * @author Lazaro
 */

public class AlterarAFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField mpAluno;
    @FXML
    private TextField mAluno;
    @FXML
    private TextField noAluno;
    @FXML
    private TextField nuCPF;
    @FXML
    private TextField teAluno;
    @FXML
    private TextField idA;
    @FXML
    private TextField idR;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    @FXML
    private void pesq(){
        String mp = mpAluno.getText();
        
        try{
            contest conn = new contest();
            Statement pesq = conn.conectar1().createStatement();
            ResultSet pes = pesq.executeQuery("select * from aluno where matriculaAluno = '"+mp+"'");
            while(pes.next()){
                idA.setText(pes.getString("idaluno"));
                mAluno.setText(pes.getString("matriculaaluno"));
                noAluno.setText(pes.getString("nomeAluno"));
                nuCPF.setText(pes.getString("nCPF"));
                teAluno.setText(pes.getString("telefone"));
            
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    @FXML
    private void sAl(){
        try{
        contest conn = new contest();
        Statement sal = conn.conectar1().createStatement();
        String in = "UPDATE `Aluno` SET `matriculaAluno`='"+mAluno.getText()+"',`nomeAluno`='"+noAluno.getText()+"',`nCPF`='"+nuCPF.getText()+"',`Telefone`='"+teAluno.getText()+"' WHERE matriculaaluno = '"+mpAluno.getText()+"';";
        sal.executeUpdate(in);
        }catch(SQLException e){
            System.out.println(e);
        }
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("Alterar Aluno");
            dialogoInfo.setHeaderText("Alteração Concluida");
            dialogoInfo.setContentText("Aluno alterado com sucesso !!!");
            dialogoInfo.showAndWait();
        mpAluno.setText("");
        mAluno.setText("");
        noAluno.setText("");
        nuCPF.setText("");
        teAluno.setText("");
        
    }
    @FXML
    private void exL(){
        Alert dialogoAviso = new Alert(Alert.AlertType.WARNING);
            dialogoAviso.setTitle("Aluno Livro");
            dialogoAviso.setHeaderText("Atenção aluno sendo excluido");
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
        Statement exiA = conn.conectar1().createStatement();
        Statement exrA = conn.conectar1().createStatement();
        ResultSet sr = exi.executeQuery( "select * from reserva where idaluno = '"+idA.getText()+"';");
        while(sr.next()){
            idR.setText(sr.getString("idreserva"));
        }
        String exA = "Delete from itens where id_reserva = '"+idR.getText()+"';";
        String exAr = "Delete from reserva where idaluno = '"+idA.getText()+"';";
        String exl = "Delete from aluno where idaluno = '"+idA.getText()+"';";
        exiA.executeUpdate(exA);
        exrA.executeUpdate(exAr);
        ex.executeUpdate(exl);
        mpAluno.setText("");
        mAluno.setText("");
        noAluno.setText("");
        nuCPF.setText("");
        teAluno.setText("");
        }catch(SQLException e){
            System.out.println(e);
        }}});
    }
   
    
}
