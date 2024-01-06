package utez.edu.mx.Operacion_Diagnostico.model.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClientesDto {

    private Integer id_cliente;
    private String nombre;
    private String apellidos;
    private String curp;
    private String fecha_nacimiento;
}
