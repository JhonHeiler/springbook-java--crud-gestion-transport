package sotware.estrategico.envio.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sotware.estrategico.envio.models.Puerto;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PuertoDaolmp implements PuertoDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Puerto> getPuerto() {
        String query = "FROM Puerto";
        return entityManager.createQuery(query).getResultList();
    }
}
