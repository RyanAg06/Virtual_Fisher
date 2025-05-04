package Codigo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Jugador implements Serializable
{
    /* Atributos */
    
    // Variables Jugador
    private int dinero = 0, nivel = 1, tirosRestantes = 1, xp = 0, cooldown = 3;
    // Contadores Peces
    List<Pez> peces = new ArrayList<>();
    private int bacalao = 0, salmon = 0, tropical = 0, pulpo = 0, pezOro = 0, pezEsmeralda = 0;

    /* Metodos */
    public void addPeces(Pez pez) {
        peces.add(pez);
    }
    public void clearPeces() {    
        peces.clear();
        bacalao = 0;
        salmon = 0;
        tropical = 0;
        pulpo = 0;
        pezOro = 0;
        pezEsmeralda = 0;
    }
    
    /* Getters y Setters */
    public List<Pez> getInventario()
    {
        return peces;
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
    public List<Pez> getPeces() {
        return peces;
    }
    public void setPeces(List<Pez> peces) {
        this.peces = peces;
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
