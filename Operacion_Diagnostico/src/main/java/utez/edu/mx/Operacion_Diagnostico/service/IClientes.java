package utez.edu.mx.Operacion_Diagnostico.service;

import utez.edu.mx.Operacion_Diagnostico.model.dto.ClientesDto;
import utez.edu.mx.Operacion_Diagnostico.model.entity.ClientesBean;

import java.util.List;

public interface IClientes {

    ClientesBean save(ClientesDto clientesDto);

    ClientesBean findById(Integer id);

    void delete(ClientesBean clientesBean);

    List<ClientesBean> findAll();

}
