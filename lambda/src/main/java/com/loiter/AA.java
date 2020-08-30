package com.loiter;

import lombok.Data;
import lombok.ToString;
//@Data
//@ToString
public class AA {
    private String primaryKey;
    private String teamID;
    private Integer aa;
    private Integer bb;
    private Float cc;

    public AA() {
        this.aa = 0;
        this.bb = 0;
        this.cc = 0.0f;
    }


    public AA sum(AA foo){
        if(primaryKey == null){
            this.primaryKey = foo.getPrimaryKey();
        }
        this.aa += foo.getAa();
        this.bb += foo.getBb();
        this.cc += foo.getCc();
        return this;
    }

    @Override
    public String toString() {
        return "AA{" +
                "primaryKey='" + primaryKey + '\'' +
                ", teamID='" + teamID + '\'' +
                ", aa=" + aa +
                ", bb=" + bb +
                ", cc=" + cc +
                '}';
    }


    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public AA(String primaryKey, Integer aa, Integer bb, Float cc) {
        this.primaryKey = primaryKey;
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;
    }

    public AA(String primaryKey, String teamID, Integer aa, Integer bb, Float cc) {
        this.primaryKey = primaryKey;
        this.teamID = teamID;
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getAa() {
        return aa;
    }

    public void setAa(Integer aa) {
        this.aa = aa;
    }

    public Integer getBb() {
        return bb;
    }

    public void setBb(Integer bb) {
        this.bb = bb;
    }

    public Float getCc() {
        return cc;
    }

    public void setCc(Float cc) {
        this.cc = cc;
    }
}