package com.Bank.StringProva.Controlador;

import com.Bank.StringProva.Entidade.ClienteBanco;
import com.Bank.StringProva.Entidade.ContaBanco;
import com.Bank.StringProva.Entidade.MovimentacaoBanco;
import com.Bank.StringProva.Entidade.Operacao;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/contas")
public class ContaBancoControlador {

    List<ContaBanco> list;
    List<ClienteBanco>clientes;
    List<MovimentacaoBanco> listaMovimentacoes1;
    List<MovimentacaoBanco> listaMovimentacoes2;
    Random random = new Random();

    public ContaBancoControlador(){
        MovimentacaoBanco m1 = new MovimentacaoBanco(1,2,"Saque",1000);
        MovimentacaoBanco m2 = new MovimentacaoBanco(2,1,"Deposito",500);
        MovimentacaoBanco m3 = new MovimentacaoBanco(3,1,"Deposito",1200);

        ArrayList<ContaBanco> list = new ArrayList<>();
        ArrayList<ClienteBanco> clientes = new ArrayList<>();
        ArrayList<MovimentacaoBanco> listaMovimentacoes2 = new ArrayList<>();
        listaMovimentacoes2.add(m1);
        ArrayList<MovimentacaoBanco> listaMovimentacoes1 = new ArrayList<>();
        listaMovimentacoes1.add(m2);
        listaMovimentacoes1.add(m3);

        ClienteBanco cliente1 = new ClienteBanco(1, "Deivid", "Golias");
        ClienteBanco cliente2 = new ClienteBanco(2, "Heleno", "Matias");
        clientes.add(cliente1);
        clientes.add(cliente2);

        ContaBanco c1 = new ContaBanco(1,cliente1,1000,listaMovimentacoes1);
        ContaBanco c2 = new ContaBanco(2,cliente2,500,listaMovimentacoes2);
        list.add(c1);
        list.add(c2);

        this.list = list;
        this.clientes=clientes;
        this.listaMovimentacoes1=listaMovimentacoes1;
        this.listaMovimentacoes2=listaMovimentacoes2;

    }

    @GetMapping
    public List<ContaBanco> ListarContas(){
        return list;
    }

    @GetMapping("/clientes")
    public List<ClienteBanco> ListarClientes(){
        return clientes;
    }

    @GetMapping("/{id}/saldo")
    public Double getSaldo(@PathVariable int id) {
        for (ContaBanco conta : list) {
            if (conta.getId() == id) {
                return conta.getSaldo();
            }
        }
        return null;
    }
    @GetMapping("/{id}/movimentacoes")
    public List<MovimentacaoBanco> getMovimentacoes(@PathVariable int id) {
        for (ContaBanco conta : list) {
            if (conta.getId() == id) {
                return conta.getMovimentacoes();
            }
        }
        return null;
    }

    @GetMapping("/{id}/movimentacoes/{idMov}/detalhes")
    public MovimentacaoBanco getMovimentacao(@PathVariable int id, @PathVariable int idMov) {
        for (ContaBanco conta : list) {
            if (conta.getId() == id) {
                for (MovimentacaoBanco mov : conta.getMovimentacoes()) {
                    if (mov.getId() == idMov) {
                        return mov;
                    }
                }
            }
        }
        return null;
    }

    @PostMapping("/addcliente")
    public ClienteBanco criarCliente(@RequestBody ClienteBanco novoCliente) {
        novoCliente.setId(random.nextInt(10000));
        clientes.add(novoCliente);
        return novoCliente;
    }

    @PutMapping("/atualizarcliente/{id}")
    public ClienteBanco atualizarCliente(@PathVariable int id, @RequestBody ClienteBanco atualizado) {
        for (ClienteBanco cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNome(atualizado.getNome());
                cliente.setSobrenome(atualizado.getSobrenome());
                return cliente;
            }
        }
        return null;
    }

    @PostMapping("/addconta")
    public ContaBanco criarConta(@RequestBody ContaBanco conta) {
        for (ClienteBanco cliente : clientes) {
            if (cliente.getId().equals(conta.getCliente().getId())) {
                ContaBanco novaConta = new ContaBanco(
                        random.nextInt(10000),
                        cliente,
                        conta.getSaldo(),
                        conta.getMovimentacoes() != null ? conta.getMovimentacoes() : new ArrayList<>()
                );
                this.list.add(novaConta);
                return novaConta;
            }
        }
        return null;
    }

    @PostMapping("/depositar/{id}")
    public String Depositar(@PathVariable int id, @RequestBody Operacao dto) {
        double valor = dto.getValor();

        for (ContaBanco conta : list) {
            if (conta.getId() == id) {
                conta.setSaldo(conta.getSaldo() + valor);

                MovimentacaoBanco mov = new MovimentacaoBanco(
                        random.nextInt(10000),
                        id,
                        "Deposito",
                        valor
                );

                conta.getMovimentacoes().add(mov);
                return "Depósito realizado com sucesso.";
            }
        }
        return null;
    }
    @PostMapping("/sacar/{id}")
    public String Sacar(@PathVariable int id, @RequestBody Operacao dto) {
        double valor = dto.getValor();
        for (ContaBanco conta : list) {
            if (conta.getId() == id) {
                conta.setSaldo(conta.getSaldo() - valor);

                MovimentacaoBanco mov = new MovimentacaoBanco(
                        random.nextInt(10000),
                        id,
                        "Saque",
                        valor
                );

                conta.getMovimentacoes().add(mov);
                return "Saque realizado com sucesso.";
            }
        }
        return null;
    }







}
