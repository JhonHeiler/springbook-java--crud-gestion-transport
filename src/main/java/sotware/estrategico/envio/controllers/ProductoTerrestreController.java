package sotware.estrategico.envio.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sotware.estrategico.envio.dao.ProductoTerrestreDao;
import sotware.estrategico.envio.models.ProductoTerrestre;


import java.util.List;

@RestController
public class ProductoTerrestreController {
    @Autowired
    private ProductoTerrestreDao productoTerrestreDao;
    @RequestMapping(value = "api/productoTerrestres",method = RequestMethod.GET)
    public List<ProductoTerrestre> getproductoTerrestreDao(){
        return productoTerrestreDao.getProductoTerrestre();
    }
}
