package sotware.estrategico.envio.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sotware.estrategico.envio.models.ProductoTerrestre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class ProductoTerrestreDaolmp implements ProductoTerrestreDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<ProductoTerrestre> getProductoTerrestre() {
        String query = "FROM ProductoTerrestre";
        return entityManager.createQuery(query).getResultList();
    }
}
