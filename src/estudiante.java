public class estudiante {
    String nombre;
    String apellido;
    String cedula;
    Double nota_1;
    Double nota_2;
    Double promedio;

    public estudiante() {}

    public estudiante(String nombre, String apellido, String cedula, Double nota_1, Double nota_2, Double promedio)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.nota_1 = nota_1;
        this.nota_2 = nota_2;
        this.promedio = promedio;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getCedula() {return cedula;}

    public void setCedula(String cedula) {this.cedula = cedula;}

    public Double getNota_1() {return nota_1;}

    public void setNota_1(Double nota_1) {this.nota_1 = nota_1;}

    public Double getNota_2() {return nota_2;}

    public void setNota_2(Double nota_2) {this.nota_2 = nota_2;}

    public Double getPromedio() {return promedio;}

    public void setPromedio(Double promedio) {this.promedio = promedio;}


    public Double calcularPromedio()
    {
        promedio = Math.round(((nota_1 + nota_2) / 2) * 100.0) / 100.0;
        return promedio;
    }
}