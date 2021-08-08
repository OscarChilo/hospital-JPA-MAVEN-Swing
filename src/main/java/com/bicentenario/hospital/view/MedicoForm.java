package com.bicentenario.hospital.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class MedicoForm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MedicoForm() {
		setBounds(100, 100, 450, 300);

	}

}
