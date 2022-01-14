package sotware.estrategico.envio.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sotware.estrategico.envio.dao.ProductoMaritimoDao;
import sotware.estrategico.envio.models.ProductoMaritimo;

import java.util.List;

@RestController
public class ProductoMaritimoController {
    @Autowired
    private ProductoMaritimoDao productoMaritimoDao;
    @RequestMapping(value = "api/productoMaritimos",method = RequestMethod.GET)
    public List<ProductoMaritimo> getProductoMaritimo(){
        return productoMaritimoDao.getProductoMaritimo();
    }
}
