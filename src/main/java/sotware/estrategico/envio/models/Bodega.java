package sotware.estrategico.envio.models;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name="bodega")
@ToString
@EqualsAndHashCode
public class Bodega {
    @Id
    @Getter @Setter @Column(name="id_bodega")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter @Column(name="nombre")
    private String 	nombre ;
    @Getter @Setter @Column(name="id_localizacion")
    private Long id_localizacion;
}
