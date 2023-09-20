import java.util.ArrayList;
import java.util.Scanner;

public class calcunotas2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita el nombre del estudiante
        System.out.println("¿Cuál es tu nombre?");
        String nombreEstudiante = scanner.nextLine();

        // Pregunta cuántas materias desea promediar
        System.out.println("¿Cuántas materias deseas promediar?");
        int numMaterias = Integer.parseInt(scanner.nextLine());

        double promedioTotal = 0; // Almacena el promedio total de todas las materias

        // Bucle para ingresar las notas y porcentajes de cada materia
        for (int materia = 1; materia <= numMaterias; materia++) {
            System.out.println("Ingresa el nombre de la materia " + materia + ":");
            String nombreMateria = scanner.nextLine();

            // Pregunta cuántas notas se desean ingresar para esta materia
            System.out.println("¿Cuántas notas tienes para " + nombreMateria + "?");
            int numNotas = Integer.parseInt(scanner.nextLine());

            ArrayList<Double> notas = new ArrayList<>();
            ArrayList<Integer> porcentajes = new ArrayList<>();

            // Captura las notas y porcentajes para esta materia
            for (int i = 0; i < numNotas; i++) {
                System.out.println("Ingresa la nota " + (i + 1) + " para " + nombreMateria + ":");
                double nota = Double.parseDouble(scanner.nextLine());
                notas.add(nota);

                System.out.println(
                        "Ingresa el porcentaje de la nota " + (i + 1) + " para " + nombreMateria + " (de 0 a 100):");
                int porcentaje = Integer.parseInt(scanner.nextLine());
                porcentajes.add(porcentaje);
            }

            // Calcula el promedio para esta materia
            double notasPromedio = calcularNotasPromedio(notas, porcentajes);
            System.out.println(nombreMateria + ": " + notasPromedio);

            // Agrega el promedio de esta materia al promedio total
            promedioTotal += notasPromedio;
        }

        // Calcula el promedio total y lo muestra
        double notaFinal = promedioTotal / numMaterias;
        System.out.println("El promedio del semestre para " + nombreEstudiante + " es: " + notaFinal);

        // Cierra el scanner
        scanner.close();
    }

    public static double calcularNotasPromedio(ArrayList<Double> notas, ArrayList<Integer> porcentajes) {
        double suma = 0;
        int sumaPorcentajes = 0;

        for (int i = 0; i < notas.size(); i++) {
            sumaPorcentajes += porcentajes.get(i);
        }

        if (sumaPorcentajes != 100) {
            return -1; // Error: La suma de los porcentajes es incorrecta
        }

        for (int i = 0; i < notas.size(); i++) {
            suma += (notas.get(i) * porcentajes.get(i) / 100.0);
        }

        return suma;
    }
}
