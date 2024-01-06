package utez.edu.mx.Operacion_Diagnostico.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.Operacion_Diagnostico.model.dao.ClientesDao;
import utez.edu.mx.Operacion_Diagnostico.model.dto.ClientesDto;
import utez.edu.mx.Operacion_Diagnostico.model.entity.ClientesBean;
import utez.edu.mx.Operacion_Diagnostico.service.IClientes;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientesImpl implements IClientes {

    private final ClientesDao clientesDao;

    @Transactional
    @Override
    public ClientesBean save(ClientesDto clientesDto){
        ClientesBean clientes = ClientesBean.builder()
                .id_cliente(clientesDto.getId_cliente())
                .nombre(clientesDto.getNombre())
                .apellidos(clientesDto.getApellidos())
                .curp(clientesDto.getCurp())
                .fecha_nacimiento(clientesDto.getFecha_nacimiento())
                .build();
        return clientesDao.save(clientes);
    }

    @Transactional
    @Override
    public ClientesBean findById(Integer id){
        return clientesDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(ClientesBean clientesBean){
        clientesDao.delete(clientesBean);
    }

    @Transactional
    @Override
    public List<ClientesBean> findAll(){
        return (List<ClientesBean>) clientesDao.findAll();
    }

}
