package sotware.estrategico.envio.models;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name="producto_maritimo")
@ToString
@EqualsAndHashCode
public class ProductoMaritimo {
    @Id
    @Getter @Setter @Column(name="id_producto_maritimo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter @Column(name="nombre")
    private String 	nombre ;
    @Getter @Setter @Column(name="id_puerto")
    private Long id_puerto ;
}
