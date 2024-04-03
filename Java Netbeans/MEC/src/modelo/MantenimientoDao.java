
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class MantenimientoDao {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarMantenimiento(Mantenimiento man) {
        
        String sql = "INSERT INTO mantenimiento(ninventario, idcliente, mantenimiento, descripcion, marca, modelo, serial, fechaentrada, fechasalida) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, man.getNinventario());
            ps.setInt(2, man.getIdcliente());
            ps.setString(3, man.getMantenimiento());
            ps.setString(4, man.getDescripcion());
            ps.setString(5, man.getMarca());
            ps.setString(6, man.getModelo());
            ps.setString(7, man.getSerial());
            ps.setString(8, man.getFechaentrada());
            ps.setString(9, man.getFechasalida());
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
    
    public List ListarMantenimiento() {
        
        List<Mantenimiento> ListaMan = new ArrayList();
        String sql = "SELECT * FROM mantenimiento";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Mantenimiento man = new Mantenimiento();
                man.setId(rs.getInt("id"));
                man.setNinventario(rs.getInt("ninventario"));
                man.setIdcliente(rs.getInt("idcliente"));
                man.setMantenimiento(rs.getString("mantenimiento"));
                man.setDescripcion(rs.getString("descripcion"));
                man.setMarca(rs.getString("marca"));
                man.setModelo(rs.getString("modelo"));
                man.setSerial(rs.getString("serial"));
                man.setFechaentrada(rs.getString("fechaentrada"));
                man.setFechasalida(rs.getString("fechasalida"));
                ListaMan.add(man);
                
            }
            
        } catch (SQLException e) {
            
            System.out.println(e.toString());
            
        }
        
        return ListaMan;
        
    }
    
    public boolean EliminarMantenimiento(int id) {
        
        String sql = "DELETE FROM mantenimiento WHERE id = ?";
        
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
    
    public boolean ModificarMantenimiento(Mantenimiento man) {
        
        String sql = "UPDATE mantenimiento SET ninventario=?, idcliente=?, mantenimiento=?, descripcion=?, marca=?, modelo=?, serial=?, fechaentrada=?, fechasalida=? WHERE id=?";
        
        try {
            
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, man.getNinventario());
            ps.setInt(2, man.getIdcliente());
            ps.setString(3, man.getMantenimiento());
            ps.setString(4, man.getDescripcion());
            ps.setString(5, man.getMarca());
            ps.setString(6, man.getModelo());
            ps.setString(7, man.getSerial());
            ps.setString(8, man.getFechaentrada());
            ps.setString(9, man.getFechasalida());
            ps.setInt(10, man.getId());
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
    
    public DefaultTableModel BuscarMantenimiento(String buscar) {

        int contador = 1;
        String[] nombresColumnas = {"ID", "N° INVENTARIO", "ID-CLIENTE", "MANTENIMIENTO", "DESCRIPCIÓN", "MARCA", "MODELO", "SERIAL", "FECHA-ENTRADA", "FECHA-SALIDA"};
        String[] registros = new String[10];

        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);

        String sql = "SELECT * FROM mantenimiento WHERE idcliente LIKE "+buscar+"";

        
        try {

            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                registros[0] = Integer.toString(contador);
                registros[1] = rs.getString("ninventario");
                registros[2] = rs.getString("idcliente");
                registros[3] = rs.getString("mantenimiento");
                registros[4] = rs.getString("descripcion");
                registros[5] = rs.getString("marca");
                registros[6] = rs.getString("modelo");
                registros[7] = rs.getString("serial");
                registros[8] = rs.getString("fechaentrada");
                registros[9] = rs.getString("fechasalida");

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
