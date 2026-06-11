package com.restaurante.salao;

/**
 * Classe que representa a Mesa do restaurante, utilizando o padrão State.
 * @author Luís Sestari
 * @version 1.0
 */
public class Mesa {
    private MesaState state;

    public Mesa() { this.state = new MesaLivreState(); }

    public void setState(MesaState state) { this.state = state; }

    public MesaState getState() { return state; }

    public void ocupar() { state.ocupar(this); }

    public void lancarPedido() { state.lancarPedido(this); }

    public void liberar() { state.liberar(this); }
}