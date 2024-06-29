/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.Cita;

import Desvanecimiento.Desvanecimiento;
import desplazable.Desface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import modelo.Cita;
import modelo.Doctor;
import modelo.Paciente;
import modelo.EspecialidadDoctor;
import modeloDAO.CitaDAO;
import modeloDAO.DoctorDAO;
import modeloDAO.EspecialidadDoctorDAO;
import modeloDAO.PacienteDAO;
import vista.principal.Principal;

public class AgendarCita extends javax.swing.JFrame {
    
    Desvanecimiento objDesva ;
    
    
    int xMouse, yMaouse;
    
    Desface desplace;
    //PACIENTE
    ArrayList<Paciente> todosPacientes = new ArrayList<>();//LISTA TIENE TODOS LOS PACIENTES
    PacienteDAO objPacienteDAO = new PacienteDAO();

    Cita c = new Cita();
    CitaDAO objCitaDAO = new CitaDAO();

    //ESPECIALIDAD
    EspecialidadDoctorDAO objEspeDAO = new EspecialidadDoctorDAO();
    ArrayList<EspecialidadDoctor> listaEspecialidad = new ArrayList<>();

    //DOCTOR
    DoctorDAO objDoctorDAO = new DoctorDAO();
    ArrayList<Doctor> listaDoctores = new ArrayList<>();

    //fecha
    ArrayList<Doctor> listaFechas = new ArrayList<>();
    DoctorDAO objDoctorDAOFECHA = new DoctorDAO();

    //turno
    ArrayList<Doctor> listaTURNO = new ArrayList<>();
    DoctorDAO objDoctorDATURNO = new DoctorDAO();

    public AgendarCita() {
        initComponents();
        mostrarPaciente();
        mostrarEspecialidadDoctor();
        actualizarComboDoctores();
        comboFechaTurno();
        comboTurno();
        desplace = new Desface();
        objDesva = new Desvanecimiento();


        this.setLocationRelativeTo(null);
    }
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }

    private void mostrarPaciente() {

        todosPacientes = objPacienteDAO.listarTodos();

        for (int i = 0; i < todosPacientes.size(); i++) {
            cbxNombre.addItem(todosPacientes.get(i).getNombre() + " " + todosPacientes.get(i).getApellido() + " - "
                    + todosPacientes.get(i).getDni());

        }
    }

    private void mostrarEspecialidadDoctor() {
        cbxEspecialidad.removeAllItems();
        listaEspecialidad = objEspeDAO.especialidadesQueContenganDoctor();

        for (int i = 0; i < listaEspecialidad.size(); i++) {
            cbxEspecialidad.addItem(listaEspecialidad.get(i).getNomEspe());
        }

        cbxEspecialidad.addActionListener((ActionEvent e1) -> {
            cbxFecha.removeAllItems();
            actualizarComboDoctores();

        });
    }

    private void actualizarComboDoctores() {
        // Limpiar el combo box de doctores
        cbxDoctor.removeAllItems();
        listaDoctores.clear();
        // Obtener la especialidad seleccionada
        int e = 0;
        e = cbxEspecialidad.getSelectedIndex();
        String cod_espe = listaEspecialidad.get(e).getCodEspe();

        listaDoctores = objDoctorDAO.DoctorFiltradoPorEspe(cod_espe);

        // Agregar los doctores al combo box
        for (int i = 0; i < listaDoctores.size(); i++) {

            cbxDoctor.addItem(listaDoctores.get(i).getCODIGO_DOCTOR() + " - " + listaDoctores.get(i).getNombre() + " "
                    + listaDoctores.get(i).getApellido());

        }
        cbxDoctor.addActionListener((ActionEvent e1) -> {
            comboFechaTurno();
        });

    }

    private void comboFechaTurno() {
        // Limpiar el combo box de doctores
        cbxFecha.removeAllItems();
        listaFechas.clear();

        // Obtener la especialidad seleccionada
        int e = cbxDoctor.getSelectedIndex();

        if (e >= 0) {
            String cod_doctor = listaDoctores.get(e).getCODIGO_DOCTOR();
            listaFechas = objDoctorDAOFECHA.fechaUnDoctorSinRepetir(cod_doctor);

            // Agregar los doctores al combo box
            for (int i = 0; i < listaFechas.size(); i++) {
                cbxFecha.addItem(listaFechas.get(i).getFecha());
            }
            
            
            cbxFecha.addActionListener((ActionEvent e1) -> {
            comboTurno();
        });

        }
    }

    private void comboTurno() {
        
        cbxTurno.removeAllItems();
        listaTURNO.clear();
        // Obtener la especialidad seleccionada
        int e = cbxFecha.getSelectedIndex();

        if (e >= 0) {
            String cod_doctor = listaFechas.get(e).getCODIGO_DOCTOR();
            //agregando en turno
            String fecha = listaFechas.get(e).getFecha();
            listaTURNO = objDoctorDATURNO.todaLaTablaDoctor_turno(cod_doctor, fecha);

            for (int i = 0; i < listaTURNO.size(); i++) {
                cbxTurno.addItem(listaTURNO.get(i).getTurno());
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnlDesplazableConfig = new javax.swing.JPanel();
        ImagenConfig = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnlDesaparecer = new javax.swing.JPanel();
        lblModificar = new javax.swing.JLabel();
        lblListar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalidad = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        cbxNombre = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtConsulta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxEspecialidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxDoctor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxFecha = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxTurno = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pnlPartedeArriba = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDesplazableConfig.setBackground(new java.awt.Color(56, 54, 142));

        ImagenConfig.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        ImagenConfig.setForeground(new java.awt.Color(255, 255, 255));
        ImagenConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/ConfigurarCita.png"))); // NOI18N
        ImagenConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenConfigMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDesplazableConfigLayout = new javax.swing.GroupLayout(pnlDesplazableConfig);
        pnlDesplazableConfig.setLayout(pnlDesplazableConfigLayout);
        pnlDesplazableConfigLayout.setHorizontalGroup(
            pnlDesplazableConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesplazableConfigLayout.createSequentialGroup()
                .addComponent(ImagenConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDesplazableConfigLayout.setVerticalGroup(
            pnlDesplazableConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesplazableConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagenConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(500, Short.MAX_VALUE))
        );

        jPanel1.add(pnlDesplazableConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 580));

        jPanel5.setBackground(new java.awt.Color(56, 54, 142));

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
                .addGroup(pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRegresar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        pnlDesaparecerLayout.setVerticalGroup(
            pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesaparecerLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblModificar)
                .addGap(18, 18, 18)
                .addComponent(lblListar)
                .addGap(18, 18, 18)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(pnlDesaparecer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDesaparecer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 580));

        jPanel3.setBackground(new java.awt.Color(56, 54, 142));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("AGENDAR CITA");

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
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExit1Layout.setVerticalGroup(
            pnlExit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(247, 247, 247)
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addContainerGap(17, Short.MAX_VALUE))
            .addComponent(pnlExit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 730, 60));

        txtSalidad.setColumns(20);
        txtSalidad.setRows(5);
        jScrollPane1.setViewportView(txtSalidad);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 520, 110));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblPaciente.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lblPaciente.setText("Nombre del paciente");

        cbxNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxNombre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNombreItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel1.setText("Motivo de Consulta");

        txtConsulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel2.setText("Especialidad");

        cbxEspecialidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEspecialidadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel3.setText("Doctor");

        cbxDoctor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel5.setText("Fecha");

        cbxFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel4.setText("Turno");

        cbxTurno.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaciente)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxNombre, 0, 280, Short.MAX_VALUE)
                    .addComponent(txtConsulta)
                    .addComponent(cbxEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxFecha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaciente)
                    .addComponent(cbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 500, 320));

        jPanel4.setBackground(new java.awt.Color(56, 54, 142));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Enviar");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 100, 40));

        jPanel6.setBackground(new java.awt.Color(56, 54, 142));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Enviar");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 100, 40));

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
            .addGap(0, 830, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        private void calcular() {
        c.descuento(todosPacientes.get(cbxNombre.getSelectedIndex()), listaEspecialidad.get(cbxEspecialidad.getSelectedIndex()));//aqui se manda todo el objeto 
        c.calcularPago(listaEspecialidad.get(cbxEspecialidad.getSelectedIndex()));

        txtSalidad.setText("Descuento: " + c.getDescuento() + "\n El paciente debe pagar por la consulta::" + c.getPago());
    }

    private void cbxEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEspecialidadActionPerformed

    private void cbxNombreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNombreItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNombreItemStateChanged

    private void ImagenConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenConfigMouseClicked

        if (pnlDesplazableConfig.getX() == 0) {
            desplace.desplazarDerecha(pnlDesplazableConfig, pnlDesplazableConfig.getX(), 105, 10, 10);
            pnlDesaparecer.setVisible(true);
        } else if (pnlDesplazableConfig.getX() == 105) {
            desplace.desplazarIzquierda(pnlDesplazableConfig, pnlDesplazableConfig.getX(), 0, 10, 10);
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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Paciente objPaciente = new Paciente();
        Doctor objDoctor = new Doctor();
        
        //AGREGANDO DNI
        int dniPa = cbxNombre.getSelectedIndex();
        objPaciente.setDni(todosPacientes.get(dniPa).getDni());
        c.setPac(objPaciente);
        //CALCULANDO EL PAGO Y DESCUENTO
        calcular();
         //PAGO
         c.setPago(c.getPago());
         //DESCUENTO
         c.setDescuento(c.getDescuento());
        
        //MOTIVO CONSULTA
        c.setMotivoConsulta(txtConsulta.getText());
        

        //CODigo doctor
        int indiceDoc = cbxDoctor.getSelectedIndex();
        String codDoc = listaDoctores.get(indiceDoc).getCODIGO_DOCTOR();
        objDoctor.setCODIGO_DOCTOR(codDoc);
        //CODIGO HORARIO
        int indiceH = cbxTurno.getSelectedIndex();
        objDoctor.setCODIGO_HORARIO(listaTURNO.get(indiceH).getCODIGO_HORARIO());
        
        c.setDoc(objDoctor);
        
        
        

        objCitaDAO.agregar(c);
    }//GEN-LAST:event_jLabel7MouseClicked

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
        ModificarCita cm = new ModificarCita();
        cm.setVisible(true);
        cm.almanecarCodRecep(cod_recep);
        objDesva.Abrir(cm, 10);
        
    }//GEN-LAST:event_lblModificarMouseClicked

    private void lblListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListarMouseClicked
        dispose();
        BuscarCita bp = new BuscarCita();
        bp.setVisible(true);
        bp.almanecarCodRecep(cod_recep);
        
        objDesva.Abrir(bp, 10);
    }//GEN-LAST:event_lblListarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked
        dispose();
        EliminarCita ec = new EliminarCita();
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
                new AgendarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel ImagenConfig;
    private javax.swing.JLabel btnRegresar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxDoctor;
    private javax.swing.JComboBox<String> cbxEspecialidad;
    private javax.swing.JComboBox<String> cbxFecha;
    private javax.swing.JComboBox<String> cbxNombre;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JPanel pnlDesaparecer;
    private javax.swing.JPanel pnlDesplazableConfig;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextArea txtSalidad;
    // End of variables declaration//GEN-END:variables
}
