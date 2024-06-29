package vista.Paciente;

import Desvanecimiento.Desvanecimiento;
import desplazable.Desface;
import java.awt.Color;
import modelo.Paciente;
import modeloDAO.PacienteDAO;
import javax.swing.JOptionPane;
import vista.principal.Principal;

public class RegistroPaciente extends javax.swing.JFrame {
    //para desvanecimiento
    Desvanecimiento objDesva ;
    
    int xMouse, yMaouse;
    
    Paciente objPaciente = new Paciente();
    PacienteDAO objPacienteDao = new PacienteDAO();
    Desface desplace;

    public RegistroPaciente() {
        initComponents();
        objDesva = new Desvanecimiento();
        desplace = new Desface();
        pnl3.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        Plegable1 = new javax.swing.JPanel();
        imagenConfi = new javax.swing.JLabel();
        pnl3 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblListar = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlPartedeArriba = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Plegable1.setBackground(new java.awt.Color(56, 54, 142));

        imagenConfi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenConfi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/ConfigurarCita.png"))); // NOI18N
        imagenConfi.setText("Configuración");
        imagenConfi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imagenConfi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagenConfiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Plegable1Layout = new javax.swing.GroupLayout(Plegable1);
        Plegable1.setLayout(Plegable1Layout);
        Plegable1Layout.setHorizontalGroup(
            Plegable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Plegable1Layout.createSequentialGroup()
                .addComponent(imagenConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );
        Plegable1Layout.setVerticalGroup(
            Plegable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Plegable1Layout.createSequentialGroup()
                .addComponent(imagenConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 487, Short.MAX_VALUE))
        );

        jPanel1.add(Plegable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 550));

        pnl3.setBackground(new java.awt.Color(56, 54, 142));

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/inicio.png"))); // NOI18N
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMouseClicked(evt);
            }
        });

        lblEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/ELIMINAR.png"))); // NOI18N
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEliminarMouseClicked(evt);
            }
        });

        lblListar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblListar.setForeground(new java.awt.Color(255, 255, 255));
        lblListar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/BUSCAR.png"))); // NOI18N
        lblListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblListarMouseClicked(evt);
            }
        });

        lblModificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblModificar.setForeground(new java.awt.Color(255, 255, 255));
        lblModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/MODIFICAR.png"))); // NOI18N
        lblModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl3Layout.createSequentialGroup()
                        .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblListar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblListar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 550));

        jPanel2.setBackground(new java.awt.Color(56, 54, 142));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 550));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel10.setText("Dni");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel11.setText("Nombres");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel12.setText("Apellidos");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel13.setText("Celular");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel14.setText("Correo Electronico");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 309, -1, 40));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel15.setText("Direccion");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel16.setText("Edad");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel17.setText("Tipo de Seguro");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, -1));

        txtDni.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 180, -1));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 180, -1));

        txtApellidos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 180, -1));

        txtCelular.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 180, -1));

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 315, 180, -1));

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 180, -1));

        txtEdad.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 180, -1));

        cbxTipo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completo", "Parcial", "No tiene" }));
        jPanel1.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 180, -1));

        jPanel3.setBackground(new java.awt.Color(56, 54, 142));

        jLabel18.setBackground(new java.awt.Color(56, 54, 142));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Enviar");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 90, 40));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/s.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 40, 80));

        jPanel5.setBackground(new java.awt.Color(56, 54, 142));

        pnlExit1.setBackground(new java.awt.Color(56, 54, 142));

        Exit.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Exit.setText("X");
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlExit1Layout = new javax.swing.GroupLayout(pnlExit1);
        pnlExit1.setLayout(pnlExit1Layout);
        pnlExit1Layout.setHorizontalGroup(
            pnlExit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExit1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExit1Layout.setVerticalGroup(
            pnlExit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExit1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRAR PACIENTE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 205, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(198, 198, 198)
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 710, 60));

        pnlPartedeArriba.setBackground(new java.awt.Color(249, 249, 249));
        pnlPartedeArriba.setOpaque(false);
        pnlPartedeArriba.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlPartedeArribaMouseDragged(evt);
            }
        });
        pnlPartedeArriba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlPartedeArribaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlPartedeArribaLayout = new javax.swing.GroupLayout(pnlPartedeArriba);
        pnlPartedeArriba.setLayout(pnlPartedeArribaLayout);
        pnlPartedeArribaLayout.setHorizontalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imagenConfiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenConfiMouseClicked
        if (Plegable1.getX() == 0) {
            desplace.desplazarDerecha(Plegable1, Plegable1.getX(), 90, 10, 10);
            pnl3.setVisible(true);
        } else if (Plegable1.getX() == 90) {
            desplace.desplazarIzquierda(Plegable1, Plegable1.getX(), 0, 10, 10);
            pnl3.setVisible(false);
        }
    }//GEN-LAST:event_imagenConfiMouseClicked
    
    
    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        
        Paciente objPaciente = new Paciente();
        PacienteDAO objPacienteDAO =  new PacienteDAO();

        // AGREGANDO EN TABLA PERSONA
        objPaciente.setDni(txtDni.getText());
        objPaciente.setNombre(txtNombre.getText());
        objPaciente.setApellido(txtApellidos.getText());
        objPaciente.setCelular(txtCelular.getText());
        objPaciente.setCorreo(txtCorreo.getText());
        objPaciente.setDireccion(txtDireccion.getText());
        objPaciente.setEdad(Integer.parseInt(txtEdad.getText()));
        
        objPaciente.setTipoSeguro(cbxTipo.getSelectedItem().toString());
        
        objPacienteDAO.agregar(objPaciente);
        
        
        JOptionPane.showMessageDialog(null,"Se agregó al paciente correctamente");
    }//GEN-LAST:event_jLabel18MouseClicked

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
        pnlExit1.setBackground(new Color(56, 54, 142));
        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseExited

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
        pnlExit1.setBackground(Color.red);
        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void pnlPartedeArribaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMaouse);
    }//GEN-LAST:event_pnlPartedeArribaMouseDragged

    private void pnlPartedeArribaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMousePressed
        xMouse = evt.getX();
        yMaouse = evt.getY();
    }//GEN-LAST:event_pnlPartedeArribaMousePressed

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        dispose();

        Principal p = new Principal();
        p.setVisible(true);
        p.datosRecep(cod_recep);
        objDesva.Abrir(p, 10);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked

        dispose();
        EliminarPaciente ec = new EliminarPaciente();
        ec.setVisible(true);
        ec.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ec, 10);
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void lblListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListarMouseClicked
        dispose();
        ListarPaciente bd = new ListarPaciente();
        bd.setVisible(true);
        
        bd.almanecarCodRecep(cod_recep);
        objDesva.Abrir(bd, 10);
    }//GEN-LAST:event_lblListarMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        dispose();
        ModificarPaciente md = new ModificarPaciente();
        md.setVisible(true);
        md.almanecarCodRecep(cod_recep);
        objDesva.Abrir(md, 10);
    }//GEN-LAST:event_lblModificarMouseClicked


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Plegable1;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel imagenConfi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblListar;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
