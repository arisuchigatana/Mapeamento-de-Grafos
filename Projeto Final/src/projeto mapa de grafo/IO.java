/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomapadegrafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IO {
    
    public static void lerArquivoIntrucoes() {
        
        try {
        
            File arquivo = new File("InstrucoesProjetoFinal.txt");
            Scanner leitor = new Scanner(arquivo);
        
            while (leitor.hasNextLine()){
            
                String linha = leitor.nextLine();
                
                QuebraLinha(linha);
                
            } 
        
        
        } catch(FileNotFoundException e) {
                
            System.out.println("Arquivo não encontrado.");
            
            String local = new File("").getAbsolutePath();
            
            System.out.println("Crie um arquivo de instruções neste local " + local);
            
            
         //   e.printStackTrace();
                
        }
            
    }
    
    public static void QuebraLinha(String linha) {
        
        String[] partes = linha.split(" ");
        
        if(partes.length > 1) {
            
            Main.InterpretaComandos(partes);
            
        }
        
    }
    
    
    
}
