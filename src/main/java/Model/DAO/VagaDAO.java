/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Vaga;
import java.util.ArrayList;
import java.util.List;
import Model.Repository.VagaRepository;

/**
 *
 * @author ander
 */
public class VagaDAO implements VagaRepository {
    private static final List<Vaga> vagas = new ArrayList<>();
    
    @Override
    public void cadastrarSetor(Vaga vaga) {
        recuperarVagas().add(vaga);
    }

    @Override
    public List<Vaga> recuperarVagas() {
        return vagas;
    }

    @Override
    public Vaga buscarCarroPlaca(String placa) {
        return recuperarVagas().stream()
                               .filter(c -> c.getCarroEstacionado() != null)
                               .filter(c -> c.getCarroEstacionado().getPlaca().equalsIgnoreCase(placa))
                               .findAny()
                               .orElse(null);
    }
    
    @Override
    public boolean setorExiste(String setor) {
        return recuperarVagas().stream().anyMatch(s -> s.getSetor().equalsIgnoreCase(setor));
    }
}
