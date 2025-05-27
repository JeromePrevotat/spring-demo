package com.humanbooster.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.humanbooster.demo.model.Utilisateur;
import com.humanbooster.demo.service.UtilisateurService;

@RestController
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }

    @PostMapping("/utilisateurs")
    public void saveUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateurService.saveUtilisateur(utilisateur);
    }

    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable int id){
        // Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateurById(id);
        // if (utilisateur != null){
        //     return ResponseEntity.ok(utilisateur);
        // } else {
        //     return ResponseEntity.notFound().build();
        // }
        return utilisateurService.getUtilisateurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateur> deleteUtilisateurById(@PathVariable int id){
        return utilisateurService.deleteUtilisateurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur newUtilisateur, int id){
        return utilisateurService.updateUtilisateur(newUtilisateur, id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
