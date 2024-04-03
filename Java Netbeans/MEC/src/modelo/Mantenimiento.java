package modelo;

public class Mantenimiento {
    
    private int id;
    private int ninventario;
    private int idcliente;
    private String mantenimiento;
    private String descripcion;
    private String marca;
    private String modelo;
    private String serial;
    private String fechaentrada;
    private String fechasalida;

    public Mantenimiento() {
    }

    public Mantenimiento(int id, int ninventario, int idcliente, String mantenimiento, String descripcion, String marca, String modelo, String serial, String fechaentrada, String fechasalida) {
        this.id = id;
        this.ninventario = ninventario;
        this.idcliente = idcliente;
        this.mantenimiento = mantenimiento;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.serial = serial;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNinventario() {
        return ninventario;
    }

    public void setNinventario(int ninventario) {
        this.ninventario = ninventario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(String mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(String fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }
    
    
    
}