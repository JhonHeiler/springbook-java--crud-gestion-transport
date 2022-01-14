package sotware.estrategico.envio.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name="cliente")
@ToString
@EqualsAndHashCode
public class Cliente {
    @Id
    @Getter @Setter @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter @Column(name="nombre")
    private String 	nombre ;
    @Getter @Setter @Column(name="email")
    private String 	email ;
    @Getter @Setter @Column(name="password")
    private String 	password ;
}
