//package com.github.acnaweb.study_apir.service;
//
//import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestCreate;
//import com.github.acnaweb.study_apir.model.Pedido;
//import com.github.acnaweb.study_apir.model.PedidoStatus;
//import com.github.acnaweb.study_apir.repository.ItemRepository;
//import com.github.acnaweb.study_apir.repository.PedidoRepository;
//import com.github.acnaweb.study_apir.repository.ProdutoRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//import static org.mockito.Mockito.when;
//
//public class PedidoServiceTest {
//    @Mock
//    private PedidoRepository pedidoRepository;
//
//    @Mock
//    private ProdutoRepository produtoRepository;
//
//    @Mock
//    private ItemRepository itemRepository; // Embora não usado diretamente nos métodos, é uma dependência
//
//    @InjectMocks
//    private PedidoService pedidoService;
//
//    @Test
//    @DisplayName("Deve criar um pedido com sucesso")
//    void criarPedido_comDtoValido_retornaPedidoSalvo() {
//        // GIVEN (Dado que...)
//        PedidoRequestCreate dto = new PedidoRequestCreate(); // Preencha o DTO conforme necessário
//        Pedido pedidoEsperado = new Pedido();
//        pedidoEsperado.setId(1L);
//        pedidoEsperado.setStatus(PedidoStatus.ABERTO);
//
//        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedidoEsperado);
//
//        // WHEN (Quando...)
//        Pedido pedidoCriado = pedidoService.criarPedido(dto);
//
//        // THEN (Então...)
//        assertNotNull(pedidoCriado);
//        assertEquals(pedidoEsperado.getId(), pedidoCriado.getId());
//        assertEquals(PedidoStatus.ABERTO, pedidoCriado.getStatus());
//        verify(pedidoRepository, times(1)).save(any(Pedido.class)); // Verifica se o método save foi chamado exatamente uma vez
//    }
//}
