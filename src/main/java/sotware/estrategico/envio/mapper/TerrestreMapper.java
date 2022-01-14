package sotware.estrategico.envio.mapper;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sotware.estrategico.envio.models.Cliente;
import sotware.estrategico.envio.models.ProductoTerrestre;
import javax.persistence.*;
@Entity
@Table(name="terrestre")
@ToString
@EqualsAndHashCode
public class TerrestreMapper {
    @Id
    @Getter @Setter @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = ProductoTerrestre.class)
    @Getter @Setter  @JoinColumn(name="id_producto_terrestre")
    private ProductoTerrestre productoTerrestre;
    @Getter @Setter @Column(name="cantidad_producto")
    private int cantidad_producto ;
    @Getter @Setter @Column(name="fecha_registro")
    private String fecha_registro ;
    @Getter @Setter @Column(name="precio_envio")
    private double 	precio_envio ;
    @Getter @Setter @Column(name="placa_vehiculo")
    private String 	placa_vehiculo ;
    @Getter @Setter @Column(name="numero_guia")
    private String 	numero_guia ;
    @ManyToOne(targetEntity = Cliente.class)
    @Getter @Setter @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @Getter @Setter @Column(name="fecha_entrega")
    private String fecha_entrega ;
}



