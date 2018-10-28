package loginsenha;


public class Principal {
    
    
    public static void main(String[] args)throws Exception {
     
        LoginSenha loginSenha = new LoginSenha();
    
        boolean menu = true;
        while(menu){
            menu = loginSenha.Menu(menu);
        }
        
    }
    
}
