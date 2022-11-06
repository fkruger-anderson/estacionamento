/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Helper;

import Model.Carro;
import Model.Vaga;
import View.TelaOperacao;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class TelaOperacaoHelper {
    public final TelaOperacao view;

    public TelaOperacaoHelper(TelaOperacao view) {
        this.view = view;
    }

    public void vagasDisp(List<Vaga> disponiveis) {
        view.getCbVaga().removeAllItems();
        disponiveis.forEach(v -> view.getCbVaga().addItem(v));
    }

    public void preencherCarros(List<Carro> carros) {
        view.getCbCarro().removeAllItems();
        carros.forEach(c -> view.getCbCarro().addItem(c));
    }

    public void preencherTabelaVagas(List<Vaga> vagas) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTbVagas().getModel();
        tableModel.setNumRows(0);
        
        for (Vaga vaga : vagas) {
            tableModel.addRow(new Object[] {
                vaga.getSetor(),
                vaga.getNumVaga(),
                vaga.vagaOcupada() ? vaga.getCarroEstacionado().getPlaca() : ""
            });
        }
    }

    public void preencherSetores(String setores) {
        view.getTfSetores().setText(setores);
    }

    public void numVagasDisp(int disponiveis) {
        view.getTfVagas().setText(disponiveis + "");
    }

    public Vaga pegarVaga() {
        return (Vaga) view.getCbVaga().getSelectedItem();
    }

    public Carro pegarCarro() {
        return (Carro) view.getCbCarro().getSelectedItem();
    }

    public String pegarPlaca() {
        return view.getTfPlaca().getText();
    }
}