package com.betobatista.xurras.entities;

public class AmigoEntities {

    private int idAmigo;
    private String nmAmigo;
    private String sxAmigo;
    private double vlAmigo;

    public AmigoEntities(int idAmigo, String nmAmigo, String sxAmigo, double vlAmigo) {
        this.idAmigo = idAmigo;
        this.nmAmigo = nmAmigo;
        this.sxAmigo = sxAmigo;
        this.vlAmigo = vlAmigo;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public String getNmAmigo() {
        return nmAmigo;
    }

    public void setNmAmigo(String nmAmigo) {
        this.nmAmigo = nmAmigo;
    }

    public String getSxAmigo() {
        return sxAmigo;
    }

    public void setSxAmigo(String sxAmigo) {
        this.sxAmigo = sxAmigo;
    }

    public double getVlAmigo() {
        return vlAmigo;
    }

    public void setVlAmigo(double vlAmigo) {
        this.vlAmigo = vlAmigo;
    }
}
