package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class EmpleadosDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarEmpleados(Empleados em) {
        
        String sql = "INSERT INTO empleados(documento, nombre, apellidos, correo, telefono, cargo) VALUES (?,?,?,?,?,?)";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getDocumento());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getApellidos());
            ps.setString(4, em.getCorreo());
            ps.setInt(5, em.getTelefono());
            ps.setString(6, em.getCargo());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            return false;
            
        }
        
        finally {
            
            try {
                
                con.close();
                
            } catch (SQLException e) {
                
                System.out.println(e.toString());
                
            }
            
        }
        
    }
    
    public List ListarEmpleados() {
        
        List<Empleados> ListaEm = new ArrayList();
        String sql = "SELECT * FROM empleados";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Empleados em = new Empleados();
                em.setId(rs.getInt("id"));
                em.setDocumento(rs.getInt("documento"));
                em.setNombre(rs.getString("nombre"));
                em.setApellidos(rs.getString("apellidos"));
                em.setCorreo(rs.getString("correo"));
                em.setTelefono(rs.getInt("telefono"));
                em.setCargo(rs.getString("cargo"));
                ListaEm.add(em);
                
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            
        }
        
        return ListaEm;
        
    }
    
    public boolean EliminarEmpleados(int id) {
        
        String sql = "DELETE FROM empleados WHERE id = ?";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            return false;
        }
        
        finally {
            
            try {
                
                con.close();
                
            } catch (SQLException ex) {
                
                System.out.println(ex.toString());
                
            }
            
        }
        
    }
    
    public boolean ModificarEmpleados(Empleados em) {
        
        String sql = "UPDATE empleados SET documento=?, nombre=?, apellidos=?, correo=?, telefono=?, cargo=? WHERE id=?";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getDocumento());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getApellidos());
            ps.setString(4, em.getCorreo());
            ps.setInt(5, em.getTelefono());
            ps.setString(6, em.getCargo());
            ps.setInt(7, em.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            return false;
            
        }
        
        finally {
            
            try {
                
                con.close();
                
            } catch (SQLException e) {
                
                System.out.println(e.toString());
                
            }
            
        }
        
    }
    
    public DefaultTableModel BuscarEmpleados(String buscar) {

        int contador = 1;
        String[] nombresColumnas = {"ID", "DOCUMENTO", "NOMBRES", "APELLIDOS", "CORREO", "TELÉFONO", "CARGO"};
        String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT * FROM empleados WHERE documento LIKE "+buscar+"";

        
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
                registros[6] = rs.getString("cargo");

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
