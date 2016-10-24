package com.jamerlan.model;

import java.io.Serializable;


/**
 ADDUSER [mic]Bedarfsriese DE 0
 ADDUSER [DoR]Isildur[teh] US 0
 ADDUSER amadeustekken FR 0
 ADDUSER [ACE]babar FR 0
 */
public class User implements Serializable {
    private final String userName;
    private String country;
    private String cpu;
    private String accountId;
    private String status;
    private String battlestatus;
    private String teamColor;
    private String ip;
    private int port;
    private Channel channel; //need for SAYPRIVATE Command

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String country, String cpu, String accountId) {
        this.userName = userName;
        this.country = country;
        this.cpu = cpu;
        this.accountId = accountId;
    }

    public User(String userName, String battlestatus, String teamColor) {
        this.userName = userName;
        this.battlestatus = battlestatus;
        this.teamColor = teamColor;
    }

    public User(String userName, String status) {
        this.userName = userName;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public String getCountry() {
        return country;
    }

    public String getCpu() {
        return cpu;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBattlestatus() {
        return battlestatus;
    }

    public void setBattlestatus(String battlestatus) {
        this.battlestatus = battlestatus;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", country='" + country + '\'' +
                ", cpu='" + cpu + '\'' +
                ", accountId='" + accountId + '\'' +
                ", status='" + status + '\'' +
                ", battlestatus='" + battlestatus + '\'' +
                ", teamColor='" + teamColor + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
