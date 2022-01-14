package sotware.estrategico.envio.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sotware.estrategico.envio.dao.TerrestreDao;
import sotware.estrategico.envio.mapper.TerrestreMapper;
import sotware.estrategico.envio.models.Terrestre;


import java.util.List;

@RestController
public class TerrestreController {
    @Autowired
    private TerrestreDao terrestreDao;
    @RequestMapping(value = "api/terrestres",method = RequestMethod.GET)
    public List<TerrestreMapper> getTerrestre(){
        return terrestreDao.getTerrestre();
    }

    @RequestMapping(value = "api/terrestres/{id}",method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        terrestreDao.eliminar(id);
    }

    @RequestMapping(value = "api/terrestres",method = RequestMethod.POST)
    public void registrarTerrestre(@RequestBody Terrestre terrestre){
        terrestreDao.registrar(terrestre);
    }

    @RequestMapping(value = "api/mostrarTerrestre/{id}",method = RequestMethod.GET)
    public Terrestre mostrarTerrestre( @PathVariable Long id){
        return terrestreDao.mostrarTerrestre(id);
    }

    @RequestMapping(value = "api/ediTerrestres",method = RequestMethod.PUT)
    public void editUsuario(@RequestBody Terrestre terrestre){
        terrestreDao.actualizarTerrestre(terrestre);
    }
}
