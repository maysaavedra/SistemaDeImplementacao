
package TesteAplicação;

import Objetos.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;





public class TabelaProjeto extends JFrame {
	private static final long serialVersionUID = 1L;
        private JTable tabela;
    public TabelaProjeto (final Tela1 pai, ArrayList<Projeto> projetos, String titulos[]) {
    	setLayout(new FlowLayout());//tipo de layout
        setSize(new Dimension(700, 200));//tamanho do frame
        setLocationRelativeTo(null);//centralizado
        setTitle("Meus Funcionario");//titulo
        String dados[][] = new String[projetos.size()][3];
        for(int i=0; i<projetos.size(); i++)
        {	Projeto projeto = projetos.get(i);
        	dados[i][0] = "" + projeto.getCd_projeto();
        	dados[i][1] = projeto.getNome_projeto();
        	dados[i][2] = projeto.getDesc_projeto();
        	
                //instanciando a JTable
                tabela=new JTable(dados,titulos);
                tabela.setPreferredScrollableViewportSize(new Dimension(650,100));//barra de rolagem
                tabela.setFillsViewportHeight(true);
                tabela.setDefaultEditor(Object.class, null);
                //adicionando a tabela em uma barra de rolagem, ficará envolta , pela mesma 
                JScrollPane scrollPane=new JScrollPane(tabela);  
                tabela.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        		if(e.getClickCount() == 2) {
        			JTable target = (JTable)e.getSource();
        			int linha = target.getSelectedRow();
        			pai.irParaCodigoProjeto(Long.parseLong((String) tabela.getModel().getValueAt(linha, 0)));
        			  dispose();
        		  }
        	  }
        	});
        add(scrollPane);
        setVisible(true);
    }
        }
}

    
