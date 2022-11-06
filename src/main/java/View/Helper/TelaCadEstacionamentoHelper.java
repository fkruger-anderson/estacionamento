/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Helper;

import View.TelaCadEstacionamento;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ander
 */
public class TelaCadEstacionamentoHelper {
    public final TelaCadEstacionamento view;

    public TelaCadEstacionamentoHelper(TelaCadEstacionamento view) {
        this.view = view;
    }

    public Map<String, String> infosVagas() {
        Map<String, String> infosVagas = new HashMap<>();
        String setor = view.getTfSetor().getText().toUpperCase();
        String vagas = view.getTfVagas().getText();
        
        infosVagas.put("setor", setor);
        infosVagas.put("vagas", vagas);
        
        return infosVagas;
    }

    public void limparTela() {
        view.getTfSetor().setText("");
        view.getTfVagas().setText("");    
    }

    public void mostrarMensagem(String vagas_cadastradas) {
        view.exibirMensagem(vagas_cadastradas);
    }
    
}
