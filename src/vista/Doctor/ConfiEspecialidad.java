package vista.Doctor;

import Desvanecimiento.Desvanecimiento;
import java.awt.Color;
import desplazable.Desface;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.EspecialidadDoctor;
import modeloDAO.EspecialidadDoctorDAO;
import vista.principal.Principal;

public class ConfiEspecialidad extends javax.swing.JFrame {

    Desvanecimiento objDesva;

    String cod_recep;

    public void almanecarCodRecep(String cod) {
        cod_recep = cod;
    }

    int xMouse, yMaouse;
    Desface desplace;
    EspecialidadDoctor e = new EspecialidadDoctor();
    EspecialidadDoctorDAO e2 = new EspecialidadDoctorDAO();
    ArrayList<EspecialidadDoctor> listaEspecialidad = new ArrayList<>();
    DefaultTableModel x = new DefaultTableModel();

    public ConfiEspecialidad() {
        initComponents();
        mostrarEspecialidad();
        mostrarNombreColumnas();
        mostrarTabla();
        mostrarDatosModi();
        this.setLocationRelativeTo(null);
        pnlModificar.setVisible(false);
        pnlAgregar.setVisible(false);
        pnlEliminar.setVisible(false);
        desplace = new Desface();

        objDesva = new Desvanecimiento();
    }

    private void mostrarNombreColumnas() {
        x.addColumn("Codigo Especialidad");
        x.addColumn("Nombre Especialidad");
        x.addColumn("Tarifa");

        tblEspecialida.setModel(x);
    }

    public void limpiarTabla() {
        x.setRowCount(0);

    }

    private void mostrarTabla() {

        listaEspecialidad.clear();
        limpiarTabla();
        listaEspecialidad = e2.listarTodos();

        for (int i = 0; i < listaEspecialidad.size(); i++) {
            //AGREGANDO LOS DATOS A LA TABLA
            Object[] data = {listaEspecialidad.get(i).getCodEspe(), listaEspecialidad.get(i).getNomEspe(),
                listaEspecialidad.get(i).getTarifa()};
            x.addRow(data);
        }
    }

    private void mostrarEspecialidad() {
        limpiarCbx();
        listaEspecialidad.clear();
        listaEspecialidad = e2.listarTodos();

        for (int i = 0; i < listaEspecialidad.size(); i++) {
            //AGREGANDO LOS DATOS A COMBO BOX
            cbxEspecialidadEliminar.addItem(listaEspecialidad.get(i).getNomEspe());
            cbxEspecialidadModificar.addItem(listaEspecialidad.get(i).getNomEspe());

        }

        cbxEspecialidadModificar.addActionListener((ActionEvent e1) -> {
            mostrarDatosModi();
        });
    }

    private void limpiarCbx() {
        cbxEspecialidadEliminar.removeAllItems();
        cbxEspecialidadModificar.removeAllItems();
    }

    private void mostrarDatosModi() {
        int indiceModi = cbxEspecialidadModificar.getSelectedIndex();
        if (indiceModi >= 0) {
            String cod = listaEspecialidad.get(indiceModi).getCodEspe();
            txtCodModificar.setText(e2.listarUno(cod).getCodEspe());
            txtEspecialidadModificar.setText(e2.listarUno(cod).getNomEspe());
            txtTarifaModificar.setText(e2.listarUno(cod).getTarifa() + "");
        }
    }

    private void btnAgregar() {

        String codEspe = txtCodAgregar1.getText();
        String nom = txtNomAgregar1.getText();

        boolean codigoExistente = false;
        boolean nomExistente = false;
        for (EspecialidadDoctor d : e2.listarTodos()) {
            if (d.getCodEspe().equals(codEspe)) {
                codigoExistente = true;
                break;
            } else if (d.getNomEspe().equals(nom)) {
                nomExistente = true;
                break;
            }
        }

        if (codigoExistente) {
            JOptionPane.showMessageDialog(null, "El código de la especialidad ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nomExistente) {
            JOptionPane.showMessageDialog(null, "El nombre de la especialidad ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            e.setCodEspe(txtCodAgregar1.getText());
            e.setNomEspe(txtNomAgregar1.getText());
            e.setTarifa(Double.parseDouble(txtTarifaAgregar1.getText()));
            e2.agregar(e);
            mostrarEspecialidad();
            mostrarTabla();
            confirmacionAgregar("agregó");
            limpiarAgregar();
            txtCodAgregar1.requestFocus();
        }
    }

    private void limpiarAgregar() {
        txtCodAgregar1.setText(null);
        txtNomAgregar1.setText(null);
        txtTarifaAgregar1.setText(null);
    }

    public void confirmacionAgregar(String a) {
        JOptionPane.showMessageDialog(null, "Se " + a + " la especialidad correctamente");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnlDesplazable = new javax.swing.JPanel();
        ImagenConfig = new javax.swing.JLabel();
        pnlDesaparecer = new javax.swing.JPanel();
        lblModificar = new javax.swing.JLabel();
        lblListar = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnlModificar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbxEspecialidadModificar = new javax.swing.JComboBox<>();
        pnlOpcionModificar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCodModificar = new javax.swing.JTextField();
        txtEspecialidadModificar = new javax.swing.JTextField();
        txtTarifaModificar = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnAgregar2 = new javax.swing.JLabel();
        pnlEliminar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxEspecialidadEliminar = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        btnAgregar1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        rdbAgregar = new javax.swing.JRadioButton();
        rbtModificar = new javax.swing.JRadioButton();
        rbtEspecialidad = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        pnlAgregar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodAgregar1 = new javax.swing.JTextField();
        txtNomAgregar1 = new javax.swing.JTextField();
        txtTarifaAgregar1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEspecialida = new javax.swing.JTable();
        pnlPartedeArriba = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDesplazable.setBackground(new java.awt.Color(56, 54, 142));

        ImagenConfig.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        ImagenConfig.setForeground(new java.awt.Color(255, 255, 255));
        ImagenConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/ConfigurarCita.png"))); // NOI18N
        ImagenConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenConfigMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDesplazableLayout = new javax.swing.GroupLayout(pnlDesplazable);
        pnlDesplazable.setLayout(pnlDesplazableLayout);
        pnlDesplazableLayout.setHorizontalGroup(
            pnlDesplazableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesplazableLayout.createSequentialGroup()
                .addComponent(ImagenConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDesplazableLayout.setVerticalGroup(
            pnlDesplazableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesplazableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagenConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(620, Short.MAX_VALUE))
        );

        jPanel1.add(pnlDesplazable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 700));

        pnlDesaparecer.setBackground(new java.awt.Color(56, 54, 142));

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
                .addGroup(pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDesaparecerLayout.createSequentialGroup()
                        .addGroup(pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnRegresar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDesaparecerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblListar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDesaparecerLayout.setVerticalGroup(
            pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesaparecerLayout.createSequentialGroup()
                .addComponent(lblRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlDesaparecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 100, 630));

        jPanel4.setBackground(new java.awt.Color(56, 54, 142));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pnlModificar.setBackground(new java.awt.Color(56, 54, 142));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Elegir especialidad");

        cbxEspecialidadModificar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        pnlOpcionModificar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("Código");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setText("Tarifa");

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setText("Nombre de la especialidad");

        txtCodModificar.setEditable(false);
        txtCodModificar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCodModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodModificarActionPerformed(evt);
            }
        });

        txtEspecialidadModificar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        txtTarifaModificar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(56, 54, 142));

        btnAgregar2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnAgregar2.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar2.setText("Modificar");
        btnAgregar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregar2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlOpcionModificarLayout = new javax.swing.GroupLayout(pnlOpcionModificar);
        pnlOpcionModificar.setLayout(pnlOpcionModificarLayout);
        pnlOpcionModificarLayout.setHorizontalGroup(
            pnlOpcionModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionModificarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlOpcionModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(46, 46, 46)
                .addGroup(pnlOpcionModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTarifaModificar)
                    .addComponent(txtCodModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(txtEspecialidadModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlOpcionModificarLayout.setVerticalGroup(
            pnlOpcionModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionModificarLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(pnlOpcionModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlOpcionModificarLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(pnlOpcionModificarLayout.createSequentialGroup()
                        .addGroup(pnlOpcionModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEspecialidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(pnlOpcionModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCodModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlOpcionModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtTarifaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 53, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout pnlModificarLayout = new javax.swing.GroupLayout(pnlModificar);
        pnlModificar.setLayout(pnlModificarLayout);
        pnlModificarLayout.setHorizontalGroup(
            pnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlModificarLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(110, 110, 110)
                        .addComponent(cbxEspecialidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlOpcionModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlModificarLayout.setVerticalGroup(
            pnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlModificarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxEspecialidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlOpcionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 213, 700, 260));

        pnlEliminar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Especialidad");

        cbxEspecialidadEliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(56, 54, 142));

        btnAgregar1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnAgregar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar1.setText("Eliminar");
        btnAgregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnAgregar1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnAgregar1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlEliminarLayout = new javax.swing.GroupLayout(pnlEliminar);
        pnlEliminar.setLayout(pnlEliminarLayout);
        pnlEliminarLayout.setHorizontalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEliminarLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(cbxEspecialidadEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        pnlEliminarLayout.setVerticalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEliminarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbxEspecialidadEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.add(pnlEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 670, 120));

        jPanel2.setBackground(new java.awt.Color(56, 54, 142));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Configurar Especialidad");

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
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlExit1Layout.setVerticalGroup(
            pnlExit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 770, Short.MAX_VALUE)
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 70));

        buttonGroup1.add(rdbAgregar);
        rdbAgregar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rdbAgregar.setText("Agregar Especialidad");
        rdbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(rdbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        buttonGroup1.add(rbtModificar);
        rbtModificar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rbtModificar.setText("Modificar Especialidad");
        rbtModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtModificarActionPerformed(evt);
            }
        });
        jPanel1.add(rbtModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        buttonGroup1.add(rbtEspecialidad);
        rbtEspecialidad.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rbtEspecialidad.setText("Eliminar Especialidad");
        rbtEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEspecialidadActionPerformed(evt);
            }
        });
        jPanel1.add(rbtEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("¿Que desea hacer?");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        pnlAgregar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Codigo");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("Nombre especialidad");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setText("Tarifa");

        txtCodAgregar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodAgregar1KeyPressed(evt);
            }
        });

        txtNomAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomAgregar1ActionPerformed(evt);
            }
        });
        txtNomAgregar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomAgregar1KeyPressed(evt);
            }
        });

        txtTarifaAgregar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTarifaAgregar1KeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(56, 54, 142));

        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlAgregarLayout = new javax.swing.GroupLayout(pnlAgregar);
        pnlAgregar.setLayout(pnlAgregarLayout);
        pnlAgregarLayout.setHorizontalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(69, 69, 69)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTarifaAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlAgregarLayout.setVerticalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarLayout.createSequentialGroup()
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(17, 17, 17)
                                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtNomAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtTarifaAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(pnlAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 690, 140));

        tblEspecialida.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblEspecialida);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 70, -1, 610));

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
            .addGap(0, 1530, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImagenConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenConfigMouseClicked

        if (pnlDesplazable.getX() == 0) {
            desplace.desplazarDerecha(pnlDesplazable, pnlDesplazable.getX(), 90, 10, 10);
            pnlDesaparecer.setVisible(true);
        } else if (pnlDesplazable.getX() == 90) {
            desplace.desplazarIzquierda(pnlDesplazable, pnlDesplazable.getX(), 0, 10, 10);
            pnlDesaparecer.setVisible(false);
        }
    }//GEN-LAST:event_ImagenConfigMouseClicked

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

    private void rdbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAgregarActionPerformed
        pnlAgregar.setVisible(true);
        pnlEliminar.setVisible(false);
        pnlModificar.setVisible(false);
    }//GEN-LAST:event_rdbAgregarActionPerformed

    private void rbtModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtModificarActionPerformed

        pnlModificar.setVisible(true);
        pnlAgregar.setVisible(false);
        pnlEliminar.setVisible(false);
    }//GEN-LAST:event_rbtModificarActionPerformed

    private void rbtEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEspecialidadActionPerformed

        pnlEliminar.setVisible(true);
        pnlAgregar.setVisible(false);
        pnlModificar.setVisible(false);
    }//GEN-LAST:event_rbtEspecialidadActionPerformed

    private void txtCodAgregar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodAgregar1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNomAgregar1.requestFocus();

        }
    }//GEN-LAST:event_txtCodAgregar1KeyPressed

    private void txtNomAgregar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomAgregar1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTarifaAgregar1.requestFocus();
        }
    }//GEN-LAST:event_txtNomAgregar1KeyPressed

    private void txtTarifaAgregar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarifaAgregar1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAgregar.requestFocus();
        }
    }//GEN-LAST:event_txtTarifaAgregar1KeyPressed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        btnAgregar();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void txtNomAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomAgregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomAgregar1ActionPerformed

    private void btnAgregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregar1MouseClicked
        int indice = cbxEspecialidadEliminar.getSelectedIndex();
        e2.eliminar(listaEspecialidad.get(indice).getCodEspe());
        mostrarEspecialidad();
        mostrarTabla();
        confirmacionAgregar("eliminó");
    }//GEN-LAST:event_btnAgregar1MouseClicked

    private void txtCodModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodModificarActionPerformed

    private void btnAgregar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregar2MouseClicked
        int indiceModi = cbxEspecialidadModificar.getSelectedIndex();
        String cod = listaEspecialidad.get(indiceModi).getCodEspe();

        e.setCodEspe(txtCodModificar.getText());
        e.setNomEspe(txtEspecialidadModificar.getText());
        e.setTarifa(Double.parseDouble(txtTarifaModificar.getText()));

        e2.modificar(e);
        mostrarEspecialidad();
        mostrarTabla();
        confirmacionAgregar("modificó");
    }//GEN-LAST:event_btnAgregar2MouseClicked

    private void pnlPartedeArribaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMaouse);
    }//GEN-LAST:event_pnlPartedeArribaMouseDragged

    private void pnlPartedeArribaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMousePressed
        xMouse = evt.getX();
        yMaouse = evt.getY();
    }//GEN-LAST:event_pnlPartedeArribaMousePressed

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        dispose();
        ModificarDoctor md = new ModificarDoctor();
        md.setVisible(true);
        objDesva.Abrir(md, 10);
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListarMouseClicked
        dispose();
        BuscarDoctor bd = new BuscarDoctor();
        bd.setVisible(true);
        bd.almanecarCodRecep(cod_recep);
        objDesva.Abrir(bd, 10);
    }//GEN-LAST:event_lblListarMouseClicked

    private void lblRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarMouseClicked
        dispose();
        DoctorRegistro dc = new DoctorRegistro();
        dc.setVisible(true);
        dc.almanecarCodRecep(cod_recep);
        objDesva.Abrir(dc, 10);
    }//GEN-LAST:event_lblRegistrarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        dispose();
        EliminarDoctor ec = new EliminarDoctor();
        ec.almanecarCodRecep(cod_recep);
        ec.setVisible(true);
        ec.setVisible(true);
        objDesva.Abrir(ec, 10);

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
                new ConfiEspecialidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel ImagenConfig;
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnAgregar1;
    private javax.swing.JLabel btnAgregar2;
    private javax.swing.JLabel btnRegresar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxEspecialidadEliminar;
    private javax.swing.JComboBox<String> cbxEspecialidadModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblListar;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JPanel pnlAgregar;
    private javax.swing.JPanel pnlDesaparecer;
    private javax.swing.JPanel pnlDesplazable;
    private javax.swing.JPanel pnlEliminar;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlModificar;
    private javax.swing.JPanel pnlOpcionModificar;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JRadioButton rbtEspecialidad;
    private javax.swing.JRadioButton rbtModificar;
    private javax.swing.JRadioButton rdbAgregar;
    private javax.swing.JTable tblEspecialida;
    private javax.swing.JTextField txtCodAgregar1;
    private javax.swing.JTextField txtCodModificar;
    private javax.swing.JTextField txtEspecialidadModificar;
    private javax.swing.JTextField txtNomAgregar1;
    private javax.swing.JTextField txtTarifaAgregar1;
    private javax.swing.JTextField txtTarifaModificar;
    // End of variables declaration//GEN-END:variables
}
