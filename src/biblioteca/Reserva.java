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
public class Reserva {
    
    private final SimpleIntegerProperty idItem = new SimpleIntegerProperty();
    private final SimpleIntegerProperty idReserva = new SimpleIntegerProperty();
    private final SimpleStringProperty noAluno = new SimpleStringProperty();
    private final SimpleIntegerProperty idLivro = new SimpleIntegerProperty();
    private final SimpleStringProperty noLivro = new SimpleStringProperty();
    private final SimpleStringProperty daSaida = new SimpleStringProperty();
    private final SimpleStringProperty daEntrada = new SimpleStringProperty();
    private final ArrayList <Reserva> Reservas;
    
    public Reserva(int idItem, int idReserva, String noAluno, int idLivro, String noLivro, String daSaida, String daEntrada){
        this.idItem.set(idItem);
        this.idReserva.set(idReserva);
        this.noAluno.set(noAluno);
        this.idLivro.set(idLivro);
        this.noLivro.set(noLivro);
        this.daSaida.set(daSaida);
        this.daEntrada.set(daEntrada);
        Reservas = new ArrayList();
    }
    
    public int getIdItem() {
        return idItem.get();
    }

    public void setIdItem(int idItem) {
        this.idItem.set(idItem);
    }
     public int getIdReserva() {
        return idReserva.get();
    }

    public void setIdReserva(int idReserva) {
        this.idReserva.set(idReserva);
    }
    public String getNoAluno() {
        return noAluno.get();
    }

    public void setNoAluno(String noAluno) {
        this.noAluno.set(noAluno);
    }
       public int getIdLivro() {
        return idLivro.get();
    }

    public void setIdLivro(int idLivro) {
        this.idLivro.set(idLivro);
    }
    public String getNoLivro() {
        return noLivro.get();
    }

    public void setNoLivro(String noLivro) {
        this.noLivro.set(noLivro);
    }
    public String getDaSaida() {
        return daSaida.get();
    }

    public void setDaSaida(String daSaida) {
        this.daSaida.set(daSaida);
    }
    public String getDaEntrada() {
        return daEntrada.get();
    }

    public void setDaEntrada(String daEntrada) {
        this.daEntrada.set(daEntrada);
    }

    public void adL(Reserva r){
        Reservas.add(r);
    }
    
}
