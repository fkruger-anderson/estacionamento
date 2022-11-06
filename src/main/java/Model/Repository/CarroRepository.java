/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Repository;

import Model.Carro;
import java.util.List;

/**
 *
 * @author ander
 */
public interface CarroRepository {
    public void cadastrarCarro(Carro carro);
    public List<Carro> recuperarCarros();
    public boolean carroExiste(Carro carro);
}
