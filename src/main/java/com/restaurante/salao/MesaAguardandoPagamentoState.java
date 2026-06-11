package com.restaurante.salao;

/**
 * Estado representando uma mesa aguardando o pagamento da conta.
 * @author Luís Sestari
 * @version 1.0
 */
public class MesaAguardandoPagamentoState implements MesaState {

    /**
     * Tenta ocupar uma mesa que está aguardando pagamento, lançando exceção.
     * @param mesa a mesa que se tentou ocupar
     */
    @Override
    public void ocupar(Mesa mesa) {
        throw new IllegalStateException("A mesa está aguardando pagamento.");
    }

    /**
     * Tenta lançar um novo pedido em uma mesa que está fechando, lançando exceção.
     * @param mesa a mesa onde se tentou lançar o pedido
     */
    @Override
    public void lancarPedido(Mesa mesa) {
        throw new IllegalStateException("Não é possível lançar novos pedidos em uma mesa fechando!");
    }

    /**
     * Libera a mesa, alterando o estado para Livre.
     * @param mesa a mesa a ser liberada
     */
    @Override
    public void liberar(Mesa mesa) {
        mesa.setState(new MesaLivreState());
    }
}