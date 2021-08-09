package com.bicentenario.hospital.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.bicentenario.hospital.dao.EnfermedadDAO;
import com.bicentenario.hospital.dao.MedicamentoDAO;
import com.bicentenario.hospital.model.Medicamento;
import com.bicentenario.hospital.model.Enfermedad;
import com.bicentenario.hospital.model.JPAUtil;

public class MedicamentoForm extends JInternalFrame {
	private JTextField txtId;
	private JTextField txtMedicamento;
	private JTextField txtBuscar;
	private JTable table1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicamentoForm frame = new MedicamentoForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void listarTabla(JTable tabla) {
		DefaultTableModel model = new DefaultTableModel(null, new Object[] 
				{"ID","MEDICAMENTOS"});
		JPAUtil.getEntityManagerFactory();
		MedicamentoDAO listar=new MedicamentoDAO();

		@SuppressWarnings("unchecked")
		List<Medicamento> listarMedicamentos=listar.obtenerMedicamentos();
		for (Medicamento i :listarMedicamentos) {
			model.addRow(new Object[] { i.getId_medicamento(), i.getNomb_medicamento() });
		}
		tabla.setModel(model);
		
		JPAUtil.shutdown();
	}
	
	public void listaBuscar(JTable tabla, int clave) {
		DefaultTableModel model = new DefaultTableModel(null, new Object[] 
				{"ID","MEDICAMENTOS"});
		
		Medicamento m = new Medicamento();
		MedicamentoDAO buscarMedicamento=new MedicamentoDAO();
		m = buscarMedicamento.buscar(clave);
		model.addRow(new Object[] {m.getId_medicamento(), m.getNomb_medicamento()});
		table1.setModel(model);
		
		JPAUtil.shutdown();
	}
	
	public void eliminar(int clave) {
		MedicamentoDAO eliminarMedicamento = new MedicamentoDAO();
		eliminarMedicamento.eliminar(clave);
		JPAUtil.shutdown();
	}
	
	private void limpiar() {
		txtId.setText("");
		txtMedicamento.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	public MedicamentoForm() {
		setClosable(true);
		setBounds(0, 0, 1280, 650);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "REGISTRO DE MEDICAMENTOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(51, 93, 381, 363);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Id = new JLabel("ID Medicamento");
		Id.setBounds(30, 107, 113, 19);
		panel.add(Id);
		
		JLabel Nombre = new JLabel("Medicamento");
		Nombre.setBounds(30, 189, 95, 19);
		panel.add(Nombre);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(153, 103, 186, 23);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtMedicamento = new JTextField();
		txtMedicamento.setBounds(153, 185, 186, 23);
		panel.add(txtMedicamento);
		txtMedicamento.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(124, 264, 133, 38);
		panel.add(btnLimpiar);
		
		JLabel lblNewLabel = new JLabel("MEDICAMENTOS");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel.setBounds(536, 28, 197, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Medicamento");
		lblNewLabel_1.setBounds(51, 521, 108, 20);
		getContentPane().add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(169, 516, 145, 25);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clave1=Integer.parseInt(txtBuscar.getText());
				listaBuscar(table1,clave1);
			}
		});
		btnBuscar.setBounds(324, 507, 108, 43);
		getContentPane().add(btnBuscar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent e) {
				MedicamentoDAO guardarMedicamento = new MedicamentoDAO();
				JPAUtil.getEntityManagerFactory();
				String medicamento;
				Medicamento newMedicamento = new Medicamento();
				
				medicamento = txtMedicamento.getText();
				newMedicamento.setNomb_medicamento(medicamento);
				guardarMedicamento.guardar(newMedicamento);
				
				JPAUtil.shutdown();
				JOptionPane.showMessageDialog(null, "Medicamento REGISTRADO con EXITO!!");
				limpiar();
				listarTabla(table1);
				
			}
		});
		btnAgregar.setBounds(457, 126, 143, 43);
		getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MedicamentoDAO actualizarMedicamento = new MedicamentoDAO();
				JPAUtil.getEntityManagerFactory();
				Medicamento exitsMedicamento = new Medicamento();
				String medicamento;
				int idMedicamento;
				
				idMedicamento = Integer.parseInt(txtId.getText());
				medicamento = txtMedicamento.getText();
				exitsMedicamento.setId_medicamento(idMedicamento);
				exitsMedicamento.setNomb_medicamento(medicamento);
				
				actualizarMedicamento.editar(exitsMedicamento);
				JPAUtil.shutdown();
				JOptionPane.showMessageDialog(null, "Medicamento ACTUALIZADO con EXITO!!");
				limpiar();
				listarTabla(table1);
			}
		});
		btnActualizar.setBounds(456, 180, 144, 46);
		getContentPane().add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtBuscar.getText());
				eliminar(id);
				JOptionPane.showMessageDialog(null, "Medicamento ELIMINADO con EXITO!!");
				txtBuscar.setText("");
				listarTabla(table1);
			}
		});
		btnEliminar.setBounds(456, 237, 144, 46);
		getContentPane().add(btnEliminar);
		
		JButton btnMostrar = new JButton("Mostrar Medicamentos");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarTabla(table1);
			}
		});
		btnMostrar.setBounds(622, 484, 197, 59);
		getContentPane().add(btnMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(622, 92, 584, 364);
		getContentPane().add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		table1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				table1=(JTable)e.getSource();
				if(e.getClickCount()==1) {
					txtId.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());
					txtMedicamento.setText(table1.getValueAt(table1.getSelectedRow(), 1).toString());
				}
			}
		});
	}

}
