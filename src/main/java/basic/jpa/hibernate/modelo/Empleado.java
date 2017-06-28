package basic.jpa.hibernate.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fredwinrosales <fredwinrosales@gmail.com>
 */
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "cod_empleado")
    private Long codigo;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "fecha_nac")
    private Date fechaNacimiento;
    
    public Empleado(){
        
    }

    public Empleado(Long codigo, String apellidos, String nombres, Date fechaNacimiento) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", apellidos=" + apellidos + ", nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
}
