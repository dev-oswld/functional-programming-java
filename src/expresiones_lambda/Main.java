package expresiones_lambda;

public class Main {

    public static void main(String[] args) {

        ItfSaludar saludaruno = nombre -> System.out.println("Hola te saluda " + nombre);
        saludaruno.Saluda("Oswaldo");

        ItfSaludar saludardos = nombre -> {
            if (nombre.equals("Taco")) {
                System.out.println("Hola al parecer de gustan muchos los tacos al pastor");
            } else {
                System.out.println("Hola mi nombre es " + nombre);
            }
        };
        saludardos.Saluda("Taco");

        ItfSuma suma = (valor_uno, valor_dos) -> valor_uno + valor_dos;
        int resultado = suma.suma(5, 8);
        System.out.println("\nUsando la Interfaz Suma se tiene que es " + resultado);

        suma = (uno, dos) -> {
            int resultado_final = uno + dos;
            System.out.println("Usando un lambda el resultado es " + resultado_final);
            return resultado_final;
        };

        resultado = suma.suma(70, 80);
        System.out.println("Usando un objeto la suma es " + resultado);
    }
}