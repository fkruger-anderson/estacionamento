/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.DAO.CarroDAO;
import Model.Repository.CarroRepository;

/**
 *
 * @author ander
 */
public class Banco {
    public static void iniciar() {
        CarroRepository carroRepository = new CarroDAO();
        
        Carro carro1 = new Carro("Fusca", "Prata", "AAA1234", true);
        Carro carro2 = new Carro("Gol", "Prata", "AAA1593", false);
        Carro carro3 = new Carro("Onix", "Prata", "AAA3456", false);
        Carro carro4 = new Carro("Argo", "Prata", "AAA4567", false);
        Carro carro5 = new Carro("BMW", "Prata", "AAA6789", false);
        Carro carro6 = new Carro("Fusca", "Prata", "BBB1234", true);
        Carro carro7 = new Carro("Gol", "Prata", "BBB1593", false);
        Carro carro8 = new Carro("Onix", "Prata", "BBB3456", false);
        Carro carro9 = new Carro("Argo", "Prata", "BBB4567", false);
        Carro carro10 = new Carro("BMW", "Prata", "BBB6789", false);
        
        carroRepository.cadastrarCarro(carro1);
        carroRepository.cadastrarCarro(carro2);
        carroRepository.cadastrarCarro(carro3);
        carroRepository.cadastrarCarro(carro4);
        carroRepository.cadastrarCarro(carro5);
        carroRepository.cadastrarCarro(carro6);
        carroRepository.cadastrarCarro(carro7);
        carroRepository.cadastrarCarro(carro8);
        carroRepository.cadastrarCarro(carro9);
        carroRepository.cadastrarCarro(carro10);
    }
}
