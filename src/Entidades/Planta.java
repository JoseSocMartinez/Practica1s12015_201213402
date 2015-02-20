/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Jose
 */
public class Planta {
    private int ataque;
    private int vida;
    private String tipoAtaque;
    private String nombre;

    /**
     * @return the ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * @param ataque the ataque to set
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the tipoAtaque
     */
    public String getTipoAtaque() {
        return tipoAtaque;
    }

    /**
     * @param tipoAtaque the tipoAtaque to set
     */
    public void setTipoAtaque(String tipoAtaque) {
        this.tipoAtaque = tipoAtaque;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
