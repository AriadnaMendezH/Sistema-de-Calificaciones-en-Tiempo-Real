public class Main {

    public static void main(String[] args) {
        SistemaCalificaciones sistema = new SistemaCalificaciones();

        // Arreglo con las calificaciones que van llegando
        int[] calificaciones = {78, 92, 55, 110, 80};

        for (int i = 0; i < calificaciones.length; i++) {
            sistema.agregarCalificacion(calificaciones[i]);
        }

        // 1. Ver lista ordenada
        System.out.println("Lista ordenada: " + sistema.verLista());

        // 2. Consultar minima, maxima, mediana y posicion 2
        System.out.println("Minima: " + sistema.obtenerMinima());
        System.out.println("Maxima: " + sistema.obtenerMaxima());
        System.out.println("Mediana: " + sistema.obtenerMediana());
        System.out.println("Posicion 2: " + sistema.consultarPosicion(2));

        // 3. Corregir una calificacion (cambiar 55 por 68)
        sistema.corregirCalificacion(55, 68);
        System.out.println("Lista corregida: " + sistema.verLista());

        // 4. Eliminar calificacion invalida (110)
        sistema.eliminarCalificacion(110);
        System.out.println("Sin la invalida: " + sistema.verLista());

        // 5. Saber si alguien saco una calificacion
        System.out.println("Alguien saco 80?: " + sistema.buscarCalificacion(80));
        System.out.println("Alguien saco 100?: " + sistema.buscarCalificacion(100));

        // 6. Total de estudiantes
        System.out.println("Total de entregas: " + sistema.totalEstudiantes());
    }
}
