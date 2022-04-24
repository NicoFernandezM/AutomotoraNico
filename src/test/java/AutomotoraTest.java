import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AutomotoraTest {

    @Test
    public void añadirVendedorTest() {
        String[] rutIngresados = new String[]{"123456785", "hola", "201040388", "111111118"};
        Vendedor casoCorrecto = new Vendedor("Andrés", 45, "111111111");
        Automotora automotora = new Automotora();
        int count = 1;

        for (int i = 0; i < rutIngresados.length; i++) {
            int indiceRandom = (int) (Math.random() * 4);
            Vendedor v = new Vendedor("Juan", 37, rutIngresados[indiceRandom]);
            if (automotora.añadirVendedor(v)) {
                count++;
            }
        }

        for (Vendedor vendedor : automotora.getVendedores()) {
            assertTrue(DigitoVerificador.validarRut(vendedor.getRut()));
        }

        automotora.añadirVendedor(casoCorrecto);

        List<Vendedor> listaVendedores = automotora.getVendedores();
        assertTrue(listaVendedores.contains(casoCorrecto));

        assertEquals(listaVendedores.size(), count);
    }
}