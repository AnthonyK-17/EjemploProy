package vista;

import controlador.ClienteController;
import controlador.HiloServicio;
import java.awt.Image;
import java.io.File;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Automovil;
import modelo.Cliente;
import modelo.GeneradorID;
import modelo.OrdenTrabajo;
import modelo.Servicio;

public class ClienteView extends javax.swing.JFrame {

    private Cliente cliente;
    private ClienteController controller;
    private DefaultTableModel modelAutos;
    private DefaultTableModel modelOrdenes;

    public ClienteView(Cliente cliente) {
        this.cliente = cliente;
        this.controller = new ClienteController(cliente);
        initComponentes();
        configurarComponentesAdicionales();
        setTitle("USAC Taller Automotriz - Cliente: " + cliente.getNombreCompleto());
        setLocationRelativeTo(null);
    }

    private void configurarComponentesAdicionales() {
        // Configurar modelo de tabla de autos
        String[] columnasAutos = {"Placa", "Marca", "Modelo", "Foto"};
        modelAutos = new DefaultTableModel(columnasAutos, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Solo la columna de foto es editable (para el botón)
            }
        };
        tablaAutos.setModel(modelAutos);
        tablaAutos.getColumn("Foto").setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return new javax.swing.JButton(value != null ? value.toString() : "");
            }
        });
        tablaAutos.getColumn("Foto").setCellEditor(new ButtonEditor(new javax.swing.JTextField()));

        // Configurar modelo de tabla de órdenes
        String[] columnasOrdenes = {"Orden", "Automóvil", "Servicio", "Estado"};
        modelOrdenes = new DefaultTableModel(columnasOrdenes, 0);
        tablaProgreso.setModel(modelOrdenes);

        // Cargar datos iniciales
        actualizarTablaAutos();
    }

    private void initComponentes() {

        tabbedPane = new javax.swing.JTabbedPane();
        panelAutos = new javax.swing.JPanel();
        scrollAutos = new javax.swing.JScrollPane();
        tablaAutos = new javax.swing.JTable();
        btnAgregarAuto = new javax.swing.JButton();
        panelServicios = new javax.swing.JPanel();
        lblAuto = new javax.swing.JLabel();
        comboAutos = new javax.swing.JComboBox<>();
        lblServicio = new javax.swing.JLabel();
        comboServicios = new javax.swing.JComboBox<>();
        btnSolicitar = new javax.swing.JButton();
        panelProgreso = new javax.swing.JPanel();
        scrollProgreso = new javax.swing.JScrollPane();
        tablaProgreso = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaAutos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Placa", "Marca", "Modelo", "Foto"
                }
        ));
        scrollAutos.setViewportView(tablaAutos);

        btnAgregarAuto.setText("Agregar Automóvil");
        btnAgregarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAutosLayout = new javax.swing.GroupLayout(panelAutos);
        panelAutos.setLayout(panelAutosLayout);
        panelAutosLayout.setHorizontalGroup(
                panelAutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelAutosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelAutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollAutos, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                                        .addGroup(panelAutosLayout.createSequentialGroup()
                                                .addComponent(btnAgregarAuto)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        panelAutosLayout.setVerticalGroup(
                panelAutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAutosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAgregarAuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollAutos, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                                .addContainerGap())
        );

        tabbedPane.addTab("Mis Automóviles", panelAutos);

        lblAuto.setText("Automóvil:");

        lblServicio.setText("Servicio:");

        btnSolicitar.setText("Solicitar Servicio");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelServiciosLayout = new javax.swing.GroupLayout(panelServicios);
        panelServicios.setLayout(panelServiciosLayout);
        panelServiciosLayout.setHorizontalGroup(
                panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelServiciosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelServiciosLayout.createSequentialGroup()
                                                .addComponent(lblAuto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboAutos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblServicio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnSolicitar))
                                .addContainerGap(194, Short.MAX_VALUE))
        );
        panelServiciosLayout.setVerticalGroup(
                panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelServiciosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAuto)
                                        .addComponent(comboAutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblServicio)
                                        .addComponent(comboServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnSolicitar)
                                .addContainerGap(483, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Solicitar Servicio", panelServicios);

        tablaProgreso.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Orden", "Automóvil", "Servicio", "Estado"
                }
        ));
        scrollProgreso.setViewportView(tablaProgreso);

        btnActualizar.setText("Actualizar Progreso");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProgresoLayout = new javax.swing.GroupLayout(panelProgreso);
        panelProgreso.setLayout(panelProgresoLayout);
        panelProgresoLayout.setHorizontalGroup(
                panelProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelProgresoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                                        .addGroup(panelProgresoLayout.createSequentialGroup()
                                                .addComponent(btnActualizar)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        panelProgresoLayout.setVerticalGroup(
                panelProgresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProgresoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                                .addContainerGap())
        );

        tabbedPane.addTab("Ver Progreso", panelProgreso);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>                        

    private void btnAgregarAutoActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.JTextField txtPlaca = new javax.swing.JTextField(15);
        javax.swing.JTextField txtMarca = new javax.swing.JTextField(15);
        javax.swing.JTextField txtModelo = new javax.swing.JTextField(15);
        javax.swing.JTextField txtRutaImagen = new javax.swing.JTextField(15);
        txtRutaImagen.setEditable(false);

        javax.swing.JButton btnBuscarImagen = new javax.swing.JButton("Buscar Imagen");
        btnBuscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes JPG", "jpg"));
                if (fileChooser.showOpenDialog(ClienteView.this) == JFileChooser.APPROVE_OPTION) {
                    File archivo = fileChooser.getSelectedFile();
                    txtRutaImagen.setText(archivo.getAbsolutePath());
                }
            }
        });

        panel.add(new javax.swing.JLabel("Placa:"));
        panel.add(txtPlaca);
        panel.add(new javax.swing.JLabel("Marca:"));
        panel.add(txtMarca);
        panel.add(new javax.swing.JLabel("Modelo:"));
        panel.add(txtModelo);
        panel.add(new javax.swing.JLabel("Imagen (JPG):"));
        panel.add(txtRutaImagen);
        panel.add(btnBuscarImagen);

        javax.swing.JButton btnGuardar = new javax.swing.JButton("Guardar Automóvil");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (validarAutomovil(txtPlaca.getText(), txtMarca.getText(), txtModelo.getText())) {
                    Automovil auto = new Automovil(
                            txtPlaca.getText(),
                            txtMarca.getText(),
                            txtModelo.getText(),
                            txtRutaImagen.getText()
                    );
                    controller.agregarAutomovil(auto);
                    actualizarTablaAutos();
                    ((javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(panel)).dispose();
                }
            }
        });

        panel.add(btnGuardar);

        javax.swing.JFrame dialogo = new javax.swing.JFrame("Agregar Automóvil");
        dialogo.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        dialogo.add(panel);
        dialogo.pack();
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {
        int autoIndex = comboAutos.getSelectedIndex();
        String servicioNombre = (String) comboServicios.getSelectedItem();

        if (autoIndex >= 0 && servicioNombre != null) {
            Automovil autoSeleccionado = cliente.getAutomoviles()[autoIndex];

            // Crear servicio con los parámetros correctos
            Servicio servicioObj = new Servicio(
                    0, // ID temporal (deberías usar GeneradorID)
                    servicioNombre, // Nombre del servicio
                    autoSeleccionado.getMarca(), // Marca compatible
                    autoSeleccionado.getModelo(), // Modelo compatible
                    new int[0], // Array vacío de repuestos (puedes cambiarlo según necesites)
                    150.00, // Precio mano de obra (valor ejemplo)
                    150.00 // Precio total (igual al de mano de obra si no hay repuestos)
            );

            // Crear orden de trabajo
            OrdenTrabajo orden = new OrdenTrabajo(
                    GeneradorID.generarIDOrdenTrabajo(), // Usando el generador
                    autoSeleccionado,
                    cliente,
                    servicioObj,
                    new Date(),
                    null,
                    "Cola de espera"
            );

            new HiloServicio(orden, null, null).start();

            JOptionPane.showMessageDialog(this,
                    "Servicio solicitado con éxito. Estado: " + orden.getEstado(),
                    "Solicitud de Servicio",
                    JOptionPane.INFORMATION_MESSAGE);

            actualizarTablaProgreso();
        }
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        actualizarTablaProgreso();
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarAuto;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JComboBox<String> comboAutos;
    private javax.swing.JComboBox<String> comboServicios;
    private javax.swing.JLabel lblAuto;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JPanel panelAutos;
    private javax.swing.JPanel panelProgreso;
    private javax.swing.JPanel panelServicios;
    private javax.swing.JScrollPane scrollAutos;
    private javax.swing.JScrollPane scrollProgreso;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tablaAutos;
    private javax.swing.JTable tablaProgreso;
    // End of variables declaration                   

    private void actualizarTablaAutos() {
        modelAutos.setRowCount(0);
        for (int i = 0; i < cliente.getCantidadAutomoviles(); i++) {
            Automovil auto = cliente.getAutomoviles()[i];
            modelAutos.addRow(new Object[]{
                auto.getPlaca(),
                auto.getMarca(),
                auto.getModelo(),
                "Ver Foto"
            });
        }

        // Actualizar combo de autos en pestaña de servicios
        comboAutos.removeAllItems();
        for (int i = 0; i < cliente.getCantidadAutomoviles(); i++) {
            comboAutos.addItem(cliente.getAutomoviles()[i].toString());
        }
    }

    private void actualizarTablaProgreso() {
        modelOrdenes.setRowCount(0);
        // Aquí deberías obtener las órdenes reales del cliente
        // Esto es solo un ejemplo con datos simulados
        modelOrdenes.addRow(new Object[]{123, "ABC123 - Honda Civic", "Diagnóstico", "En servicio"});
        modelOrdenes.addRow(new Object[]{124, "XYZ789 - Toyota Corolla", "Cambio de aceite", "Cola de espera"});
    }

    private boolean validarAutomovil(String placa, String marca, String modelo) {
        if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Todos los campos son obligatorios",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private int generarNumeroOrden() {
        return (int) (Math.random() * 1000) + 100; // Simulación, en realidad usarías un generador secuencial
    }

    class ButtonEditor extends javax.swing.DefaultCellEditor {

        private String label;

        public ButtonEditor(javax.swing.JTextField textField) {
            super(textField);
        }

        @Override
        public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            javax.swing.JButton button = new javax.swing.JButton(label);
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Automovil auto = cliente.getAutomoviles()[row];
                    if (auto.getRutaImagen() != null && !auto.getRutaImagen().isEmpty()) {
                        mostrarImagen(auto.getRutaImagen());
                    } else {
                        JOptionPane.showMessageDialog(ClienteView.this,
                                "No hay imagen disponible para este automóvil",
                                "Imagen no disponible",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }
    }

    private void mostrarImagen(String rutaImagen) {
        javax.swing.JFrame frameImagen = new javax.swing.JFrame("Foto del Automóvil");
        frameImagen.setSize(400, 400);

        ImageIcon icon = new ImageIcon(rutaImagen);
        // Escalar la imagen si es muy grande
        Image img = icon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        javax.swing.JLabel label = new javax.swing.JLabel(new ImageIcon(img));
        frameImagen.add(label);

        frameImagen.setLocationRelativeTo(this);
        frameImagen.setVisible(true);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Mostrar la vista
        Cliente clienteEjemplo = new Cliente("12345678", "Nombre Ejemplo", "usuario", "password", "normal");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteView(clienteEjemplo).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
