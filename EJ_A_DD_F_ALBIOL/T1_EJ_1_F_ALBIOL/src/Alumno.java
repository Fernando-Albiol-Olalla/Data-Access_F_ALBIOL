import java.util.ArrayList;


public class Alumno {
    private String nombre;
    private int nota;

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public final int getNota() {
        return nota;
    }

    public final void setNota(int nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
        }
    }

    public final boolean getAprobado() {
        if (nota >= 5)
            return true;
        else
            return false;
    }
}

class Alumnos {
    private final ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public final void agregar(Alumno alu) {
        listaAlumnos.add(alu);
    }

    public final Alumno obtener(int num) {
        if (num >= 0 && num < listaAlumnos.size()) {
            return listaAlumnos.get(num);
        }
        return null;
    }

    public final float getMedia() {
        if (listaAlumnos.isEmpty()) {
            return 0;
        } else {
            float media = 0;
            for (Alumno alumno : listaAlumnos) {
                media += alumno.getNota();
            }
            return media / listaAlumnos.size();
        }
    }
}
