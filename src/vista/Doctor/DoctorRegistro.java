
package vista.Doctor;
import Desvanecimiento.Desvanecimiento;
import java.awt.Color;
import desplazable.Desface;
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
public class DoctorRegistro extends javax.swing.JFrame {
    
    Desvanecimiento objDesva ;
    
    int xMouse, yMaouse;
    Desface desplace;
    Doctor objDoctor = new Doctor();
    DoctorDAO objDoctorDao = new DoctorDAO();

    EspecialidadDoctorDAO objEspecialidadDAO = new EspecialidadDoctorDAO();
    ArrayList<EspecialidadDoctor> listaEspecialidad = new ArrayList<>();

    ArrayList<Doctor> listaDoctor = new ArrayList<>();
    public DoctorRegistro() {
        initComponents();
        desplace = new Desface();
        this.setLocationRelativeTo(null);
        mostrarEspecialidadDoctor();
        pnlTurno.setVisible(false);
        cbxDoctorExistente.setVisible(false);
        checkbox();
        objDesva = new Desvanecimiento();
    }
    private void mostrarEspecialidadDoctor() {
        listaEspecialidad = objEspecialidadDAO.listarTodos();

        for (int i = 0; i < listaEspecialidad.size(); i++) {
            cbxEspecialidadDoctor.addItem(listaEspecialidad.get(i).getNomEspe());
        }
    }
    String cod_recep;
    public void almanecarCodRecep(String cod){
        cod_recep = cod;
    }
    






    public void registroDoctor() {

        Doctor objDoctor = new Doctor();
        DoctorDAO objDoctorDAO = new DoctorDAO();

        // AGREGANDO EN TABLA PERSONA
        objDoctor.setDni(txtDniDoctor.getText());
        objDoctor.setNombre(txtNomDoctor.getText());
        objDoctor.setApellido(txtApellidosDoctor.getText());
        objDoctor.setCelular(txtCelularDoctor.getText());
        objDoctor.setCorreo(txtCorreoDoctor.getText());
        objDoctor.setDireccion(txtDirecDoctor.getText());
        objDoctor.setEdad(Integer.parseInt(txtEdadDoctor.getText()));

        // AGREGANDO DOCTOR
        objDoctor.setCODIGO_DOCTOR(txtCodDoctor.getText());
        // MANDAR EL OBJETO ESPECIALIDAD
        int indice = cbxEspecialidadDoctor.getSelectedIndex();
        objDoctor.setObjEspe(listaEspecialidad.get(indice));

        objDoctorDao.agregar(objDoctor);
        JOptionPane.showMessageDialog(null, "El doctor se ha agregado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }

    public void registroDoctor2() {

        if (rbtDoctorExistente.isSelected()) {

        }
        // Crear instancia de Horario
        Doctor objComprobar = new Doctor();
        Doctor objDoctor = new Doctor();
        DoctorDAO objDoctorDAO = new DoctorDAO();

        String codigo_doctor = txtCodDoctor.getText();
        String fecha = LBLPONERTEXTO.getText();
        String turno = cbxTurnoDoctor.getSelectedItem().toString();

        objComprobar = objDoctorDAO.listarHorarioPorDoctor(codigo_doctor, fecha, turno);

        //VERIFICAR SI LOS DATOS INGRESADOS EXISTENTEN EN LA BASE DE DATOS
        
        if(objComprobar == null){
            objDoctor.setCODIGO_DOCTOR(txtCodDoctor.getText());
            objDoctor.setFecha(LBLPONERTEXTO.getText());
            objDoctor.setCupos(10);
            objDoctor.setTurno(cbxTurnoDoctor.getSelectedItem().toString());

            objDoctorDAO.agregarSoloTablaDoctorTurno(objDoctor);
            JOptionPane.showMessageDialog(null, "Se ingresó el horario correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }else
            JOptionPane.showMessageDialog(null, "EL DOCTOR INGRESADO YA HA SIDO INGRESADO EN ESA FECHA Y TURNO", "Error", JOptionPane.ERROR_MESSAGE);
        

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        pnlDesplazable = new javax.swing.JPanel();
        ImagenConfig = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlExit1 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlDesaparecer = new javax.swing.JPanel();
        lblModificar = new javax.swing.JLabel();
        lblListar = new javax.swing.JLabel();
        lblEliminar = new javax.swing.JLabel();
        lnlEspecialidad = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbxEspecialidadDoctor = new javax.swing.JComboBox<>();
        lblEspe = new javax.swing.JLabel();
        txtCorreoDoctor = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtDirecDoctor = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        cbGenerarCod = new javax.swing.JCheckBox();
        txtDniDoctor = new javax.swing.JTextField();
        txtEdadDoctor = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtNomDoctor = new javax.swing.JTextField();
        txtApellidosDoctor = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCelularDoctor = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodDoctor = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnEnviar = new javax.swing.JLabel();
        pnlDoctorExistente = new javax.swing.JPanel();
        cbxDoctorExistente = new javax.swing.JComboBox<>();
        rbtDoctorExistente = new javax.swing.JRadioButton();
        Calendar = new com.toedter.calendar.JCalendar();
        pnlTurno = new javax.swing.JPanel();
        lblTurno = new javax.swing.JLabel();
        cbxTurnoDoctor = new javax.swing.JComboBox<>();
        lblEscojaturno = new javax.swing.JLabel();
        LBLPONERTEXTO = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        pnlPartedeArriba = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(56, 54, 142));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 80, 630));

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

        jPanel2.setBackground(new java.awt.Color(56, 54, 142));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro Doctor");

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
        jLabel2.setText("Registrar Horario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 595, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlExit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 70));

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

        lnlEspecialidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lnlEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Cita/imagenes/Especialidad.png"))); // NOI18N
        lnlEspecialidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lnlEspecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lnlEspecialidadMouseClicked(evt);
            }
        });
        lnlEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lnlEspecialidadKeyPressed(evt);
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
                    .addComponent(lblEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lnlEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 1, Short.MAX_VALUE))
            .addComponent(btnRegresar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDesaparecerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblListar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDesaparecerLayout.setVerticalGroup(
            pnlDesaparecerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDesaparecerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblModificar)
                .addGap(18, 18, 18)
                .addComponent(lblListar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lnlEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEliminar)
                .addGap(146, 146, 146)
                .addComponent(btnRegresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbxEspecialidadDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxEspecialidadDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxEspecialidadDoctorKeyPressed(evt);
            }
        });

        lblEspe.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblEspe.setText("Especialidad");

        txtCorreoDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCorreoDoctor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtCorreoDoctor.setSelectionColor(new java.awt.Color(51, 51, 51));
        txtCorreoDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoDoctorKeyPressed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblNombre.setText("Nombres");

        txtDirecDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDirecDoctor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtDirecDoctor.setSelectionColor(new java.awt.Color(51, 51, 51));
        txtDirecDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDirecDoctorKeyPressed(evt);
            }
        });

        lblEdad.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblEdad.setText("Edad");

        cbGenerarCod.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbGenerarCod.setSelected(true);
        cbGenerarCod.setText("Generar código automaticamente");
        cbGenerarCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenerarCodActionPerformed(evt);
            }
        });

        txtDniDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDniDoctor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtDniDoctor.setSelectionColor(new java.awt.Color(51, 51, 51));
        txtDniDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniDoctorKeyPressed(evt);
            }
        });

        txtEdadDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEdadDoctor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtEdadDoctor.setSelectionColor(new java.awt.Color(51, 51, 51));
        txtEdadDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdadDoctorKeyPressed(evt);
            }
        });

        lblApellido.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblApellido.setText("Apellidos");

        txtNomDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNomDoctor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtNomDoctor.setSelectionColor(new java.awt.Color(51, 51, 51));
        txtNomDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomDoctorKeyPressed(evt);
            }
        });

        txtApellidosDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellidosDoctor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtApellidosDoctor.setSelectionColor(new java.awt.Color(51, 51, 51));
        txtApellidosDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosDoctorKeyPressed(evt);
            }
        });

        lblCelular.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblCelular.setText("Celular");

        lblCorreo.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblCorreo.setText("Correo electronico");

        txtCelularDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCelularDoctor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtCelularDoctor.setSelectionColor(new java.awt.Color(51, 51, 51));
        txtCelularDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularDoctorKeyPressed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblDireccion.setText("Dirección");

        lblDni.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblDni.setText("Dni");

        lblCodigo.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        lblCodigo.setText("Codigo");

        txtCodDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodDoctor.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtCodDoctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodDoctorKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDni)
                                    .addComponent(lblCodigo))
                                .addGap(176, 176, 176)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDniDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                                    .addComponent(txtCodDoctor)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEdad)
                                    .addComponent(lblApellido)
                                    .addComponent(lblNombre)
                                    .addComponent(lblCorreo)
                                    .addComponent(lblCelular)
                                    .addComponent(lblDireccion)
                                    .addComponent(lblEspe))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxEspecialidadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDirecDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCelularDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNomDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidosDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbGenerarCod, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCodDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cbGenerarCod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDni)
                    .addComponent(txtDniDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNomDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidosDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblEdad))
                    .addComponent(txtEdadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelular)
                    .addComponent(txtCelularDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreo)
                    .addComponent(txtCorreoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDirecDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEspe)
                    .addComponent(cbxEspecialidadDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 640, 500));

        jPanel5.setBackground(new java.awt.Color(56, 54, 142));

        btnEnviar.setBackground(new java.awt.Color(56, 54, 142));
        btnEnviar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEnviar.setText("Enviar");
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });
        btnEnviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEnviarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 90, 40));

        pnlDoctorExistente.setBackground(new java.awt.Color(255, 255, 255));
        pnlDoctorExistente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDoctorExistente.add(cbxDoctorExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 290, -1));

        rbtDoctorExistente.setText("Elegir un doctor existente");
        rbtDoctorExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDoctorExistenteActionPerformed(evt);
            }
        });
        pnlDoctorExistente.add(rbtDoctorExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 54, -1, -1));

        jPanel1.add(pnlDoctorExistente, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, 110));

        Calendar.setBackground(new java.awt.Color(153, 255, 0));
        Calendar.setDecorationBackgroundColor(new java.awt.Color(255, 153, 0));
        Calendar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        Calendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalendarPropertyChange(evt);
            }
        });
        jPanel1.add(Calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 190, 480, 190));

        pnlTurno.setBackground(new java.awt.Color(255, 255, 255));
        pnlTurno.setToolTipText(".");

        lblTurno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTurno.setText("Turno");

        cbxTurnoDoctor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxTurnoDoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turno mañana", "Turno Tarde", "Turno noche" }));

        lblEscojaturno.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblEscojaturno.setText("Eligir un turno para la fecha");

        LBLPONERTEXTO.setText(".");

        javax.swing.GroupLayout pnlTurnoLayout = new javax.swing.GroupLayout(pnlTurno);
        pnlTurno.setLayout(pnlTurnoLayout);
        pnlTurnoLayout.setHorizontalGroup(
            pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(cbxTurnoDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(pnlTurnoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblEscojaturno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBLPONERTEXTO, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel1.add(pnlTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 400, -1, -1));

        jPanel8.setBackground(new java.awt.Color(56, 54, 142));

        btnRegistrar.setBackground(new java.awt.Color(56, 54, 142));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("registra");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 570, -1, -1));

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
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(pnlPartedeArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 50));

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

    private void ImagenConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenConfigMouseClicked

        if (pnlDesplazable.getX() == 0) {
            desplace.desplazarDerecha(pnlDesplazable, pnlDesplazable.getX(), 100, 10, 10);
            pnlDesaparecer.setVisible(true);
        } else if (pnlDesplazable.getX() == 100) {
            desplace.desplazarIzquierda(pnlDesplazable, pnlDesplazable.getX(), 0, 10, 10);
            pnlDesaparecer.setVisible(false);
        }
    }//GEN-LAST:event_ImagenConfigMouseClicked

    private void cbxEspecialidadDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxEspecialidadDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtDirecDoctor.requestFocus();
        }
    }//GEN-LAST:event_cbxEspecialidadDoctorKeyPressed

    private void txtCorreoDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtDirecDoctor.requestFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtCelularDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtCorreoDoctorKeyPressed

    private void txtDirecDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirecDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnEnviar.requestFocus();

        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtCorreoDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtDirecDoctorKeyPressed

    private void cbGenerarCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenerarCodActionPerformed
        checkbox();
    }//GEN-LAST:event_cbGenerarCodActionPerformed

    private void txtDniDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniDoctorKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtNomDoctor.requestFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtCodDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtDniDoctorKeyPressed

    private void txtEdadDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtCelularDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtEdadDoctorKeyPressed

    private void txtNomDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtApellidosDoctor.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtDniDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtNomDoctorKeyPressed

    private void txtApellidosDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtEdadDoctor.requestFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtNomDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtApellidosDoctorKeyPressed

    private void txtCelularDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtCorreoDoctor.requestFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtApellidosDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtCelularDoctorKeyPressed

    private void txtCodDoctorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodDoctorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtDniDoctor.requestFocus();
        }
    }//GEN-LAST:event_txtCodDoctorKeyPressed

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked
        btnRegistrar.setEnabled(true);
        registroDoctor();
    }//GEN-LAST:event_btnEnviarMouseClicked

    private void rbtDoctorExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDoctorExistenteActionPerformed

        if (rbtDoctorExistente.isSelected()) {
            cbxDoctorExistente.setVisible(true);
            btnRegistrar.setEnabled(true);
            btnEnviar.setEnabled(false);
            ocultarEditable();
            mostrarDoctor();
            mostrarDatos();
            cbGenerarCod.setEnabled(false);
        } else {
            cbxDoctorExistente.setVisible(false);
            btnRegistrar.setEnabled(false);
            btnEnviar.setEnabled(true);
            mostrarEditable();
            cbGenerarCod.setEnabled(true);
        }

    }//GEN-LAST:event_rbtDoctorExistenteActionPerformed

    private void CalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalendarPropertyChange
        String fecha;

        if (evt.getOldValue() != null) {
            SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
            fecha = ff.format(Calendar.getCalendar().getTime());
            pnlTurno.setVisible(true);
            LBLPONERTEXTO.setText(fecha);
        }
    }//GEN-LAST:event_CalendarPropertyChange

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        registroDoctor2();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEnviarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEnviarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            registroDoctor();

        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtDirecDoctor.requestFocus();

        }
    }//GEN-LAST:event_btnEnviarKeyPressed

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

    private void lblModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarMouseClicked
        dispose();
        ModificarDoctor md = new ModificarDoctor();
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

    private void lnlEspecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnlEspecialidadMouseClicked
        dispose();
        ConfiEspecialidad objc = new ConfiEspecialidad();
        objc.setVisible(true);
        objc.almanecarCodRecep(cod_recep);
        objDesva.Abrir(objc, 10);
    }//GEN-LAST:event_lnlEspecialidadMouseClicked

    private void lnlEspecialidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnlEspecialidadKeyPressed

    }//GEN-LAST:event_lnlEspecialidadKeyPressed

    private void btnRegresar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresar1MouseClicked
        dispose();

        Principal p = new Principal();
        p.setVisible(true);
        p.datosRecep(cod_recep);
        objDesva.Abrir(p, 10);
    }//GEN-LAST:event_btnRegresar1MouseClicked
    private void checkbox() {
        if (cbGenerarCod.isSelected()) {
            objDoctorDao.nuevoCod(objDoctor);
            txtCodDoctor.setText(objDoctor.getCODIGO_DOCTOR());
            btnRegistrar.setEnabled(false);
        } else {
            txtCodDoctor.setText(null);
            btnRegistrar.setEnabled(false);
            txtCodDoctor.requestFocus();
        }
    }
    private void mostrarDoctor() {
        listaDoctor = objDoctorDao.todosDoctoresSinDuplicar();
        for (int i = 0; i < listaDoctor.size(); i++) {
            cbxDoctorExistente.addItem(listaDoctor.get(i).getNombre() + listaDoctor.get(i).getApellido() + " - " + listaDoctor.get(i).getCODIGO_DOCTOR());
        }
        cbxDoctorExistente.addActionListener((ActionEvent e1) -> {
            mostrarDatos();
        });
    }

    private void mostrarDatos() {
        int indiDoc = cbxDoctorExistente.getSelectedIndex();
        txtCodDoctor.setText(listaDoctor.get(indiDoc).getCODIGO_DOCTOR());

        txtDniDoctor.setText(listaDoctor.get(indiDoc).getDni());
        txtNomDoctor.setText(listaDoctor.get(indiDoc).getNombre());
        txtApellidosDoctor.setText(listaDoctor.get(indiDoc).getApellido());
        txtEdadDoctor.setText(listaDoctor.get(indiDoc).getEdad() + "");
        txtCelularDoctor.setText(listaDoctor.get(indiDoc).getCelular());
        txtCorreoDoctor.setText(listaDoctor.get(indiDoc).getCorreo());
        txtDirecDoctor.setText(listaDoctor.get(indiDoc).getDireccion());
        cbxEspecialidadDoctor.setSelectedItem(listaDoctor.get(indiDoc).getObjEspe().getNomEspe());

    }
    private void ocultarEditable() {
        txtCodDoctor.setEnabled(false);
        txtDniDoctor.setEnabled(false);
        txtNomDoctor.setEnabled(false);
        txtApellidosDoctor.setEnabled(false);
        txtEdadDoctor.setEnabled(false);
        txtCelularDoctor.setEnabled(false);
        txtCorreoDoctor.setEnabled(false);
        txtDirecDoctor.setEnabled(false);
        cbxEspecialidadDoctor.setEnabled(false);
    }

    private void mostrarEditable() {
        txtCodDoctor.setEnabled(true);
        txtDniDoctor.setEnabled(true);
        txtNomDoctor.setEnabled(true);
        txtApellidosDoctor.setEnabled(true);
        txtEdadDoctor.setEnabled(true);
        txtCelularDoctor.setEnabled(true);
        txtCorreoDoctor.setEnabled(true);
        txtDirecDoctor.setEnabled(true);
        cbxEspecialidadDoctor.setEnabled(true);
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar Calendar;
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel ImagenConfig;
    private javax.swing.JLabel LBLPONERTEXTO;
    private javax.swing.JLabel btnEnviar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel btnRegresar1;
    private javax.swing.JCheckBox cbGenerarCod;
    private javax.swing.JComboBox<String> cbxDoctorExistente;
    private javax.swing.JComboBox<String> cbxEspecialidadDoctor;
    private javax.swing.JComboBox<String> cbxTurnoDoctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEliminar;
    private javax.swing.JLabel lblEscojaturno;
    private javax.swing.JLabel lblEspe;
    private javax.swing.JLabel lblListar;
    private javax.swing.JLabel lblModificar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JLabel lnlEspecialidad;
    private javax.swing.JPanel pnlDesaparecer;
    private javax.swing.JPanel pnlDesplazable;
    private javax.swing.JPanel pnlDoctorExistente;
    private javax.swing.JPanel pnlExit1;
    private javax.swing.JPanel pnlPartedeArriba;
    private javax.swing.JPanel pnlTurno;
    private javax.swing.JRadioButton rbtDoctorExistente;
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
