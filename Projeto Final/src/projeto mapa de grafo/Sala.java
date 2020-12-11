/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomapadegrafo;

public class Sala {
    
    private String nome;
    
    private boolean visitado;
    
    private Item item;
    
    public Sala(int indice) {
        
        this.nome = "Sala " + indice;
        
        this.visitado = false;
        
        this.item = null;
        
    }
    
    public void insereItem(Item item) {
        
        this.item = item;
        
    }
    
    public Item retiraItem() {
        
        
        Item valorItem;
        
        valorItem = this.item;
        
        this.item = null;
        
        return valorItem;
            
    }
    
    public void recebeVisita() {
        
        this.visitado = true;
        
    }
    
    public String exibeNome() {
        
        return nome;
        
    }
    
    public boolean Visitado() {
        
        return visitado;
    }
    
}
