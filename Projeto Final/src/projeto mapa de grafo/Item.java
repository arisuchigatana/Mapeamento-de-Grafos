/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomapadegrafo;

public class Item {
 
    private String nome;
    
    private double peso;

    public Item(String nome) {
        
        this.nome = nome;
        
    }
    
    public String getNome() {
        
        return nome;
        
    }
    
    @Override
    public String toString() {
        
        return nome;
    }
    
    public String exibeItem() {
        
        String toPrint = " [ ";
        
        toPrint += nome + " , " + peso + " ]";
        
        return toPrint;
        
    }
    
}
