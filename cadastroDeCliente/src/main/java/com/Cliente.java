
package com;

public class Cliente {
    private static int codigoContador = 1;
    
    private int codigo;
    private String nome;
    private Endereco endereco;
    private String telefone;
    
    public Cliente(){  
        this.codigo =codigoContador++;
        this.nome ="";
        this.endereco = new Endereco();
        this.telefone = "";
        
    }
    public Cliente(String nome, Endereco endereco, String telefone){
        this.codigo = codigoContador++;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco.toString();
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
 
    @Override
    public String toString(){
        return "Cliente: "+this.codigo + " nome: "+ this.nome + " endereco: "+getEndereco() +" telefone: "+this.telefone;
    }
    
}
