/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exception.EstacionamentoException;
import Model.Carro;
import Model.DAO.CarroDAO;
import Model.Repository.CarroRepository;
import View.Helper.TelaCadCarroHelper;
import View.TelaCadCarro;

/**
 *
 * @author ander
 */
public class TelaCadCarroController {
    public final TelaCadCarroHelper helper;

    public TelaCadCarroController(TelaCadCarro view) {
        this.helper = new TelaCadCarroHelper(view);
    }

    public void salvarCarro() throws EstacionamentoException {
        Carro carro = helper.obterCarro();
        
        CarroRepository carroRepository = new CarroDAO();
        
        if (carroRepository.carroExiste(carro)) {
            throw new EstacionamentoException("Carro já existe");
        }
        
        carroRepository.cadastrarCarro(carro);
        helper.limparTela();
        helper.mostrarMensagem("Carro salvo");
    }
}
