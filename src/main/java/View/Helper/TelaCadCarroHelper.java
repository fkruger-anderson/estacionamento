/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Helper;

import Model.Carro;
import View.TelaCadCarro;

/**
 *
 * @author ander
 */
public class TelaCadCarroHelper {
    public final TelaCadCarro view;

    public TelaCadCarroHelper(TelaCadCarro view) {
        this.view = view;
    }

    public Carro obterCarro() {
        String modelo = view.getTfModelo().getText().toUpperCase();
        String cor = view.getTfCor().getText().toUpperCase();
        String placa = view.getTfPlaca().getText().toUpperCase();
        boolean especial = view.getChbEspecial().isSelected();
        
        return new Carro(modelo, cor, placa, especial);
    }

    public void limparTela() {
        view.getTfModelo().setText("");
        view.getTfCor().setText("");
        view.getTfPlaca().setText("");
        view.getChbEspecial().setSelected(false);    
    }

    public void mostrarMensagem(String carro_salvo) {
        view.exibirMensagem(carro_salvo);
    }
}