package com.restaurante.salao;

/**
 * Estado representando uma mesa ocupada no restaurante.
 * @author Luís Sestari
 * @version 1.0
 */
public class MesaOcupadaState implements MesaState {

    /**
     * Tenta ocupar uma mesa que já está ocupada, lançando exceção.
     * @param mesa a mesa que se tentou ocupar
     */
    @Override
    public void ocupar(Mesa mesa) {
        throw new IllegalStateException("A mesa já está ocupada!");
    }

    /**
     * Lança um pedido na mesa ocupada.
     * @param mesa a mesa onde o pedido será lançado
     */
    @Override
    public void lancarPedido(Mesa mesa) {
        // Lógica para registrar pedido na mesa
        System.out.println("Pedido lançado com sucesso na mesa ocupada.");
    }

    /**
     * Libera a mesa, alterando o estado para AguardandoPagamento.
     * @param mesa a mesa a ser liberada
     */
    @Override
    public void liberar(Mesa mesa) {
        mesa.setState(new MesaAguardandoPagamentoState());
    }
}