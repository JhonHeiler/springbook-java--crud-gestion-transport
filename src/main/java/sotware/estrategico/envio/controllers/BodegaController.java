package sotware.estrategico.envio.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sotware.estrategico.envio.dao.BodegaDao;
import sotware.estrategico.envio.models.Bodega;



import java.util.List;

@RestController
public class BodegaController {
    @Autowired
    private BodegaDao bodega;
    @RequestMapping(value = "api/bodegas",method = RequestMethod.GET)
    public List<Bodega> getproductoTerrestreDao(){
        return bodega.getBodega();
    }
}
