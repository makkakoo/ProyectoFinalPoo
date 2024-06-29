
package vista.Paciente;

import Desvanecimiento.Desvanecimiento;
import desplazable.Desface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Paciente;
import modeloDAO.PacienteDAO;
import vista.principal.Principal;

public class ListarPaciente extends javax.swing.JFrame {
    
    Desvanecimiento objDesva ;
    

    DefaultTableModel x = new DefaultTableModel();
    DefaultTableModel x2 = new DefaultTableModel();
    PacienteDAO objPacienteDao = new PacienteDAO();
    ArrayList<Paciente> listaPaciente = new ArrayList<>();
    
    
    Desface desplace;
    int xMouse, yMouse;
    
    public ListarPaciente() {
        initComponents();
        mostrarNombreColumnas();
        mostrarNombreColumnas2();
        mostrarPaciente();
        pnlBuscar.setVisible(false);
        pnlMostrar.setVisible(false);
        this.setLocationRelativeTo(null);
        objDesva = new Desvanecimiento();
        desplace= new Desface();
        tblMostrarPacientes.getTableHeader().setBackground(Color.red);
    }
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }
    
    private void mostrarPaciente() {
        limpiarCbx();
        listaPaciente.clear();
        listaPaciente = objPacienteDao.listarTodos();
        for (int i = 0; i < listaPaciente.size(); i++) {
            //AGREGANDO LOS DATOS A COMBO BOX
            cbxBuscar.addItem(listaPaciente.get(i).getNombre()+ " " + listaPaciente.get(i).getApellido()+ " - " + listaPaciente.get(i).getDni());

        }

        cbxBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarTabla();
            }
        });
    }
    
    private void limpiarCbx() {
        cbxBuscar.removeAllItems();
    }
    
    private void mostrarNombreColumnas() {
        x.addColumn("Dni");
        x.addColumn("Nombre");
        x.addColumn("Apellido");
        x.addColumn("Edad");
        x.addColumn("Celular");
        x.addColumn("Correo");
        x.addColumn("Direccion");

        tblBuscar.setModel(x);
    }
    
    private void mostrarNombreColumnas2() {
        x2.addColumn("Dni");
        x2.addColumn("Nombre");
        x2.addColumn("Apellido");
        x2.addColumn("Edad");
        x2.addColumn("Celular");
        x2.addColumn("Correo");
        x2.addColumn("Direccion");

        tblMostrarPacientes.setModel(x2);
    }
    
    private void mostrarTabla() {
        limpiarTabla();
        int indiceCbx = cbxBuscar.getSelectedIndex();
        String dn1 = listaPaciente.get(indiceCbx).getDni();

        Object[] data = {objPacienteDao.listarUno(dn1).getDni(),
            objPacienteDao.listarUno(dn1).getNombre(), objPacienteDao.listarUno(dn1).getApellido(), objPacienteDao.listarUno(dn1).getEdad(),
            objPacienteDao.listarUno(dn1).getCelular(), objPacienteDao.listarUno(dn1).getCorreo(), objPacienteDao.listarUno(dn1).getDireccion()};
        x.addRow(data);
    }
    
    private void mostrarTabla2() {
        limpiarTabla2();
        listaPaciente.clear();
        listaPaciente = objPacienteDao.listarTodos();

        for (int i = 0; i < listaPaciente.size(); i++) {
            //AGREGANDO LOS DATOS A LA TABLA
            Object[] data = {listaPaciente.get(i).getDni(),
                listaPaciente.get(i).getNombre(), listaPaciente.get(i).getApellido(), listaPaciente.get(i).getEdad(),
                listaPaciente.get(i).getCelular(), listaPaciente.get(i).getCorreo(), listaPaciente.get(i).getDireccion()};
            x2.addRow(data);
        }
        }
    public void limpiarTabla() {
        x.setRowCount(0);
        }
    public void limpiarTabla2() {
        x2.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Plegable1 = new javax.swing.JPanel();
        imagenConfi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnl3 = new javax.swing.JPanel();
        lblRegistrar = new javax.swing.JLabel();
        lblModificar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        pnlMostrar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrarPacientes = new javax.swing.JTable();
        pnlBuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscar = new javax.swing.JTable();
        RbtMostrar = new javax.swing.JRadioButton();
        rbtBuscar = new javax.swing.JRadioButton();

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
                .addComponent(imagenConfi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(480, Short.MAX_VALUE))
        );

        jPanel1.add(Plegable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 550));

        jPanel2.setBackground(new java.awt.Color(56, 54, 142));

        pnl3.setBackground(new java.awt.Color(56, 54, 142));

        lblRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/REGISTRAR.png"))); // NOI18N
        lblRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegistrarMouseClicked(evt);
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

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistrar)
                    .addComponent(btnRegresar)
                    .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(lblModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addComponent(lblRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 550));

        jPanel3.setBackground(new java.awt.Color(56, 54, 142));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCAR PACIENTE");

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
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExit1Layout.setVerticalGroup(
            pnlExit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 800, 80));

        pnlMostrar.setBackground(new java.awt.Color(255, 255, 255));

        tblMostrarPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMostrarPacientes.setCellSelectionEnabled(true);
        tblMostrarPacientes.setFocusable(false);
        tblMostrarPacientes.setRowHeight(25);
        tblMostrarPacientes.setSelectionBackground(new java.awt.Color(56, 54, 142));
        tblMostrarPacientes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblMostrarPacientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblMostrarPacientes);
        tblMostrarPacientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout pnlMostrarLayout = new javax.swing.GroupLayout(pnlMostrar);
        pnlMostrar.setLayout(pnlMostrarLayout);
        pnlMostrarLayout.setHorizontalGroup(
            pnlMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        pnlMostrarLayout.setVerticalGroup(
            pnlMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(pnlMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 570, 350));

        pnlBuscar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nombre del paciente");

        tblBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBuscar);

        javax.swing.GroupLayout pnlBuscarLayout = new javax.swing.GroupLayout(pnlBuscar);
        pnlBuscar.setLayout(pnlBuscarLayout);
        pnlBuscarLayout.setHorizontalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        pnlBuscarLayout.setVerticalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jPanel1.add(pnlBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 610, 360));

        buttonGroup1.add(RbtMostrar);
        RbtMostrar.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        RbtMostrar.setText("Mostrar todos los pacientes");
        RbtMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(RbtMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));

        buttonGroup1.add(rbtBuscar);
        rbtBuscar.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        rbtBuscar.setText("Listar un paciente");
        rbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(rbtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imagenConfiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenConfiMouseClicked
        if (Plegable1.getX() == 0) {
            desplace.desplazarDerecha(Plegable1, Plegable1.getX(), 100, 10, 10);
            pnl3.setVisible(true);
        } else if (Plegable1.getX() == 100) {
            desplace.desplazarIzquierda(Plegable1, Plegable1.getX(), 0, 10, 5);
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

    private void RbtMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtMostrarActionPerformed
        pnlMostrar.setVisible(true);
        pnlBuscar.setVisible(false);
        mostrarTabla2();
    }//GEN-LAST:event_RbtMostrarActionPerformed

    private void rbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBuscarActionPerformed
        pnlBuscar.setVisible(true);
        pnlMostrar.setVisible(false);
    }//GEN-LAST:event_rbtBuscarActionPerformed

    private void lblRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarMouseClicked
        dispose();
        RegistroPaciente rp = new RegistroPaciente();
        rp.setVisible(true);
        rp.almanecarCodRecep(cod_recep);
        objDesva.Abrir(rp, 10);
    }//GEN-LAST:event_lblRegistrarMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        dispose();
        ModificarPaciente mp = new ModificarPaciente();
        mp.setVisible(true);
        mp.almanecarCodRecep(cod_recep);
        objDesva.Abrir(mp, 10);
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        dispose();
        EliminarPaciente ep = new EliminarPaciente();
        ep.setVisible(true);
        ep.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ep, 10);
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void btnRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseClicked
        dispose();

        Principal p = new Principal();
        p.setVisible(true);
        p.datosRecep(cod_recep);
        objDesva.Abrir(p, 10);
    }//GEN-LAST:event_btnRegresarMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Plegable1;
    private javax.swing.JRadioButton RbtMostrar;
    private javax.swing.JLabel btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxBuscar;
    private javax.swing.JLabel imagenConfi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlMostrar;
    private javax.swing.JRadioButton rbtBuscar;
    private javax.swing.JTable tblBuscar;
    private javax.swing.JTable tblMostrarPacientes;
    // End of variables declaration//GEN-END:variables
}
