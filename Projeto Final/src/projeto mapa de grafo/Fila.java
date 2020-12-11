/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomapadegrafo;

import java.lang.reflect.Array;
import java.util.*;


public class Fila<T> {
    private T[] fila;    // guarda os dados inseridos na estrutura
    private int ini;        // índice do início da fila
    private int fim;        // índice do fim da fila
    private int tamanho;    // número de elementos atualmente presentes na estrutura
    
    /*
    Construtor da classe Fila. Recebe a capacidade da esturutra, isto é, quantos
    elementos podem estar armazenados de uma só vez, no máximo.
    */
    public Fila(Class<T> tipo, int capacidade) {
        fila = (T[])Array.newInstance(tipo, capacidade); // onde armazena os valores
        ini = 0;    // linha opcional --> Java inicializa int com 0
        fim = -1;
        tamanho = 0;
    }
    
    /*
    Recebe um novo dado para armazenar na fila. Insere no fim da fila
    Lança uma exception se a fila já estiver cheia.
    */
    public void insere(T novo) {
        if (tamanho == fila.length) {
            throw new IndexOutOfBoundsException("Tentando inserir em fila lotada.");
        }
        tamanho++;
        fim++;
        if (fim == fila.length) fim = 0;
        // ou:
        //fim = fim + 1 % fila.length;
        fila[fim] = novo;
    }
    
    /*
    Remove o elemento que está no início da fila e o retorna.
    Lança uma exception se a fila estiver vazia.
    */
    public T remove() {
        if (tamanho == 0)
            throw new IndexOutOfBoundsException("Tentando remover da fila vazia.");;
        T removido = fila[ini];
        ini++;
        if (ini == fila.length) ini = 0;
        tamanho--;
        return removido;
    }
    
    /* 
    Retorna o elemento que está no início da fila.
    Se a fila estiver vazia, lança uma exception.
    */
    public T inicio() {
        if (tamanho == 0)
            throw new IndexOutOfBoundsException("Tentando acessar início de fila vazia.");;
        return fila[ini];
    }
    
    /*
    Retorna o número de elementos presentes na estrutura.
    */
    public int tamanho() {
        return tamanho;
    }
    
    @Override
    public String toString() {
        
        String toPrint = " [ ";
        
        for (int i = 0; i < tamanho; i++){
            
            if(i + 1 != tamanho) {
                
                toPrint += fila[i] + " , ";
                
            } else {
                
                toPrint += fila[i];
                
            }
            
            
        }
        
        toPrint += " ] ";
        
        return toPrint;
    }
    
}
