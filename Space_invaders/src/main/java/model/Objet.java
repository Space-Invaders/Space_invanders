/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luidjy
 */
public class Objet {

    public String nom;
    public int x;
    public int y;
    public int largeur;
    public int hauteur;
    public int type;

    public Objet(String nom, int x, int y, int largeur, int hauteur, int type) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.type = type;
    }
}
