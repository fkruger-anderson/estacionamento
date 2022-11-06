/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exception.EstacionamentoException;
import Model.DAO.VagaDAO;
import Model.Repository.VagaRepository;
import Model.Vaga;
import View.Helper.TelaCadEstacionamentoHelper;
import View.TelaCadEstacionamento;
import java.util.Map;

/**
 *
 * @author ander
 */
public class TelaCadEstacionamentoController {
    public final TelaCadEstacionamentoHelper helper;

    public TelaCadEstacionamentoController(TelaCadEstacionamento view) {
        this.helper = new TelaCadEstacionamentoHelper(view);
    }

    public void cadastrarVagas() throws EstacionamentoException {
        Map<String, String> infos = helper.infosVagas();
        String setor = infos.get("setor");
        int vagas = Integer.parseInt(infos.get("vagas"));

        VagaRepository vagaRepository = new VagaDAO();

        if (vagaRepository.setorExiste(setor)) {
            throw new EstacionamentoException("Setor já existe.");
        }
                
        for (int i = 1; i <= vagas; i++) {
            if (i <= vagas * 0.2) {
                vagaRepository.cadastrarSetor(new Vaga(setor, i, true));
            } else {
                vagaRepository.cadastrarSetor(new Vaga(setor, i, false));
            }
        }

        helper.limparTela();
        helper.mostrarMensagem("Vagas cadastradas");            
    }    
}