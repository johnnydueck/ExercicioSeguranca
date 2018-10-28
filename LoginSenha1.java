
package loginsenha;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.*;
import java.math.*;
        


public class LoginSenha {
    Scanner sc = new Scanner(System.in);
    

    public boolean Menu(boolean menu)throws Exception{
        byte opcaoMenu;
        System.out.println("1)Cadastra-se");
        System.out.println("2)Login");        
        System.out.println("3)Sair1");
        opcaoMenu = sc.nextByte();
        
        if(opcaoMenu == 1){
            Usuario usuario = Cadastro();
            String hashSenha = Hash(usuario.getSenha());
            String cadastro = (usuario.getNome()+ " " + hashSenha);
            Leitor(".//arquivo.txt" , cadastro);           
            
            
            
        }else if(opcaoMenu == 2){
            
        }else if(opcaoMenu == 3){
            menu = false;
        }
        else{
            System.out.println("Opção invalida!");
        }
        
        return menu;        
    }
    
    public Usuario Cadastro(){
        System.out.println("Digite o nome do usuario:");
        String nome = ReceberString();
        System.out.println("Digite a senha:");
        String senha = ReceberString();
        Usuario usuario = new Usuario(nome, senha);
        System.out.println("Usuario cadastrado!");
        return usuario;
       
    }
    
    public static void Leitor(String path, String arquivo) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = arquivo;
        while (true) {
            if (linha != null) {
                System.out.println(linha);
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
    
     public static void escritor(String path, String arquivo) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        
        buffWrite.append(arquivo + "\n");
        buffWrite.close();
    }

    
    public String Hash(String x)throws Exception{
        
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(x.getBytes(),0,x.length());
        String hash = (new BigInteger(1, m.digest()).toString(16));   
        return hash;
        
    }
    
    public String ReceberString(){
        String string = sc.next();
        return string;
    }
    
}
