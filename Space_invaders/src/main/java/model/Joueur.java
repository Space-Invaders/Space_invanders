/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luidjy
 */
public class Joueur {
    private int idJoueur;
    private String pseudo;

    public Joueur() {
    }

    public Joueur(int idJoueur, String pseudo) {
        this.idJoueur = idJoueur;
        this.pseudo = pseudo;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return "Joueur{" + "idJoueur=" + idJoueur + ", pseudo=" + pseudo + '}';
    }
}
