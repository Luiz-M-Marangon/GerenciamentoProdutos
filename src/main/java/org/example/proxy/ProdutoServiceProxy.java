package org.example.proxy;

import org.example.model.Usuario;

public class ProdutoServiceProxy implements ProdutoService{

    private ProdutoService realService;
    private Usuario usuario;


    public ProdutoServiceProxy(ProdutoService realService, Usuario usuario){
        this.realService = realService;
        this.usuario = usuario;
    }

    @Override
    public void alterarPreco(int id, double novoPreco){
        System.out.println("Verificando permissões de usuário...");

        if (usuario.isGerente()){
            System.out.println("Permissão Concedida.");
            realService.alterarPreco(id, novoPreco);
        } else{
            System.out.println("Permissão negada: Usuário não é gerente.");
        }
    }
}