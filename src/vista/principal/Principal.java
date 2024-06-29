package vista.principal;

import Desvanecimiento.Desvanecimiento;
import java.awt.Color;
import modelo.Recepcionista;
import modeloDAO.RecepcionistaDAO;
import vista.Cita.AgendarCita;
import vista.Cita.BuscarCita;
import vista.Doctor.BuscarDoctor;
import vista.Doctor.DoctorRegistro;
import vista.Paciente.ListarPaciente;
import vista.Paciente.RegistroPaciente;

/**
 *
 * @author GRACE
 */
public class Principal extends javax.swing.JFrame {

    String cod_recep;
    int xMouse, yMaouse;

    //para desvanecimiento
    Desvanecimiento objDesva;

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        //desvanecimiento
        objDesva = new Desvanecimiento();
        lblMrPeet.setVisible(false);
        lblDoctorTV.setVisible(false);
        lblWalter.setVisible(false);
    }

    public void datosRecep(String cod) {
        Recepcionista r = new Recepcionista();
        RecepcionistaDAO rDao = new RecepcionistaDAO();
        
        lblNombre.setText(rDao.listarUno(cod).getNombre() + " " + rDao.listarUno(cod).getApellido());
        lblCodRecep.setText(rDao.listarUno(cod).getCodRecepcionista());
        lblDni.setText(rDao.listarUno(cod).getDni());
        
        
        
        cod_recep = rDao.listarUno(cod).getCodRecepcionista();
        if (rDao.listarUno(cod).getCodRecepcionista().equals("R001")) {
            lblMrPeet.setVisible(true);
            lblDoctorTV.setVisible(false);
            lblWalter.setVisible(false);

        } else if (rDao.listarUno(cod).getCodRecepcionista().equals("R002")) {
            lblMrPeet.setVisible(false);
            lblDoctorTV.setVisible(false);
            lblWalter.setVisible(true);
        } else {
            lblMrPeet.setVisible(false);
            lblDoctorTV.setVisible(true);
            lblWalter.setVisible(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCodRecep = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblMrPeet = new javax.swing.JLabel();
        lblDoctorTV = new javax.swing.JLabel();
        lblWalter = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlExit = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblRDoctor = new javax.swing.JLabel();
        lblRPaciente = new javax.swing.JLabel();
        lblRCita = new javax.swing.JLabel();
        lblBuscarDoctor = new javax.swing.JLabel();
        lblBuscarPaciente = new javax.swing.JLabel();
        lblBuscarCita = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnlPartedeArriba = new javax.swing.JPanel();
        lblRDoctor1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 226, 120, 20));

        lblCodRecep.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        lblCodRecep.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblCodRecep, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 290, 120, 20));

        lblDni.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        lblDni.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 360, 120, 20));

        lblMrPeet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/mr peet netbeans.png"))); // NOI18N
        jPanel1.add(lblMrPeet, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 20, 130, 140));

        lblDoctorTV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoctorTV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/doctor netbeans_1.png"))); // NOI18N
        jPanel1.add(lblDoctorTV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 170));

        lblWalter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWalter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/walter neetbeans.png"))); // NOI18N
        jPanel1.add(lblWalter, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 150));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/salir.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 600, 170, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/fondo izquierda.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 690));

        pnlExit.setBackground(new java.awt.Color(255, 255, 255));

        Exit.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 0, 0));
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

        javax.swing.GroupLayout pnlExitLayout = new javax.swing.GroupLayout(pnlExit);
        pnlExit.setLayout(pnlExitLayout);
        pnlExitLayout.setHorizontalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExitLayout.createSequentialGroup()
                    .addGap(0, 3, Short.MAX_VALUE)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlExitLayout.setVerticalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlExitLayout.createSequentialGroup()
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        jPanel1.add(pnlExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 60, 60));

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel14.setText("Busquedas");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 230, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/LOGO GRANDEEEEEEE.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 330, 60));

        lblRDoctor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/registrar doctor.png"))); // NOI18N
        lblRDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRDoctorMouseClicked(evt);
            }
        });
        jPanel1.add(lblRDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 180, 180));

        lblRPaciente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblRPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/registrar paciente.png"))); // NOI18N
        lblRPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRPacienteMouseClicked(evt);
            }
        });
        jPanel1.add(lblRPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 190, 200));

        lblRCita.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/registrar cita.png"))); // NOI18N
        lblRCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRCitaMouseClicked(evt);
            }
        });
        jPanel1.add(lblRCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, 190, 180));

        lblBuscarDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBuscarDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/buscar doctor.png"))); // NOI18N
        lblBuscarDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscarDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarDoctorMouseClicked(evt);
            }
        });
        jPanel1.add(lblBuscarDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 190, 190));

        lblBuscarPaciente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/buscar paciente.jpg.png"))); // NOI18N
        lblBuscarPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarPacienteMouseClicked(evt);
            }
        });
        jPanel1.add(lblBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 190, 190));

        lblBuscarCita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBuscarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/buscar cita.png"))); // NOI18N
        lblBuscarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarCitaMouseClicked(evt);
            }
        });
        jPanel1.add(lblBuscarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 470, 200, 190));

        jLabel17.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel17.setText("Registros ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 230, -1));

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
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 50));

        lblRDoctor1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRDoctor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRDoctor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRDoctor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRDoctor1MouseClicked(evt);
            }
        });
        jPanel1.add(lblRDoctor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 180, 180));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
        pnlExit.setBackground(Color.red);
        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
        pnlExit.setBackground(Color.white);
        Exit.setForeground(Color.red);
    }//GEN-LAST:event_ExitMouseExited

    private void lblRPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRPacienteMouseClicked
        dispose();
        RegistroPaciente mp = new RegistroPaciente();
        mp.setVisible(true);
        mp.almanecarCodRecep(cod_recep);
        objDesva.Abrir(mp, 10);
    }//GEN-LAST:event_lblRPacienteMouseClicked

    private void lblRCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRCitaMouseClicked
        dispose();
        AgendarCita ac = new AgendarCita();
        ac.setVisible(true);
        ac.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ac, 10);
    }//GEN-LAST:event_lblRCitaMouseClicked

    private void pnlPartedeArribaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMaouse);
    }//GEN-LAST:event_pnlPartedeArribaMouseDragged

    private void pnlPartedeArribaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMousePressed
        xMouse = evt.getX();
        yMaouse = evt.getY();
    }//GEN-LAST:event_pnlPartedeArribaMousePressed

    private void lblBuscarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarPacienteMouseClicked
        dispose();
        ListarPaciente lp = new ListarPaciente();
        lp.almanecarCodRecep(cod_recep);
        lp.setVisible(true);
        objDesva.Abrir(lp, 10);
    }//GEN-LAST:event_lblBuscarPacienteMouseClicked

    private void lblBuscarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarCitaMouseClicked
        dispose();
        BuscarCita bc = new BuscarCita();
        bc.setVisible(true);
        bc.almanecarCodRecep(cod_recep);

        objDesva.Abrir(bc, 10);
    }//GEN-LAST:event_lblBuscarCitaMouseClicked

    private void lblBuscarDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarDoctorMouseClicked
        dispose();
        BuscarDoctor bd = new BuscarDoctor();
        bd.setVisible(true);
        bd.almanecarCodRecep(cod_recep);
       
        objDesva.Abrir(bd, 10);
    }//GEN-LAST:event_lblBuscarDoctorMouseClicked

    private void lblRDoctor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRDoctor1MouseClicked
        dispose();
        DoctorRegistro rp = new DoctorRegistro();
        rp.setVisible(true);
        rp.almanecarCodRecep(cod_recep);
    }//GEN-LAST:event_lblRDoctor1MouseClicked

    private void lblRDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRDoctorMouseClicked
        dispose();
        DoctorRegistro rp = new DoctorRegistro();
        rp.setVisible(true);
        rp.almanecarCodRecep(cod_recep);
        objDesva.Abrir(rp, 10);
    }//GEN-LAST:event_lblRDoctorMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
        Login l = new Login();
        l.setVisible(true);
        objDesva.Abrir(l, 10);
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBuscarCita;
    private javax.swing.JLabel lblBuscarDoctor;
    private javax.swing.JLabel lblBuscarPaciente;
    private javax.swing.JLabel lblCodRecep;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDoctorTV;
    private javax.swing.JLabel lblMrPeet;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRCita;
    private javax.swing.JLabel lblRDoctor;
    private javax.swing.JLabel lblRDoctor1;
    private javax.swing.JLabel lblRPaciente;
    private javax.swing.JLabel lblWalter;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JPanel pnlPartedeArriba;
    // End of variables declaration//GEN-END:variables
}
