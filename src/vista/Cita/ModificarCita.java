package vista.Cita;

import Desvanecimiento.Desvanecimiento;
import desplazable.Desface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cita;
import modelo.Doctor;
import modelo.Paciente;
import modelo.EspecialidadDoctor;
import modeloDAO.CitaDAO;
import modeloDAO.DoctorDAO;
import modeloDAO.EspecialidadDoctorDAO;
import modeloDAO.PacienteDAO;
import vista.principal.Principal;

public class ModificarCita extends javax.swing.JFrame {
    
    Desvanecimiento objDesva ;
    
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }
    
    int xMouse, yMaouse;
    
    Desface desplace;
    //PACIENTE
    ArrayList<Paciente> todosPacientes = new ArrayList<>();//LISTA TIENE TODOS LOS PACIENTES
    PacienteDAO objPacienteDAO = new PacienteDAO();

    //cita
    CitaDAO objCitaDAO = new CitaDAO();
    ArrayList<Cita> listaCita = new ArrayList<>();

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

    public ModificarCita() {
        initComponents();
        desplace = new Desface();
        mostrarCita();
        mostrarPaciente();
        mostrarEspecialidadDoctor();
        actualizarComboDoctores();
        comboFechaTurno();
        comboTurno();
        mostrarDatos();
        objDesva = new Desvanecimiento();
        this.setLocationRelativeTo(null);
    }

    private void mostrarCita() {
        listaCita = objCitaDAO.listarTodos();

        for (int i = 0; i < listaCita.size(); i++) {
            cbxNuevaCita.addItem(listaCita.get(i).getCodCita());

        }

        cbxNuevaCita.addActionListener((ActionEvent e1) -> {
            mostrarDatos();

        });

    }

    private void mostrarDatos() {

        //OBJETOS
        //PACIENTE
        PacienteDAO objPaDAO = new PacienteDAO();
        //DOCTOR
        DoctorDAO objDocDAO = new DoctorDAO();
        Doctor objDoc;

        //OBTENER EL INDICE
        int indice = cbxNuevaCita.getSelectedIndex();

        //ESPECIALIDAD -DOCTOR
        String cod_horario = listaCita.get(indice).getDoc().getCODIGO_HORARIO();
        objDoc = objDocDAO.listaHoarario(cod_horario);
        cbxEspecialidad.setSelectedItem(objDoc.getObjEspe().getNomEspe());
        cbxDoctor.setSelectedItem(objDoc.getCODIGO_HORARIO() + " - " + objDoc.getNombre() + objDoc.getApellido());

        //OBTENER DATOS DEL PACIENTE
        String dni = listaCita.get(indice).getPac().getDni();
        objPaDAO.listarUno(dni);

        //MOSTRANDO DATOS DE LA CITA
        cbxNombre.setSelectedItem(objPaDAO.listarUno(dni).getNombre() + " " + objPaDAO.listarUno(dni).getApellido() + " - "
                + objPaDAO.listarUno(dni).getDni());

        txtCita.setText(listaCita.get(indice).getCodCita());
        txtConsulta.setText(listaCita.get(indice).getMotivoConsulta());

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

    private void calcular() {

        Cita c = new Cita();
        c.descuento(todosPacientes.get(cbxNombre.getSelectedIndex()), listaEspecialidad.get(cbxEspecialidad.getSelectedIndex()));
        c.calcularPago(listaEspecialidad.get(cbxEspecialidad.getSelectedIndex()));

//        txtSalidad.setText("Descuento: " + c.getDescuento() + "\n El paciente debe pagar por la consulta::" + c.getPago());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlDesplazableConfig = new javax.swing.JPanel();
        ImagenConfig = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlDesaparecer = new javax.swing.JPanel();
        btnRegresar1 = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cbxNuevaCita = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtCita = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxNombre = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtConsulta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbxEspecialidad = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbxDoctor = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cbxFecha = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbxTurno = new javax.swing.JComboBox<>();
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
            .addComponent(ImagenConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDesplazableConfigLayout.setVerticalGroup(
            pnlDesplazableConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesplazableConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImagenConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(500, Short.MAX_VALUE))
        );

        jPanel1.add(pnlDesplazableConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 580));

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
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExit1Layout.setVerticalGroup(
            pnlExit1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExit1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 80, 80));

        jPanel2.setBackground(new java.awt.Color(56, 54, 142));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODIFICAR CITA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(307, 307, 307))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 80));

        pnlDesaparecer.setBackground(new java.awt.Color(56, 54, 142));

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

        lblRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/REGISTRAR.png"))); // NOI18N
        lblRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBuscar.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/BUSCAR.png"))); // NOI18N
        lblBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDesaparecerLayout = new javax.swing.GroupLayout(pnlDesaparecer);
        pnlDesaparecer.setLayout(pnlDesaparecerLayout);
        pnlDesaparecerLayout.setHorizontalGroup(
            pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
            .addComponent(lblEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegresar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDesaparecerLayout.setVerticalGroup(
            pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDesaparecerLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlDesaparecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 580));

        jPanel4.setBackground(new java.awt.Color(56, 54, 142));

        jLabel20.setBackground(new java.awt.Color(56, 54, 142));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Enviar");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 90, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel13.setText("Cita a modificar");

        cbxNuevaCita.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel11.setText("Codigo de Cita");

        txtCita.setEditable(false);
        txtCita.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCitaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel15.setText("Nombre del Paciente");

        cbxNombre.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel14.setText("Motivo de consulta");

        txtConsulta.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel16.setText("Especialidad");

        cbxEspecialidad.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel19.setText("Doctor");

        cbxDoctor.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        cbxDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel17.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel17.setText("Fecha");

        cbxFecha.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel18.setText("Turno");

        cbxTurno.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTurno, 0, 282, Short.MAX_VALUE)
                    .addComponent(cbxFecha, 0, 282, Short.MAX_VALUE)
                    .addComponent(cbxDoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtConsulta)
                    .addComponent(cbxNombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCita)
                    .addComponent(cbxNuevaCita, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbxNuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cbxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbxDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 560, 400));

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
            .addGap(0, 860, Short.MAX_VALUE)
        );
        pnlPartedeArribaLayout.setVerticalGroup(
            pnlPartedeArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 80));

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

    private void ImagenConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenConfigMouseClicked
        if (pnlDesplazableConfig.getX() == 0) {
            desplace.desplazarDerecha(pnlDesplazableConfig, pnlDesplazableConfig.getX(), 105, 10, 10);
            pnlDesaparecer.setVisible(true);
        } else if (pnlDesplazableConfig.getX() == 105) {
            desplace.desplazarIzquierda(pnlDesplazableConfig, pnlDesplazableConfig.getX(), 0, 10, 10);
            pnlDesaparecer.setVisible(false);
        }
    }//GEN-LAST:event_ImagenConfigMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked

        Cita c = new Cita();
        //DOCTOR
        Doctor objDoctor;
        DoctorDAO objDocDAO = new DoctorDAO();

        //PACIENTE
        PacienteDAO objPacDao = new PacienteDAO();
        Paciente objPaciente;

        calcular();
        //MODIFICANDO CON NUEVOS DATOS
        //CODIGO CITA
        c.setCodCita(txtCita.getText());

        //PACIENTE
        int a = cbxNombre.getSelectedIndex();
        String dni = todosPacientes.get(a).getDni();
        objPaciente = objPacDao.listarUno(dni);
        c.setPac(objPaciente);

        //PAGO - DESCUENTO
        c.setPago(c.getPago());
        c.setDescuento(c.getDescuento());

        //MOTIVO CONSULTA
        c.setMotivoConsulta(txtConsulta.getText());

        //DOCTOR
        int e = cbxTurno.getSelectedIndex();
        String cod_horario = listaTURNO.get(e).getCODIGO_HORARIO();
        objDoctor = objDocDAO.listaHoarario(cod_horario);
        c.setDoc(objDoctor);

        objCitaDAO.modificar(c);

        JOptionPane.showMessageDialog(null, "Se modificó la cita correctamente");
    }//GEN-LAST:event_jLabel20MouseClicked

    private void txtCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCitaActionPerformed

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

    private void pnlPartedeArribaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMaouse);
    }//GEN-LAST:event_pnlPartedeArribaMouseDragged

    private void pnlPartedeArribaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartedeArribaMousePressed
        xMouse = evt.getX();
        yMaouse = evt.getY();
    }//GEN-LAST:event_pnlPartedeArribaMousePressed

    private void btnRegresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresar1MouseClicked
        dispose();

        Principal p = new Principal();
        p.setVisible(true);
        p.datosRecep(cod_recep);
        objDesva.Abrir(p, 10);
    }//GEN-LAST:event_btnRegresar1MouseClicked

    private void lblRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegistrarMouseClicked
        dispose();
        AgendarCita dc = new AgendarCita();
        dc.setVisible(true);
        dc.almanecarCodRecep(cod_recep);
        objDesva.Abrir(dc, 10);
    }//GEN-LAST:event_lblRegistrarMouseClicked

    private void lblEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEliminarMouseClicked

        dispose();
        EliminarCita ec = new EliminarCita();
        ec.setVisible(true);
        ec.almanecarCodRecep(cod_recep);
        objDesva.Abrir(ec, 10);
    }//GEN-LAST:event_lblEliminarMouseClicked

    private void lblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarMouseClicked
        dispose();
        BuscarCita bd = new BuscarCita();
        bd.setVisible(true);
        bd.almanecarCodRecep(cod_recep);
        objDesva.Abrir(bd, 10);
    }//GEN-LAST:event_lblBuscarMouseClicked


    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel ImagenConfig;
    private javax.swing.JLabel btnRegresar1;
    private javax.swing.JComboBox<String> cbxDoctor;
    private javax.swing.JComboBox<String> cbxEspecialidad;
    private javax.swing.JComboBox<String> cbxFecha;
    private javax.swing.JComboBox<String> cbxNombre;
    private javax.swing.JComboBox<String> cbxNuevaCita;
    private javax.swing.JComboBox<String> cbxTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JPanel pnlDesaparecer;
    private javax.swing.JPanel pnlDesplazableConfig;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JTextField txtCita;
    private javax.swing.JTextField txtConsulta;
    // End of variables declaration//GEN-END:variables
}
