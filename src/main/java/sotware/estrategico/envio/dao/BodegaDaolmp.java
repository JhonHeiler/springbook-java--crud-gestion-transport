package sotware.estrategico.envio.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sotware.estrategico.envio.models.Bodega;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BodegaDaolmp implements BodegaDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Bodega> getBodega() {
        String query = "FROM Bodega";
        return entityManager.createQuery(query).getResultList();
    }
}
