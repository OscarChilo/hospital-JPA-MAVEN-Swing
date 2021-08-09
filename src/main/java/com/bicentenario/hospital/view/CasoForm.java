package com.bicentenario.hospital.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.bicentenario.hospital.dao.CasoDAO;
import com.bicentenario.hospital.dao.EnfermedadDAO;
import com.bicentenario.hospital.dao.PacienteDAO;
import com.bicentenario.hospital.model.Caso;
import com.bicentenario.hospital.model.Enfermedad;
import com.bicentenario.hospital.model.JPAUtil;
import com.bicentenario.hospital.model.Paciente;
import com.panayotis.gnuplot.GNUPlotParameters;
import com.panayotis.gnuplot.JavaPlot;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ItemEvent;

public class CasoForm extends JInternalFrame {
	private JTextField txtId;
	private JTextField txtTemperatura;
	private JTextField txtSaturacion;
	private JTextField txtBuscar;
	private JTable table2;
	private JComboBox cmbEnfermedad;
	
	public static SimpleDateFormat formato;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				//llenarCombo(cmbEnfermedad);
				try {
					CasoForm frame = new CasoForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void listarCasos(JTable tabla) {
		
		formato = new SimpleDateFormat("yyyy-MM-dd");
		DefaultTableModel model = new DefaultTableModel(null, new Object[] {"ID_CASO","IdPaciente","Apellidos","NombEnfermedad","IdMedico","IdMedicamento","Temperatura","Saturacion","Fecha"});
		

		JPAUtil.getEntityManagerFactory();
		
		CasoDAO listar=new CasoDAO();

		
		List<Caso> listarCasos=listar.obtenerCasos();

		
		for (Caso i :listarCasos) {
			model.addRow(new Object[] { i.getId_caso(), i.getId_paciente(), i.getApellidos(),i.getNomb_enfermedad(),i.getId_medico(),i.getId_medicamento(),i.getTemperatura(),i.getSaturacion(),formato.format(i.getFecha()) });
		}
		tabla.setModel(model);
		
		JPAUtil.shutdown();
	}
	
	public void buscar(JTable tabla, int id) {
		formato = new SimpleDateFormat("yyyy-MM-dd");
		DefaultTableModel model = new DefaultTableModel(null, new Object[] {"NRO","ID_CASO","IdPaciente","Apellidos","NombEnfermedad","IdMedico","IdMedicamento","Temperatura","Saturacion","Fecha"});
		

		JPAUtil.getEntityManagerFactory();
		
		CasoDAO listar=new CasoDAO();

		
		List<Caso> listarCasos=listar.listaCasos(id);
		
		int count=1;
		for (Caso c  : listarCasos) {
			model.addRow(new Object[] {count,c.getId_caso(),c.getId_paciente(),c.getApellidos(),c.getNomb_enfermedad(),c.getId_medico(),c.getId_medicamento(),c.getTemperatura(),c.getSaturacion(),formato.format(c.getFecha())});
			count++;
		}
		tabla.setModel(model);
		
		JPAUtil.shutdown();
		
	}
	
	@SuppressWarnings("unchecked")
	public void llenarCombo(JComboBox cmbEnfer) {
		
		JPAUtil.getEntityManagerFactory();
		cmbEnfer.removeAllItems();
		EnfermedadDAO lista=new EnfermedadDAO();
		List<Enfermedad> listaEnfer=lista.obtenerEnfermedades();
		
		

        //Rellena el comboBox con la descripción del ArrayList alAutos
        for(Enfermedad i:listaEnfer ){
            cmbEnfer.addItem(i.getNomb_enfermedad());
        }
        //Item seleccionado por defecto, en la posición 0
        cmbEnfer.setSelectedIndex(0);
        JPAUtil.shutdown();
	}

	/**
	 * Create the frame.
	 */
	public CasoForm() {
		
		setBounds(0, 0, 1280, 650);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "REGISTRO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(48, 121, 342, 351);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Paciente");
		lblNewLabel.setBounds(28, 52, 74, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enfermedad");
		lblNewLabel_1.setBounds(28, 99, 93, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Medico a Cargo");
		lblNewLabel_2.setBounds(28, 146, 105, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Medicamento");
		lblNewLabel_3.setBounds(28, 192, 105, 14);
		panel.add(lblNewLabel_3);
		
		txtId = new JTextField();
		txtId.setBounds(142, 49, 179, 25);
		panel.add(txtId);
		txtId.setColumns(10);
		
		cmbEnfermedad = new JComboBox();
		cmbEnfermedad.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
		            String enfermedad=e.getItem().toString();
		        }
			}
		});
		cmbEnfermedad.setBounds(142, 95, 179, 22);
		panel.add(cmbEnfermedad);
		
		JLabel lblNewLabel_4 = new JLabel("Temperatura");
		lblNewLabel_4.setBounds(57, 232, 93, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Satutacion");
		lblNewLabel_5.setBounds(207, 232, 86, 14);
		panel.add(lblNewLabel_5);
		
		txtTemperatura = new JTextField();
		txtTemperatura.setBounds(47, 250, 86, 25);
		panel.add(txtTemperatura);
		txtTemperatura.setColumns(10);
		
		txtSaturacion = new JTextField();
		txtSaturacion.setBounds(190, 250, 86, 25);
		panel.add(txtSaturacion);
		txtSaturacion.setColumns(10);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(112, 296, 102, 32);
		panel.add(btnLimpiar);
		
		textField = new JTextField();
		textField.setBounds(143, 138, 178, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 184, 178, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(134, 511, 134, 23);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ID Paciente");
		lblNewLabel_6.setBounds(58, 514, 66, 14);
		getContentPane().add(lblNewLabel_6);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(txtBuscar.getText());
				buscar(table2,id);
				
				JPAUtil.getEntityManagerFactory();
				
				CasoDAO listarTemp=new CasoDAO();
				CasoDAO listarSatu=new CasoDAO();

				
				List<Caso> listTemperatura=listarTemp.listaTemp(id);
				List<Caso> listSaturacion=listarSatu.listaSatu(id);
				JPAUtil.shutdown();
				
				for (int p=0 ;p<listTemperatura.size();p++) {
					System.out.println((p+1)+" "+listTemperatura.get(p)+"\n");
				}
				
				try {
					File temperatura = null;
					File saturacion = null;
					BufferedWriter bw = null;
					BufferedWriter bw2 = null;
					temperatura = new File("temperatura.txt");
					saturacion = new File("saturacion.txt");
					temperatura.createNewFile();
					saturacion.createNewFile();
					bw = new BufferedWriter(new FileWriter(temperatura));
					bw2 = new BufferedWriter(new FileWriter(saturacion));
					
					int cont = 1;
					for(int  i =0; i<listTemperatura.size();i++) {
						bw.write((i+1) + " " + listTemperatura.get(i) +"\t"); // tiempo x temperatura
						bw.newLine();
						cont++;
					}
					
					for(int  j =0; j<listSaturacion.size();j++) {
						bw2.write((j+1) + " " + listSaturacion.get(j) +"\t"); // tiempo x temperatura
						bw2.newLine();
						cont++;
					}
					
					bw.close();
					bw2.close();
					//Desktop.getDesktop().open(gnu);
					//Desktop.getDesktop().open(gnu2);
					JavaPlot p = new JavaPlot();
					
					GNUPlotParameters params=p.getParameters();
					p.setTitle("Signos Vitales");
					params.set("xlabel 'FECHAS'");
					params.set("ylabel 'TEMPERATURA   Y   SATURACION'");

			        p.addPlot("\"temperatura.txt\" with lines");
			        p.addPlot("\"saturacion.txt\" with lines");
			        p.plot();
					
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//JOptionPane.showMessageDialog(null, "Graficado con EXITO!!")
				
				
			}
		});
		btnBuscar.setBounds(273, 503, 89, 31);
		getContentPane().add(btnBuscar);
		
		JButton btnAgregar = new JButton("Agregar CASO");
		btnAgregar.setBounds(400, 251, 133, 65);
		getContentPane().add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(543, 121, 696, 351);
		getContentPane().add(scrollPane);
		
		table2 = new JTable();
		scrollPane.setViewportView(table2);
		
		JButton btnMostrar = new JButton("Mostrar TABLA");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarCasos(table2);
				llenarCombo(cmbEnfermedad);
			}
		});
		btnMostrar.setBounds(543, 503, 192, 31);
		getContentPane().add(btnMostrar);
		
		JLabel lblNewLabel_7 = new JLabel("CASOS");
		lblNewLabel_7.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel_7.setBounds(597, 25, 124, 37);
		getContentPane().add(lblNewLabel_7);

	}
}
