package usac_taller_automotriz;
import controlador.*;
import vista.LoginView;
/**
 *
 * @author Anthony
 */
public class USAC_Taller_Automotriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AdminController adminController = new AdminController();
        ProgresoController progresoController = new ProgresoController();
        BitacoraManager bitacoraManager = new BitacoraManager();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView(adminController, progresoController, bitacoraManager).setVisible(true);
            }
        });
    }

}
