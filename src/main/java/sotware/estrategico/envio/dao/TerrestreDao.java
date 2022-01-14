package sotware.estrategico.envio.dao;

import sotware.estrategico.envio.mapper.TerrestreMapper;
import sotware.estrategico.envio.models.Terrestre;

import java.util.List;

public interface TerrestreDao {
    List<TerrestreMapper> getTerrestre();
    void eliminar(Long id);
    void registrar(Terrestre terrestre);
    void actualizarTerrestre(Terrestre terrestre);
    Terrestre mostrarTerrestre(Long id);
}
