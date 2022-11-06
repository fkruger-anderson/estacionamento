/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ander
 */
public class Vaga {
    private final String setor;
    private final int numVaga;
    private final boolean especial;
    private Carro carroEstacionado;

    public Vaga(String setor, int numVaga, boolean especial) {
        this.setor = setor;
        this.numVaga = numVaga;
        this.especial = especial;
    }

    public String getSetor() {
        return setor;
    }

    public int getNumVaga() {
        return numVaga;
    }

    public boolean isEspecial() {
        return especial;
    }

    public Carro getCarroEstacionado() {
        return carroEstacionado;
    }
    
    public boolean estacionarCarro(Carro carro) {
        this.carroEstacionado = carro;
        carro.estacionar();
        return true;
    }
    
    public boolean vagaOcupada() {
        return getCarroEstacionado() != null;
    }
    
    public void registrarSaida() {
        getCarroEstacionado().saida();
        this.carroEstacionado = null;
    }

    @Override
    public String toString() {
        return String.format("%s%d - %s", getSetor(), getNumVaga(), isEspecial() ? "Especial" : "Normal");
    }
}