package com.ep4.fernando.service;
import com.ep4.fernando.entity.Visita;

import java.util.List;

public interface VisitaService {
    Visita createVisita(Visita visita);
    Visita getVisitaById(Long visitaId);
    List<Visita> getAllVisitas();
    Visita updateVisita(Visita visita);
    void deleteVisita(Long visitaId);
}
