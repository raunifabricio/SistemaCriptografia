/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.tg1.view;

import fatec.tg1.model.Utilitarios;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author MR.ROBOTNEO
 */
public class GuiMenu extends javax.swing.JFrame {

    /**
     * Creates new form GuiMenu
     */
    public GuiMenu() {
        initComponents();
        
        Utilitarios u = new Utilitarios();
        u.InserirIcone(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lblData = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        lblUsuario1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCad = new javax.swing.JMenu();
        menuCadUser = new javax.swing.JMenuItem();
        jMenuArquivo = new javax.swing.JMenu();
        jCbxEncriptarArq = new javax.swing.JCheckBoxMenuItem();
        jCbxDescripArq = new javax.swing.JCheckBoxMenuItem();
        jMenuPartição = new javax.swing.JMenu();
        jMenuEncriptPart = new javax.swing.JCheckBoxMenuItem();
        jMenuDescripPart = new javax.swing.JCheckBoxMenuItem();
        jMenuTexto = new javax.swing.JMenu();
        jMenuEncripDecsripTxt = new javax.swing.JCheckBoxMenuItem();
        menuBackup = new javax.swing.JMenu();
        jMenuGerarBackup = new javax.swing.JCheckBoxMenuItem();
        jMenuOpc = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        desktop.setPreferredSize(new java.awt.Dimension(640, 480));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        lblData.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblData.setText("Data");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Usuário");

        lblPerfil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPerfil.setText("Administrador");

        lblUsuario1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario1.setText("Usuário:");

        menuCad.setText("Cadastro");

        menuCadUser.setText("Usuário");
        menuCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadUserActionPerformed(evt);
            }
        });
        menuCad.add(menuCadUser);

        jMenuBar1.add(menuCad);

        jMenuArquivo.setText("Arquivo");

        jCbxEncriptarArq.setSelected(true);
        jCbxEncriptarArq.setText("Encriptar");
        jCbxEncriptarArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbxEncriptarArqActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jCbxEncriptarArq);

        jCbxDescripArq.setSelected(true);
        jCbxDescripArq.setText("Descriptografar");
        jCbxDescripArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbxDescripArqActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jCbxDescripArq);

        jMenuBar1.add(jMenuArquivo);

        jMenuPartição.setText("Partição");

        jMenuEncriptPart.setSelected(true);
        jMenuEncriptPart.setText("Encriptar");
        jMenuEncriptPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEncriptPartActionPerformed(evt);
            }
        });
        jMenuPartição.add(jMenuEncriptPart);

        jMenuDescripPart.setSelected(true);
        jMenuDescripPart.setText("Descriptografar");
        jMenuDescripPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDescripPartActionPerformed(evt);
            }
        });
        jMenuPartição.add(jMenuDescripPart);

        jMenuBar1.add(jMenuPartição);

        jMenuTexto.setText("Texto");

        jMenuEncripDecsripTxt.setSelected(true);
        jMenuEncripDecsripTxt.setText("Encriptar/Descriptar");
        jMenuEncripDecsripTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEncripDecsripTxtActionPerformed(evt);
            }
        });
        jMenuTexto.add(jMenuEncripDecsripTxt);

        jMenuBar1.add(jMenuTexto);

        menuBackup.setText("Backup");

        jMenuGerarBackup.setSelected(true);
        jMenuGerarBackup.setText("Gerar e Restaurar Backup");
        jMenuGerarBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerarBackupActionPerformed(evt);
            }
        });
        menuBackup.add(jMenuGerarBackup);

        jMenuBar1.add(menuBackup);

        jMenuOpc.setText("Opções");
        jMenuOpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpcActionPerformed(evt);
            }
        });

        jMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenuOpc.add(jMenuSair);

        jMenuBar1.add(jMenuOpc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblData)
                    .addComponent(lblPerfil)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(lblUsuario1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblData)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1124, 649));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCbxEncriptarArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbxEncriptarArqActionPerformed
        //new GuiEncriptarArquivo().setVisible(true);
        GuiEncriptarArquivo1 guiEncriptarArquivo = new GuiEncriptarArquivo1();
        guiEncriptarArquivo.setVisible(true);
        desktop.add(guiEncriptarArquivo);
    }//GEN-LAST:event_jCbxEncriptarArqActionPerformed

    private void jCbxDescripArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbxDescripArqActionPerformed
        //new GuiDescriptarArquivo().setVisible(true);
        GuiDescriptografarArquivo guiDescriptografarArquivo = new GuiDescriptografarArquivo();
        guiDescriptografarArquivo.setVisible(true);
        desktop.add(guiDescriptografarArquivo);
    }//GEN-LAST:event_jCbxDescripArqActionPerformed

    private void jMenuEncriptPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEncriptPartActionPerformed
        //new GuiEncriptarPartição().setVisible(true);
        GuiEncriptarParticao guiEncriptarParticao = new GuiEncriptarParticao();
        guiEncriptarParticao.setVisible(true);
        desktop.add(guiEncriptarParticao);
    }//GEN-LAST:event_jMenuEncriptPartActionPerformed

    private void jMenuDescripPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDescripPartActionPerformed
        //new GuiDescriptarPartição().setVisible(true);
        GuiDescriptografarParticao guiDescriptografarParticao = new GuiDescriptografarParticao();
        guiDescriptografarParticao.setVisible(true);
        desktop.add(guiDescriptografarParticao);
    }//GEN-LAST:event_jMenuDescripPartActionPerformed

    private void jMenuEncripDecsripTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEncripDecsripTxtActionPerformed
        //new GuiEncripDescripTxt().setVisible(true);
        GuiEncripDescripTxt1 guiEncripDescripTxt = new GuiEncripDescripTxt1();
        guiEncripDescripTxt.setVisible(true);
        desktop.add(guiEncripDescripTxt);
    }//GEN-LAST:event_jMenuEncripDecsripTxtActionPerformed

    private void jMenuGerarBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerarBackupActionPerformed
        //new GuiGerarBackup().setVisible(true);
        GuiGerarBackup1 guiGerarBackup = new GuiGerarBackup1();
        guiGerarBackup.setVisible(true);
        desktop.add(guiGerarBackup);
    }//GEN-LAST:event_jMenuGerarBackupActionPerformed

    private void jMenuOpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpcActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuOpcActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // ao ativar a janela, mude e atualize a data:
        Date data = new Date();
        // formatando a data
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void menuCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadUserActionPerformed
        GuiCadastroUsuario1 guiCadastroUsuario = new GuiCadastroUsuario1();
        guiCadastroUsuario.setVisible(true);
        desktop.add(guiCadastroUsuario);
    }//GEN-LAST:event_menuCadUserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JCheckBoxMenuItem jCbxDescripArq;
    private javax.swing.JCheckBoxMenuItem jCbxEncriptarArq;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JCheckBoxMenuItem jMenuDescripPart;
    private javax.swing.JCheckBoxMenuItem jMenuEncripDecsripTxt;
    private javax.swing.JCheckBoxMenuItem jMenuEncriptPart;
    private javax.swing.JCheckBoxMenuItem jMenuGerarBackup;
    private javax.swing.JMenu jMenuOpc;
    private javax.swing.JMenu jMenuPartição;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JMenu jMenuTexto;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblPerfil;
    public static javax.swing.JLabel lblUsuario;
    public static javax.swing.JLabel lblUsuario1;
    public static javax.swing.JMenu menuBackup;
    public static javax.swing.JMenu menuCad;
    private javax.swing.JMenuItem menuCadUser;
    // End of variables declaration//GEN-END:variables
}
