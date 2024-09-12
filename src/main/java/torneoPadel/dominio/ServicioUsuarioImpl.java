package torneoPadel.dominio;

import com.tallerwebi.dominio.Usuario;
import com.tallerwebi.infraestructura.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
    this.repositorioUsuario = repositorioUsuario;

    }

    @Override
    public List<Usuario> listarTodos() {
        return this.repositorioUsuario.listarTodos();
    }
}
