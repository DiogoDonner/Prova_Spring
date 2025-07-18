package com.Bank.StringProva.Controlador;

import com.Bank.StringProva.Entidade.ClienteBanco;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/clientes")
public class ClienteBancoControlador {

    private List<ClienteBanco> list;
    Random random = new Random();

        public ClienteBancoControlador() {
            ClienteBanco cliente1 = new ClienteBanco(1, "Deivid", "Golias");
            ClienteBanco cliente2 = new ClienteBanco(2, "Heleno", "Matias");

            ArrayList<ClienteBanco> list = new ArrayList<>();
            list.add(cliente1);
            list.add(cliente2);
            this.list = list;

        }
    @GetMapping
    public List<ClienteBanco> ListarClientes(){
        return list;
    }

    @PostMapping("/addcliente")
    public ClienteBanco criarCliente(@RequestBody ClienteBanco novoCliente) {
        novoCliente.setId(random.nextInt(10000));
        list.add(novoCliente);
        return novoCliente;
    }

    @PutMapping("/atualizarcliente/{id}")
    public ClienteBanco atualizarCliente(@PathVariable int id, @RequestBody ClienteBanco atualizado) {
        for (ClienteBanco cliente : list) {
            if (cliente.getId() == id) {
                cliente.setNome(atualizado.getNome());
                cliente.setSobrenome(atualizado.getSobrenome());
                return cliente;
            }
        }
        return null;
    }

    }




