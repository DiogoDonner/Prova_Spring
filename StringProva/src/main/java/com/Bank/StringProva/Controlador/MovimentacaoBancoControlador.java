package com.Bank.StringProva.Controlador;

import com.Bank.StringProva.Entidade.MovimentacaoBanco;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoBancoControlador {

    private List<MovimentacaoBanco> list;

    public MovimentacaoBancoControlador(){

        MovimentacaoBanco m1 = new MovimentacaoBanco(1,2,"Saque",1000);
        MovimentacaoBanco m2 = new MovimentacaoBanco(2,1,"Deposito",500);
        MovimentacaoBanco m3 = new MovimentacaoBanco(3,1,"Deposito",1200);

        ArrayList<MovimentacaoBanco> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);

        this.list= list;

    }

    @GetMapping
    public List<MovimentacaoBanco> ListarMovimentacoes(){
        return list;
    }





}
