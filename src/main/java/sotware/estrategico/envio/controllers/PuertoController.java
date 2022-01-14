package sotware.estrategico.envio.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sotware.estrategico.envio.dao.PuertoDao;
import sotware.estrategico.envio.models.Puerto;


import java.util.List;

@RestController
public class PuertoController {
    @Autowired
    private PuertoDao puerto;
    @RequestMapping(value = "api/puertos",method = RequestMethod.GET)
    public List<Puerto> getproductoTerrestreDao(){
        return puerto.getPuerto();
    }
}
