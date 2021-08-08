package com.bicentenario.hospital.view;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bicentenario.hospital.dao.PacienteDAO;
import com.bicentenario.hospital.model.JPAUtil;
import com.bicentenario.hospital.model.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class PacienteForm extends JInternalFrame {
	private JTextField txtId;
	private JTextField txtDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtNacimiento;
	private JTextField txtTelefono;
	private JTextField txtBuscar;
	private JTable table1;
	
	public static SimpleDateFormat formato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteForm frame = new PacienteForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	public void listarTabla(JTable tabla) {
		
		formato = new SimpleDateFormat("yyyy-MM-dd");
		DefaultTableModel model = new DefaultTableModel(null, new Object[] {"ID_PACIENTE","DNI","NOMBRES","APELLIDOS","FECH.Nacimiento","EDAD","TELEFONO"});
		

		JPAUtil.getEntityManagerFactory();
		
		PacienteDAO listar=new PacienteDAO();

		@SuppressWarnings("unchecked")
		List<Paciente> listarPacientes=listar.obtenerPacientes();

		
		for (Paciente i :listarPacientes) {
			model.addRow(new Object[] { i.getId_paciente(), i.getDni(), i.getNomb_paciente(), i.getApell_paciente(),formato.format(i.getFech_nacimiento()),i.getEdad(),i.getTelefono() });
		}
		tabla.setModel(model);
		
		JPAUtil.shutdown();

	}
	
	public void listaBuscar(JTable tabla, int clave) {
		DefaultTableModel model = new DefaultTableModel(null, new Object[] {"ID_PACIENTE","DNI","NOMBRES","APELLIDOS","FECH.Nacimiento","EDAD","TELEFONO"});
		Paciente p=new Paciente();
		PacienteDAO buscarPaciente=new PacienteDAO();
		p=buscarPaciente.buscar(clave);
		
		model.addRow(new Object[] {p.getId_paciente(),p.getDni(),p.getNomb_paciente(),p.getApell_paciente(),p.getFech_nacimiento(),p.getEdad(),p.getTelefono()});
		table1.setModel(model);
		JPAUtil.shutdown();
	}
	
	public void eliminar(int clave) {
		PacienteDAO eliminarPaciente=new PacienteDAO();
		eliminarPaciente.eliminar(clave);
		JPAUtil.shutdown();
	}
	private void limpiar() {
		txtId.setText("");
		txtDni.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtNacimiento.setText("");
		txtTelefono.setText("");
		txtDni.requestFocus();
		
	}
	

	/**
	 * Create the frame.
	 */
	public PacienteForm() {
		setClosable(true);
		setBounds(0, 0, 1280, 650);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "REGISTRO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(31, 92, 381, 364);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Id = new JLabel("ID Paciente");
		Id.setBounds(32, 61, 55, 14);
		panel.add(Id);
		
		JLabel Dni = new JLabel("DNI");
		Dni.setBounds(32, 104, 46, 14);
		panel.add(Dni);
		
		JLabel Nombre = new JLabel("Nombres");
		Nombre.setBounds(32, 143, 42, 14);
		panel.add(Nombre);
		
		JLabel Apellidos = new JLabel("Apellidos");
		Apellidos.setBounds(32, 183, 42, 14);
		panel.add(Apellidos);
		
		JLabel Fecha = new JLabel("Fech. Nacimiento");
		Fecha.setBounds(32, 227, 82, 14);
		panel.add(Fecha);
		
		JLabel Telefono = new JLabel("NRO Celular");
		Telefono.setBounds(32, 269, 58, 14);
		panel.add(Telefono);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(155, 58, 186, 23);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(155, 101, 186, 23);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(155, 140, 186, 23);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(155, 180, 186, 23);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtNacimiento = new JTextField();
		txtNacimiento.setText("Ejemplo: 1995-02-16");
		txtNacimiento.setBounds(155, 224, 186, 23);
		panel.add(txtNacimiento);
		txtNacimiento.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(155, 266, 186, 23);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(135, 330, 95, 23);
		panel.add(btnLimpiar);
		
		JLabel lblNewLabel = new JLabel("PACIENTES");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblNewLabel.setBounds(576, 28, 137, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Paciente");
		lblNewLabel_1.setBounds(79, 521, 54, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(143, 518, 128, 25);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int clave1=Integer.parseInt(txtBuscar.getText());
				listaBuscar(table1,clave1);
			}
		});
		btnBuscar.setBounds(281, 509, 108, 43);
		getContentPane().add(btnBuscar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				
				formato = new SimpleDateFormat("yyyy-MM-dd");
				
				PacienteDAO guardarPaciente=new PacienteDAO();
				JPAUtil.getEntityManagerFactory();
				String dni,nombres,apellidos,telefono;
				int edad;
				Date fecha = null;
				Paciente newpaciente=new Paciente();
				dni=txtDni.getText();
				nombres=txtNombres.getText();
				apellidos=txtApellidos.getText();				
				try {
					fecha=formato.parse(txtNacimiento.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				edad=LocalDate.now().getYear()-LocalDate.parse(txtNacimiento.getText()).getYear();
				telefono=txtTelefono.getText();
				
				newpaciente.setDni(dni);
				newpaciente.setNomb_paciente(nombres);
				newpaciente.setApell_paciente(apellidos);
				newpaciente.setFech_nacimiento(fecha);
				newpaciente.setEdad(edad);
				newpaciente.setTelefono(telefono);
				
				guardarPaciente.guardar(newpaciente);
				
				JPAUtil.shutdown();
				JOptionPane.showMessageDialog(null, "Paciente REGISTRADO con EXITO!!");
				limpiar();
				listarTabla(table1);
				
			}
		});
		btnAgregar.setBounds(439, 126, 104, 43);
		getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				formato = new SimpleDateFormat("yyyy-MM-dd");
				
				PacienteDAO actualizarPaciente=new PacienteDAO();
				JPAUtil.getEntityManagerFactory();
				Paciente exitsPaciente=new Paciente();
				
				String dni,nombres,apellidos,telefono;
				int edad,idPaciente;
				Date fecha = null;
				
				idPaciente=Integer.parseInt(txtId.getText());
				dni=txtDni.getText();
				nombres=txtNombres.getText();
				apellidos=txtApellidos.getText();				
				try {
					fecha=formato.parse(txtNacimiento.getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				telefono=txtTelefono.getText();
				exitsPaciente.setId_paciente(idPaciente);
				exitsPaciente.setDni(dni);
				exitsPaciente.setNomb_paciente(nombres);
				exitsPaciente.setApell_paciente(apellidos);
				exitsPaciente.setFech_nacimiento(fecha);
				exitsPaciente.setTelefono(telefono);
				
				actualizarPaciente.editar(exitsPaciente);
				
				JPAUtil.shutdown();
				JOptionPane.showMessageDialog(null, "Paciente ACTUALIZADO con EXITO!!");
				limpiar();
				listarTabla(table1);
			}
		});
		btnActualizar.setBounds(438, 180, 105, 46);
		getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id=Integer.parseInt(txtBuscar.getText());
				eliminar(id);
				JOptionPane.showMessageDialog(null, "Paciente ELIMINADO con EXITO!!");
				txtBuscar.setText("");
				listarTabla(table1);
				
			}
		});
		btnEliminar.setBounds(438, 237, 105, 46);
		getContentPane().add(btnEliminar);
		
		JButton btnMostrar = new JButton("Mostrar Tabla");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarTabla(table1);
			}
		});
		btnMostrar.setBounds(576, 467, 137, 59);
		getContentPane().add(btnMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(576, 92, 630, 364);
		getContentPane().add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table1=(JTable)e.getSource();
				Point point=e.getPoint();
				int row=table1.rowAtPoint(point);
				if(e.getClickCount()==1) {
					
					txtId.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());
					txtDni.setText(table1.getValueAt(table1.getSelectedRow(), 1).toString());
					txtNombres.setText(table1.getValueAt(table1.getSelectedRow(), 2).toString());
					txtApellidos.setText(table1.getValueAt(table1.getSelectedRow(), 3).toString());
					txtNacimiento.setText(table1.getValueAt(table1.getSelectedRow(), 4).toString());
					txtTelefono.setText(table1.getValueAt(table1.getSelectedRow(), 6).toString());
						
				}
			}
		});

	}
}
