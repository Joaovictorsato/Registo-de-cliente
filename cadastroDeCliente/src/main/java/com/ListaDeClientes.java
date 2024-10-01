
package com;

import java.util.ArrayList;
import java.util.List;

public class ListaDeClientes {
    private static List<Cliente> listaClientes = new ArrayList<>();
    
    public static void adicionarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    
    public static void exibirClientes(){
        for(Cliente cliente: listaClientes){
            System.out.println(cliente.toString());
        }
    }
}
