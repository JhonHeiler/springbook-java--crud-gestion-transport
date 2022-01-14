package sotware.estrategico.envio.models;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name="producto_terrestre")
@ToString
@EqualsAndHashCode
public class ProductoTerrestre {
    @Id
    @Getter @Setter @Column(name="id_producto_terrestre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter @Column(name="nombre")
    private String 	nombre ;
    @Getter @Setter @Column(name="id_bodega")
    private Long id_bodega ;
}
