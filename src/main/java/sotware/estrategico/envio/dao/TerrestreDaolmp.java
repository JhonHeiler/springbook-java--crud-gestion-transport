package sotware.estrategico.envio.dao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sotware.estrategico.envio.mapper.TerrestreMapper;
import sotware.estrategico.envio.models.Terrestre;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TerrestreDaolmp implements TerrestreDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<TerrestreMapper> getTerrestre(){
        String query = "FROM TerrestreMapper";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {
        Terrestre terrestre = entityManager.find(Terrestre.class, id);
        entityManager.remove(terrestre);
    }
    @Override
    public void registrar(Terrestre terrestre) {
        entityManager.merge(terrestre);
    }


    @Override
    public Terrestre mostrarTerrestre(Long id){
        Terrestre terrestre = entityManager.find(Terrestre.class, id);
        return terrestre;
    }
    @Override
    public void actualizarTerrestre(Terrestre terrestre) {
        String query = "UPDATE Terrestre SET id_producto_terrestre = :id_producto_terrestre, cantidad_producto = :cantidad_producto, fecha_registro = :fecha_registro, precio_envio = :precio_envio, placa_vehiculo = :placa_vehiculo, numero_guia = :numero_guia, fecha_entrega =: fecha_entrega   WHERE id = :id";
        entityManager.createQuery(query)
                .setParameter("id_producto_terrestre", terrestre.getId_producto_terrestre())
                .setParameter("cantidad_producto", terrestre.getCantidad_producto())
                .setParameter("fecha_registro", terrestre.getFecha_registro())
                .setParameter("precio_envio", terrestre.getPrecio_envio())
                .setParameter("placa_vehiculo", terrestre.getPlaca_vehiculo())
                .setParameter("numero_guia", terrestre.getNumero_guia())
                .setParameter("fecha_entrega", terrestre.getFecha_entrega())
                .setParameter("id", terrestre.getId())
                .executeUpdate();
    }
}
