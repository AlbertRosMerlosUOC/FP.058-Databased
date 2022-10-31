package databased.modelo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {
    private Datos datos = new Datos();

    @org.junit.jupiter.api.Test
    void pedidoEnviado() {
        Cliente c1 = new ClienteStandard("Juan@email.com", "11111111A", "Juan Gómez","c/ La paz n 23, Jaén" );
        int tiempo_preparacion = 12;
        Articulo a1 = new Articulo("a1", "Texto para la descripción...", 22.98, 1.45, tiempo_preparacion);
        //Tiempo de preparación no transcurrido
        Pedido p1 = new Pedido(1, c1, a1, 2, LocalDateTime.now());
        datos.addPedido(p1);
        assertFalse(p1.pedidoEnviado());

        //Tiempo de preparación transcurrido
        LocalDateTime fecha_preparacion = LocalDateTime.now().minusMinutes(20);
        Pedido p2 = new Pedido(1, c1, a1, 2, fecha_preparacion);
        datos.addPedido(p2);
        assertTrue(p2.pedidoEnviado());
    }

    @org.junit.jupiter.api.Test
    void precioEnvio() {
        //Para calcular el precio del pedido hay que tener en cuenta el precio de venta,
        // las unidades pedidas,
        // el coste del envío y si el cliente que lo ha realizado es premium.
        // Si es premium paga una cuota anual de 30 euros y se le aplica un 20% de descuento en los gastos de envío de cada pedido

        Cliente cs = new ClienteStandard("Juan@email.com", "11111111A", "Juan Gómez","c/ La paz n 23, Jaén" );
        Cliente cp = new ClientePremium("maria@email.com", "22222222B", "Maria Jiménez","c/ Luna n 23, Segovia" );
        Articulo a1 = new Articulo("a1", "Texto para la descripción...", 22.98, 1.45, 10);

        //Pedido cliente standard: 22.98 * 2 + 1.45 = 47.41
        Pedido pcs1 = new Pedido(1, cs, a1, 2, LocalDateTime.now());
        datos.addPedido(pcs1);
        assertEquals(47.41, pcs1.precioEnvio(), 0.01);

        //Pedido cliente premium: 22.98 * 2 + (1.45 - 1.45 * 0.2) = 47.12
        Pedido pcp1 = new Pedido(1, cp, a1, 2, LocalDateTime.now());
        datos.addPedido(pcp1);
        assertEquals(47.12, pcp1.precioEnvio(), 0.01);
    }
}