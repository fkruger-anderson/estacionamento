/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Carro;
import Model.Repository.CarroRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ander
 */
public class CarroDAO implements CarroRepository {
    public static final List<Carro> carros = new ArrayList<>();

    @Override
    public void cadastrarCarro(Carro carro) {
        carros.add(carro);
    }

    @Override
    public List<Carro> recuperarCarros() {
        return carros;
    }
    
    @Override
    public boolean carroExiste(Carro carro) {
        return recuperarCarros().stream()
                                .anyMatch(c -> c.getPlaca().equalsIgnoreCase(carro.getPlaca()));
    }
}