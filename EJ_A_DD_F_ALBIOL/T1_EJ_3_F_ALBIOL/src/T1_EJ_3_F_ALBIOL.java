import java.util.*;

public class T1_EJ_3_F_ALBIOL {

    private static final String TIPO_NO_VALIDO = "Tipo de pintura no valido.";
    private static final String MATERIAL_INCORRECTO = "Material incorrecto.";
    private static final String ESTILO_NO_VALIDO = "Estilo no valido.";

    static class Autor {

        private String  Nombre;
        private String  Nacionalidad;

        public String getNombre() { return Nombre; }
        public void setNombre (String Nombre) { this.Nombre = nombre; }

        public String getNacionalidad() { return Nacionalidad; }
        public void setNacionalidad (String Nacionalidad) { this.Nacionalidad = nacionalidad; }
    }

    static class Obra extends Autor {

        private String  Titulo;
        private Set<Autor> _NomAutor = new HashSet<>();

        public String getTitulo() { return Titulo; }
        public void setTitulo (String Titulo) { this.Titulo = titulo; }
    }

    static class Pintura extends Obra {

        private String Formato;
        private String Tipo;
        private Set<Obra> _TitulObra = new HashSet<>();

        public String getFormato() { return Formato; }
        public void setFormato (String Formato) { this.Formato = formato; }

        public String getTipo() { return Tipo; }
        public void setTipo(String tipo) {
            if (tipo == Oleo)
                this.Tipo = Oleo;
            else if (tipo == Pastel)
                this.Tipo = Pastel;
            else if (tipo == Acuarela)
                this.Tipo = Acuarela;
            else
                throw new IllegalArgumentException(TIPO_NO_VALIDO);
        }
    }

    static class Escultura extends Obra {

        private String Material;
        private String Estilo;
        private Set<Obra> _TitulObra = new HashSet<>();

        public String getMaterial() { return Material; }
        public void setMaterial(String material) {
            if (material == Bronce)
                this.Material = Bronce;
            else if (material == Hierro)
                this.Material = Hierro;
            else if (material == Marmol)
                this.Material = Marmol;
            else
                try {
                    throw new IllegalAccessException(MATERIAL_INCORRECTO);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
        }

        public String getEstilo() { return Estilo; }
        public void setEstilo(String estilo) {
            if (estilo == Neoclasico)
                this.Estilo = Neoclasico;
            else if (estilo == Grecorromano)
                this.Estilo = Grecorromano;
            else if (estilo == Cubista)
                this.Estilo = Cubista;
            else
                try {
                    throw new IllegalAccessException(ESTILO_NO_VALIDO);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    static class Museo extends Obra {

        private String Nombre;
        private String Direccion;
        private String Ciudad;
        private String Pais;
        private Set<Obra> _TitulObra = new HashSet<>();

        public String getNombre() { return Nombre; }
        public void setNombre (String Nombre) { this.Nombre = nombre; }

        public String getDireccion() { return Direccion; }
        public void setDireccion (String Direccion) { this.Direccion = direccion; }

        public String getCiudad() { return Ciudad; }
        public void setCiudad (String Ciudad) { this.Ciudad = ciudad; }

        public String getPais() { return Pais; }
        public void setPais (String Pais) { this.Pais = pais; }
    }
}
