package utez.edu.mx.Operacion_Diagnostico.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Operacion_Diagnostico.model.dto.ClientesDto;
import utez.edu.mx.Operacion_Diagnostico.model.entity.ClientesBean;
import utez.edu.mx.Operacion_Diagnostico.service.impl.ClientesImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1")
@RestController
@AllArgsConstructor
public class ClientesController {

    private final ClientesImpl clientesService;

    @PostMapping("/clientes")
    public ClientesDto create(@RequestBody ClientesDto clientesDto){
        ClientesBean clientesSave = clientesService.save(clientesDto);
        return clientesDto.builder()
                .id_cliente(clientesSave.getId_cliente())
                .nombre(clientesSave.getNombre())
                .apellidos(clientesSave.getApellidos())
                .curp(clientesSave.getCurp())
                .fecha_nacimiento(clientesSave.getFecha_nacimiento())
                .build();
    }

    @PutMapping("/clientes")
    public ClientesDto update(@RequestBody ClientesDto clientesDto){
        ClientesBean clientesUpdate = clientesService.save(clientesDto);
        return clientesDto.builder()
                .id_cliente(clientesUpdate.getId_cliente())
                .nombre(clientesUpdate.getNombre())
                .apellidos(clientesUpdate.getApellidos())
                .curp(clientesUpdate.getCurp())
                .fecha_nacimiento(clientesUpdate.getFecha_nacimiento())
                .build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            ClientesBean clientes = clientesService.findById(id);
            clientesService.delete(clientes);
            return new ResponseEntity<>(clientes, HttpStatus.NO_CONTENT);
        } catch (DataAccessException daex){
            response.put("mensaje", daex.getMessage());
            response.put("Clientes", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clientes/{id}")
    public ClientesBean findById(@PathVariable Integer id){
        return clientesService.findById(id);
    }

    @GetMapping("/clientes")
    public List<ClientesBean> findAll(){
        return clientesService.findAll();
    }

}
