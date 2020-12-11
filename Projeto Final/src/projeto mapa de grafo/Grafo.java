package projetomapadegrafo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
    
    private int[][] adj;        // matriz de adjacências
    private int numVertices;    // número de vértices
    private int numArestas;     // número de arestas
    
    // arrays usados para a busca em largura (BFS)
    private int[] pai;
    private int[] dist;
    
    private Sala[] salas;
    
    private Personagem personagem;
    
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.adj = new int[numVertices][numVertices];
        this.numArestas = 0;
        
        this.pai = new int[numVertices];
        this.dist = new int[numVertices];
        
        this.salas = new Sala[numVertices];
        
        for (int i = 0; i < numVertices; i++) {
            this.salas[i] = new Sala(i); 
        }
        
    }
    
    public Fila<String> posicionaPersonagem(int X) {
     
        if(this.personagem != null) {
            
            this.personagem.Posicionar(this.salas[X]);
            
        } else {
            
            this.personagem = new Personagem(this.salas[X]);
            
        }
        
        return this.salasProximas(X);
        
    }
    
    public Fila<String> moverPersonagem(int X) {
        
        if (this.dist.length > X && this.dist[X] == 1) {
            
            return this.posicionaPersonagem(X);
            
        }
        
        return null;
    } 
    
    public Fila<String> salasProximas(int X) {
     
        this.BFS(X);
        
        int cont = 0;
        
        Fila<String> nomes = null;
        
        for(int i = 0; i < this.dist.length; i++) {
            
            if(dist[i] == 1) {
                
                cont++;
                
            }
            
        }
        
        if(cont > 0) {
        
            nomes = new Fila(String.class, cont);
        
            for(int i = 0; i < this.dist.length; i++) {
            
                if(dist[i] == 1) {
                    
                    nomes.insere(this.salas[i].exibeNome());
                    
                }
                
            }
        
        }
        
       return nomes;
        
    }
    
    public int tamanho() {
        return numVertices;
    }
    
    public boolean vizinhos(int u, int v) {
        return (adj[u][v] == 1);
    }
    
    /* Esse método recebe o rótulo de dois vértices, u e v.
        Se ainda não existe aresta u-v, adiciona essa aresta e
    retorna tru.
        Se já existe a aresta u-v, retorna false sem fazer
    modificações na matriz.
    */
    public boolean adicionaAresta(int u, int v) {
       if (vizinhos(u, v)) {
           return false;    // não faço nada!
       }
       adj[u][v] = 1;
       adj[v][u] = 1;
       numArestas++;
       return true; // operação foi bem-sucedida
    }
    
    public void adicionaItem(int X, String s) {
       
        this.salas[X].insereItem(new Item(s));
        
    }
    
    public Personagem Personagem() {
        
        return this.personagem;
        
    }
    
    /* Realiza a Busca em Largura (BFS -- Bradth-First Search)
       começando por um vértice de rótulo s */
    public void BFS(int s) {
        for (int v = 0; v < numVertices; v++) {
            pai[v] = -1;    // "não inicializado"
            dist[v] = -1;   // "não inicializado"
        }
        
        Fila<Integer> F = new Fila(Integer.class, numVertices);
        
        dist[s] = 0;
        pai[s] = s;
        F.insere(s);
        
        while (F.tamanho() > 0) {
            // removo da fila um vértice que será processado nessa
            // iteração do loop
            int u = (int) F.remove();
            for (int v = 0; v < numVertices; v++) {
                // se u e v são vizinhos e vértice v ainda não descoberto,
                // então o u acabou de descobrir o vértice v!
                if (vizinhos(u, v) && pai[v] == -1) {
                    pai[v] = u;
                    dist[v] = 1 + dist[u];
                    F.insere(v);
                }
            }
        }
    }
    
    Grafo() {
        // construtor do grafo
    }
        
    public int[] pai() {
        return pai;
    }
    
    public int[] dist() {
        return dist;
    }
    
    public String imprimePai() {
        
        String toPrint = " [ ";
        
        for (int i = 0; i < pai.length; i++){
            
          if( i + 1 != pai.length) {
              
              toPrint += pai[i] + " , ";
              
          } else {
              
              toPrint += pai[i];
              
          }
          
        }
        
        toPrint += " ] ";
        
        return toPrint;
    }
    
    public String imprimeDist() {
        
        String toPrint = " [ ";
        
        for (int i = 0; i < dist.length; i++){
            
            if( i + 1 != dist.length) {
                
                toPrint += dist[i] + " , ";
            
            } else {
            
                toPrint += dist[i];
            
            }
        }
        
        toPrint += " ] ";
        
        return toPrint;
        
    }
    
}
