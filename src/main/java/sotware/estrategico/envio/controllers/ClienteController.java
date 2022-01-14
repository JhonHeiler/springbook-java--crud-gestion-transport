package sotware.estrategico.envio.controllers;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sotware.estrategico.envio.dao.ClienteDao;
import sotware.estrategico.envio.models.Cliente;


import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteDao clienteDao;
    @RequestMapping(value = "api/clientes",method = RequestMethod.GET)
    public List<Cliente> getCliente(){
        return clienteDao.getCliente();
    }

    @RequestMapping(value = "api/clientes/{id}",method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        clienteDao.eliminar(id);
    }


    @RequestMapping(value = "api/clientes",method = RequestMethod.POST)
    public void registrarCliente(@RequestBody Cliente cliente){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024,1, cliente.getPassword());
        cliente.setPassword(hash);

        clienteDao.registrar(cliente);
    }
}
