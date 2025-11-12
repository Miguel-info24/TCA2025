package com.miguel.vannucci.models.interfaces;

import java.util.List;

import com.miguel.vannucci.models.Barco;

public interface barcoDAO {
    int addBarco(int idBarco, String nomeBarco, String tipoBarco, String materialBarco);
    boolean updateBarco(int idBarco, String nomeBarco, String tipoBarco, String materialBarco);
    boolean deleteBarco(int idBarco);
    List<Barco> getBarcos();
    List<Barco> getBarcosById(int idBarco);
    List<Barco> getBarcosByUserId(int idUser);
}
