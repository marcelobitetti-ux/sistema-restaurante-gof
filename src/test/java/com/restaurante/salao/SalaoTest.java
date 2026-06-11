package com.restaurante.salao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes unitários para o módulo de salão.
 * @author Luís Sestari
 * @version 1.0
 */
public class SalaoTest {
    private Mesa mesa;

    @BeforeEach
    public void setup() {
        mesa = new Mesa();
    }

    /**
     * Testa se a mudança de estado para Ocupada ocorre corretamente.
     */
    @Test
    public void testCT03_MudancaDeStatusParaOcupada() {
        mesa.ocupar();
        assertTrue(mesa.getState() instanceof MesaOcupadaState, "A mesa deveria estar no estado Ocupada.");
    }

    /**
     * Valida se o sistema bloqueia pedidos em mesas livres lançando exceção.
     */
    @Test
    public void testCT13_ImpedirPedidoEmMesaVaga() {
        assertThrows(IllegalStateException.class, () -> {
            mesa.lancarPedido();
        }, "Deveria lançar IllegalStateException ao tentar pedir em mesa livre.");
    }
}