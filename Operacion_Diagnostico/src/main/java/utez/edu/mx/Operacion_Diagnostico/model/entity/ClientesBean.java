package utez.edu.mx.Operacion_Diagnostico.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "clientes")
public class ClientesBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "curp", nullable = false, unique = true)
    private String curp;
    @Column(name = "fecha_nacimiento", nullable = false)
    private String fecha_nacimiento;
}
