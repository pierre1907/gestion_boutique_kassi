package sn.ksi.gestion_boutique_kassi.controller;

import sn.ksi.gestion_boutique_kassi.model.Dette;
import sn.ksi.gestion_boutique_kassi.service.IDetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients/{clientId}/debts")
public class DetteController {

    @Autowired
    private IDetteService detteService;

    @PostMapping
    public ResponseEntity<Dette> createDette(@PathVariable Long clientId, @RequestBody Dette dette) {
        Dette createdDette = detteService.createDette(clientId, dette);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDette);
    }

    @GetMapping
    public ResponseEntity<List<Dette>> getDettesByClientId(@PathVariable Long clientId) {
        List<Dette> dettes = detteService.getDettesByClientId(clientId);
        return ResponseEntity.ok(dettes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dette> updateDette(@PathVariable Long clientId, @PathVariable Long id,
            @RequestBody Dette dette) {
        Dette updatedDette = detteService.updateDette(id, dette);
        return ResponseEntity.ok(updatedDette);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDette(@PathVariable Long clientId, @PathVariable Long id) {
        detteService.deleteDette(id);
        return ResponseEntity.noContent().build();
    }
}
