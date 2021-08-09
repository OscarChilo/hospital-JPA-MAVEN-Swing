package com.bicentenario.hospital.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bicentenario.hospital.dao.MedicoDAO;
import com.bicentenario.hospital.model.JPAUtil;
import com.bicentenario.hospital.model.Medico;

public class MedicoForm extends JInternalFrame {
	private JTextField txtId;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEspecialidad;
	private JTextField txtTelefono;
	private JTextField txtBuscar;
	private JTable table1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicoForm frame = new MedicoForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void listarTabla(JTable tabla) {
		DefaultTableModel model = new DefaultTableModel(null, new Object[] 
				{"ID","NOMBRES","APELLIDOS","ESPECIALIDAD","TELEFONO"});
		JPAUtil.getEntityManagerFactory();
		MedicoDAO listar = new MedicoDAO();

		@SuppressWarnings("unchecked")
		List<Medico> listarMedicos = listar.obtenerMedicos();
		for (Medico i : listarMedicos) {
			model.addRow(new Object[] { 
					i.getId_medico(),i.getNombres(),i.getApellidos(),i.getEspecialidad(),i.getTelefono() });
		}
		tabla.setModel(model);
		
		JPAUtil.shutdown();
	}
	
	public void listaBuscar(JTable tabla, int clave) {
		DefaultTableModel model = new DefaultTableModel(null, new Object[] 
				{"ID","NOMBRES","APELLIDOS","ESPECIALIDAD","TELEFONO"});
		
		Medico m = new Medico();
		MedicoDAO buscarMedico=new MedicoDAO();
		m = buscarMedico.buscar(clave);
		model.addRow(new Object[] { m.getId_medico(),m.getNombres(),m.getApellidos(),m.getEspecialidad(),m.getTelefono() });
		table1.setModel(model);
		
		JPAUtil.shutdown();
	}
	
	public void eliminar(int clave) {
		MedicoDAO eliminarMedico = new MedicoDAO();
		eliminarMedico.eliminar(clave);
		JPAUtil.shutdown();
	}
	
	private void limpiar() {
		txtId.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtEspecialidad.setText("");
		txtTelefono.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	public MedicoForm() {
		setClosable(true);
		setBounds(0, 0, 1280, 650);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "REGISTRO DE MÉDICOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(31, 92, 381, 364);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Id = new JLabel("ID Medico");
		Id.setBounds(32, 61, 82, 20);
		panel.add(Id);
		
		JLabel Nombres = new JLabel("Nombres");
		Nombres.setBounds(32, 104, 82, 20);
		panel.add(Nombres);
		
		JLabel Apellidos = new JLabel("Apellidos");
		Apellidos.setBounds(32, 143, 82, 20);
		panel.add(Apellidos);
		
		JLabel Especialidad = new JLabel("Especialidad");
		Especialidad.setBounds(32, 183, 124, 20);
		panel.add(Especialidad);
		
		JLabel Celular = new JLabel("NRO Celular");
		Celular.setBounds(32, 227, 113, 20);
		panel.add(Celular);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(155, 58, 186, 23);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(155, 101, 186, 23);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(155, 140, 186, 23);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(155, 180, 186, 23);
		panel.add(txtEspecialidad);
		txtEspecialidad.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(155, 224, 186, 23);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(137, 297, 124, 33);
		panel.add(btnLimpiar);
		
		JLabel lblNewLabel = new JLabel("MEDICOS");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel.setBounds(576, 11, 156, 52);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Medico");
		lblNewLabel_1.setBounds(47, 497, 87, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(143, 492, 128, 25);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int clave1=Integer.parseInt(txtBuscar.getText());
				listaBuscar(table1,clave1);
			}
		});
		btnBuscar.setBounds(281, 483, 131, 43);
		getContentPane().add(btnBuscar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				MedicoDAO guardarMedico = new MedicoDAO();
				JPAUtil.getEntityManagerFactory();
				String nombres, apellidos, especialidad, telefono;
				Medico newmedico=new Medico();
				nombres=txtNombres.getText();
				apellidos=txtApellidos.getText();
				especialidad=txtEspecialidad.getText();
				telefono=txtTelefono.getText();
				
				newmedico.setNombres(nombres);
				newmedico.setApellidos(apellidos);
				newmedico.setEspecialidad(especialidad);
				newmedico.setTelefono(telefono);
				
				guardarMedico.guardar(newmedico);
				
				JPAUtil.shutdown();
				JOptionPane.showMessageDialog(null, "Médico REGISTRADO con EXITO!!");
				limpiar();
				listarTabla(table1);
				
			}
		});
		btnAgregar.setBounds(423, 126, 132, 43);
		getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoDAO actualizarMedico=new MedicoDAO();
				JPAUtil.getEntityManagerFactory();
				Medico exitsMedico=new Medico();
				String nombres, apellidos, especialidad, telefono;
				int idMedico;
				
				idMedico = Integer.parseInt(txtId.getText());
				nombres = txtNombres.getText();
				apellidos = txtApellidos.getText();	
				especialidad = txtEspecialidad.getText();
				telefono = txtTelefono.getText();
				
				exitsMedico.setId_medico(idMedico);
				exitsMedico.setNombres(nombres);
				exitsMedico.setApellidos(apellidos);
				exitsMedico.setEspecialidad(especialidad);
				exitsMedico.setTelefono(telefono);
				
				actualizarMedico.editar(exitsMedico);
				JPAUtil.shutdown();
				JOptionPane.showMessageDialog(null, "Médico ACTUALIZADO con EXITO!!");
				limpiar();
				listarTabla(table1);
			}
		});
		btnActualizar.setBounds(422, 180, 133, 46);
		getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(txtBuscar.getText());
				eliminar(id);
				JOptionPane.showMessageDialog(null, "Médico ELIMINADO con EXITO!!");
				txtBuscar.setText("");
				listarTabla(table1);
				
			}
		});
		btnEliminar.setBounds(422, 237, 133, 46);
		getContentPane().add(btnEliminar);
		
		JButton btnMostrar = new JButton("Mostrar Tabla");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarTabla(table1);
			}
		});
		btnMostrar.setBounds(576, 467, 156, 59);
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
				if(e.getClickCount()==1) {
					txtId.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());
					txtNombres.setText(table1.getValueAt(table1.getSelectedRow(), 1).toString());
					txtApellidos.setText(table1.getValueAt(table1.getSelectedRow(), 2).toString());
					txtEspecialidad.setText(table1.getValueAt(table1.getSelectedRow(), 3).toString());
					txtTelefono.setText(table1.getValueAt(table1.getSelectedRow(), 4).toString());	
				}
			}
		});
	}

}