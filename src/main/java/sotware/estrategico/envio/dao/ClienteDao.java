package sotware.estrategico.envio.dao;

import sotware.estrategico.envio.models.Cliente;


import java.util.List;

public interface ClienteDao {
    List<Cliente> getCliente();
    void eliminar(Long id);
    void registrar(Cliente cliente);
    Cliente obtenerClientePorCredenciales(Cliente cliente);

}
