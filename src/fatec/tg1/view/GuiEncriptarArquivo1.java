/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.tg1.view;

import fatec.tg1.model.Arquivo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GuiEncriptarArquivo1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form GuiEncriptarArquivo1
     */
    public GuiEncriptarArquivo1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPLGerarHash = new javax.swing.JPanel();
        jLblArquivo = new javax.swing.JLabel();
        jTfdFile = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jLblSha512 = new javax.swing.JLabel();
        jBtnCopiarSha512 = new javax.swing.JButton();
        jBtnCopiarTudo = new javax.swing.JButton();
        jLblHash = new javax.swing.JLabel();
        jBtnColar = new javax.swing.JButton();
        jBtnVerificarHash = new javax.swing.JButton();
        jLblSenhaEncripArq = new javax.swing.JLabel();
        jTxfSenhaEncripArq = new javax.swing.JTextField();
        jBtnEncriptarArq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTfdSha512 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTfdHash = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Encriptar Arquivo");
        setPreferredSize(new java.awt.Dimension(780, 550));

        jPLGerarHash.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encriptar Arquivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N
        jPLGerarHash.setToolTipText("");

        jLblArquivo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblArquivo.setText("Arquivo:");

        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/buscar arquivo.png"))); // NOI18N
        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jLblSha512.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblSha512.setText("Sha512:");

        jBtnCopiarSha512.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/copia-de.png"))); // NOI18N
        jBtnCopiarSha512.setText("Copiar Sha512");
        jBtnCopiarSha512.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCopiarSha512ActionPerformed(evt);
            }
        });

        jBtnCopiarTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/copiar td.png"))); // NOI18N
        jBtnCopiarTudo.setText("Copiar Tudo");

        jLblHash.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLblHash.setText("Hash:");

        jBtnColar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/colar.png"))); // NOI18N
        jBtnColar.setText("Colar");
        jBtnColar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnColarActionPerformed(evt);
            }
        });

        jBtnVerificarHash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/senha.png"))); // NOI18N
        jBtnVerificarHash.setText("Verificar Hash");
        jBtnVerificarHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVerificarHashActionPerformed(evt);
            }
        });

        jLblSenhaEncripArq.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLblSenhaEncripArq.setText("Senha:");

        jBtnEncriptarArq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/tg1/view/icon/criptografar.png"))); // NOI18N
        jBtnEncriptarArq.setText("Encriptar");
        jBtnEncriptarArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEncriptarArqActionPerformed(evt);
            }
        });

        jTfdSha512.setColumns(20);
        jTfdSha512.setLineWrap(true);
        jTfdSha512.setRows(5);
        jScrollPane1.setViewportView(jTfdSha512);

        jTfdHash.setEditable(false);
        jTfdHash.setColumns(20);
        jTfdHash.setLineWrap(true);
        jTfdHash.setRows(5);
        jTfdHash.setBorder(null);
        jTfdHash.setEnabled(false);
        jTfdHash.setOpaque(false);
        jScrollPane2.setViewportView(jTfdHash);

        javax.swing.GroupLayout jPLGerarHashLayout = new javax.swing.GroupLayout(jPLGerarHash);
        jPLGerarHash.setLayout(jPLGerarHashLayout);
        jPLGerarHashLayout.setHorizontalGroup(
            jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLGerarHashLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPLGerarHashLayout.createSequentialGroup()
                        .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPLGerarHashLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLblSenhaEncripArq))
                            .addGroup(jPLGerarHashLayout.createSequentialGroup()
                                .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblSha512)
                                    .addComponent(jLblHash))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPLGerarHashLayout.createSequentialGroup()
                                    .addComponent(jTxfSenhaEncripArq, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(220, 220, 220))
                                .addComponent(jBtnVerificarHash, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1)))
                        .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPLGerarHashLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnColar)
                                .addGap(211, 211, 211))
                            .addGroup(jPLGerarHashLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBtnCopiarTudo, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jBtnCopiarSha512, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jBtnEncriptarArq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPLGerarHashLayout.createSequentialGroup()
                        .addComponent(jLblArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTfdFile, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPLGerarHashLayout.setVerticalGroup(
            jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLGerarHashLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTfdFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar)
                    .addComponent(jLblArquivo))
                .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLGerarHashLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxfSenhaEncripArq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblSenhaEncripArq)
                            .addComponent(jBtnEncriptarArq))
                        .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPLGerarHashLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLblSha512))
                            .addGroup(jPLGerarHashLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPLGerarHashLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jBtnCopiarSha512)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCopiarTudo)))
                .addGap(8, 8, 8)
                .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLGerarHashLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLblHash))
                    .addGroup(jPLGerarHashLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPLGerarHashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBtnColar)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jBtnVerificarHash))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPLGerarHash, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPLGerarHash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showSaveDialog(null);
        if(i==1){
            jTfdFile.setText("");
        }else {
            File arquivo = file.getSelectedFile();
            jTfdFile.setText(arquivo.getPath());
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnCopiarSha512ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCopiarSha512ActionPerformed
        String text = jTfdSha512.getText();
        StringBuilder builder = new StringBuilder(text);
        builder.replace(jTfdSha512.getSelectionStart(), jTfdSha512.getSelectionEnd(),"");
    }//GEN-LAST:event_jBtnCopiarSha512ActionPerformed

    private void jBtnColarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnColarActionPerformed
        String text = jTfdSha512.getText();
        StringBuilder builder = new StringBuilder(text);
        builder.replace(jTfdSha512.getSelectionStart(), jTfdSha512.getSelectionEnd(),"");
        jTfdHash.setText(text);
    }//GEN-LAST:event_jBtnColarActionPerformed

    private void jBtnVerificarHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVerificarHashActionPerformed
        String hash = jTfdHash.getText();
        arquivo = new Arquivo(jTfdSha512.getText());
        arquivo.setSenhahexAdmin(jTfdSha512.getText());

        if(arquivo.CompararHashes(hash)){
            JOptionPane.showMessageDialog(this, "Hashes Iguais!!!");
        }else {
            JOptionPane.showMessageDialog(this, "Hashes diferentes!!! \nFavor verificar hash");
        }
    }//GEN-LAST:event_jBtnVerificarHashActionPerformed

    private void jBtnEncriptarArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEncriptarArqActionPerformed
        String senhAdmin = null;
        arquivo = new Arquivo(jTxfSenhaEncripArq.getText());
        try {
            senhAdmin = arquivo.Encriptar();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GuiEncriptarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GuiEncriptarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTfdSha512.setText(senhAdmin);
    }//GEN-LAST:event_jBtnEncriptarArqActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnColar;
    private javax.swing.JButton jBtnCopiarSha512;
    private javax.swing.JButton jBtnCopiarTudo;
    private javax.swing.JButton jBtnEncriptarArq;
    private javax.swing.JButton jBtnVerificarHash;
    private javax.swing.JLabel jLblArquivo;
    private javax.swing.JLabel jLblHash;
    private javax.swing.JLabel jLblSenhaEncripArq;
    private javax.swing.JLabel jLblSha512;
    private javax.swing.JPanel jPLGerarHash;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTfdFile;
    private javax.swing.JTextArea jTfdHash;
    private javax.swing.JTextArea jTfdSha512;
    private javax.swing.JTextField jTxfSenhaEncripArq;
    // End of variables declaration//GEN-END:variables
    Arquivo arquivo = null;
}
