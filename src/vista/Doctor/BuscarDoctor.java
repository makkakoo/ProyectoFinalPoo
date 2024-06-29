
package vista.Doctor;

import Desvanecimiento.Desvanecimiento;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Doctor;
import modeloDAO.DoctorDAO;
import vista.principal.Principal;
import desplazable.Desface;
import java.awt.Color;


public class BuscarDoctor extends javax.swing.JFrame {
    
    Desvanecimiento objDesva ;

    DefaultTableModel x = new DefaultTableModel();
    DefaultTableModel x2 = new DefaultTableModel();

    ArrayList<Doctor> listarUno = new ArrayList<>();
    DoctorDAO objDoctorDao = new DoctorDAO();
    Desface desplace;
    
    int xMouse, yMaouse;
    
    public BuscarDoctor() {
        initComponents();
        mostrarNombreColumnas();
        mostrarNombreColumnas2();
        mostrarDoctor();
        mostrarTabla();
        pnlMostrar.setVisible(false);
        pnlBuscar.setVisible(false);
        this.setLocationRelativeTo(null);
        desplace= new Desface();
        setBackground(Color.yellow);
        objDesva = new Desvanecimiento();
    }
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }
    
    private void mostrarDoctor() {

        limpiarCbx();
        listarUno.clear();
        listarUno = objDoctorDao.todosDoctoresSinDuplicar();

        for (int i = 0; i < listarUno.size(); i++) {
            // AGREGANDO LOS DATOS A COMBO BOX
            cbxBuscar.addItem(listarUno.get(i).getNombre() + " " + listarUno.get(i).getApellido() + " - " + listarUno.get(i).getCODIGO_DOCTOR());
        }

        // ASIGNAR EL ACTION LISTENER AL COMBO BOX
        cbxBuscar.addActionListener((ActionEvent e) -> {
            mostrarTabla();
        });
    }

    private void limpiarCbx() {
        cbxBuscar.removeAllItems();
    }

    private void mostrarNombreColumnas() {
        x.addColumn("Codigo");
        x.addColumn("Dni");
        x.addColumn("Nombre");
        x.addColumn("Apellido");
        x.addColumn("Edad");
        x.addColumn("Celular");
        x.addColumn("Correo");
        x.addColumn("Direccion");
        x.addColumn("Especialidad");
        x.addColumn("Fecha");
        x.addColumn("Turno");

        tblBuscar.setModel(x);
    }

    private void mostrarTabla() {
        limpiarTabla();
        DoctorDAO objDoctorDao = new DoctorDAO();
        ArrayList<Doctor> listaDoctor = new ArrayList<>();

        int inde = cbxBuscar.getSelectedIndex();
        String dni = listarUno.get(inde).getDni();
        listaDoctor = objDoctorDao.listarUno(dni);

        for (int i = 0; i < listaDoctor.size(); i++) {
            Object[] data = {listaDoctor.get(i).getCODIGO_DOCTOR(), listaDoctor.get(i).getDni(), listaDoctor.get(i).getNombre(),
                listaDoctor.get(i).getApellido(), listaDoctor.get(i).getEdad(), listaDoctor.get(i).getCelular(),
                listaDoctor.get(i).getCorreo(), listaDoctor.get(i).getDireccion(), listaDoctor.get(i).getObjEspe().getNomEspe(),
                listaDoctor.get(i).getFecha(),
                listaDoctor.get(i).getTurno()};
            x.addRow(data);
        }
    }

    public void limpiarTabla() {

        x.setRowCount(0);
    }

    private void mostrarNombreColumnas2() {
        x2.addColumn("Codigo");
        x2.addColumn("Dni");
        x2.addColumn("Nombre");
        x2.addColumn("Apellido");
        x2.addColumn("Edad");
        x2.addColumn("Celular");
        x2.addColumn("Correo");
        x2.addColumn("Direccion");
        x2.addColumn("Especialidad");
        x2.addColumn("Fecha");
        x2.addColumn("Turno");

        tblMostrarDoctores.setModel(x2);
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
        pnlDesaparecer = new javax.swing.JPanel();
        lblRegistrar = new javax.swing.JLabel();
        btnModificar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        pnlMostrar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrarDoctores = new javax.swing.JTable();
        pnlBuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscar = new javax.swing.JTable();
        RbtMostrar = new javax.swing.JRadioButton();
        rbtBuscar = new javax.swing.JRadioButton();
        pnlPartedeArriba = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Plegable1.setBackground(new java.awt.Color(56, 54, 142));

        imagenConfi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/ConfigurarCita.png"))); // NOI18N
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

        pnlDesaparecer.setBackground(new java.awt.Color(56, 54, 142));

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

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/MODIFICAR.png"))); // NOI18N
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
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

        btnRegresar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegresar1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/inicio.png"))); // NOI18N
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDesaparecerLayout = new javax.swing.GroupLayout(pnlDesaparecer);
        pnlDesaparecer.setLayout(pnlDesaparecerLayout);
        pnlDesaparecerLayout.setHorizontalGroup(
            pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesaparecerLayout.createSequentialGroup()
                .addComponent(lblRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDesaparecerLayout.createSequentialGroup()
                .addGroup(pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDesaparecerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlDesaparecerLayout.setVerticalGroup(
            pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesaparecerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlDesaparecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 100, 480));

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

        jPanel3.setBackground(new java.awt.Color(56, 54, 142));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Doctor");

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
                .addContainerGap()
                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
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
                .addContainerGap(419, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(377, 377, 377)
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 1030, 80));

        pnlMostrar.setBackground(new java.awt.Color(255, 255, 255));

        tblMostrarDoctores.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMostrarDoctores.setFocusable(false);
        tblMostrarDoctores.setRowHeight(25);
        tblMostrarDoctores.setSelectionBackground(new java.awt.Color(56, 54, 142));
        tblMostrarDoctores.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblMostrarDoctores.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblMostrarDoctores);

        javax.swing.GroupLayout pnlMostrarLayout = new javax.swing.GroupLayout(pnlMostrar);
        pnlMostrar.setLayout(pnlMostrarLayout);
        pnlMostrarLayout.setHorizontalGroup(
            pnlMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );
        pnlMostrarLayout.setVerticalGroup(
            pnlMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(pnlMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 890, 350));

        pnlBuscar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nombre del doctor");

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
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
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

        jPanel1.add(pnlBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 850, 360));

        buttonGroup1.add(RbtMostrar);
        RbtMostrar.setText("Buscar un doctor");
        RbtMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(RbtMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        buttonGroup1.add(rbtBuscar);
        rbtBuscar.setText("Mostrar todos los doctores");
        rbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(rbtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, -1, -1));

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
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imagenConfiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenConfiMouseClicked
        if (Plegable1.getX() == 0) {
            desplace.desplazarDerecha(Plegable1, Plegable1.getX(), 80, 10, 10);
            pnlDesaparecer.setVisible(true);
        } else if (Plegable1.getX() == 80) {
            desplace.desplazarIzquierda(Plegable1, Plegable1.getX(), 0, 10, 10);
            pnlDesaparecer.setVisible(false);
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
        pnlMostrar.setVisible(false);
        pnlBuscar.setVisible(true);
    }//GEN-LAST:event_RbtMostrarActionPerformed

    private void rbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBuscarActionPerformed
        pnlMostrar.setVisible(true);
        pnlBuscar.setVisible(false);
        limpiarTabla2();
        DoctorDAO objDoctorDao = new DoctorDAO();
        ArrayList<Doctor> listaDoctor = new ArrayList<>();

        listaDoctor = objDoctorDao.listarTodos();

        for (int i = 0; i < listaDoctor.size(); i++) {

//                listaHorarioMuchos = objHorarioDAO.listarTodosConCod(listaDoctormUCHOS.get(i).getCodDoctor());
            //AGREGANDO LOS DATOS A LA TABLA
            Object[] data = {listaDoctor.get(i).getCODIGO_DOCTOR(), listaDoctor.get(i).getDni(),
                listaDoctor.get(i).getNombre(), listaDoctor.get(i).getApellido(), listaDoctor.get(i).getEdad(),
                listaDoctor.get(i).getCelular(), listaDoctor.get(i).getCorreo(), listaDoctor.get(i).getDireccion(),
                listaDoctor.get(i).getObjEspe().getNomEspe(),
                listaDoctor.get(i).getFecha(),
                listaDoctor.get(i).getTurno()};
            x2.addRow(data);}
    }//GEN-LAST:event_rbtBuscarActionPerformed

    private void pnlPartedeArribaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMaouse);
    }//GEN-LAST:event_pnlPartedeArribaMouseDragged

    private void pnlPartedeArribaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMousePressed
        xMouse = evt.getX();
        yMaouse = evt.getY();
    }//GEN-LAST:event_pnlPartedeArribaMousePressed

    private void lblRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarMouseClicked
        dispose();
        DoctorRegistro rd = new DoctorRegistro();
        rd.setVisible(true);
        rd.almanecarCodRecep(cod_recep);
        objDesva.Abrir(rd, 10);
    }//GEN-LAST:event_lblRegistrarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        dispose();
        ModificarDoctor md = new ModificarDoctor();
        md.setVisible(true);
        md.almanecarCodRecep(cod_recep);
        objDesva.Abrir(md, 10);
    }//GEN-LAST:event_btnModificarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        dispose();
        ConfiEspecialidad ce = new ConfiEspecialidad();
        ce.setVisible(true);
        ce.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ce, 10);
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void btnRegresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresar1MouseClicked
        dispose();

        Principal p = new Principal();
        p.setVisible(true);
        p.datosRecep(cod_recep);
        objDesva.Abrir(p, 10);
    }//GEN-LAST:event_btnRegresar1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Plegable1;
    private javax.swing.JRadioButton RbtMostrar;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnRegresar1;
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
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlDesaparecer;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlMostrar;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JRadioButton rbtBuscar;
    private javax.swing.JTable tblBuscar;
    private javax.swing.JTable tblMostrarDoctores;
    // End of variables declaration//GEN-END:variables
}
