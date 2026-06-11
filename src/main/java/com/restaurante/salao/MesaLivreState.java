package com.restaurante.salao;

/**
 * Estado representando uma mesa livre no restaurante.
 * @author Luís Sestari
 * @version 1.0
 */
public class MesaLivreState implements MesaState {
    @Override
    public void ocupar(Mesa mesa) { mesa.setState(new MesaOcupadaState()); }

    @Override
    public void lancarPedido(Mesa mesa) {
        throw new IllegalStateException("Não é possível lançar pedido em uma mesa livre!");
    }

    @Override
    public void liberar(Mesa mesa) {
        // Mesa já está livre
    }
}