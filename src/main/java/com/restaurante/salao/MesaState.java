package com.restaurante.salao;

/**
 * Interface que define o comportamento padrão para os estados da mesa.
 * @author Luís Sestari
 * @version 1.0
 */
public interface MesaState {
    /**
     * Ocupa a mesa, alterando seu estado.
     * @param mesa a mesa a ser ocupada
     */
    void ocupar(Mesa mesa);

    /**
     * Lança um pedido na mesa.
     * @param mesa a mesa onde o pedido será lançado
     */
    void lancarPedido(Mesa mesa);

    /**
     * Libera a mesa, alterando seu estado.
     * @param mesa a mesa a ser liberada
     */
    void liberar(Mesa mesa);
}