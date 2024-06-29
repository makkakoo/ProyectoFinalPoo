package vista.principal;

import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.Recepcionista;
import modeloDAO.RecepcionistaDAO;
import Desvanecimiento.Desvanecimiento;

public class Login extends javax.swing.JFrame {

    int xMouse, yMaouse;
    
    //para desvanecimiento
    Desvanecimiento objDesva ;
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //desvanecimiento
        objDesva = new Desvanecimiento();
        objDesva.Abrir(this, 20);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        pnlExit = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        fondoClinica = new javax.swing.JLabel();
        pnlPartedeArriba = new javax.swing.JPanel();
        logoS = new javax.swing.JLabel();
        iniciarSesion = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        contra = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtCodigo = new javax.swing.JTextField();
        separador1 = new javax.swing.JSeparator();
        separador2 = new javax.swing.JSeparator();
        pnlAceptar = new javax.swing.JPanel();
        aceptar = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlExit.setBackground(new java.awt.Color(255, 255, 255));
        pnlExit.setOpaque(false);

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
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
        pnlExitLayout.setVerticalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        bg.add(pnlExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 50, 50));

        fondoClinica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/fonod h.jpg"))); // NOI18N
        bg.add(fondoClinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 320, 490));

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
            .addGap(0, 910, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        bg.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 50));

        logoS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/principal/imagenesLogin/s.png"))); // NOI18N
        logoS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bg.add(logoS, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 40, 40));

        iniciarSesion.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        iniciarSesion.setText("INICIAR SESIÓN");
        bg.add(iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        codigo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        codigo.setText("CÓDIGO");
        bg.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        contra.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        contra.setText("CONTRASEÑA");
        bg.add(contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        txtContraseña.setText("***********");
        txtContraseña.setBorder(null);
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtContraseñaMousePressed(evt);
            }
        });
        bg.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 470, -1));

        txtCodigo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(204, 204, 204));
        txtCodigo.setText("Ingrese su código");
        txtCodigo.setBorder(null);
        txtCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCodigoMousePressed(evt);
            }
        });
        bg.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 470, 40));

        separador1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 470, 10));

        separador2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 470, 10));

        pnlAceptar.setBackground(new java.awt.Color(56, 54, 142));

        aceptar.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        aceptar.setForeground(new java.awt.Color(255, 255, 255));
        aceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aceptar.setText("Aceptar");
        aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aceptarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlAceptarLayout = new javax.swing.GroupLayout(pnlAceptar);
        pnlAceptar.setLayout(pnlAceptarLayout);
        pnlAceptarLayout.setHorizontalGroup(
            pnlAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        pnlAceptarLayout.setVerticalGroup(
            pnlAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(pnlAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlPartedeArribaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMousePressed
        xMouse = evt.getX();
        yMaouse = evt.getY();
    }//GEN-LAST:event_pnlPartedeArribaMousePressed

    private void pnlPartedeArribaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMaouse);
    }//GEN-LAST:event_pnlPartedeArribaMouseDragged

    private void aceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseEntered
        pnlAceptar.setBackground(new Color(109, 107, 199));
    }//GEN-LAST:event_aceptarMouseEntered

    private void aceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseExited
        pnlAceptar.setBackground(new Color(56, 54, 142));
    }//GEN-LAST:event_aceptarMouseExited

    private void aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseClicked
        btnAceptar();
    }//GEN-LAST:event_aceptarMouseClicked

    private void txtCodigoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoMousePressed
        if (txtCodigo.getText().equals("Ingrese su código")) {
            txtCodigo.setText(null);
            txtCodigo.setForeground(Color.black);
        }

        if (String.valueOf(txtContraseña.getPassword()).isEmpty()) {
            txtContraseña.setText("***********");
            txtContraseña.setForeground(new Color(204, 204, 204));
        }


    }//GEN-LAST:event_txtCodigoMousePressed

    private void txtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMousePressed

        if (String.valueOf(txtContraseña.getPassword()).equals("***********")) {
            txtContraseña.setText(null);
            txtContraseña.setForeground(Color.black);
        }

        if (txtCodigo.getText().isEmpty()) {
            txtCodigo.setText("Ingrese su código");
            txtCodigo.setForeground(new Color(204, 204, 204));
        }


    }//GEN-LAST:event_txtContraseñaMousePressed

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        
        objDesva.Cerrar(this, 10);
//        System.exit(0);
        
        
    }//GEN-LAST:event_ExitMouseClicked

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
        pnlExit.setOpaque(true);
        pnlExit.setBackground(Color.red);

        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
        pnlExit.setOpaque(false);
        pnlExit.setBackground(new Color(56, 54, 142));
        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseExited

    private void btnAceptar() {
        Recepcionista r = new Recepcionista();
        RecepcionistaDAO rd = new RecepcionistaDAO();
        String codRecepcionista, contraRecepcionista;
        codRecepcionista = txtCodigo.getText();
        contraRecepcionista = String.valueOf(txtContraseña.getPassword());
        r = rd.validarLogueo(codRecepcionista, contraRecepcionista);
        if (r == null) {
            JOptionPane.showMessageDialog(this, "Código o Contraseña incorrectos");
        } else {
            Principal p = new Principal();
            p.datosRecep(txtCodigo.getText());
            dispose();
            objDesva.Abrir(p, 10);
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel aceptar;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel contra;
    private javax.swing.JLabel fondoClinica;
    private javax.swing.JLabel iniciarSesion;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logoS;
    private javax.swing.JPanel pnlAceptar;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtContraseña;
    // End of variables declaration//GEN-END:variables
}
