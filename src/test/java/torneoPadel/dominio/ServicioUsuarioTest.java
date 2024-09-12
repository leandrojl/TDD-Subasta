package torneoPadel.dominio;

import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.infraestructura.RepositorioUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioUsuarioTest {

    private ServicioUsuario servicioUsuario;
    private RepositorioUsuario repositorioUsuario;

   @BeforeEach
    public void setUp() throws Exception {
        this.repositorioUsuario =  mock(RepositorioUsuario.class);
        this.servicioUsuario =  new ServicioUsuarioImpl(repositorioUsuario);
   }

    @Test
    public void siNoHayUsuariosDeberiaDevolverUnaLista(){

       dadoQueNoHayUsuariosCreados();
       List<Usuario> listado = cuandoConsultoTodosLosUsuarios();
       entoncesObtengoUnaListaVacia(listado);

    }

    private void dadoQueNoHayUsuariosCreados() {
       when(repositorioUsuario.listarTodos()).thenReturn(new LinkedList<Usuario>());
    }

    private List<Usuario> cuandoConsultoTodosLosUsuarios() {
       return servicioUsuario.listarTodos();
    }

    private void entoncesObtengoUnaListaVacia(List<Usuario> listado){
       assertThat(listado, empty());
    }

}
