/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomapadegrafo;

import java.lang.reflect.Array;

public class Pilha<T> {
    
    
    
    private T[] pilha;
    
    private int topo;
    
    private static final int TAMANHO_PADRAO = 10;
    
    public Pilha(Class<T> tipo) {
        
        pilha = (T[])Array.newInstance(tipo, TAMANHO_PADRAO);;
        topo = 0;
        
    }
    
    public Pilha(Class<T> tipo, int capacidade) {
        
        pilha = (T[])Array.newInstance(tipo, capacidade);
        topo = 0;
        
    }
    
    public void empilha(T valor) {
        
        if (topo == pilha.length) {
            
          throw new IndexOutOfBoundsException("Tentando inserir em pilha lotada.");
        }
        
        pilha[topo] = valor;
        
        topo++;
        
    }
    
    public T desempilha() {
        
       if(topo == 0) {
           throw new ArrayIndexOutOfBoundsException("Tentando remover de pilha vazia.");
       }
       
       T valor = pilha[topo-1];
       pilha[topo - 1] = null;
       topo--;
       
       return valor;
    }
    
    
    public T peek() {
        
       if(topo == 0) {
           throw new ArrayIndexOutOfBoundsException("Tentando remover da pilha vazia.");
       }
       
       T valor = pilha[topo-1];
       
       return valor;
        
    }
    
    public int tamanho() {
        return topo;
    }
    
    public int capacidade() {
        return pilha.length;
    }
    
    public int capacidadeRestante() {
        
        int result = pilha.length - topo;
        
        return result;
    }
    
    public void limpar() {
        
        for (int i = 0; i < pilha.length; i++) {
            
            pilha[i] = null;
            
        }
        
        topo = 0;
        
    }
    
    @Override
    public String toString() {
        
        String toPrint = " [ ";
        
        for(int i = topo; i > 0; i--) {
            
            if(i - 1 != 0) {
                
                toPrint += pilha[i - 1] + " , ";
                
            } else {
                
                toPrint += pilha[i - 1] + " ] ";
            }
            
        }
        
        return toPrint;
        
    }
    
}
