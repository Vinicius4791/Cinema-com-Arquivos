package javacine;

import java.io.Serializable;

public class Vendas implements Serializable{
    private final float pipocaPequena = 4;
    private final float pipocaGrande = 7;
    private final float agua = 3;
    private final float chocolate = 4;
    private final float refrigerante = 6.5f;

    public Vendas(){}

    public float getPipocaPequena() {
        return pipocaPequena;
    }

    public float getPipocaGrande() {
        return pipocaGrande;
    }

    public float getAgua() {
        return agua;
    }

    public float getChocolate() {
        return chocolate;
    }

    public float getRefrigerante() {
        return refrigerante;
    }
    
    
}
