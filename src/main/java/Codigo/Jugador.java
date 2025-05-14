package Codigo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable
{
    // Variables Jugador
    private List<Tesoros> peces = new ArrayList<>();
    private List<Canas> canas = new ArrayList<>();
    private int dinero = 0, nivel = 1, xp = 0, xpLimite = 100, cooldown = 3, indexCana = 0;
    private int bacalao = 0, salmon = 0, tropical = 0, pulpo = 0;

    /* Metodos */
    public void clearPeces() {    
        peces.clear();
        bacalao = 0;
        salmon = 0;
        tropical = 0;
        pulpo = 0;
    }
    public void subirNivel() {
        nivel++;
        xpLimite = calcularLimite();
        System.out.println("SUBES NIVEL " + nivel + "!!");
    }
    public int calcularLimite() {
        return (int)(xpLimite * Math.pow(1.2, nivel));
    }
    
    /* Getters y Setters */
    public List<Tesoros> getInventario() {
        return peces;
    }
    public void addPeces(Tesoros pez) {
        peces.add(pez);
    }
    public List<Canas> getCanas() {
        return canas;
    }
    public void addCana(Canas cana) {
        canas.add(cana);
    }
    public int getDinero() {
        return dinero;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    public int getCooldown() {
        return cooldown;
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
    public int getIndexCana() {
        return indexCana;
    }
    public void setIndexCana(int index) {
        this.indexCana = index;
    }
    public List<Tesoros> getPeces() {
        return peces;
    }
    public void setPeces(List<Tesoros> peces) {
        this.peces = peces;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {    
        this.xp = xp;
    }
    public int getXpLimite() {
        return xpLimite;
    }
    public int getSalmon() {
        return salmon;
    }
    public void setSalmon(int salmon) {
        this.salmon = salmon;
    }
    public int getBacalao() {
        return bacalao;
    }
    public void setBacalao(int bacalao) {
        this.bacalao = bacalao;
    }
    public int getTropical() {
        return tropical;
    }
    public void setTropical(int tropical) {
        this.tropical = tropical;
    }
    public int getPulpo() {
        return pulpo;
    }
    public void setPulpo(int pulpo) {
        this.pulpo = pulpo;
    }
}
