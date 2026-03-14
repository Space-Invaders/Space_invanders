/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author luidjy
 */
public class Partie {
    private int idPartie;
    private int score;
    private int aliensDetruits;
    private String resultat;
    private Timestamp datePartie;
    private int idJoueur;

    public Partie() {
    }

    public Partie(int idPartie, int score, int aliensDetruits, String resultat, Timestamp datePartie, int idJoueur) {
        this.idPartie = idPartie;
        this.score = score;
        this.aliensDetruits = aliensDetruits;
        this.resultat = resultat;
        this.datePartie = datePartie;
        this.idJoueur = idJoueur;
    }

    public int getIdPartie() {
        return idPartie;
    }

    public void setIdPartie(int idPartie) {
        this.idPartie = idPartie;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAliensDetruits() {
        return aliensDetruits;
    }

    public void setAliensDetruits(int aliensDetruits) {
        this.aliensDetruits = aliensDetruits;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Timestamp getDatePartie() {
        return datePartie;
    }

    public void setDatePartie(Timestamp datePartie) {
        this.datePartie = datePartie;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "idPartie=" + idPartie +
                ", score=" + score +
                ", aliensDetruits=" + aliensDetruits +
                ", resultat=" + resultat +
                ", datePartie=" + datePartie +
                ", idJoueur=" + idJoueur +
                '}';
    }
    
}
