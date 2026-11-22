public class SistemaCalificaciones {

    private ListaEnlazada calificaciones;

    public SistemaCalificaciones() {
        this.calificaciones = new ListaEnlazada();
    }

    // Guarda la calificacion que llega del estudiante ya ordenada
    public void agregarCalificacion(int nota) {
        calificaciones.insertarOrdenado(nota);
    }

    // 1. Ver la lista de calificaciones siempre ordenada de menor a mayor
    public String verLista() {
        return calificaciones.toString();
    }

    // 2. Consultar la calificacion en cualquier posicion (del 1 al total)
    public int consultarPosicion(int pos) {
        return calificaciones.obtenerNodo(pos).getDato();
    }

    // Como la lista ya esta ordenada, la minima siempre es la primera
    public int obtenerMinima() {
        return calificaciones.obtenerNodo(1).getDato();
    }

    // La maxima siempre es la ultima de la lista
    public int obtenerMaxima() {
        return calificaciones.obtenerNodo(calificaciones.getTamanio()).getDato();
    }

    // Calcula la mediana buscando el dato de en medio
    public double obtenerMediana() {
        int total = calificaciones.getTamanio();
        int mitad = total / 2;

        if (total % 2 != 0) {
            // Si son impares, regresamos el numero que queda justo en el centro
            return calificaciones.obtenerNodo(mitad + 1).getDato();
        } else {
            // Si son pares, sacamos el promedio de los dos numeros del centro
            int num1 = calificaciones.obtenerNodo(mitad).getDato();
            int num2 = calificaciones.obtenerNodo(mitad + 1).getDato();
            return (num1 + num2) / 2.0;
        }
    }

    // 3. Corregir calificaciones erroneas
    public void corregirCalificacion(int notaErronea, int notaNueva) {
        // Primero borramos la calificacion que estaba mal
        boolean seBorro = calificaciones.eliminarPorVair(notaErronea);

        // Si si existia, metemos la nueva para que se acomode en orden
        if (seBorro) {
            calificaciones.insertarOrdenado(notaNueva);
        }
    }

    // 4. Eliminar calificaciones invalidas
    public void eliminarCalificacion(int notaInvalida) {
        calificaciones.eliminarPorVair(notaInvalida);
    }

    // 5. Saber si alguien saco una calificacion especifica
    public boolean buscarCalificacion(int nota) {
        return calificaciones.buscar(nota);
    }

    // 6. Ver el total de estudiantes que ya entregaron
    public int totalEstudiantes() {
        return calificaciones.getTamanio();
    }
}
