package com.humanbooster.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.demo.model.Utilisateur;
import com.humanbooster.demo.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService (UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Transactional
    public void saveUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(int id){
        return utilisateurRepository.findById(id);
    }
    
    public Optional<Utilisateur> deleteUtilisateurById(int id){
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(id);
        utilisateurOpt.ifPresent(utilisateurRepository::delete);
        return utilisateurOpt;
    }
}
