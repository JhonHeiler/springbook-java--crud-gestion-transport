package sotware.estrategico.envio.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sotware.estrategico.envio.dao.ClienteDao;
import sotware.estrategico.envio.models.Cliente;
import sotware.estrategico.envio.utils.JWTUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public List<String> login(@RequestBody Cliente cliente) {

        List<String> lista = new ArrayList<>();
        Cliente clienteLogueado = clienteDao.obtenerClientePorCredenciales(cliente);
        if (clienteLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(clienteLogueado.getId()), clienteLogueado.getEmail());
            lista.add(tokenJwt);
            lista.add(String.valueOf(clienteLogueado.getId()));
            return lista;
        }
        lista.add("FAIL");
        return lista;
    }




}
