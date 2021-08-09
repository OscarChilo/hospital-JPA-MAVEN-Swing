package com.bicentenario.hospital.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bicentenario.hospital.dao.EnfermedadDAO;
import com.bicentenario.hospital.model.JPAUtil;
import com.bicentenario.hospital.model.Enfermedad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class EnfermedadForm extends JInternalFrame {
	private JTextField txtId;
	private JTextField txtNombresE;
	private JTextField txtSintomas;
	private JTextField txtBuscar;
	private JTable table1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnfermedadForm frame = new EnfermedadForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void listarTabla(JTable tabla) {
		DefaultTableModel model = new DefaultTableModel(null, new Object[] 
				{"ID","ENFERMEDADES","SINTOMAS"});
		JPAUtil.getEntityManagerFactory();
		EnfermedadDAO listar=new EnfermedadDAO();

		@SuppressWarnings("unchecked")
		List<Enfermedad> listarEnfermedads=listar.obtenerEnfermedades();
		for (Enfermedad i :listarEnfermedads) {
			model.addRow(new Object[] { i.getId_enfermedad(), i.getNomb_enfermedad(), i.getSintomas() });
		}
		tabla.setModel(model);
		
		JPAUtil.shutdown();
	}
	
	public void listaBuscar(JTable tabla, int clave) {
		DefaultTableModel model = new DefaultTableModel(null, new Object[] 
				{"ID","ENFERMEDADES","SINTOMAS"});
		
		Enfermedad e = new Enfermedad();
		EnfermedadDAO buscarEnfermedad=new EnfermedadDAO();
		e = buscarEnfermedad.buscar(clave);
		model.addRow(new Object[] {e.getId_enfermedad(), e.getNomb_enfermedad(), e.getSintomas()});
		table1.setModel(model);
		
		JPAUtil.shutdown();
	}
	
	public void eliminar(int clave) {
		EnfermedadDAO eliminarEnfermedad = new EnfermedadDAO();
		eliminarEnfermedad.eliminar(clave);
		JPAUtil.shutdown();
	}
	
	private void limpiar() {
		txtId.setText("");
		txtNombresE.setText("");
		txtSintomas.setText("");
	}

	/**
	 * Create the frame.
	 */
	public EnfermedadForm() {
		setClosable(true);
		setBounds(0, 0, 1280, 650);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "REGISTRO DE ENFERMEDADES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(31, 92, 426, 324);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Id = new JLabel("ID Enfermedad");
		Id.setBounds(32, 61, 113, 14);
		panel.add(Id);
		
		JLabel Nombre = new JLabel("Nombre Enfermedad");
		Nombre.setBounds(32, 126, 123, 14);
		panel.add(Nombre);
		
		JLabel Sintomas = new JLabel("Sintomas");
		Sintomas.setBounds(32, 183, 113, 14);
		panel.add(Sintomas);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(197, 61, 186, 23);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtNombresE = new JTextField();
		txtNombresE.setBounds(197, 125, 186, 23);
		panel.add(txtNombresE);
		txtNombresE.setColumns(10);
		
		txtSintomas = new JTextField();
		txtSintomas.setBounds(197, 183, 186, 23);
		panel.add(txtSintomas);
		txtSintomas.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(159, 253, 123, 34);
		panel.add(btnLimpiar);
		
		JLabel lblNewLabel = new JLabel("ENFERMEDADES");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel.setBounds(576, 28, 210, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Enfermedad");
		lblNewLabel_1.setBounds(32, 489, 108, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(131, 484, 128, 25);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clave1=Integer.parseInt(txtBuscar.getText());
				listaBuscar(table1,clave1);
			}
		});
		btnBuscar.setBounds(282, 478, 131, 36);
		getContentPane().add(btnBuscar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent e) {
				EnfermedadDAO guardarEnfermedad=new EnfermedadDAO();
				JPAUtil.getEntityManagerFactory();
				String nombre, sintomas;
				Enfermedad newEnfermedad = new Enfermedad();
				
				nombre = txtNombresE.getText();
				sintomas = txtSintomas.getText();
				newEnfermedad.setNomb_enfermedad(nombre);
				newEnfermedad.setSintomas(sintomas);
				guardarEnfermedad.guardar(newEnfermedad);
				
				JPAUtil.shutdown();
				JOptionPane.showMessageDialog(null, "Enfermedad REGISTRADA con EXITO!!");
				limpiar();
				listarTabla(table1);
				
			}
		});
		btnAgregar.setBounds(485, 127, 137, 43);
		getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				EnfermedadDAO actualizarEnfermedad=new EnfermedadDAO();
				JPAUtil.getEntityManagerFactory();
				Enfermedad exitsEnfermedad=new Enfermedad();
				String nombre,sintomas;
				int idEnfermedad;
				
				idEnfermedad = Integer.parseInt(txtId.getText());
				nombre = txtNombresE.getText();
				sintomas=txtSintomas.getText();	
				exitsEnfermedad.setId_enfermedad(idEnfermedad);
				exitsEnfermedad.setNomb_enfermedad(nombre);
				exitsEnfermedad.setSintomas(sintomas);
				
				actualizarEnfermedad.editar(exitsEnfermedad);
				JPAUtil.shutdown();
				JOptionPane.showMessageDialog(null, "Enfermedad ACTUALIZADA con EXITO!!");
				limpiar();
				listarTabla(table1);
			}
		});
		btnActualizar.setBounds(485, 181, 137, 46);
		getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtBuscar.getText());
				eliminar(id);
				JOptionPane.showMessageDialog(null, "Enfermedad ELIMINADA con EXITO!!");
				txtBuscar.setText("");
				listarTabla(table1);
				
			}
		});
		btnEliminar.setBounds(485, 238, 137, 46);
		getContentPane().add(btnEliminar);
		
		JButton btnMostrar = new JButton("Mostrar Tabla");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarTabla(table1);
			}
		});
		btnMostrar.setBounds(649, 467, 137, 59);
		getContentPane().add(btnMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(650, 92, 570, 364);
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
					txtNombresE.setText(table1.getValueAt(table1.getSelectedRow(), 1).toString());
					txtSintomas.setText(table1.getValueAt(table1.getSelectedRow(), 2).toString());
				}
			}
		});

	}
}