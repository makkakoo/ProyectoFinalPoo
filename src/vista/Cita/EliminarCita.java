package vista.Cita;


import Desvanecimiento.Desvanecimiento;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cita;
import modeloDAO.CitaDAO;

public class EliminarCita extends javax.swing.JFrame {
    
    Desvanecimiento objDesva ;
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }

    int xMouse, yMaouse;
    
    ArrayList<Cita> listaCita = new ArrayList<>();
    CitaDAO objCitaDAO = new CitaDAO();

    public EliminarCita() {
        initComponents();
        mostrarCita();
        this.setLocationRelativeTo(null);
        objDesva = new Desvanecimiento();
    }

    private void limpiarCbx() {
        cbxEliminar.removeAllItems();
    }


    private void mostrarCita() {
        limpiarCbx();
        listaCita.clear();
        listaCita = objCitaDAO.listarTodos();

        for (int i = 0; i < listaCita.size(); i++) {
            cbxEliminar.addItem(listaCita.get(i).getCodCita());

        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlExit = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlEliminar = new javax.swing.JPanel();
        Eliminar = new javax.swing.JLabel();
        pnlRegresar1 = new javax.swing.JPanel();
        Regresar1 = new javax.swing.JLabel();
        cbxEliminar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(56, 54, 142));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ELIMINAR CITA");

        pnlExit.setBackground(new java.awt.Color(56, 54, 142));

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

        javax.swing.GroupLayout pnlExitLayout = new javax.swing.GroupLayout(pnlExit);
        pnlExit.setLayout(pnlExitLayout);
        pnlExitLayout.setHorizontalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExitLayout.setVerticalGroup(
            pnlExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(pnlExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 50));

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel2.setText("Cita a eliminar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 140, 40));

        pnlEliminar.setBackground(new java.awt.Color(56, 54, 142));

        Eliminar.setBackground(new java.awt.Color(255, 255, 255));
        Eliminar.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Eliminar.setText("Eliminar");
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlEliminarLayout = new javax.swing.GroupLayout(pnlEliminar);
        pnlEliminar.setLayout(pnlEliminarLayout);
        pnlEliminarLayout.setHorizontalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        pnlEliminarLayout.setVerticalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(pnlEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 110, 30));

        pnlRegresar1.setBackground(new java.awt.Color(56, 54, 142));

        Regresar1.setBackground(new java.awt.Color(255, 255, 255));
        Regresar1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        Regresar1.setForeground(new java.awt.Color(255, 255, 255));
        Regresar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Regresar1.setText("Regresar");
        Regresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Regresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Regresar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Regresar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Regresar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlRegresar1Layout = new javax.swing.GroupLayout(pnlRegresar1);
        pnlRegresar1.setLayout(pnlRegresar1Layout);
        pnlRegresar1Layout.setHorizontalGroup(
            pnlRegresar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Regresar1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        pnlRegresar1Layout.setVerticalGroup(
            pnlRegresar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Regresar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(pnlRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, -1, -1));

        cbxEliminar.setBackground(new java.awt.Color(204, 204, 255));
        cbxEliminar.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jPanel1.add(cbxEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 210, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseEntered
        pnlEliminar.setBackground(Color.RED);
    }//GEN-LAST:event_EliminarMouseEntered

    private void EliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseExited
        pnlEliminar.setBackground(new Color(56, 54, 142));
    }//GEN-LAST:event_EliminarMouseExited

    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked
        btnEliminar();
    }//GEN-LAST:event_EliminarMouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMaouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMaouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
        pnlExit.setBackground(Color.red);
        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
        pnlExit.setBackground(new Color(56, 54, 142));
        Exit.setForeground(Color.white);
    }//GEN-LAST:event_ExitMouseExited

    private void Regresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Regresar1MouseClicked
        dispose();
        AgendarCita ac = new AgendarCita();
        ac.setVisible(true);
        ac.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ac, 10);
    }//GEN-LAST:event_Regresar1MouseClicked

    private void Regresar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Regresar1MouseEntered
        pnlRegresar1.setBackground(new Color(109, 107, 199));
    }//GEN-LAST:event_Regresar1MouseEntered

    private void Regresar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Regresar1MouseExited
        pnlRegresar1.setBackground(new Color(56, 54, 142));
    }//GEN-LAST:event_Regresar1MouseExited

    
    
    private void btnEliminar() {
        objCitaDAO.eliminar(cbxEliminar.getSelectedItem().toString());
        mostrarCita();
        JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
    }
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Eliminar;
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel Regresar1;
    private javax.swing.JComboBox<String> cbxEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlEliminar;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JPanel pnlRegresar1;
    // End of variables declaration//GEN-END:variables
}
