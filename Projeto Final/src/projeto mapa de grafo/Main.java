package projetomapadegrafo;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Grafo grafo = Estrutura.grafo;
        
        String input = "";
        
        Scanner ler = new Scanner(System.in);
        
        while(!input.equals("F")) {
            
            // Parte 1:
            System.out.println("G. para criar um grafo: ");
            System.out.println("A. para adicionar aresta: ");
            System.out.println("I. para adicionar item na aresta especificada: ");
            
            // Parte 2:
            System.out.println("P. Posiciona personagem na vértice especificada: ");
            System.out.println("M. Personagem se desloca usando o menor caminho, até a vértice especificada: ");
            System.out.println("C. Mostra os itens que o personagem pegou em ordem: ");
            
            // Leitura de comandos pelo arquivo
            System.out.println("R. Ativa leitura de Arquivo de Instruções");
            
            System.out.println("F. Encerra o programa.");
            
            System.out.print("Informe a operação desejada: ");
            input = ler.nextLine();
            
            input = input.toUpperCase();
            
            int X, Y;
            Fila<String> salas;
            
            switch (input) {
                
                case "G":
                    
                    System.out.println("Informe a quantidade de vértices do grafo: ");
                    int N = ler.nextInt();

                    grafo = new Grafo(N);
                    
                    break;
                    
                case "A":
                
                    System.out.println("Informe o primeiro vértice a ser adjacente:");
                    X = ler.nextInt();

                    System.out.println("Informe o segundo vértice a ser adjacente:");
                    Y = ler.nextInt();

                    grafo.adicionaAresta(X, Y);
                    
                    System.out.println("\nAresta entre os vértices " 
                        + X + " e " + Y +
                        " criada com sucesso!\n ");
                    
                    break;
                    
                case "I":
                    
                    System.out.println("Informe a aresta em que irá adicionar o item: ");
                    X = ler.nextInt();

                    System.out.println("Qual item irá adicionar? ");
                    String item = ler.nextLine();

                    grafo.adicionaItem(X, item);
                    
                    System.out.println("Um " + item + " foi inserido na Sala " + X);
                    
                    break;
                    
                case "P":
                    
                    System.out.println("Vértice que o personagem será deslocado: ");
                    X = ler.nextInt();
                
                    salas = grafo.posicionaPersonagem(X);
                    
                    System.out.println("\nSalas disponíveis para passar:\n" 
                            + salas.toString());
                    
                    break;
                    
                case "M":
                    
                    System.out.println("Informe um vértice para ser percorrido:");
                    X = ler.nextInt();
                
                    salas = grafo.moverPersonagem(X);
                    
                    System.out.println("\nCaminho percorrido pelo Personagem:\n" 
                            + grafo.Personagem().exibirHistorico());
                    
                    System.out.println("\nSalas disponíveis para passar:\n" 
                            + salas.toString());
                    
                    break;
                    
                case "C":
                    
                    System.out.println("\nLista de itens coletados:\n");
                
                    System.out.println(grafo.Personagem().exibirColecao());
                    
                    break;
                    
                case "R":
                    
                    System.out.println("\nLeitura de Arquivo de Instruções\n");
                
                    IO.lerArquivoIntrucoes();
                
                    grafo = Estrutura.grafo;
                    
                    break;
                    
                case "F":
                    
                    System.out.println("Programa encerrado com sucesso");
                    
                    break;
                
                default:
                    
                    if(input.length() > 1) {
                        
                        IO.QuebraLinha(input);
                        
                    }
                    
                    break;
                
            }
           
            System.out.println("\n");
            
        }
    }
    
    public static void InterpretaComandos(String[] partes) {
        
        Grafo grafo = Estrutura.grafo;
        
        partes[0] = partes[0].toUpperCase();
        
        int operandoAInt = 0;
        
        int operandoBInt = 0;
        
        String operandoBString = "";
        
        Fila<String> salas;
        
        switch (partes[0]) {
            
            case "G":
                
                operandoAInt = Integer.parseInt(partes[1]);
                
                Estrutura.grafo = new Grafo(operandoAInt);
                
                System.out.println("\n\nGrafo criado!\n");
                
                break;
                
            case "A":
                
                operandoAInt = Integer.parseInt(partes[1]);
                
                operandoBInt = Integer.parseInt(partes[2]);
                
                grafo.adicionaAresta(operandoAInt, operandoBInt);
                
                System.out.println("\nAresta entre os vértices " 
                        + operandoAInt + " e " + operandoBInt +
                        " criada com sucesso!\n ");
                
                break;
            
            case "I":
                
                operandoAInt = Integer.parseInt(partes[1]);
                
                operandoBString = partes[2];
                
                grafo.adicionaItem(operandoAInt, operandoBString);
                
                 System.out.println("Um " + operandoBString + " foi inserido na Sala " + operandoAInt);
                
                break;
            
            case "P":
                
                operandoAInt = Integer.parseInt(partes[1]);
                
                salas = grafo.posicionaPersonagem(operandoAInt);
                
                System.out.println("\nSalas disponíveis para passar:\n" 
                            + salas.toString());
                
                break;
                
            case "M":
                
                operandoAInt = Integer.parseInt(partes[1]);
                
                salas = grafo.moverPersonagem(operandoAInt);
                
                System.out.println("\nCaminho percorrido pelo Personagem:\n" 
                            + grafo.Personagem().exibirHistorico());
                
                System.out.println("\nSalas disponíveis para passar:\n" 
                            + salas.toString());
                
                break;
                
            default:
                
                break;
            
        }
        
    }
    
}
