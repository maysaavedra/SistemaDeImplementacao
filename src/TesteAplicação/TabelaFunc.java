
package TesteAplicação;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

import Objetos.Funcionario;

public class TabelaFunc extends JFrame {
	private static final long serialVersionUID = 1L;
        private JTable tabela;
    public TabelaFunc (final Tela1 pai, ArrayList<Funcionario> funcionarios, String titulos[]) {
    	setLayout(new FlowLayout());//tipo de layout
        setSize(new Dimension(700, 200));//tamanho do frame
        setLocationRelativeTo(null);//centralizado
        setTitle("Meus Funcionario");//titulo
        String dados[][] = new String[funcionarios.size()][6];
        for(int i=0; i<funcionarios.size(); i++)
        {	Funcionario funcionario = funcionarios.get(i);
        	dados[i][0] = "" + funcionario.getMatricula();
        	dados[i][1] = funcionario.getNome();
        	dados[i][2] = funcionario.getData_nasc();
        	dados[i][3] = funcionario.getEndereco();
        	dados[i][4] = funcionario.getTelefone();
                dados[i][5] = funcionario.getEmail();
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
        			pai.irParaMatricula(Long.parseLong((String) tabela.getModel().getValueAt(linha, 0)));
        			  dispose();
        		  }
        	  }
        	});
        add(scrollPane);
        setVisible(true);
    }
        }
}
