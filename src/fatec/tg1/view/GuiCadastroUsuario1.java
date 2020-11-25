/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.tg1.view;

import fatec.tg1.control.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno Yuji
 */
public class GuiCadastroUsuario1 extends javax.swing.JInternalFrame {

    //  usando a variavel conexao do DAL

    Connection conexao = null;
    // criando variáveis especiais para conexão com o banco
    //Prepared Statement e ResultSet são frameworks do pacote java.sql
    // e servem para preparar e executar as instruções SQL
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /**
     * Creates new form GuiCadastroUsuario1
     */
    public GuiCadastroUsuario1() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void estadoBotoes_Inicial() {
        btnAdicionar.setEnabled(true);
        btnUsuUpdate.setEnabled(false);
        btnUsuDelete.setEnabled(false);
        btnUsuCancel.setEnabled(false);
        txtUsuSenha.setEnabled(true);
        txtUserPesquisar.setText(null);
        
        ((DefaultTableModel) tblUsuarios.getModel()).setRowCount(0);
        
        txtUsuId.setText(null);
        txtUsuNome.setText(null);
        txtUsuFone.setText(null);
        txtUsuEmail.setText(null);
    }
    
    private void estadoBotoes_TabelaClicada() {
        btnAdicionar.setEnabled(false);
        btnUsuUpdate.setEnabled(true);
        btnUsuDelete.setEnabled(true);
        btnUsuCancel.setEnabled(true);
        txtUsuSenha.setEnabled(false);
    }
    
    //método para adicionar usuários
    private void adicionar() {
        String sql = "insert into tb_usuario(nome, fone, email, senha, perfil) values(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            //pst.setString(1, txtUsuId.getText());
            pst.setString(1, txtUsuNome.getText());
            pst.setString(2, txtUsuFone.getText());
            pst.setString(3, txtUsuEmail.getText());
            pst.setString(4, txtUsuSenha.getText());
            pst.setString(5, cboUsuPerfil.getSelectedItem().toString());
            //validação dos campos obrigatórios
            if ((txtUsuNome.getText().isEmpty()) || (txtUsuEmail.getText().isEmpty()) || (txtUsuSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            } else {

//a linha abaixo atualiza a tabela usuario com os dados do formulário
                //a etrutura abaixo é usada para confirmar a inserção dos dados na tabela
                int adicionado = pst.executeUpdate();
                //a linha abaixo serve de apoio ao entendimento da lógica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    //txtUsuId.setText(null);
                    txtUsuSenha.setText(null);
                    estadoBotoes_Inicial();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //método para pesquisar clientes pelo nome com filtro
    private void pesquisar_cliente() {
        String sql = "select id, nome, fone, email, perfil from tb_usuario where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para o ?
            //atenção ao "%" - continuação da String sql
            pst.setString(1, txtUserPesquisar.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tblUsuarios.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método para setar os campos do formulário com o conteúdo da tabela
    public void setar_campos() {
        int setar = tblUsuarios.getSelectedRow();
        txtUsuId.setText(tblUsuarios.getModel().getValueAt(setar, 0).toString());
        txtUsuNome.setText(tblUsuarios.getModel().getValueAt(setar, 1).toString());
        txtUsuFone.setText(tblUsuarios.getModel().getValueAt(setar, 2).toString());
        txtUsuEmail.setText(tblUsuarios.getModel().getValueAt(setar, 3).toString());
        cboUsuPerfil.setSelectedItem(tblUsuarios.getModel().getValueAt(setar, 4).toString());
        //a linha abaixo desabilita o botão adicionar e campo de senha
        estadoBotoes_TabelaClicada();
    }

    //criando o método para alterar dados do usuário
    private void alterar() {
        String sql = "update tb_usuario set nome=?, fone=?, email=?, perfil=? where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuNome.getText());
            pst.setString(2, txtUsuFone.getText());
            pst.setString(3, txtUsuEmail.getText());
            pst.setString(4, cboUsuPerfil.getSelectedItem().toString());
            pst.setString(5, txtUsuId.getText());
            if ((txtUsuNome.getText().isEmpty()) || (txtUsuEmail.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

//a linha abaixo atualiza a tabela usuario com os dados do formulário
                //a etrutura abaixo é usada para confirmar a alteração dos dados na tabela
                int adicionado = pst.executeUpdate();
                //a linha abaixo serve de apoio ao entendimento da lógica
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso");
                    estadoBotoes_Inicial();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // método responsável pela remoção de usuários

    private void remover() {
        //a estrutura abaixo confirma a remoção do usuário
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário ?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tb_usuario where id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtUsuId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário Removido com sucesso");
                    estadoBotoes_Inicial();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnUsuUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnUsuDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtUsuNome = new javax.swing.JTextField();
        txtUsuEmail = new javax.swing.JTextField();
        cboUsuPerfil = new javax.swing.JComboBox();
        txtUsuFone = new javax.swing.JTextField();
        txtUserPesquisar = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        btnUsuCancel = new javax.swing.JButton();
        txtUsuSenha = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuários");
        setPreferredSize(new java.awt.Dimension(780, 550));

        jLabel6.setText("Fone");

        jLabel2.setText("* Nome ");

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/create.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar");
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel3.setText("* E-mail");

        jLabel4.setText("* Senha");

        btnUsuUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/update.png"))); // NOI18N
        btnUsuUpdate.setToolTipText("Alterar");
        btnUsuUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuUpdate.setEnabled(false);
        btnUsuUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuUpdateActionPerformed(evt);
            }
        });

        jLabel5.setText("* Perfil");

        btnUsuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/delete.png"))); // NOI18N
        btnUsuDelete.setToolTipText("Remover");
        btnUsuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuDelete.setEnabled(false);
        btnUsuDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuDeleteActionPerformed(evt);
            }
        });

        jLabel7.setText("* Campos obrigatórios");

        cboUsuPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "user" }));

        txtUsuFone.setFocusCycleRoot(true);
        txtUsuFone.setFocusTraversalPolicyProvider(true);

        txtUserPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserPesquisarKeyReleased(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Endereço", "Fone", "email"
            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblUsuarios);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/search.png"))); // NOI18N

        jLabel8.setText("Id Usuário");

        txtUsuId.setEnabled(false);

        btnUsuCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/cancel.png"))); // NOI18N
        btnUsuCancel.setToolTipText("Cancelar");
        btnUsuCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuCancel.setEnabled(false);
        btnUsuCancel.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUsuCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuCancelActionPerformed(evt);
            }
        });

        jLabel9.setText("Pesquisar por Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUserPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(358, 358, 358)
                                            .addComponent(cboUsuPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel6))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel7))
                                                .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtUsuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(29, 29, 29)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel4)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel5)))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(87, 87, 87)
                                                    .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(85, 85, 85)
                                                    .addComponent(btnUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(83, 83, 83)
                                                    .addComponent(btnUsuCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGap(74, 74, 74))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(txtUsuSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboUsuPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        setBounds(0, 0, 780, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // chamando o método adicionar
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnUsuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuUpdateActionPerformed
        // chamando o método alterar
        alterar();
    }//GEN-LAST:event_btnUsuUpdateActionPerformed

    private void btnUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuDeleteActionPerformed
        // chamando o método remover
        remover();
    }//GEN-LAST:event_btnUsuDeleteActionPerformed

    // evento quando está digitando
    private void txtUserPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserPesquisarKeyReleased
        // chamar o método pesquisar clientes
        pesquisar_cliente();
    }//GEN-LAST:event_txtUserPesquisarKeyReleased

    // evento que será usado para setar os campos da tabela (clicando com o mouse)
    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // chamando o método para setar os campos
        setar_campos();
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnUsuCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuCancelActionPerformed
        estadoBotoes_Inicial();
    }//GEN-LAST:event_btnUsuCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnUsuCancel;
    private javax.swing.JButton btnUsuDelete;
    private javax.swing.JButton btnUsuUpdate;
    private javax.swing.JComboBox cboUsuPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtUserPesquisar;
    private javax.swing.JTextField txtUsuEmail;
    private javax.swing.JTextField txtUsuFone;
    private javax.swing.JTextField txtUsuId;
    private javax.swing.JTextField txtUsuNome;
    private javax.swing.JPasswordField txtUsuSenha;
    // End of variables declaration//GEN-END:variables
}
