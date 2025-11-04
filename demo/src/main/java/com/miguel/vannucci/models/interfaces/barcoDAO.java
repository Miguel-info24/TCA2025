package com.miguel.vannucci.models.interfaces;

import com.miguel.vannucci.models.Barco;

public interface barcoDAO {
    int addBarco(int id, String nome, String tipo, double tamanho, String material);
    boolean updateBarco(int id, String nome, String tipo, double tamanho, String material);
    boolean deleteBarco(int id);
    java.util.List<Barco> getBarcos();
    java.util.List<Barco> getBarcosById(int id);
}
