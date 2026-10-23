package br.com.ifba.usuario.view;

import br.com.ifba.infrastructure.util.JPAUtil;
import br.com.ifba.usuario.entity.Usuario;
import br.com.ifba.usuario.view.TelaEdicao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private JButton renderButton;
    private JButton editButton;
    private String text;
    private ImageIcon icon;
    private String acao; // "EDITAR" ou "EXCLUIR"
    private Usuario usuario = new Usuario();

    
    private boolean buscar(String cpf){
        EntityManager entityManager = JPAUtil.getEntityManager();
        
        if (cpf == null || cpf.isEmpty()){
            return false;
        }
        
        entityManager.getTransaction().begin();
        String jpql = "select u from Usuario as u where u.pessoa.cpf = :cpf";
        TypedQuery<Usuario> query =  entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("cpf", cpf);
        
        List<Usuario> resultados = query.getResultList();
        
        //Fechando o recurso do garçom
        entityManager.close();
        
        if (resultados.isEmpty()){
            this.usuario = null;
            return false;
        }
        
        this.usuario = resultados.get(0);
        return true;
        
    }

    public ButtonColumn(JTable table, int column, ImageIcon icon, String acao) {
        this.icon = icon;
        this.acao = acao;
        
        renderButton = new JButton();
        renderButton.setIcon(icon);
        
        editButton = new JButton();
        editButton.setIcon(icon);
        editButton.setFocusPainted(false);
        
        editButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
            //Descobre qual linha da tabela foi clicada
            int linhaSelecionada = table.getSelectedRow();
                
            if (linhaSelecionada != -1) {
                // Verifica qual ação executar com base no parâmetro passado
                if (acao.equals("EDITAR")) {
                    // Lógica para abrir a tela de edição
                    String nomeUsuario = (String) table.getValueAt(linhaSelecionada, 0);
                    //Pega o cpf que está na coluna 1 daquela linha
                    String cpfSelecionado = (String) table.getValueAt(linhaSelecionada, 1);
                    
                    //Buscar o usuario no banco de dados
                    //Chama um garçom
                    EntityManager em = JPAUtil.getEntityManager();
                    
                    TypedQuery <Usuario> query = em.createQuery("select u from Usuario u where u.pessoa.cpf = :cpf", Usuario.class);
                    query.setParameter("cpf", cpfSelecionado);
                    
                    Usuario usuarioParaEditar = query.getSingleResult();
                    
                    TelaEdicao telaEditar = new TelaEdicao(usuarioParaEditar);
                    telaEditar.setVisible(true);
                        
                } else if (acao.equals("EXCLUIR")) {
                    // Lógica para abrir o JOptionPane de exclusão
                    int resposta = JOptionPane.showConfirmDialog(
                        table, 
                        "Deseja realmente excluir este usuário?", 
                        "Confirmação de Exclusão", 
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                    );
                        
                    if (resposta == JOptionPane.YES_OPTION) {
                        // 1. Pega o ID dinamicamente da linha selecionada na tabela
                        // (Substitua '0' pelo índice da coluna onde fica o ID na sua tabela)
                        String cpfUsuario = (String) table.getValueAt(linhaSelecionada, 1);
                        boolean resultado = buscar(cpfUsuario);
                        
                        //Apaga do banco de dados 
                        //Abre a conexão
                        if (resultado){
                            EntityManager em = JPAUtil.getEntityManager();
                        
                            Usuario usuarioEncontrado = em.find(Usuario.class, usuario.getId());
                        
                            em.getTransaction().begin();
                            em.remove(usuarioEncontrado);
                            em.getTransaction().commit();
                        
                            //Fechando a conexão
                            em.close();
                        
                            // Remove visualmente da tabela 
                            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();
                            model.removeRow(linhaSelecionada);
                        }
                        else{
                            javax.swing.JOptionPane.showMessageDialog(table, "Usuario não encontrado!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                        }
                        }
                    }
                }
            }
        });

        table.getColumnModel().getColumn(column).setCellRenderer(this);
        table.getColumnModel().getColumn(column).setCellEditor(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderButton.setIcon(icon);
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        editButton.setIcon(icon);
        return editButton;
    }

    @Override
    public Object getCellEditorValue() {
        return text;
    }
}