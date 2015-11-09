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
public class Aluno {
    
    private String noAluno, nCpF, nTel;
    private int nMatricula;
    
    public void Aluno(String noAluno, String nCpF, String nTel, int nMatricula ){
        noAluno = this.noAluno;
        nCpF = this.nCpF;
        nTel = this.nTel;
        nMatricula = this.nMatricula; 
    }

    public String getNoAluno() {
        return noAluno;
    }

    public void setNoAluno(String noAluno) {
        this.noAluno = noAluno;
    }

    public String getnCpF() {
        return nCpF;
    }

    public void setnCpF(String nCpF) {
        this.nCpF = nCpF;
    }

    public String getnTel() {
        return nTel;
    }

    public void setnTel(String nTel) {
        this.nTel = nTel;
    }

    public int getnMatricula() {
        return nMatricula;
    }

    public void setnMatricula(int nMatricula) {
        this.nMatricula = nMatricula;
    }
    
    
    
}
