
package TesteAplicação;

import DAO.*;
import Objetos.*;
import java.util.ArrayList;




public class PopularBD {
    public static void main(String[] args) {
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.adiciona(new Funcionario( 1L , "Carlos","01/06/1981", "XYZ", "123456" , "cedmenezes@gmail.com"));
		dao.adiciona(new Funcionario(2L ,"Mayara",  "11/01/1995", "ABC","1223654" ,"mayara@gmail.com" ));
                dao.adiciona(new Funcionario(3L ,"Irineu",  "14/11/1958", "ABC","1223654" ,"irineu@gmail.com" ));
		
		System.out.println("Lista de Funcionario:");
		ArrayList<Funcionario> f = (ArrayList<Funcionario>) dao.getListar();
		for(Funcionario x:f) System.out.println(x);

		
                ProjetoDAO dao_proj = new ProjetoDAO();
                dao_proj.adiciona(new Projeto (1L, "Projeto Teste", "I'm trying'"));
                System.out.println("Lista de Projeto:");
                ArrayList<Projeto> p= (ArrayList<Projeto>) dao_proj.getListar();
                
	}
    
    
}
