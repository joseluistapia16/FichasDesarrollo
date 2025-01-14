/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capacitacion.views;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jose Luis Tapia
 */
public class Ventana extends JDialog {

    public Ventana(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Login con Imagen de Fondo");
        setSize(600, 400); // Tamaño del JFrame
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear un JPanel con imagen de fondo
        JPanel panelConFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar y dibujar la imagen de fondo
                ImageIcon imagen = new ImageIcon("C:\\Fichas_Medicas\\img\\crear.jpeg");
                g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        panelConFondo.setLayout(null); // Layout nulo para posicionar componentes libremente

        // Crear componentes (labels, cajas de texto, botón)
        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setBounds(150, 100, 100, 30); // x, y, ancho, alto
        labelUsuario.setForeground(Color.WHITE);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(250, 100, 200, 30);

        JLabel labelPassword = new JLabel("Contraseña:");
        labelPassword.setBounds(150, 150, 100, 30);
        labelPassword.setForeground(Color.WHITE);

        JPasswordField campoPassword = new JPasswordField();
        campoPassword.setBounds(250, 150, 200, 30);

        JButton botonLogin = new JButton("Iniciar Sesión");
        botonLogin.setIcon(new javax.swing.ImageIcon("C:\\Fichas_Medicas\\img\\ic_grabar.png")); // NOI18N
        botonLogin.setBounds(250, 200, 150, 30);

        // Añadir evento al botón de Login
        botonLogin.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String password = new String(campoPassword.getPassword());

            // Validación básica (puedes reemplazarla con lógica real)
            if (usuario.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Cerrar la ventana de login
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Añadir componentes al panel
        panelConFondo.add(labelUsuario);
        panelConFondo.add(campoUsuario);
        panelConFondo.add(labelPassword);
        panelConFondo.add(campoPassword);
        panelConFondo.add(botonLogin);

        // Añadir el panel al JFrame
        add(panelConFondo);

        setVisible(true); // Hacer visible el JFrame
    }

    public static void main(String[] args) {
        new Ventana(new JFrame(), true);
    }
}
