package fatec.tg1.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author MR.ROBOTNEO
 */
public class Arquivo {
    private String senhaAdmin;
    private String senhahexAdmin;

    public Arquivo(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

    public void setSenhaAdmin(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }

    public String getSenhahexAdmin() {
        return senhahexAdmin;
    }

    public void setSenhahexAdmin(String senhahexAdmin) {
        this.senhahexAdmin = senhahexAdmin;
    }
    
    public String Encriptar() throws NoSuchAlgorithmException,
  UnsupportedEncodingException {

     MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
     byte messageDigestSenhaAdmin[] = algorithm.digest(senhaAdmin.getBytes("UTF-8"));

     StringBuilder hexStringSenhaAdmin = new StringBuilder();
     for (byte b : messageDigestSenhaAdmin) {
              hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
     }
     
        String senhahexAdmin = hexStringSenhaAdmin.toString();

        return senhahexAdmin;
    }
    
    public boolean CompararHashes(String hash){
       return senhahexAdmin.equals(hash);
    }
    
}
