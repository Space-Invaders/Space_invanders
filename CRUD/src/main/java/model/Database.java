/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luidjy
 */
public class Database {
    private String userName = "postgres" ;
    private String passWord = "admin";
    private String connectionUrl = "jdbc:postgresql://localhost:5432/Space";

    public Database() {
    }

    public Database(String userName, String passWord, String connectionUrl) {
        this.userName = userName;
        this.passWord = passWord;
        this.connectionUrl = connectionUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
    
    
    
    
    
}
