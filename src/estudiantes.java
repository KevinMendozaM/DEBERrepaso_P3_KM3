import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class estudiantes {
    public JPanel mainPanel;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField cedula;
    private JTextField b1;
    private JTextField b2;
    public JButton registrar;
    public JButton buscar;


    public estudiantes() {
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreEstudiante = nombre.getText();
                String apellidoEstudiante = apellido.getText();
                String cedulaEstudiante = cedula.getText();
                String b1Estudiante = b1.getText();
                String b2Estudiante = b2.getText();

                // Validación de los campos
                if (nombreEstudiante.isEmpty() || apellidoEstudiante.isEmpty() ||
                        cedulaEstudiante.isEmpty() || b1Estudiante.isEmpty() || b2Estudiante.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                    return;
                }

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ESFOT1", "root", "");
                    String sql = "INSERT INTO estudiante1 (nombre, apellido, cedula, b1, b2) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, nombreEstudiante);
                    pstmt.setString(2, apellidoEstudiante);
                    pstmt.setString(3, cedulaEstudiante);
                    pstmt.setDouble(4, Double.parseDouble(b1Estudiante));
                    pstmt.setDouble(5, Double.parseDouble(b2Estudiante));
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente.");
                    conn.close();
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar estudiante: " + ex.getMessage());
                }
            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreEstudiante = nombre.getText();

                // Validación del campo
                if (nombreEstudiante.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del estudiante.");
                    return;
                }

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ESFOT1", "root", "");
                    String sql = "SELECT * FROM estudiante1 WHERE nombre = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, nombreEstudiante);
                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        String resultado = "Nombre: " + resultSet.getString("nombre") +
                                "\nApellido: " + resultSet.getString("apellido") +
                                "\nCédula: " + resultSet.getString("cedula") +
                                "\nNota 1: " + resultSet.getDouble("b1") +
                                "\nNota 2: " + resultSet.getDouble("b2");
                        JOptionPane.showMessageDialog(null, resultado);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un estudiante con el nombre " + nombreEstudiante);
                    }

                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al buscar estudiante: " + ex.getMessage());
                }
            }
        });
    }

}



