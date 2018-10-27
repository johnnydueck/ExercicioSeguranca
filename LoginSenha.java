
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
    
    public void gravaArquivo(String nomeArquivo, String conteudo, boolean append) {
        File arquivo = new File(nomeArquivo + ".txt");
        try {
            FileWriter grava = new FileWriter(arquivo, append);
            PrintWriter escreve = new PrintWriter(grava);
            escreve.println(conteudo);
            escreve.close();
            grava.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String lerConteudoArquivo(File arquivo) throws IOException {
        StringBuilder retorno = new StringBuilder();
        BufferedReader conteudo = new BufferedReader(new FileReader(arquivo));
        while (conteudo.ready()) {
            
            retorno.append(conteudo.readLine()).append("\r\n");
        }
        return retorno.toString();
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
