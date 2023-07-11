package com.ep4.fernando.controller;
import com.ep4.fernando.entity.Visita;
import com.ep4.fernando.service.VisitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/visitas")
public class VisitaController {
    @Autowired
    private VisitaService visitaService;

    @PostMapping
    // http://localhost:8080/api/visitas
    public ResponseEntity<Visita>createVisita(@RequestBody Visita visita) {
        Visita savedVisita = visitaService.createVisita(visita);
        return new ResponseEntity<>(savedVisita, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    // http://localhost:8080/api/visitas/1
    public ResponseEntity<Visita>getVisitaById(@PathVariable("id") Long visitaId) {
        Visita visita = visitaService.getVisitaById(visitaId);
        return new ResponseEntity<>(visita, HttpStatus.OK);
    }
    @GetMapping
    // http://localhost:8080/api/visitas
    public ResponseEntity<List<Visita>>getAllVisitas() {
        List<Visita> visitaList = visitaService.getAllVisitas();
        return new ResponseEntity<>(visitaList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    // http://localhost:8080/api/visitas/1
    public ResponseEntity<Visita> updateVisita(@PathVariable("id") Long visitaid, @RequestBody Visita visita) {
        visita.setId(visitaid);
        Visita updatedVisita = visitaService.updateVisita(visita);
        return new ResponseEntity<>(updatedVisita, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    // http://localhost:8080/api/visitas/1
    public ResponseEntity<String> deleteVisita(@PathVariable("id") Long visitaId) {
        visitaService.deleteVisita(visitaId);
        return new ResponseEntity<>("Visita entry was deleted successfully", HttpStatus.OK);
    }
}
