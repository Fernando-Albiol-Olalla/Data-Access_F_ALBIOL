import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;





public class Ejercicio_1 {

    private static final String FECHA_NACIMIENTO_NO_VALIDA = "Fecha de nacimiento no válida";
    private static final String TELEFONO_NO_VALIDO = "Teléfono no válido";
    private static final String SUELDO_NO_VALIDO = "Sueldo no válido";

    static class Persona {
        private String _nombre;
        private LocalDate _fechaNacimiento;

        public String getNombre() {
            return _nombre;
        }

        public void setNombre(String nombre) {
            this._nombre = nombre;
        }

        public LocalDate getFechaNacimiento() {
            return _fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            if (fechaNacimiento.isAfter(LocalDate.now()))
                throw new IllegalArgumentException(FECHA_NACIMIENTO_NO_VALIDA);
            this._fechaNacimiento = fechaNacimiento;
        }

        public int getEdad() {
            return Period.between(_fechaNacimiento, LocalDate.now()).getYears();
        }
    }

    static class Cliente extends Persona {
        private String _telefono;
        private Set<Empresa> _esClienteDe = new HashSet<>();

        public String getTelefono() {
            return _telefono;
        }

        public void setTelefono(String telefono) {
            String patronTelefono = "^((|00)\\d{2,3})?\\d{9}$";
            if (Pattern.matches(patronTelefono, telefono))
                this._telefono = telefono;
            else
                throw new IllegalArgumentException(TELEFONO_NO_VALIDO);
        }
    }

    static class Empleado extends Persona {
        private double _sueldoBruto;

        public double getSueldoBruto() {
            return _sueldoBruto;
        }

        public void setSueldoBruto(double sueldoBruto) {
            if (sueldoBruto < 0)
                throw new IllegalArgumentException(SUELDO_NO_VALIDO);
            this._sueldoBruto = sueldoBruto;
        }
    }

    static class Directivo extends Empleado {
        private String _categoria;
        private Set<Empleado> _supervisa = new HashSet<>();

        public String getCategoria() {
            return _categoria;
        }

        public void setCategoria(String categoria) {
            this._categoria = categoria;
        }

        public int getSubordinados() {
            return _supervisa.size();
        }
    }

    static class Empresa {
        private String _nombre;
        private Set<Empleado> _plantilla = new HashSet<>();
        private Set<Cliente> _carteraDeClientes = new HashSet<>();

        public String getNombre() {
            return _nombre;
        }

        public void setNombre(String nombre) {
            this._nombre = nombre;
        }

        public int getClientesTotales() {
            return _carteraDeClientes.size();
        }

        public int getEmpleadosTotales() {
            return _plantilla.size();
        }
    }
}
