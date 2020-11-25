/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.tg1.model;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Utilitarios {
    public void InserirIcone(JFrame frm) {
        try {
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/fatec/tg1/view/icon/icon-Encrypt-Decrypt.png"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
