
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingresa el valor del lado a:  ");
        Double a = scan.nextDouble();

        System.out.println("Ingresa el valor del lado b: ");
        Double b = scan.nextDouble();

        System.out.println("Ingresa el valor del lado c: ");
        Double c = scan.nextDouble();

        Triangulos triangulo = new Triangulos(a, b, c);
        String tipoTriangulo;

        // Calcular los tipos de triangulos
        if (triangulo.getA() == triangulo.getB() && triangulo.getB() == triangulo.getC()) {
            tipoTriangulo = "Equilatero";
            System.out.println("es un triangulo equilatero");
        } else if (triangulo.getA() == triangulo.getB() || triangulo.getA() == triangulo.getC() || triangulo.getB() == triangulo.getC()) {
            tipoTriangulo = "Isosceles";
            System.out.println("Es un triangulo Isosceles");
        } else {
            tipoTriangulo = "Escaleno";
            System.out.println("Es un triangulo Escaleno");
        }

        //calcular angulos, Usando ley Coseno
        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double cosB = (a * a + c * c - b * b) / (2 * a * c);
        double cosC = (a * a + b * b - c * c) / (2 * a * b);

        // Calcular los ángulos en radianes y luego convertir a grados
        double anguloA = Math.toDegrees(Math.acos(cosA));
        double anguloB = Math.toDegrees(Math.acos(cosB));
        double anguloC = Math.toDegrees(Math.acos(cosC));

        //calcular area de triangulo
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.printf("Área del triángulo: %.2f%n", area);

        switch (tipoTriangulo) {
            case "Equilatero":
                //Triangulo equilatero
                System.out.printf("Ángulos: A=%.2f°, B=%.2f°, C=%.2f°%n", anguloA, anguloB, anguloC);
                System.out.printf("Área del triángulo: %.2f%n", area);
                break;
            case "Isosceles":
                //Triangulo Isosceles
                System.out.printf("Ángulos: A=%.2f°, B=%.2f°, C=%.2f°%n", anguloA, anguloB, anguloC);
                System.out.printf("Área del triángulo: %.2f%n", area);
                break;
            //Triangulo escaleno
            case "Escaleno":
                System.out.printf("Ángulos: A=%.2f°, B=%.2f°, C=%.2f°%n", anguloA, anguloB, anguloC);
                System.out.printf("Área del triángulo: %.2f%n", area);
                break;
            default:
                System.out.println("Triangulo desconocido");
        }

    }

}
