package sotware.estrategico.envio.dao;

import sotware.estrategico.envio.mapper.MaritimaMapper;
import sotware.estrategico.envio.models.Maritima;


import java.util.List;

public interface MaritimaDao {
    List<MaritimaMapper> getMaritima();
    void eliminar(Long id);
    void registrar(Maritima maritima);


}
