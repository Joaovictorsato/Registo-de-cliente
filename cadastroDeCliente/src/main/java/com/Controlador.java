
package com;

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class Controlador {
   
    @FXML
    private TextField nome;
    
    @FXML
    private TextField cep;
     
    @FXML
    private TextField rua;
    
    @FXML
    private TextField numeroDaCasa;
    
    @FXML
    private TextField cidade;
    
    @FXML
    private TextField estado;
    
    @FXML
    private TextField telefone;
   
    @FXML
    private void gravarCliente(){
        String nomeCliente = nome.getText();
        String cepCliente = cep.getText();
        String ruaCliente = rua.getText();
        String numero = numeroDaCasa.getText();
        String cidadeDoCliente = cidade.getText();
        String estadoDeResidencia = estado.getText();
        String telefoneCliente = telefone.getText();
        
        if(nomeCliente.isEmpty() || cepCliente.isEmpty()|| ruaCliente.isEmpty()||numero.isEmpty()||cidadeDoCliente.isEmpty()||estadoDeResidencia.isEmpty()||telefoneCliente.isEmpty()){
            Alerta("ERRO", "Todos os campos devem ser preenchidos.");
        } else{
            Endereco endereco = new Endereco(cepCliente, ruaCliente, numero, cidadeDoCliente, estadoDeResidencia);
            Cliente cliente = new Cliente(nomeCliente, endereco, telefoneCliente);
            ListaDeClientes.adicionarCliente(cliente);
            Alerta("Sucesso", "Cliente Registrado");
            ListaDeClientes.exibirClientes();
            limparCampo();
        }            
    }
    @FXML
    private void limparCampo(){
      nome.clear();
      cep.clear();
      rua.clear();
      numeroDaCasa.clear();
      cidade.clear();
      estado.clear();
      telefone.clear();    
    }
    @FXML
    private void buscarCep(){
        Buscador buscador = new Buscador();
        
        try {
            // Chame o método buscar e obtenha o endereço
            Endereco endereco = buscador.buscar(cep.getText());
            // Exiba os resultados
            rua.setText(endereco.getRua());
            cidade.setText(endereco.getCidade());
            estado.setText(endereco.getEstado());
            
           
        } catch (IllegalArgumentException e) {
             Alerta("ERRO", "Formato nao valido");
            //System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
             Alerta("ERRO", "CEP nao valido");
        } 
    }
    
    private void Alerta(String titulo, String mensagem){
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
