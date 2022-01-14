package sotware.estrategico.envio.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name="maritima")
@ToString
@EqualsAndHashCode
public class Maritima {
    @Id
    @Getter @Setter @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter @Column(name="id_producto_maritimo")
    private Long id_producto_maritimo ;
    @Getter @Setter @Column(name="cantidad_producto")
    private int cantidad_producto ;
    @Getter @Setter @Column(name="fecha_registro")
    private String fecha_registro ;
    @Getter @Setter @Column(name="precio_envio")
    private double 	precio_envio ;
    @Getter @Setter @Column(name="numero_flota")
    private String 	numero_flota ;
    @Getter @Setter @Column(name="numero_guia")
    private String 	numero_guia ;
    @Getter @Setter @Column(name="id_cliente ")
    private Long id_cliente ;
    @Getter @Setter @Column(name="fecha_entrega")
    private String fecha_entrega ;

}
