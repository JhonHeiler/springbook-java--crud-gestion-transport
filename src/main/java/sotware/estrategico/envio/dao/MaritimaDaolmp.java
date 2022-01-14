package sotware.estrategico.envio.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sotware.estrategico.envio.mapper.MaritimaMapper;
import sotware.estrategico.envio.mapper.TerrestreMapper;
import sotware.estrategico.envio.models.Maritima;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class MaritimaDaolmp implements MaritimaDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<MaritimaMapper> getMaritima(){
        String query = "FROM MaritimaMapper";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Maritima maritima = entityManager.find(Maritima.class, id);
        entityManager.remove(maritima);
    }
    @Override
    public void registrar(Maritima maritima) {
        entityManager.merge(maritima);
    }
}
