/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ander
 */
public class Carro {
    private final String modelo;
    private final String cor;
    private final String placa;
    private final boolean especial;
    private boolean estacionado;

    public Carro(String modelo, String cor, String placa, boolean especial) {
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.especial = especial;
        this.estacionado = false;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isEspecial() {
        return especial;
    }

    public boolean isEstacionado() {
        return estacionado;
    }
    
    public boolean estacionar() {
        if (!isEstacionado()) {
            this.estacionado = true;
            return true;
        }
        return false;
    }
    
    public boolean saida() {
        if (isEstacionado()) {
            this.estacionado = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", getPlaca(), isEspecial() ? "Especial" : "Normal");
    }
}