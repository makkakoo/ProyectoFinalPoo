
package vista.Paciente;

import Desvanecimiento.Desvanecimiento;
import desplazable.Desface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Paciente;
import modeloDAO.PacienteDAO;
import vista.principal.Principal;

public class ModificarPaciente extends javax.swing.JFrame {
    
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }
    
    Desface desplace;
    int xMouse, yMaouse;
    
    //para desvanecimiento
    Desvanecimiento objDesva ;
    
    Paciente objPaciente = new Paciente();
    PacienteDAO objPacienteDao = new PacienteDAO();
    ArrayList<Paciente> listaPaciente = new ArrayList<>();

    public ModificarPaciente() {
        initComponents();
        desplace= new Desface();
        mostrarPaciente();
        listener();
        mostrarDatos();
        this.setLocationRelativeTo(null);
        
        //desvanecimiento
        objDesva = new Desvanecimiento();
        
    }
    
    private void mostrarPaciente() {
        limpiarCbx();
        listaPaciente.clear();

        listaPaciente = objPacienteDao.listarTodos();
        for (int i = 0; i < listaPaciente.size(); i++) {
            //AGREGANDO LOS DATOS A COMBO BOX
            cbxModificar.addItem(listaPaciente.get(i).getNombre() + " " + listaPaciente.get(i).getApellido());

        }
    }
    private void limpiarCbx() {
        cbxModificar.removeAllItems();
    }

    public void confirmacionAgregar(String a) {
        JOptionPane.showMessageDialog(null, "" + a + " el paciente ");
    }

    private void listener() {
        cbxModificar.addActionListener((ActionEvent e) -> {
            mostrarDatos();
        });
    }

    private void mostrarDatos() {
        int indiPA = cbxModificar.getSelectedIndex();
        String pac = listaPaciente.get(indiPA).getDni();

        txtNombre.setText(objPacienteDao.listarUno(pac).getNombre());
        txtApellido.setText(objPacienteDao.listarUno(pac).getApellido());
        txtEdad.setText(objPacienteDao.listarUno(pac).getEdad() + "");

        txtCelular.setText(objPacienteDao.listarUno(pac).getCelular());
        txtCorreo.setText(objPacienteDao.listarUno(pac).getCorreo());
        txtDireccion.setText(objPacienteDao.listarUno(pac).getDireccion());
        cbxTipo.setSelectedItem(objPacienteDao.listarUno(pac).getTipoSeguro());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Plegable1 = new javax.swing.JPanel();
        imagenConfi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnl3 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblListar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        cbxModificar = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        pnlPartedeArriba2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Plegable1.setBackground(new java.awt.Color(56, 54, 142));

        imagenConfi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/ConfigurarCita.png"))); // NOI18N
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
                .addComponent(imagenConfi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Plegable1Layout.setVerticalGroup(
            Plegable1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Plegable1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );

        jPanel1.add(Plegable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 550));

        jPanel2.setBackground(new java.awt.Color(56, 54, 142));

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

        lblRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/REGISTRAR.png"))); // NOI18N
        lblRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarMouseClicked(evt);
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

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(lblListar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl3Layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(lblRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblListar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 67, Short.MAX_VALUE)
                .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 550));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel10.setText("Paciente a modificar");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel11.setText("Nombres");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel12.setText("Apellidos");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel13.setText("Celular");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel14.setText("Correo Electronico");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, 40));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel15.setText("Direccion");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel16.setText("Edad");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, -1, -1));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel17.setText("Tipo de Seguro");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, -1, -1));

        txtNombre.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 180, -1));

        txtApellido.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 180, -1));

        txtCelular.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 180, -1));

        txtCorreo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 180, -1));

        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 180, -1));

        txtEdad.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 180, -1));

        cbxModificar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jPanel1.add(cbxModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 180, -1));

        jPanel5.setBackground(new java.awt.Color(56, 54, 142));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar Paciente");

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
            .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlExit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 710, 70));

        jPanel3.setBackground(new java.awt.Color(56, 54, 142));

        btnModificar.setBackground(new java.awt.Color(56, 54, 142));
        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 90, 40));

        cbxTipo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completo", "Parcial", "No tiene" }));
        jPanel1.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 180, -1));

        pnlPartedeArriba2.setBackground(new java.awt.Color(249, 249, 249));
        pnlPartedeArriba2.setOpaque(false);
        pnlPartedeArriba2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlPartedeArriba2MouseDragged(evt);
            }
        });
        pnlPartedeArriba2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlPartedeArriba2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlPartedeArriba2Layout = new javax.swing.GroupLayout(pnlPartedeArriba2);
        pnlPartedeArriba2.setLayout(pnlPartedeArriba2Layout);
        pnlPartedeArriba2Layout.setHorizontalGroup(
            pnlPartedeArriba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        pnlPartedeArriba2Layout.setVerticalGroup(
            pnlPartedeArriba2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
        pnlExit1.setBackground(Color.red);
        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
        pnlExit1.setBackground(new Color(56, 54, 142));
        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseExited

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        int indice = cbxModificar.getSelectedIndex();
        String dni = listaPaciente.get(indice).getDni();
        objPaciente.setDni(dni);
        objPaciente.setNombre(txtNombre.getText());
        objPaciente.setApellido(txtApellido.getText());
        objPaciente.setCelular(txtCelular.getText());
        objPaciente.setCorreo(txtCorreo.getText());
        objPaciente.setDireccion(txtDireccion.getText());
        objPaciente.setEdad(Integer.parseInt(txtEdad.getText()));
        
        objPaciente.setTipoSeguro(cbxTipo.getSelectedItem().toString());
        objPacienteDao.modificar(objPaciente);
        confirmacionAgregar("Se modificó correctamente");
    }//GEN-LAST:event_btnModificarMouseClicked

    private void pnlPartedeArriba2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArriba2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMaouse);
    }//GEN-LAST:event_pnlPartedeArriba2MouseDragged

    private void pnlPartedeArriba2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArriba2MousePressed
        xMouse = evt.getX();
        yMaouse = evt.getY();
    }//GEN-LAST:event_pnlPartedeArriba2MousePressed

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        dispose();

        Principal p = new Principal();
        p.setVisible(true);
        p.datosRecep(cod_recep);
        objDesva.Abrir(p, 10);
    }//GEN-LAST:event_btnRegresarMouseClicked

    private void lblRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarMouseClicked
        dispose();
        RegistroPaciente dc = new RegistroPaciente();
        dc.setVisible(true);
        dc.almanecarCodRecep(cod_recep);
        objDesva.Abrir(dc, 10);
    }//GEN-LAST:event_lblRegistrarMouseClicked

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
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Plegable1;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.JComboBox<String> cbxModificar;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblListar;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlPartedeArriba2;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
