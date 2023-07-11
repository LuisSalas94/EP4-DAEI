package com.ep4.fernando.service.implementation;
import com.ep4.fernando.entity.Visita;
import com.ep4.fernando.repository.VisitaRepository;
import com.ep4.fernando.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VisitaImplementation implements VisitaService {
    @Autowired
    private VisitaRepository visitaRepository;

    @Override
    public Visita createVisita(Visita visita) {

        return visitaRepository.save(visita);
    }

    @Override
    public Visita getVisitaById(Long visitaId) {
        return visitaRepository.findById(visitaId).get();
    }

    @Override
    public List<Visita> getAllVisitas() {
        return visitaRepository.findAll();
    }

    @Override
    public Visita updateVisita(Visita visita) {
        Visita existingVisita = visitaRepository.findById(visita.getId()).get();
        existingVisita.setLocal(visita.getLocal());
        existingVisita.setDni_afiliado(visita.getDni_afiliado());
        existingVisita.setHora(visita.getHora());
        return visitaRepository.save(existingVisita);
    }

    @Override
    public void deleteVisita(Long visitaId) {
        visitaRepository.deleteById(visitaId);
    }

}
