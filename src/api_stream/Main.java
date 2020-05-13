package api_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Rafael", 25));
        users.add(new User("Daniel", 20));
        users.add(new User("Tania", 15));
        users.add(new User("Luisa", 24));
        users.add(new User("Raul", 21));

        long cantidad_lista = users.stream().count();
        System.out.println("Numero de usuarios " + cantidad_lista);

        cantidad_lista = users.stream().filter(user -> user.getAge() > 18)
                .filter(user -> user.getUsername().startsWith("R")).count();
        System.out.println("Con filtrado más robusto " + cantidad_lista);

        /*
         System.out.println("\nFormas de crear streams");
         List<User> users_abs = new ArrayList<>(); //Por colección
         Stream<User> stream = users_abs.stream(); //Esto es una abstracción
         Stream<User> filter = stream.filter(user -> user.getAge() > 18); //Stream
         int numbers[] = {1, 2, 3, 4}; //Arreglo
         Stream numbers_steam = Stream.of(numbers);
         Stream names = Stream.of("Texto 1", "Texto 2", "Texto 3"); //Secuencia
        */
        
        System.out.println("\nTipos de métodos en Stream");
        List<User> newUsers = users.stream().filter(user -> user.getAge() > 18)
                .collect(Collectors.toList());
        System.out.println("De la lista anterior " + newUsers);

        List<Integer> numeritos = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultadito = numeritos.stream().map(num -> num * num)
                .collect(Collectors.toList());
        System.out.println("Usando el método map " + resultadito);

        List<String> names1 = Arrays.asList("Codi 1", "Codi 2");
        List<String> names2 = Arrays.asList("Codi 3", "Codi 4");
        List<String> names3 = Arrays.asList("Codi 5", "Codi 6");
        List<String> output = Stream.of(names1, names2, names3)
                .flatMap(elemento -> elemento.stream())
                .collect(Collectors.toList());
        System.out.println("Usando el método flatmap " + output);

        System.out.println("\nEncontrando los elementos");
        List<Integer> calificaciones = Arrays.asList(10, 10, 9, 5, 6, 7, 8, 9, 10);
        boolean resultado = calificaciones.stream()
                .anyMatch(calificacion -> calificacion < 6);
        System.out.println("¿Usted reprobo? " + resultado);

        System.out.println("\nEncontrar otros elementos");
        User userDefault = new User("Sin nombre", 30);
        User user = users.stream()
                .filter(u -> u.getAge() == 30)
                .findFirst().orElse(userDefault);
        System.out.println(user.getUsername());

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Long cantidad = numeros.stream().filter(n -> n > 6).count();
        System.out.println("\nUsando a filter la cantidad es " + cantidad);

        int suma = numeros.stream().mapToInt(n -> n).sum();
        System.out.println("Usando el método maptoint la suma es " + suma);

        double average = numeros.stream().mapToInt(n -> n).average().orElse(0);
        System.out.println("Usando el método average el promedio final es " + average);

        int minimo = numeros.stream().mapToInt(n -> n).min().getAsInt();
        System.out.println("Usando el método min el menor es " + minimo);

        int maximo = numeros.stream().mapToInt(n -> n).max().getAsInt();
        System.out.println("Usando el método max el mayor es " + maximo);

        System.out.println("\nReducción de elementos");
        int reduc = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, (acumulador, elemento) -> acumulador + elemento);
        System.out.println("Usando el método reduce " + reduc);

        String cadena = Stream.of("Java", "C", "Python", "Ruby")
                .reduce("", (acumulador, lenguaje) -> acumulador + "|" + lenguaje)
                .replaceFirst("\\|", "") //Pipelines con regex
                .replaceAll("\\s", "");
        System.out.println("\nUtilizando regex para un string " + cadena);

        System.out.println("\nBuscando en una lista");
        List<Integer> desorden = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        List<Integer> ordenado = desorden.stream()
                .sorted(Comparator.reverseOrder())
                .limit(5).skip(2)
                .collect(Collectors.toList());
        System.out.println("Limitado a tres elementos " + ordenado);
    }
}