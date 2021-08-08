package com.bicentenario.hospital.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class EnfermedadForm extends JInternalFrame {

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

	/**
	 * Create the frame.
	 */
	public EnfermedadForm() {
		setBounds(100, 100, 450, 300);

	}

}
