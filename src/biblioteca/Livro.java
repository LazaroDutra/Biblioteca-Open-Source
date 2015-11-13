/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Lazaro
 */
public class Livro {
    

    private final SimpleStringProperty tiLivro = new SimpleStringProperty();
    private final SimpleStringProperty noAutor = new SimpleStringProperty();
    private final SimpleIntegerProperty qtdeLivro = new SimpleIntegerProperty();
    private final SimpleIntegerProperty idlivro = new SimpleIntegerProperty();
    private final SimpleIntegerProperty ok = new SimpleIntegerProperty();
    private final ArrayList <Livro> Livros;

    public Livro (String tiLivro, String noAutor, int qtdeLivro, int ok) {
        this.tiLivro.set(tiLivro);
        this.noAutor.set(noAutor);
        this.qtdeLivro.set(qtdeLivro);
        this.ok.set(ok);
        Livros = new ArrayList();

    }
    public Livro (int idlivro,String tiLivro, String noAutor, int qtdeLivro,int ok) {
        this.idlivro.set(idlivro);
        this.tiLivro.set(tiLivro);
        this.noAutor.set(noAutor);
        this.qtdeLivro.set(qtdeLivro);
        this.ok.set(ok);
        Livros = new ArrayList();
    }

    public int getOk() {
        return ok.get();
    }

    public void setOk(int ok) {
        this.ok.set(ok);
    }

    public int getIdlivro() {
        return idlivro.get();
    }

    public void setIdlivro(int idlivro) {
        this.idlivro.set(idlivro);
    }

    public String getTiLivro() {
        return tiLivro.get();
    }

    public void setTiLivro(String tiLivro) {
        this.tiLivro.set(tiLivro);
    }

    public String getNoAutor() {
        return noAutor.get();
    }

    public void setNoAutor(String noAutor) {
        this.noAutor.set(noAutor);
    }

    public int getQtdeLivro() {
        return qtdeLivro.get();
    }

    public void setQtdeLivro(int qtdeLivro) {
        this.qtdeLivro.set(qtdeLivro);
    }
    
    public void adL(Livro l){
        Livros.add(l);
    }
    
    public void imprimeL(Livro l){
        System.out.println("Título: "+l.getTiLivro());
        System.out.println("Autor: "+l.getNoAutor());
        System.out.println("Quantidade de Livros:"+l.getQtdeLivro());
    }    
    
    
}
