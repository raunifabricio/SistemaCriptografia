package fatec.tg1.model;

/**
 *
 * @author RaunieBruno
 */
public enum Perfil {
    USUARIO,
    ADMIN;
    
    public static Perfil getUSUARIO() {    
        return USUARIO;
    }

    public static Perfil getADMIN() {
        return ADMIN;
    }
    
    
}
