package com.bicentenario.hospital.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bicentenario.hospital.view.PacienteForm;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalForm frame = new PrincipalForm();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane escritorio = new JDesktopPane();
		escritorio.setBounds(0, 33, 1280, 708);
		contentPane.add(escritorio);
		
		JMenuBar menuPrincipal = new JMenuBar();
		menuPrincipal.setBounds(0, 0, 1280, 32);
		contentPane.add(menuPrincipal);
		
		JMenu mnNewMenu = new JMenu("    Principal      ");
		menuPrincipal.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("          Mantenimento       ");
		menuPrincipal.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("    Pacientes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteForm pacienteVentana=new PacienteForm();
				escritorio.add(pacienteVentana);

				//nuevaVentana.setRelativeLocation();
				//nuevaVentana.setVisible(true);
				/*int width=escritorio.getWidth();
				int heigth=escritorio.getHeight();
				nuevaVentana.setSize(width,heigth);
				nuevaVentana.setLocation(null);*/
				
				Dimension desktopSize = escritorio.getSize();
		        Dimension FrameSize = pacienteVentana.getSize();
		        //nuevaVentana.setMaximizable(true);
		        //nuevaVentana.setma;
		        pacienteVentana.setLocation((desktopSize.width - FrameSize.width)/20, (desktopSize.height- FrameSize.height)/15);
		        pacienteVentana.show();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("    Medicos");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("    Enfermedades");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("    Medicamentos");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("    Casos");
		mnNewMenu_1.add(mntmNewMenuItem_4);
	}
}
