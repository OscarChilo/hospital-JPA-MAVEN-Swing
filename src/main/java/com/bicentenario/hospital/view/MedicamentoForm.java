package com.bicentenario.hospital.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class MedicamentoForm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MedicamentoForm() {
		setBounds(100, 100, 450, 300);

	}

}
