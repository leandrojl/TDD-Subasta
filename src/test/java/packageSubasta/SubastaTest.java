package packageSubasta;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class SubastaTest {

    Subasta subasta;

    @BeforeEach
    public void setUp() {
        this.subasta = new Subasta();

    }

    @Test
    public void queSePuedaCrearUnaSubasta() {
        Subasta subasta = new Subasta();

        assertThat(subasta, notNullValue());
    }

    @Test
    public void queSePuedaCrearUnaSubastaConNombre() {
        Subasta subasta = new Subasta("Subasta 1");

        String nombre = subasta.getNombre();

        assertThat(nombre, notNullValue());
    }

    @Test
    public void queSePuedaCrearUnaSubastaConNombreYTiempo() {
        Subasta subasta = new Subasta("Subasta 1",2.00);

        String nombre = subasta.getNombre();
        Double tiempo = subasta.getTiempo();

        assertThat(nombre, is("Subasta 1"));
        assertThat(tiempo, is(2.00));
    }


}
