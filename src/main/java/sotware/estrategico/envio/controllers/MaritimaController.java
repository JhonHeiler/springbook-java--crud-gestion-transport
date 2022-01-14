package sotware.estrategico.envio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sotware.estrategico.envio.dao.MaritimaDao;
import sotware.estrategico.envio.mapper.MaritimaMapper;
import sotware.estrategico.envio.mapper.TerrestreMapper;
import sotware.estrategico.envio.models.Maritima;


import java.util.List;

@RestController
public class MaritimaController {
    @Autowired
    private MaritimaDao maritimaDao;
    @RequestMapping(value = "api/maritimas",method = RequestMethod.GET)
    public List<MaritimaMapper> getMaritima(){
        return maritimaDao.getMaritima();
    }

    @RequestMapping(value = "api/maritimas/{id}",method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        maritimaDao.eliminar(id);
    }

    @RequestMapping(value = "api/maritimas",method = RequestMethod.POST)
    public void registrarMaritima(@RequestBody Maritima maritima){
        maritimaDao.registrar(maritima);
    }
}
