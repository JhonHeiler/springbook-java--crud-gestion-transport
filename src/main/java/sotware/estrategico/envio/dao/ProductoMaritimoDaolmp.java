package sotware.estrategico.envio.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sotware.estrategico.envio.models.ProductoMaritimo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public  class ProductoMaritimoDaolmp implements ProductoMaritimoDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<ProductoMaritimo> getProductoMaritimo() {
        String query = "FROM ProductoMaritimo";
        return entityManager.createQuery(query).getResultList();
    }




}
