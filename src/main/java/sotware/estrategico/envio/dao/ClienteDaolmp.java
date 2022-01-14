package sotware.estrategico.envio.dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sotware.estrategico.envio.models.Cliente;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ClienteDaolmp implements ClienteDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Cliente> getCliente(){
        String query = "FROM Cliente";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
        // PRUEBA
    }


    @Override
    public void registrar(Cliente cliente) {
        entityManager.merge(cliente);
    }
    @Override
    public Cliente obtenerClientePorCredenciales(Cliente cliente) {
        String query = "FROM Cliente WHERE email = :email";
        List<Cliente> lista = entityManager.createQuery(query)
                .setParameter("email", cliente.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, cliente.getPassword())) {
            return lista.get(0);
        }
        return null;
    }

}
