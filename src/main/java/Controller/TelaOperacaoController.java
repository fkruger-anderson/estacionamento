/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exception.EstacionamentoException;
import Model.Carro;
import Model.DAO.CarroDAO;
import Model.DAO.VagaDAO;
import Model.Repository.CarroRepository;
import Model.Repository.VagaRepository;
import Model.Vaga;
import View.Helper.TelaOperacaoHelper;
import View.TelaOperacao;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author ander
 */
public class TelaOperacaoController {
    public final TelaOperacaoHelper helper;

    public TelaOperacaoController(TelaOperacao view) {
        this.helper = new TelaOperacaoHelper(view);
    }

    public void setarVagas() {
        VagaRepository vagaRepository = new VagaDAO();
        List<Vaga> disponiveis = vagaRepository.recuperarVagas()    
                                               .stream()
                                               .filter(v -> !v.vagaOcupada())
                                               .toList();
        
        helper.vagasDisp(disponiveis);
    }

    public void setarCarros() {
        CarroRepository carroRepository = new CarroDAO();
        List<Carro> carros = carroRepository.recuperarCarros().stream()
                                                              .filter(c -> !c.isEstacionado())
                                                              .toList();
        helper.preencherCarros(carros);
    }

    public void tabelaVagas() {
        VagaRepository vagaRepository = new VagaDAO();
        List<Vaga> vagas = vagaRepository.recuperarVagas();
        helper.preencherTabelaVagas(vagas);
    }

    public void setoresCheios() {
        VagaRepository vagaRepository = new VagaDAO();
        List<Vaga> vagas = vagaRepository.recuperarVagas();

        StringBuilder sb = new StringBuilder();        
        
        Set<String> setores = vagas.stream()
                                   .map(Vaga::getSetor)
                                   .collect(Collectors.toSet());
        
        for (String setor : setores) {
            boolean vagasPreenchidas = vagas.stream()
                                            .filter(v -> setor.equals(v.getSetor()))
                                            .allMatch(Vaga::vagaOcupada);

            if (vagasPreenchidas) {
                if (!sb.isEmpty())
                    sb.append(", ");
                sb.append(setor);
            }
        }
        
        helper.preencherSetores(sb.toString());
    }

    public void numeroVagasDisp() {
        VagaRepository vagaRepository = new VagaDAO();
        int disponiveis = (int) vagaRepository.recuperarVagas()    
                                              .stream()
                                              .filter(v -> !v.vagaOcupada())
                                              .count();
        
        helper.numVagasDisp(disponiveis);
    }

    public void registrarEntrada() throws EstacionamentoException {
        Vaga vaga = helper.pegarVaga();
        Carro carro = helper.pegarCarro();
        
        if (vaga == null || carro == null) {
            throw new EstacionamentoException("Carro ou vaga não selecionado.");            
        }
        
        if (vaga.isEspecial() && carro.isEspecial()) {
            vaga.estacionarCarro(carro);
        } else if (!vaga.isEspecial()) {
            vaga.estacionarCarro(carro);
        } else {
            throw new EstacionamentoException("Carro não pode ser estacionado em vaga especial");
        }
        atualizarTela();
    }

    public void registrarSaida() throws EstacionamentoException {
        String placaEstacionado = helper.pegarPlaca();
        
        VagaRepository vagaRepository = new VagaDAO();
        Vaga vaga = vagaRepository.buscarCarroPlaca(placaEstacionado);
        
        if (vaga != null) {
            logSaida(vaga);
            vaga.registrarSaida();
        } else {
            throw new EstacionamentoException("Carro não encontrado.");
        }
        atualizarTela();
    }
    
    public void atualizarTela() {
        setarVagas();
        setarCarros();
        tabelaVagas();
        setoresCheios();
        numeroVagasDisp();
    }
    
    private void logSaida(Vaga vaga) {
        System.out.printf("Carro: %s saiu da Vaga: %s\n", vaga.getCarroEstacionado(), vaga);
    }
}