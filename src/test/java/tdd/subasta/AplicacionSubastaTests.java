package tdd.subasta;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class AplicacionSubastaTests {


    @Test
    public void queSePuedaCrearUnaSubasta() {
        Subasta subasta = new Subasta();

        assertThat(subasta, notNullValue());
    }
}
