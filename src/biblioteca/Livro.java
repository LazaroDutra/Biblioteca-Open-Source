/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Lazaro
 */
public class Livro {
    
    public String tiLivro, noAutor;
    public int qtdeLivro;

    public Livro(String tiLivro, String noAutor, int qtdeLivro) {
        this.tiLivro = tiLivro;
        this.noAutor = noAutor;
        this.qtdeLivro = qtdeLivro;
    }

    public String getTiLivro() {
        return tiLivro;
    }

    public void setTiLivro(String tiLivro) {
        this.tiLivro = tiLivro;
    }

    public String getNoAutor() {
        return noAutor;
    }

    public void setNoAutor(String noAutor) {
        this.noAutor = noAutor;
    }

    public int getQtdeLivro() {
        return qtdeLivro;
    }

    public void setQtdeLivro(int qtdeLivro) {
        this.qtdeLivro = qtdeLivro;
    }
    
    public void imprimeL(Livro l){
        System.out.println("Título: "+l.getTiLivro());
        System.out.println("Autor: "+l.getNoAutor());
        System.out.println("Quantidade de Livros:"+l.getQtdeLivro());
    }    
    
    
}
