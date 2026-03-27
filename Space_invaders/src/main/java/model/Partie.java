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

    private long idPartie;
    private int idJoueur;
    private int score;
    private int aliensDetruits;
    private String resultat;
    private Timestamp datePartie;

    public Partie() {
    }

    public Partie(long idPartie, int idJoueur, int score, int aliensDetruits, String resultat, Timestamp datePartie) {
        this.idPartie = idPartie;
        this.idJoueur = idJoueur;
        this.score = score;
        this.aliensDetruits = aliensDetruits;
        this.resultat = resultat;
        this.datePartie = datePartie;
    }

    public long getIdPartie() {
        return idPartie;
    }

    public void setIdPartie(long idPartie) {
        this.idPartie = idPartie;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
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

    @Override
    public String toString() {
        return "Partie{"
                + "idPartie=" + idPartie
                + ", idJoueur=" + idJoueur
                + ", score=" + score
                + ", aliensDetruits=" + aliensDetruits
                + ", resultat='" + resultat + '\''
                + ", datePartie=" + datePartie
                + '}';
    }
}
