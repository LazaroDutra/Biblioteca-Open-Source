/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import javafx.stage.StageStyle;

/**
 *
 * @author Lazaro
 */
public class BibliotecaFXMLController implements Initializable {
    //Menu Arquivo
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
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    //Menu Editar
        //Menu Livro
    @FXML
    public void alL(ActionEvent na) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlterarLFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Alterar Livro");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    @FXML
    public void prL(ActionEvent prL) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProcurarLFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Procurar Livro");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
        ////////////
        //Menu Reserva
    @FXML
    public void alR(ActionEvent alR) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BaixaRFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Alterar Livro");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    @FXML
    public void prR(ActionEvent prR) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProcurarRFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Procurar Livro");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
        /////////////
        //Menu Aluno
     public void alA(ActionEvent alR) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AlterarAFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Alterar Aluno");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    @FXML
    public void prA(ActionEvent prR) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProcurarAFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Procurar Aluno");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
     ///////////
        @FXML
    public void aju(ActionEvent aju) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SobreFXML.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Sobre");
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root1));  
                stage.show();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    
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
    /////////////////////////////////////
    
    //Tabela de Alunos
    @FXML
    private TableView <Aluno> tabelaA;
    @FXML
    private TableColumn <Aluno,Integer> idaluno;
    @FXML
    private TableColumn <Aluno,String> nAluno;
    @FXML
    private TableColumn <Aluno,String> cpf;
    @FXML
    private TableColumn <Aluno,Integer> mAluno;
    @FXML
    private TableColumn <Aluno,String> telefone;
    
    private ObservableList<Aluno> Alunos;
    ////////////////////////////////////
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Connection conn;
         conn =  conn = new contest().conectar1();
         
        } 
 
     @FXML
     public void adt(){
        Livros = FXCollections.observableArrayList();
        Alunos = FXCollections.observableArrayList();
        Reservas = FXCollections.observableArrayList();
       contest conn = new contest();
       assert tabelaA != null :"fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
       assert tabela != null :"fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
       assert tabelaR != null :"fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";

        try {
           // Tabela Livros
            Statement st = conn.conectar1().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `Livro`;");
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
            tabela.setItems(Livros);
            /////////////////////////////////////////////////////////////////
            
            // Tabela Alunos
            Statement stA = conn.conectar1().createStatement();
            ResultSet rsa = stA.executeQuery("SELECT idAluno,matriculaAluno,nomeAluno,nCPF,Telefone FROM `Aluno`;");
            while(rsa.next()){
                Aluno a = new Aluno(0,0,"","","");
                a.setIdaluno(rsa.getInt("idAluno"));
                a.setMatricula(rsa.getInt("matriculaAluno"));
                a.setNoAluno(rsa.getString("nomeAluno"));
                a.setCpf(rsa.getString("nCPF"));
                a.setTelefone(rsa.getString("Telefone"));
                
               System.out.println(rsa.getInt("idAluno"));   
                System.out.println(rsa.getInt("matriculaAluno"));
                System.out.println(rsa.getString("nomeAluno"));
                System.out.println(rsa.getString("nCPF")); 
                System.out.println(rsa.getString("Telefone"));
                a.adL(a);
                Alunos.add(a);
            }
            
            idaluno.setCellValueFactory( new PropertyValueFactory("Idaluno"));
            mAluno.setCellValueFactory( new PropertyValueFactory("matricula"));
            nAluno.setCellValueFactory( new PropertyValueFactory("NoAluno"));
            telefone.setCellValueFactory( new PropertyValueFactory("telefone"));
            cpf.setCellValueFactory( new PropertyValueFactory("cpf"));
            tabelaA.setItems(Alunos);
            
            ///////////////////////////////////////////////////////////////// 
            
            //Tabela Reservas
            Statement stR = conn.conectar1().createStatement();
            ResultSet rsr = stR.executeQuery("SELECT Itens.id_Itens as \"Item\", Itens.id_reserva AS \"Reserva\", Aluno.nomeAluno "
            + "as \"Aluno\", Itens.id_Livro as \"idLivro\", Livro.nomeLivro AS \"NomeLivro\", Reserva.dataRetirada AS \"DataSaida\", Reserva.dataEntrega as \"DataEntrega\""
            + "FROM Itens JOIN Reserva ON id_reserva = Reserva.idReserva\n" +
            "JOIN Aluno ON Reserva.idAluno = Aluno.idAluno\n" +
            "JOIN Livro ON Livro.idLivro = Itens.id_Livro;");
            while(rsr.next()){
                Reserva r = new Reserva(0,0,"",0,"","","");
                
               r.setIdItem(rsr.getInt("Item"));
                r.setIdReserva(rsr.getInt("Reserva"));
                r.setNoAluno(rsr.getString("Aluno"));
                r.setIdLivro(rsr.getInt("idLivro"));
                r.setNoLivro(rsr.getString("NomeLivro"));
                r.setDaSaida(rsr.getString("DataSaida"));
                r.setDaEntrada(rsr.getString("DataEntrega"));

                Reservas.add(r);

            }
            idR.setCellValueFactory(new PropertyValueFactory("idReserva"));
            idL.setCellValueFactory( new PropertyValueFactory("noLivro"));
            Aluno.setCellValueFactory( new PropertyValueFactory("noAluno"));
            datSaida.setCellValueFactory( new PropertyValueFactory("daSaida"));
            datEntrega.setCellValueFactory( new PropertyValueFactory("daEntrada"));
            tabelaR.setItems(Reservas);
            ////////////////////////////////////////////////////////////////////
            } catch (SQLException ex) {
            Logger.getLogger(BibliotecaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        
            @FXML /// Arquivo - PDF - Tabela Alunos
            public void pdf() throws FileNotFoundException, DocumentException, IOException, SQLException{
             Document doc = null;
             OutputStream os = null;
             try{
                 contest conn = new contest();
                 //cria o documento tamanho A4, margens de 2,54cm
                 doc = new Document(PageSize.A4);
                 //cria a stream de saída
                 os = new FileOutputStream("TabelaA.pdf");
                 //associa a stream de saída ao
                 PdfWriter.getInstance(doc, os);
                 //abre o documento
                 doc.open();
                 //adiciona o texto ao PDF 
                 PdfPTable tabelaA = new PdfPTable(new float[] { 0.2f, 0.7f, 0.7f, 0.9f, 0.7f });
                 PdfPCell header = new PdfPCell(new Paragraph("Tabela de Alunos"));
                 header.setColspan(5);
                 tabelaA.addCell(header);
                 tabelaA.addCell("ID");
                 tabelaA.addCell("Matrícula");
                 tabelaA.addCell("Nome");
                 tabelaA.addCell("C.P.F");
                 tabelaA.addCell("Telefone");
                 Statement stA = conn.conectar1().createStatement();
            ResultSet rsa = stA.executeQuery("SELECT idAluno,matriculaAluno,nomeAluno,nCPF,Telefone FROM `Aluno`;");
            while(rsa.next()){
                Aluno a = new Aluno(0,0,"","","");
                a.setIdaluno(rsa.getInt("idAluno"));
                a.setMatricula(rsa.getInt("matriculaAluno"));
                a.setNoAluno(rsa.getString("nomeAluno"));
                a.setCpf(rsa.getString("nCPF"));
                a.setTelefone(rsa.getString("Telefone"));
                
                tabelaA.addCell(String.valueOf(a.getIdaluno()));
                tabelaA.addCell(String.valueOf(a.getMatricula()));
                tabelaA.addCell(a.getNoAluno());
                tabelaA.addCell(a.getCpf());
                tabelaA.addCell(a.getTelefone());

            }
                 doc.add(tabelaA);
                }finally{
                 if (doc != null) {
                    //fechamento do documento
                    doc.close();
                 }
                 if (os != null) {
                    //fechamento da stream de saída
                    os.close();
                 }  
                }
             }
            @FXML /// Arquivo - PDF - Tabela Livros
            public void pdfL() throws FileNotFoundException, DocumentException, IOException, SQLException{
             Document doc = null;
             OutputStream os = null;
             try{
                 contest conn = new contest();
                 //cria o documento tamanho A4, margens de 2,54cm
                 doc = new Document(PageSize.A4);
                 //cria a stream de saída
                 os = new FileOutputStream("TabelaL.pdf");
                 //associa a stream de saída ao
                 PdfWriter.getInstance(doc, os);
                 //abre o documento
                 doc.open();
                 //adiciona o texto ao PDF
                 PdfPTable tabelaL = new PdfPTable(new float[] { 0.1f, 0.7f, 0.7f, 0.1f });
                 PdfPCell header = new PdfPCell(new Paragraph("Tabela de Livros"));
                 header.setColspan(4);
                 tabelaL.addCell(header);
                 tabelaL.addCell("ID");
                 tabelaL.addCell("Título");
                 tabelaL.addCell("Autor");
                 tabelaL.addCell("Qtde.");

                 Statement st = conn.conectar1().createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM `Livro`;");
                 while(rs.next()){
                     Livro l = new Livro(0,"","",0,0);
                     l.setIdlivro(rs.getInt("idlivro"));
                     l.setTiLivro(rs.getString("nomeLivro"));
                     l.setNoAutor(rs.getString("nomeAutor"));
                     l.setQtdeLivro(rs.getInt("qtdelivro"));

                    tabelaL.addCell(String.valueOf(l.getIdlivro()));
                    tabelaL.addCell(l.getTiLivro());
                    tabelaL.addCell(l.getNoAutor());
                    tabelaL.addCell(String.valueOf(l.getQtdeLivro()));
                }
                 doc.add(tabelaL);
                }finally{
                 if (doc != null) {
                    //fechamento do documento
                    doc.close();
                 }
                 if (os != null) {
                    //fechamento da stream de saída
                    os.close();
                 }  
                }
             }
            @FXML /// Arquivo - PDF - Tabela Reservas
            public void pdfR() throws FileNotFoundException, DocumentException, IOException, SQLException{
             Document doc = null;
             OutputStream os = null;
             try{
                 contest conn = new contest();
                 //cria o documento tamanho A4, margens de 2,54cm
                 doc = new Document(PageSize.A4);
                 //cria a stream de saída
                 os = new FileOutputStream("Tabela de Reservas.pdf");
                 //associa a stream de saída ao
                 PdfWriter.getInstance(doc, os);
                 //abre o documento
                 doc.open();
                 //adiciona o texto ao PDF
                 PdfPTable tabelaR = new PdfPTable(new float[] { 0.2f, 0.7f, 0.7f, 0.7f, 0.7f });
                 PdfPCell header = new PdfPCell(new Paragraph("Tabela de Reservas"));
                 header.setColspan(5);
                 tabelaR.addCell(header);
                 tabelaR.addCell("ID");
                 tabelaR.addCell("Título do Livro");
                 tabelaR.addCell("Aluno");
                 tabelaR.addCell("Data de Saida");
                 tabelaR.addCell("Data de Entrega");
                 
                 Statement stR = conn.conectar1().createStatement();
                 ResultSet rsr = stR.executeQuery("SELECT Itens.id_Itens as \"Item\", Itens.id_reserva AS \"Reserva\", Aluno.nomeAluno "
                 + "as \"Aluno\", Itens.id_Livro as \"idLivro\", Livro.nomeLivro AS \"NomeLivro\", Reserva.dataRetirada AS \"DataSaida\", Reserva.dataEntrega as \"DataEntrega\""
                 + "FROM Itens JOIN Reserva ON id_reserva = Reserva.idReserva\n" +
                 "JOIN Aluno ON Reserva.idAluno = Aluno.idAluno\n" +
                 "JOIN Livro ON Livro.idLivro = Itens.id_Livro;");
                 while(rsr.next()){
                 Reserva r = new Reserva(0,0,"",0,"","","");
                
                 r.setIdItem(rsr.getInt("Item"));
                 r.setIdReserva(rsr.getInt("Reserva"));
                 r.setNoAluno(rsr.getString("Aluno"));
                 r.setIdLivro(rsr.getInt("idLivro"));
                 r.setNoLivro(rsr.getString("NomeLivro"));
                 r.setDaSaida(rsr.getString("DataSaida"));
                 r.setDaEntrada(rsr.getString("DataEntrega"));
                 
                 tabelaR.addCell(String.valueOf(r.getIdReserva()));
                 tabelaR.addCell(r.getNoLivro());
                 tabelaR.addCell(r.getNoAluno());
                 tabelaR.addCell(r.getDaSaida());
                 tabelaR.addCell(r.getDaEntrada());
                 
            }
                 doc.add(tabelaR);
                }finally{
                 if (doc != null) {
                    //fechamento do documento
                    doc.close();
                 }
                 if (os != null) {
                    //fechamento da stream de saída
                    os.close();
                 }  
                }
             }
   }    
    
