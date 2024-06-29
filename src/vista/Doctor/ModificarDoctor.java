
package vista.Doctor;

import Desvanecimiento.Desvanecimiento;
import desplazable.Desface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Doctor;
import modelo.EspecialidadDoctor;
import modeloDAO.DoctorDAO;
import modeloDAO.EspecialidadDoctorDAO;
import vista.principal.Principal;

public class ModificarDoctor extends javax.swing.JFrame {
    
    Desvanecimiento objDesva ;
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }
    int xMouse, yMaouse;
    
    Desface desplace;
    //ESPECIALIDAD
    EspecialidadDoctorDAO e2 = new EspecialidadDoctorDAO();
    ArrayList<EspecialidadDoctor> listaEspecialidad = new ArrayList<>();
    //DOCTOR
    DoctorDAO objMostrarDoc = new DoctorDAO();
    ArrayList<Doctor> listaDoc = new ArrayList<>();

    //fecha
    ArrayList<Doctor> listaFechas = new ArrayList<>();
    DoctorDAO objDoctorDAOFECHA = new DoctorDAO();

    public ModificarDoctor() {
        initComponents();
        desplace = new Desface();
        this.setLocationRelativeTo(null);
        mostrarEspecialidad();
        mostrarDoctor();
        comboFechaTurno();
        mostrarDatos();
        objDesva = new Desvanecimiento();
    }
    
    private void mostrarDoctor() {
        limpiarCbx();
        listaDoc.clear();

        listaDoc = objMostrarDoc.todosDoctoresSinDuplicar();
        for (int i = 0; i < listaDoc.size(); i++) {
            //AGREGANDO LOS DATOS A COMBO BOX
            cbxModificar.addItem(listaDoc.get(i).getNombre() + " " + listaDoc.get(i).getApellido() + " - " + listaDoc.get(i).getCODIGO_DOCTOR());
        }

        cbxModificar.addActionListener((ActionEvent e1) -> {
            comboFechaTurno();
            mostrarDatos();

        });

    }

    private void comboFechaTurno() {
        // Limpiar el combo box de doctores
        cbxFecha.removeAllItems();
        listaFechas.clear();

        // Obtener la especialidad seleccionada
        int e = cbxModificar.getSelectedIndex();

        if (e >= 0) {
            String dni = listaDoc.get(e).getDni();
            listaFechas = objDoctorDAOFECHA.listarUno(dni);

            // Agregar los doctores al combo box
            for (int i = 0; i < listaFechas.size(); i++) {
                cbxFecha.addItem(listaFechas.get(i).getFecha() + " - " + listaFechas.get(i).getTurno());
            }
        }

    }

    private void mostrarDatos() {
        DoctorDAO objListarTodosDoc = new DoctorDAO();
        ArrayList<Doctor> lista;

        int indice = cbxModificar.getSelectedIndex();
        String dni = listaDoc.get(indice).getDni();

        lista = objListarTodosDoc.listarUno(dni);
        txtCodDoctor.setText(lista.get(0).getCODIGO_DOCTOR());
        txtDniDoctor.setText(lista.get(0).getDni());
        txtNomDoctor.setText(lista.get(0).getNombre());
        txtApellidosDoctor.setText(lista.get(0).getApellido());
        txtEdadDoctor.setText(lista.get(0).getEdad() + "");
        txtCelularDoctor.setText(lista.get(0).getCelular());
        txtCorreoDoctor.setText(lista.get(0).getCorreo());
        txtDirecDoctor.setText(lista.get(0).getDireccion());
        cbxEspecialidadModificar.setSelectedItem(lista.get(0).getObjEspe().getNomEspe());

    }

    private void limpiarCbx() {
        cbxModificar.removeAllItems();
    }

    private void mostrarEspecialidad() {
        limpiarCbx();
        listaEspecialidad.clear();
        listaEspecialidad = e2.listarTodos();

        for (int i = 0; i < listaEspecialidad.size(); i++) {
            //AGREGANDO LOS DATOS A COMBO BOX
            cbxEspecialidadModificar.addItem(listaEspecialidad.get(i).getNomEspe());
        }
    }

    public void confirmacionAgregar(String a) {
        JOptionPane.showMessageDialog(null, "Se " + a + " el doctor correctamente");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cbxFecha = new javax.swing.JComboBox<>();
        pnlDesplazable = new javax.swing.JPanel();
        ImagenConfig = new javax.swing.JLabel();
        pnlDesaparecer = new javax.swing.JPanel();
        lblModificar = new javax.swing.JLabel();
        lblListar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JLabel();
        pnlTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlEstatico = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbxModificar = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDirecDoctor = new javax.swing.JTextField();
        txtApellidosDoctor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomDoctor = new javax.swing.JTextField();
        txtCorreoDoctor = new javax.swing.JTextField();
        txtEdadDoctor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxEspecialidadModificar = new javax.swing.JComboBox<>();
        txtDniDoctor = new javax.swing.JTextField();
        txtCodDoctor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCelularDoctor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        pnlTurno = new javax.swing.JPanel();
        lblTurno = new javax.swing.JLabel();
        cbxTurnoDoctor = new javax.swing.JComboBox<>();
        lblEscojaturno = new javax.swing.JLabel();
        LBLPONERTEXTO = new javax.swing.JLabel();
        Calendar = new com.toedter.calendar.JCalendar();
        pnlPartedeArriba = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(56, 54, 142));

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
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 140, 90, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel13.setText("Elegir fecha a cambiar");

        cbxFecha.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(cbxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, -1, -1));

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
                .addGap(0, 10, Short.MAX_VALUE))
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
        lblModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/REGISTRAR.png"))); // NOI18N
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

        lblEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(255, 255, 255));
        lblEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/ELIMINAR.png"))); // NOI18N
        lblEliminar.setText("Eliminar");
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
                            .addComponent(btnRegresar1)
                            .addComponent(lblModificar)
                            .addComponent(lblListar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDesaparecerLayout.setVerticalGroup(
            pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesaparecerLayout.createSequentialGroup()
                .addComponent(lblModificar)
                .addGap(18, 18, 18)
                .addComponent(lblListar)
                .addGap(18, 18, 18)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlDesaparecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 100, 630));

        pnlTitulo.setBackground(new java.awt.Color(56, 54, 142));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar Doctor");

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
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExit1Layout.setVerticalGroup(
            pnlExit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExit1Layout.createSequentialGroup()
                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modificar Horario");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199)
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(626, 626, 626))
        );

        jPanel1.add(pnlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 70));

        pnlEstatico.setBackground(new java.awt.Color(56, 54, 142));

        javax.swing.GroupLayout pnlEstaticoLayout = new javax.swing.GroupLayout(pnlEstatico);
        pnlEstatico.setLayout(pnlEstaticoLayout);
        pnlEstaticoLayout.setHorizontalGroup(
            pnlEstaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlEstaticoLayout.setVerticalGroup(
            pnlEstaticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jPanel1.add(pnlEstatico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cbxModificar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cbxModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxModificarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel12.setText("Doctor a modificar");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Apellidos");

        txtDirecDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtDirecDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDirecDoctorKeyPressed(evt);
            }
        });

        txtApellidosDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtApellidosDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosDoctorKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Nombres");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Correo electronico");

        txtNomDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtNomDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomDoctorKeyPressed(evt);
            }
        });

        txtCorreoDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCorreoDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoDoctorKeyPressed(evt);
            }
        });

        txtEdadDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtEdadDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdadDoctorKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setText("Especialidad");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setText("Celular");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("Dni");

        cbxEspecialidadModificar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cbxEspecialidadModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEspecialidadModificarActionPerformed(evt);
            }
        });

        txtDniDoctor.setEditable(false);
        txtDniDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtDniDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniDoctorKeyPressed(evt);
            }
        });

        txtCodDoctor.setEditable(false);
        txtCodDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCodDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodDoctorKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel11.setText("Edad");

        txtCelularDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtCelularDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularDoctorKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("Codigo");

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setText("Dirección");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDniDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCelularDoctor)
                                .addComponent(txtEdadDoctor)
                                .addComponent(txtCodDoctor)
                                .addComponent(txtApellidosDoctor)
                                .addComponent(txtDirecDoctor)
                                .addComponent(txtCorreoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(118, 118, 118)
                .addComponent(cbxEspecialidadModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbxModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDniDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNomDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidosDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEdadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCelularDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCorreoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDirecDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(64, 64, 64)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbxEspecialidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 470, 600));

        jPanel7.setBackground(new java.awt.Color(56, 54, 142));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 80, 640));

        pnlTurno.setBackground(new java.awt.Color(255, 255, 255));
        pnlTurno.setToolTipText(".");

        lblTurno.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lblTurno.setText("Turno");

        cbxTurnoDoctor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cbxTurnoDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turno mañana", "Turno Tarde", "Turno noche" }));

        lblEscojaturno.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblEscojaturno.setText("Eligir un turno para la fecha");

        LBLPONERTEXTO.setText(".");

        javax.swing.GroupLayout pnlTurnoLayout = new javax.swing.GroupLayout(pnlTurno);
        pnlTurno.setLayout(pnlTurnoLayout);
        pnlTurnoLayout.setHorizontalGroup(
            pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTurnoLayout.createSequentialGroup()
                        .addComponent(lblTurno)
                        .addGap(31, 31, 31)
                        .addComponent(cbxTurnoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTurnoLayout.createSequentialGroup()
                        .addComponent(lblEscojaturno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBLPONERTEXTO, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnlTurnoLayout.setVerticalGroup(
            pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEscojaturno)
                    .addComponent(LBLPONERTEXTO))
                .addGap(28, 28, 28)
                .addGroup(pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurno)
                    .addComponent(cbxTurnoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel1.add(pnlTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 410, -1, -1));

        Calendar.setBackground(new java.awt.Color(0, 153, 0));
        Calendar.setDecorationBackgroundColor(new java.awt.Color(255, 153, 0));
        Calendar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Calendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalendarPropertyChange(evt);
            }
        });
        jPanel1.add(Calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 170, 380, 230));

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
            .addGap(0, 1500, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 70));

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

    private void ImagenConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenConfigMouseClicked

        if (pnlDesplazable.getX() == 0) {
            desplace.desplazarDerecha(pnlDesplazable, pnlDesplazable.getX(), 100, 10, 10);
            pnlDesaparecer.setVisible(true);
        } else if (pnlDesplazable.getX() == 100) {
            desplace.desplazarIzquierda(pnlDesplazable, pnlDesplazable.getX(), 0, 10, 10);
            pnlDesaparecer.setVisible(false);
        }
    }//GEN-LAST:event_ImagenConfigMouseClicked

    private void cbxModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxModificarActionPerformed

    private void txtDirecDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirecDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //            btnEnviar.requestFocus();

        }
    }//GEN-LAST:event_txtDirecDoctorKeyPressed

    private void txtApellidosDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCelularDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtApellidosDoctorKeyPressed

    private void txtNomDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtApellidosDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtNomDoctorKeyPressed

    private void txtCorreoDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDirecDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoDoctorKeyPressed

    private void txtEdadDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadDoctorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadDoctorKeyPressed

    private void cbxEspecialidadModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEspecialidadModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEspecialidadModificarActionPerformed

    private void txtDniDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniDoctorKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNomDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtDniDoctorKeyPressed

    private void txtCodDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodDoctorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodDoctorKeyPressed

    private void txtCelularDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCorreoDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtCelularDoctorKeyPressed

    private void CalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarPropertyChange
        String fecha;

        if (evt.getOldValue() != null) {
            SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
            fecha = ff.format(Calendar.getCalendar().getTime());
            pnlTurno.setVisible(true);
            LBLPONERTEXTO.setText(fecha);
        }
    }//GEN-LAST:event_CalendarPropertyChange

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
    Doctor objDoctor = new Doctor();
        DoctorDAO objDocDAO = new DoctorDAO();

        Doctor objComprobar;
        DoctorDAO objComprobarDAO = new DoctorDAO();

        EspecialidadDoctor objEspe = new EspecialidadDoctor();
        

        //PARA OBTENER EL CODIGO DE HORARIO
         String codigo_doctor = txtCodDoctor.getText();
         int indeFecha = cbxFecha.getSelectedIndex();
         
         String fecha = listaFechas.get(indeFecha).getFecha();
         
         String turno = listaFechas.get(indeFecha).getTurno();
         objComprobar = objComprobarDAO.listarHorarioPorDoctor(codigo_doctor, fecha, turno);


            //persona
            objDoctor.setDni(txtDniDoctor.getText());
            objDoctor.setNombre(txtNomDoctor.getText());
            objDoctor.setApellido(txtApellidosDoctor.getText());
            objDoctor.setCelular(txtCelularDoctor.getText());
            objDoctor.setCorreo(txtCorreoDoctor.getText());
            objDoctor.setDireccion(txtDirecDoctor.getText());

            objDoctor.setEdad(Integer.parseInt(txtEdadDoctor.getText()));

            //Doctor
            objDoctor.setCODIGO_DOCTOR(txtCodDoctor.getText());
            int indiceEspe = cbxEspecialidadModificar.getSelectedIndex();
            objEspe.setCodEspe(listaEspecialidad.get(indiceEspe).getCodEspe());
            System.out.println("especialidad: " + listaEspecialidad.get(indiceEspe).getCodEspe());
            objDoctor.setObjEspe(objEspe);
            
            //DOCTOR_TURNO
            objDoctor.setFecha(LBLPONERTEXTO.getText());
            System.out.println("asd: " + LBLPONERTEXTO.getText());
            objDoctor.setTurno(cbxTurnoDoctor.getSelectedItem().toString());
            objDoctor.setCODIGO_HORARIO(objComprobar.getCODIGO_HORARIO());
            
            
            objDocDAO.modificar(objDoctor);
            
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            

        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtDirecDoctor.requestFocus();

        }
    }//GEN-LAST:event_btnModificarKeyPressed

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
        DoctorRegistro md = new DoctorRegistro();
        md.setVisible(true);
        md.almanecarCodRecep(cod_recep);
        objDesva.Abrir(md, 10);
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListarMouseClicked
        dispose();
        BuscarDoctor bd = new BuscarDoctor();
        bd.setVisible(true);
        bd.almanecarCodRecep(cod_recep);
        objDesva.Abrir(bd, 10);
    }//GEN-LAST:event_lblListarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        dispose();
        EliminarDoctor ec = new EliminarDoctor();
        ec.setVisible(true);
        ec.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ec, 10);
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void btnRegresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresar1MouseClicked
        dispose();

        Principal p = new Principal();
        p.setVisible(true);
        p.datosRecep(cod_recep);
        objDesva.Abrir(p, 10);
    }//GEN-LAST:event_btnRegresar1MouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarDoctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar Calendar;
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel ImagenConfig;
    private javax.swing.JLabel LBLPONERTEXTO;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JLabel btnRegresar1;
    private javax.swing.JComboBox<String> cbxEspecialidadModificar;
    private javax.swing.JComboBox<String> cbxFecha;
    private javax.swing.JComboBox<String> cbxModificar;
    private javax.swing.JComboBox<String> cbxTurnoDoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblEscojaturno;
    private javax.swing.JLabel lblListar;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel pnlDesaparecer;
    private javax.swing.JPanel pnlDesplazable;
    private javax.swing.JPanel pnlEstatico;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JPanel pnlTurno;
    private javax.swing.JTextField txtApellidosDoctor;
    private javax.swing.JTextField txtCelularDoctor;
    private javax.swing.JTextField txtCodDoctor;
    private javax.swing.JTextField txtCorreoDoctor;
    private javax.swing.JTextField txtDirecDoctor;
    private javax.swing.JTextField txtDniDoctor;
    private javax.swing.JTextField txtEdadDoctor;
    private javax.swing.JTextField txtNomDoctor;
    // End of variables declaration//GEN-END:variables
}
