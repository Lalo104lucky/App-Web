package utez.edu.mx.Operacion_Diagnostico.model.dao;

import org.springframework.data.repository.CrudRepository;
import utez.edu.mx.Operacion_Diagnostico.model.entity.ClientesBean;

public interface ClientesDao extends CrudRepository<ClientesBean, Integer> {
}
