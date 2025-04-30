package vista;

import controlador.ClienteController;
import controlador.BitacoraManager;
import modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroClienteView extends javax.swing.JFrame {

    private ClienteController clienteController;
    private BitacoraManager bitacoraManager;

    // Variables declaration - do not modify
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblDPI;
    private javax.swing.JTextField txtDPI;
    private javax.swing.JLabel lblNombreCompleto;
    private javax.swing.JTextField txtNombreCompleto;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JLabel lblConfirmarContrasena;
    private javax.swing.JPasswordField txtConfirmarContrasena;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblMensaje;

    public RegistroClienteView(ClienteController clienteController, BitacoraManager bitacoraManager) {
        this.clienteController = clienteController;
        this.bitacoraManager = bitacoraManager;
        initComponentes();
        this.setLocationRelativeTo(null); // Centrar en pantalla
        this.setTitle("Registro de Cliente - USAC Taller Automotriz");

    }

    /**
     * Método para inicializar los componentes de la interfaz
     */
    private void initComponentes() {
        // Inicialización de componentes
        panelPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblDPI = new javax.swing.JLabel();
        txtDPI = new javax.swing.JTextField();
        lblNombreCompleto = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        lblConfirmarContrasena = new javax.swing.JLabel();
        txtConfirmarContrasena = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        // Configuración de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Configuración del panel principal
        panelPrincipal.setBackground(new Color(240, 240, 240));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Configuración de los componentes
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setText("Registro de Cliente");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblDPI.setText("DPI:");
        lblDPI.setFont(new Font("Arial", Font.PLAIN, 14));

        txtDPI.setFont(new Font("Arial", Font.PLAIN, 14));
        txtDPI.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Solo permitir dígitos
                }
            }
        });

        lblNombreCompleto.setText("Nombre completo:");
        lblNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 14));

        txtNombreCompleto.setFont(new Font("Arial", Font.PLAIN, 14));
        txtNombreCompleto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume(); // Solo permitir letras y espacios
                }
            }
        });

        lblUsuario.setText("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));

        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));

        lblContrasena.setText("Contraseña:");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 14));

        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 14));

        lblConfirmarContrasena.setText("Confirmar contraseña:");
        lblConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 14));

        txtConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 14));

        btnRegistrar.setText("Registrar");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrar.setBackground(new Color(70, 130, 180)); // Steel Blue
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCancelar.setBackground(new Color(220, 220, 220));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new Font("Arial", Font.ITALIC, 12));
        lblMensaje.setForeground(Color.RED);

        // Layout usando GridBagLayout para mayor flexibilidad
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(lblTitulo, gbc);

        // Añadir DPI
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(lblDPI, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtDPI, gbc);

        // Añadir Nombre completo
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        panelPrincipal.add(lblNombreCompleto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtNombreCompleto, gbc);

        // Añadir Usuario
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        panelPrincipal.add(lblUsuario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtUsuario, gbc);

        // Añadir Contraseña
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.0;
        panelPrincipal.add(lblContrasena, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtContrasena, gbc);

        // Añadir Confirmar contraseña
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.0;
        panelPrincipal.add(lblConfirmarContrasena, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtConfirmarContrasena, gbc);

        // Panel para botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelBotones.setOpaque(false);
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnCancelar);

        // Añadir panel de botones
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 5, 5, 5);
        panelPrincipal.add(panelBotones, gbc);

        // Añadir mensaje
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 5, 5, 5);
        panelPrincipal.add(lblMensaje, gbc);

        // Añadir panel principal a la ventana
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelPrincipal, BorderLayout.CENTER);

        pack();
        setSize(450, 450);
    }

    private void btnRegistrarActionPerformed(ActionEvent evt) {
        if (validarCampos()) {
            try {
                String dpi = txtDPI.getText().trim();
                String nombreCompleto = txtNombreCompleto.getText().trim();
                String usuario = txtUsuario.getText().trim();
                String password = new String(txtContrasena.getPassword());

                Cliente nuevoCliente = new Cliente(dpi, nombreCompleto, usuario, password, "normal");

                if (clienteController != null) {
                    // Verificar si el cliente ya existe
                    if (clienteController.existeCliente(dpi, usuario)) {
                        lblMensaje.setText("El cliente ya está registrado");
                        bitacoraManager.registrarEvento(
                                "Sistema",
                                "Registro de cliente",
                                "Fallo",
                                "Intento de registrar cliente existente: " + usuario
                        );
                        return;
                    }

                    clienteController.agregarCliente(nuevoCliente);

                    bitacoraManager.registrarEvento(
                            "Sistema",
                            "Registro de cliente",
                            "Éxito",
                            "Cliente registrado: " + nombreCompleto
                    );

                    JOptionPane.showMessageDialog(
                            this,
                            "Registro exitoso",
                            "Éxito",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    this.dispose();
                }
            } catch (Exception e) {
                lblMensaje.setText("Error: " + e.getMessage());
                bitacoraManager.registrarEvento(
                        "Sistema",
                        "Registro de cliente",
                        "Error",
                        "Error al registrar: " + e.getMessage()
                );
            }
        }
    }

    /**
     * Método para validar los campos del formulario
     *
     * @return true si los campos son válidos, false en caso contrario
     */
    private boolean validarCampos() {
        // Validar DPI
        if (txtDPI.getText().trim().isEmpty()) {
            lblMensaje.setText("El DPI es obligatorio.");
            txtDPI.requestFocus();
            return false;
        }

        if (txtDPI.getText().trim().length() < 8) {
            lblMensaje.setText("El DPI debe tener al menos 8 dígitos.");
            txtDPI.requestFocus();
            return false;
        }

        // Validar nombre completo
        if (txtNombreCompleto.getText().trim().isEmpty()) {
            lblMensaje.setText("El nombre completo es obligatorio.");
            txtNombreCompleto.requestFocus();
            return false;
        }

        // Validar usuario
        if (txtUsuario.getText().trim().isEmpty()) {
            lblMensaje.setText("El usuario es obligatorio.");
            txtUsuario.requestFocus();
            return false;
        }

        // Validar contraseña
        if (txtContrasena.getPassword().length == 0) {
            lblMensaje.setText("La contraseña es obligatoria.");
            txtContrasena.requestFocus();
            return false;
        }

        // Validar confirmación de contraseña
        String password = new String(txtContrasena.getPassword());
        String confirmarPassword = new String(txtConfirmarContrasena.getPassword());

        if (!password.equals(confirmarPassword)) {
            lblMensaje.setText("Las contraseñas no coinciden.");
            txtConfirmarContrasena.requestFocus();
            return false;
        }

        // Todos los campos son válidos
        lblMensaje.setText("");
        return true;
    }

    /**
     * Método para manejar el evento del botón Cancelar
     *
     * @param evt Evento de acción
     */
    private void btnCancelarActionPerformed(ActionEvent evt) {
        // Cerrar la ventana
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Establecer look and feel Nimbus */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Crear y mostrar la ventana */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear instancias de AdminController y BitacoraManager (o usar mocks para pruebas)
                ClienteController clienteController = new ClienteController(); // Asegúrate de inicializarlo correctamente
                BitacoraManager bitacoraManager = new BitacoraManager(); // Asegúrate de inicializarlo correctamente

                new RegistroClienteView(clienteController, bitacoraManager).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
