package loginsenha;

import java.util.Scanner;


public class Usuario {
    
    private String nome;
    private String senha;
    
    Scanner sc = new Scanner(System.in);
    
    public boolean setNome(String nome){
        this.nome = nome;
        return true;
    }
    
    public boolean setSenha(String senha){
        this.senha = senha;
        return true;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public Usuario(String nome, String senha){
        setNome(nome);
        setSenha(senha);
    }
    
    
    
}
