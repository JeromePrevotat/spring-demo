package com.humanbooster.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Table(name="utilisateur")
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String nom;

    @Email
    @NotBlank
    private String email;
    
    @Column(name="mot_de_passe")
    @NotBlank
    private String motDePasse;

    public Utilisateur() {}

    public Utilisateur(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // GETTER
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    
    // SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email + ", motDePasse=" + motDePasse + "]";
    }


}
