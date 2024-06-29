package vista.Cita;

import Desvanecimiento.Desvanecimiento;
import vista.Paciente.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Cita;
import modeloDAO.CitaDAO;
import vista.principal.Principal;
import desplazable.Desface;

public class BuscarCita extends javax.swing.JFrame {
    
    Desvanecimiento objDesva ;

    DefaultTableModel x = new DefaultTableModel();
    DefaultTableModel x2 = new DefaultTableModel();
    CitaDAO objCitaDAO = new CitaDAO();
    ArrayList<Cita> listaCita = new ArrayList<>();

    Desface desplace;
    int xMouse, yMaouse;

    public BuscarCita() {
        initComponents();
        mostrarNombreColumnas();
        mostrarNombreColumnas2();
        mostrarCita();
        pnlMostrar.setVisible(false);
        pnlBuscar.setVisible(false);
        this.setLocationRelativeTo(null);
        desplace = new Desface();
        setBackground(Color.yellow);
        objDesva = new Desvanecimiento();
    }

    private void mostrarCita() {
        limpiarCbx();

        listaCita.clear();
        listaCita = objCitaDAO.listarTodos();
        for (int i = 0; i < listaCita.size(); i++) {
            //AGREGANDO LOS DATOS A COMBO BOX
            cbxModificar.addItem(listaCita.get(i).getCodCita() + "-" + listaCita.get(i).getPac().getNombre() + " " + listaCita.get(i).getPac().getApellido());
        }
        cbxModificar.addActionListener((ActionEvent e) -> {
            mostrarTabla();
        });

    }
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }

    private void limpiarCbx() {
        cbxModificar.removeAllItems();
    }

    private void mostrarNombreColumnas() {
        x.addColumn("CITA");
        x.addColumn("DNI PACIENTE");
        x.addColumn("PAGO");
        x.addColumn("DESCUENTO");
        x.addColumn("MOTIVO");
        x.addColumn("CODIGO DOC");
        x.addColumn("ESPECIALIDAD");
        x.addColumn("FECHA");
        x.addColumn("TURNO");

        tblBuscar.setModel(x);
    }

    private void mostrarNombreColumnas2() {
        x2.addColumn("CITA");
        x2.addColumn("DNI PACIENTE");
        x2.addColumn("PAGO");
        x2.addColumn("DESCUENTO");
        x2.addColumn("MOTIVO");
        x2.addColumn("CODIGO DOC");
        x2.addColumn("ESPECIALIDAD");
        x2.addColumn("FECHA");
        x2.addColumn("TURNO");

        tblMostrarCitas.setModel(x2);
    }

    private void mostrarTabla() {
        limpiarTabla();

        String selectedItem = cbxModificar.getSelectedItem().toString();
        String cod = selectedItem.split("-")[0].trim();

        Object[] data = {objCitaDAO.listarUno(cod).getCodCita(), objCitaDAO.listarUno(cod).getPac().getDni(),
            objCitaDAO.listarUno(cod).getPago(), objCitaDAO.listarUno(cod).getDescuento(),
            objCitaDAO.listarUno(cod).getMotivoConsulta(),
            objCitaDAO.listarUno(cod).getDoc().getCODIGO_DOCTOR() + " - " + objCitaDAO.listarUno(cod).getDoc().getNombre(),
            objCitaDAO.listarUno(cod).getDoc().getObjEspe().getNomEspe(),
            objCitaDAO.listarUno(cod).getDoc().getFecha(), objCitaDAO.listarUno(cod).getDoc().getTurno()};

        x.addRow(data);
    }

    private void mostrarTabla2() {
        limpiarTabla2();
        listaCita.clear();
        listaCita = objCitaDAO.listarTodos();

        for (int i = 0; i < listaCita.size(); i++) {
            //AGREGANDO LOS DATOS A LA TABLA
            Object[] data = {listaCita.get(i).getCodCita(), listaCita.get(i).getPac().getDni(), listaCita.get(i).getPago(),
                listaCita.get(i).getDescuento(), listaCita.get(i).getMotivoConsulta(),
                listaCita.get(i).getDoc().getCODIGO_DOCTOR() + " - " + listaCita.get(i).getDoc().getApellido(),
                listaCita.get(i).getDoc().getObjEspe().getNomEspe(),
                listaCita.get(i).getDoc().getFecha(), listaCita.get(i).getDoc().getTurno()};
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
        lblInicio = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        pnlMostrar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMostrarCitas = new javax.swing.JTable();
        pnlBuscar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxModificar = new javax.swing.JComboBox<>();
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

        lblInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/inicio.png"))); // NOI18N
        lblInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInicioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl3Layout.createSequentialGroup()
                        .addGroup(pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lblRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(lblInicio))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 550));

        jPanel3.setBackground(new java.awt.Color(56, 54, 142));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar Cita");

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
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
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

        tblMostrarCitas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMostrarCitas.setFocusable(false);
        tblMostrarCitas.setRowHeight(25);
        tblMostrarCitas.setSelectionBackground(new java.awt.Color(56, 54, 142));
        tblMostrarCitas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblMostrarCitas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblMostrarCitas);

        javax.swing.GroupLayout pnlMostrarLayout = new javax.swing.GroupLayout(pnlMostrar);
        pnlMostrar.setLayout(pnlMostrarLayout);
        pnlMostrarLayout.setHorizontalGroup(
            pnlMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMostrarLayout.setVerticalGroup(
            pnlMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnlMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 710, 350));

        pnlBuscar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Elegir paciente");

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
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pnlBuscarLayout.setVerticalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        jPanel1.add(pnlBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 610, 360));

        buttonGroup1.add(RbtMostrar);
        RbtMostrar.setText("Mostrar todos las citas");
        RbtMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(RbtMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        buttonGroup1.add(rbtBuscar);
        rbtBuscar.setText("Listar una cita");
        rbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(rbtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, -1, -1));

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
            .addGap(0, 900, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

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
            desplace.desplazarDerecha(Plegable1, Plegable1.getX(), 105, 10, 10);
            pnl3.setVisible(true);
        } else if (Plegable1.getX() == 105) {
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

    private void RbtMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtMostrarActionPerformed
        pnlMostrar.setVisible(true);
        pnlBuscar.setVisible(false);
        mostrarTabla2();
    }//GEN-LAST:event_RbtMostrarActionPerformed

    private void rbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBuscarActionPerformed
        pnlBuscar.setVisible(true);
        pnlMostrar.setVisible(false);
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
        AgendarCita ac = new AgendarCita();
        ac.setVisible(true);
        ac.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ac, 10);
    }//GEN-LAST:event_lblRegistrarMouseClicked

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked

        dispose();
        ModificarCita mc = new ModificarCita();
        mc.setVisible(true);
        mc.almanecarCodRecep(cod_recep);
        objDesva.Abrir(mc, 10);
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        dispose();
        EliminarCita ep = new EliminarCita();
        ep.setVisible(true);
        ep.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ep, 10);
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void lblInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseClicked
        dispose();
        Principal p = new Principal();
        p.setVisible(true);
        p.datosRecep(cod_recep);
        objDesva.Abrir(p, 10);
    }//GEN-LAST:event_lblInicioMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Plegable1;
    private javax.swing.JRadioButton RbtMostrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxModificar;
    private javax.swing.JLabel imagenConfi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlMostrar;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JRadioButton rbtBuscar;
    private javax.swing.JTable tblBuscar;
    private javax.swing.JTable tblMostrarCitas;
    // End of variables declaration//GEN-END:variables
}
