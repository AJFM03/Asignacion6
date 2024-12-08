import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Asignacion_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> resultados = new ArrayList<>();

        System.out.println("Bienvenido a la calculadora de áreas y perímetros.");

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\nFiguras disponibles:");
                System.out.println("1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");
                System.out.println("6. Salir");

                System.out.print("\nSeleccione una figura (1-6): ");
                int figura = scanner.nextInt();

                if (figura == 6) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                System.out.println("\nOperaciones disponibles:");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");

                System.out.print("\nSeleccione una operación (1-2): ");
                int operacion = scanner.nextInt();

                double resultado = 0;

                switch (figura) {
                    case 1: // Círculo
                        System.out.print("Ingrese el radio del círculo: ");
                        double radio = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = Math.PI * radio * radio; // Área
                        } else if (operacion == 2) {
                            resultado = 2 * Math.PI * radio; // Perímetro
                        }
                        break;

                    case 2: // Cuadrado
                        System.out.print("Ingrese el lado del cuadrado: ");
                        double ladoCuadrado = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = ladoCuadrado * ladoCuadrado; // Área
                        } else if (operacion == 2) {
                            resultado = 4 * ladoCuadrado; // Perímetro
                        }
                        break;

                    case 3: // Triángulo
                        System.out.print("Ingrese la base del triángulo: ");
                        double base = scanner.nextDouble();
                        System.out.print("Ingrese la altura del triángulo: ");
                        double altura = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = (base * altura) / 2; // Área
                        } else if (operacion == 2) {
                            System.out.print("Ingrese los otros dos lados del triángulo (lado 1): ");
                            double lado1 = scanner.nextDouble();
                            System.out.print("Ingrese el lado 2 del triángulo: ");
                            double lado2 = scanner.nextDouble();
                            resultado = base + lado1 + lado2; // Perímetro
                        }
                        break;

                    case 4: // Rectángulo
                        System.out.print("Ingrese el largo del rectángulo: ");
                        double largo = scanner.nextDouble();
                        System.out.print("Ingrese el ancho del rectángulo: ");
                        double ancho = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = largo * ancho; // Área
                        } else if (operacion == 2) {
                            resultado = 2 * (largo + ancho); // Perímetro
                        }
                        break;

                    case 5: // Pentágono
                        System.out.print("Ingrese el lado del pentágono: ");
                        double ladoPentagono = scanner.nextDouble();
                        if (operacion == 1) {
                            System.out.print("Ingrese el apotema del pentágono: ");
                            double apotema = scanner.nextDouble();
                            resultado = (5 * ladoPentagono * apotema) / 2; // Área
                        } else if (operacion == 2) {
                            resultado = 5 * ladoPentagono; // Perímetro
                        }
                        break;

                    default:
                        System.out.println("Figura no válida.");
                        continue;
                }

                // Almacenar el resultado
                resultados.add(resultado);

                // Mostrar el resultado
                String operacionNombre = operacion == 1 ? "Área" : "Perímetro";
                System.out.printf("\nEl %s de la figura seleccionada es: %.2f\n", operacionNombre, resultado);

            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Intente nuevamente.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }

        // Mostrar todos los resultados acumulados
        System.out.println("\nResultados acumulados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Operación %d: %.2f\n", i + 1, resultados.get(i));
        }

        scanner.close();
    }
}
