/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomapadegrafo;

public class Personagem {
    
    private double capacidade;
    
    private Fila<String> historico;
    
    private Pilha<Item> colecao;
    
    private Sala localizacao; 
    
    public void Posicionar(Sala sala) {
        
        this.localizacao = sala;
        
        this.localizacao.recebeVisita();
        
        Item item = this.localizacao.retiraItem();
        
        if(item != null) {
            
            this.colecao.empilha( item );
            
        }
        
        String nome = this.localizacao.exibeNome();
        
        this.historico.insere(nome);
        
    }
    
    public Personagem(Sala sala) {
        
        this.colecao = new Pilha(Item.class);
        
        this.historico = new Fila(String.class, 1000);
        
        this.Posicionar(sala);
        
    }
    
    public String localizacaoAtual() {
        
       return this.localizacao.exibeNome();
        
    }
    
    public String exibirColecao() {
        
        return this.colecao.toString();
        
    }
    
    public String exibirHistorico() {
        
        return this.historico.toString();
        
    }
    
}
