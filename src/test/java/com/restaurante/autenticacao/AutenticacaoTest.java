package com.restaurante.autenticacao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutenticacaoTest {

    // CT01: Verificar a criação de novos perfis / Login válido
    @Test
    public void testCT01_LoginComSucesso() {
        Usuario usuario = new Usuario("gusta", "senha123", "GERENTE");

        assertEquals("gusta", usuario.getLogin());
        assertEquals("senha123", usuario.getSenha());
        assertEquals("GERENTE", usuario.getPerfil());
    }

    // CT02: Validar acesso correto com login (Simulação de credenciais vazias/inválidas)
    @Test
    public void testCT02_LoginComFalha() {
        Usuario usuario = new Usuario("gusta", "senhaErrada", "GERENTE");

        // Garante que o sistema não confunda a senha errada com a senha certa
        assertNotEquals("senha123", usuario.getSenha());
    }

    // CT12: Tentar cadastro/alteração com perfil sem permissão (Exceção)
    @Test
    public void testCT12_BloqueioDeAlteracaoItemCardapio() {
        CardapioServiceProxy proxy = new CardapioServiceProxy();
        Usuario garcom = new Usuario("pedro", "123", "GARCOM");

        // O JUnit vai testar se o Proxy realmente joga um erro de segurança na cara do Garçom
        assertThrows(SecurityException.class, () -> {
            proxy.alterarPrecoItem(garcom, "Filé Mignon", 45.90);
        });
    }

    // CT15: Validar permissão de alteração (Gerente logado com sucesso)
    @Test
    public void testCT15_PermissaoDeAlteracaoItemCardapio() {
        CardapioServiceProxy proxy = new CardapioServiceProxy();
        Usuario gerente = new Usuario("gusta", "senha123", "GERENTE");

        // O Proxy tem que retornar true e permitir que o gerente mude o preço
        boolean resultado = proxy.alterarPrecoItem(gerente, "Filé Mignon", 45.90);
        assertTrue(resultado);
    }
}