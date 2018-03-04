package com.mls.encoder.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.PostConstruct;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.mls.encoder.util.EncoderDecoderHelper;

@Component
public class EncoderUI {

	private static final String SYSTEM_PROPERTY_JAVA_AWT_HEADLESS = "java.awt.headless";
	private JFrame frame;
	private JPanel buttonPanel;
	private JPanel fieldsPanel;
	private JLabel inputString;
	private JLabel inputOffset;
	private JLabel output;
	private JTextField inputField;
	private JTextField inputOffsetField;
	private JTextField outputField;
	private JButton encrypt;

	@PostConstruct
	public void init() {
		System.setProperty(SYSTEM_PROPERTY_JAVA_AWT_HEADLESS, Boolean.FALSE.toString());
		this.createUI();
	}

	public void createUI() {
		this.frame = new JFrame("Encode Decode");
		this.frame.setSize(500, 200);
		this.buttonPanel = new JPanel();
		this.fieldsPanel = new JPanel();
		this.inputString = new JLabel("Input String");
		this.inputOffset = new JLabel("Input Offset");
		this.output = new JLabel("Encoded String");
		this.inputField = new JTextField("");
		this.inputOffsetField = new JFormattedTextField("");
		this.outputField = new JTextField("");
		this.encrypt = new JButton("Encrypt");

		this.encrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String run = EncoderDecoderHelper.encrypt(EncoderUI.this.inputField.getText(),
						EncoderUI.this.inputOffsetField.getText());
				EncoderUI.this.outputField.setText(run);
			}
		});

		this.fieldsPanel.setLayout(new BoxLayout(this.fieldsPanel, 3));
		this.buttonPanel.setLayout(new FlowLayout());
		this.fieldsPanel.add(this.inputString);
		this.fieldsPanel.add(this.inputField);
		this.fieldsPanel.add(this.inputOffset);
		this.fieldsPanel.add(this.inputOffsetField);
		this.fieldsPanel.add(this.output);
		this.fieldsPanel.add(this.outputField);
		this.buttonPanel.add(this.encrypt);
		this.frame.add(this.fieldsPanel, "First");
		this.frame.add(this.buttonPanel, "Last");
		this.frame.setDefaultCloseOperation(3);

		this.frame.setVisible(true);
	}
}
