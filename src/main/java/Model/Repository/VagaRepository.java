/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Repository;

import Model.Vaga;
import java.util.List;

/**
 *
 * @author ander
 */
public interface VagaRepository {
    public void cadastrarSetor(Vaga vaga);
    public List<Vaga> recuperarVagas();
    public Vaga buscarCarroPlaca(String placa);
    public boolean setorExiste(String setor);
}