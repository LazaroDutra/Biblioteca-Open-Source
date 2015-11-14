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
public class Aluno {
    
    private final SimpleIntegerProperty Idaluno = new SimpleIntegerProperty();
    private final SimpleIntegerProperty matricula = new SimpleIntegerProperty();
    private final SimpleStringProperty NoAluno = new SimpleStringProperty();
    private final SimpleStringProperty cpf = new SimpleStringProperty();
    private final SimpleStringProperty telefone = new SimpleStringProperty();
    private final ArrayList <Aluno> Alunos;

    public Aluno (String NoAluno, String cpf,String telefone,int matricula) {
        this.NoAluno.set(NoAluno);
        this.cpf.set(cpf);
        this.matricula.set(matricula);
        this.telefone.set(telefone);
        Alunos = new ArrayList();

    }
    public Aluno (int Idaluno, int matricula,String NoAluno, String cpf,String telefone) {
        this.Idaluno.set(Idaluno);
        this.matricula.set(matricula);
        this.NoAluno.set(NoAluno);
        this.cpf.set(cpf);
        this.telefone.set(telefone);
        Alunos = new ArrayList();
    }

   
    public int getIdaluno() {
        return Idaluno.get();
    }

    public void setIdaluno(int Idaluno) {
        this.Idaluno.set(Idaluno);
    }

    public String getNoAluno() {
        return NoAluno.get();
    }

    public void setNoAluno(String NoAluno) {
        this.NoAluno.set(NoAluno);
    }

    public String getCpf() {
        return cpf.get();
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public int getMatricula() {
        return matricula.get();
    }

    public void setMatricula(int matricula) {
        this.matricula.set(matricula);
    }
    public String getTelefone() {
        return telefone.get();
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    
    public void adL(Aluno a){
        Alunos.add(a);
    }
   
}
