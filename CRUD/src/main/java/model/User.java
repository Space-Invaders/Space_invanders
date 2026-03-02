package model;

import java.sql.Date;
public class User {

    private int userid;
    private String username;
    private String password;
    private String creerpar;
    private Date creerle;
    private String modifierpar;
    private Date modifierle;
    private boolean actif;
    private String delete_par;
    private Date delete_le;

    public User() {}

    public User(String delete_par, Date delete_le) {
        this.delete_par = delete_par;
        this.delete_le = delete_le;
    }

    public String getDelete_par() {
        return delete_par;
    }

    public void setDelete_par(String delete_par) {
        this.delete_par = delete_par;
    }

    public Date getDelete_le() {
        return delete_le;
    }

    public void setDelete_le(Date delete_le) {
        this.delete_le = delete_le;
    }
    

    public User(int userid, String username, String password, String creerpar, Date creerle, String modifierpar, Date modifierle, boolean actif) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.creerpar = creerpar;
        this.creerle = creerle;
        this.modifierpar = modifierpar;
        this.modifierle = modifierle;
        this.actif = actif;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreerpar() {
        return creerpar;
    }

    public void setCreerpar(String creerpar) {
        this.creerpar = creerpar;
    }

    public Date getCreerle() {
        return creerle;
    }

    public void setCreerle(Date creerle) {
        this.creerle = creerle;
    }

    public String getModifierpar() {
        return modifierpar;
    }

    public void setModifierpar(String modifierpar) {
        this.modifierpar = modifierpar;
    }

    public Date getModifierle() {
        return modifierle;
    }

    public void setModifierle(Date modifierle) {
        this.modifierle = modifierle;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
    

}