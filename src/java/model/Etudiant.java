/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chouaib
 */
public class Etudiant {
    
    private int id ;
    private String nom ;
    private String prenom; 
    private int age; 
    private String specialite ;
    private String numero ;
    
    public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenom, int age, String specialite, String numero) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.specialite = specialite;
        this.numero = numero;
    }
    
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getNumero() {
        return numero;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
