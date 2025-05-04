package Codigo;

import java.io.Serializable;

public class Jugador implements Serializable
{
    /* Atributos */
    
    // Variables Jugador
    private int dinero = 0, nivel = 1, tirosRestantes = 1, xp = 0;
    
    // Contadores Peces
    private int salmon = 0, bacalao = 0, propical = 0, pulpo = 0, pezOro = 0, pezEsmeralda = 0;

    
    
    /* Getters y Setters */
    public int getDinero() {
        return dinero;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getTirosRestantes() {
        return tirosRestantes;
    }
    public void setTirosRestantes(int tirosRestantes) {
        this.tirosRestantes = tirosRestantes;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {    
        this.xp = xp;
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
    public int getPropical() {
        return propical;
    }
    public void setPropical(int propical) {
        this.propical = propical;
    }
    public int getPulpo() {
        return pulpo;
    }
    public void setPulpo(int pulpo) {
        this.pulpo = pulpo;
    }
    public int getPezOro() {
        return pezOro;
    }
    public void setPezOro(int pezOro) {
        this.pezOro = pezOro;
    }
    public int getPezEsmeralda() {
        return pezEsmeralda;
    }
    public void setPezEsmeralda(int pezEsmeralda) {
        this.pezEsmeralda = pezEsmeralda;
    }
}
