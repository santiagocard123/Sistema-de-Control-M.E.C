package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistarCliente(Cliente cl) {

        String sql = "INSERT INTO clientes (documento, nombre, apellidos, correo, telefono, empresa) VALUES (?,?,?,?,?,?)";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDocumento());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApellidos());
            ps.setString(4, cl.getCorreo());
            ps.setInt(5, cl.getTelefono());
            ps.setString(6, cl.getEmpresa());
            ps.execute();
            return true;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.toString());
            return false;

        } finally {

            try {

                con.close();

            } catch (SQLException e) {

                System.out.println(e.toString());

            }

        }

    }

    public List ListarCliente() {

        List<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT * FROM clientes";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setDocumento(rs.getInt("documento"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellidos(rs.getString("apellidos"));
                cl.setCorreo(rs.getString("correo"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setEmpresa(rs.getString("empresa"));
                ListaCl.add(cl);

            }

        } catch (SQLException e) {

            System.out.println(e.toString());

        }

        return ListaCl;

    }

    public boolean EliminarCliente(int id) {

        String sql = "DELETE FROM clientes WHERE id = ?";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;

        } catch (SQLException e) {

            System.out.println(e.toString());
            return false;
        } finally {

            try {

                con.close();

            } catch (SQLException ex) {

                System.out.println(ex.toString());

            }

        }

    }

    public boolean ModificarCliente(Cliente cl) {

        String sql = "UPDATE clientes SET documento=?, nombre=?, apellidos=?, correo=?, telefono=?, empresa=? WHERE id=?";

        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDocumento());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApellidos());
            ps.setString(4, cl.getCorreo());
            ps.setInt(5, cl.getTelefono());
            ps.setString(6, cl.getEmpresa());
            ps.setInt(7, cl.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {

            System.out.println(e.toString());
            return false;

        } finally {

            try {

                con.close();

            } catch (SQLException e) {

                System.out.println(e.toString());

            }

        }

    }

    public DefaultTableModel BuscarCliente(String buscar) {

        int contador = 1;
        String[] nombresColumnas = {"ID", "DOCUMENTO", "NOMBRES", "APELLIDOS", "CORREO", "TELÉFONO", "EMPRESA"};
        String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT * FROM clientes WHERE documento LIKE "+buscar+"";

        
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = Integer.toString(contador);
                registros[1] = rs.getString("documento");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("apellidos");
                registros[4] = rs.getString("correo");
                registros[5] = rs.getString("telefono");
                registros[6] = rs.getString("empresa");

                modelo.addRow(registros);

                contador++;
                

            }

        } catch (SQLException e) {

            System.out.println(e.toString());
            

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {

                System.out.println(e.toString());

            }

        }
        return modelo;
    }

}
