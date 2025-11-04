package com.miguel.vannucci.models.interfaces;

import java.util.List;

import com.miguel.vannucci.models.Carpinteiro;

public interface CarpinteiroDAO {
    int addCarpinteiro(Carpinteiro carpinteiro);
    boolean updateCarpinteiro(Carpinteiro carpinteiro);
    boolean deleteCarpinteiro(int carpinteiroId);
    Carpinteiro getCarpinteiroById(int carpinteiroId);
    List<Carpinteiro> getCarpinteiros();
}
