/*
 Copyright 2005-2007 Matthew J. Battey

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software distributed
	under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
	CONDITIONS OF ANY KIND, either express or implied. See the License for the
	specific language governing permissions and limitations under the License.

This software implements a Java application to manage a SAFMQ server.
		
Created on May 25, 2005
*/
package com.safmq.manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author matt
 */
public class NewUserDialog extends JDialog {
	boolean good = false;
	
	JTextField		login = new JTextField("",20);
	JTextField		description = new JTextField();
	JPasswordField	password = new 	JPasswordField();
	
	
	static Icon icon = null;
	
//	static {
//		try {
//			icon = new ImageIcon(NewUserDialog.class.getResource("images/user.gif"));
//		} catch (Exception e) {
//		}
//	}

	/**
	 * @throws java.awt.HeadlessException
	 */
	public NewUserDialog() throws HeadlessException {
		super(Manager.getInstance(), "Create a New User", true);
		
		JPanel contentPanel = new JPanel();
		
		this.setContentPane(contentPanel);
		
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		getContentPane().setLayout(g);
		
		Insets origInsets = c.insets;
		
		if (icon == null)
			icon = UIManager.getIcon("OptionPane.questionIcon");
		JLabel l = new JLabel(icon);
		c.insets = new Insets(5,5,5,40);
		c.anchor = GridBagConstraints.NORTHEAST;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0;
		c.weighty = 0;
		getContentPane().add(l,c);
		
		
		l = new JLabel(
			"<html>Please enter the name, description and password<br>" +			"for the new user.</html>");
		
		c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		c.weightx=1;
		c.weighty=1;
		getContentPane().add(l,c);
		
		l = new JLabel("Login:");
		c.insets = origInsets;
		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.weightx = 1;
		getContentPane().add(l,c);
		
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 0;
		getContentPane().add(login,c);

		Dimension d = login.getPreferredSize();

		l = new JLabel("Description:");
		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.weightx = 1;
		getContentPane().add(l,c);
		
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 0;
		getContentPane().add(description,c);
		description.setPreferredSize(d);		
	
		l = new JLabel("Password:");
		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.weightx = 1;
		getContentPane().add(l,c);
		
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 0;
		getContentPane().add(password,c);
		password.setPreferredSize(d);		
		
		
		JPanel p = new JPanel();
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		getContentPane().add(p,c);
		
		Action okAction;
		Action cancelAction;
		
		g = new GridBagLayout();
		p.setLayout(g);
		JButton ok = new JButton(okAction = new SimpleAction("OK",(Integer)null,true) {
			public void actionPerformed(ActionEvent e) {
				onOK();
			}
		});
		c.insets = new Insets(10,5,5,5);
		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.fill = GridBagConstraints.NONE;
		c.weightx=1;
		p.add(ok,c);
		
		JButton cancel = new JButton(cancelAction = new SimpleAction("Cancel",(Integer)null,true) {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.NONE;
		c.weightx=0;
		p.add(cancel,c);
		
		contentPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),okAction);
		contentPanel.getActionMap().put(okAction,okAction);
		
		contentPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0),cancelAction);
		contentPanel.getActionMap().put(cancelAction,cancelAction);
		
		pack();
		this.setResizable(false);
	}

	void onOK() {
		good = true;
		setVisible(false);
	}
	
	/**
	 * Incase called instead of "show()".
	 */
	public void setVisible(boolean show) {
		if (show) good = false; // reset good to false if showing the dialog
		super.setVisible(show);
	}
	
	public String getLogin() {
		return login.getText();
	}
	public String getDescription() {
		return description.getText();
	}
	public String getPassword() {
		return new String(password.getPassword());
	}
	/**
	 * @return
	 */
	public boolean isGood() {
		return good;
	}
}
