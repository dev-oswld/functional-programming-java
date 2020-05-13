package metodos_por_referencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Método estático");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().map(Main::toCube) //valor -> Main.toCube(valor)
                .forEach(valor -> System.out.print(valor + " "));

        System.out.println("\n\nMétodo por instancia");
        Calculadora objeto = new Calculadora();
        list.stream().map(objeto::toCube).forEach(System.out::println);

        System.out.println("\nMétodo de instancia de un objeto arbitrario");
        List<User> users = new ArrayList<>();
        users.add(new User("Rafael", 29));
        users.add(new User("Eduardo", 25));
        users.add(new User("Uriel", 20));
        users.add(new User("Luis", 15));
        users.add(new User("Marines", 10));
        users.stream().map(User::getUsername).forEach(System.out::println);

        System.out.println("\nConstructor por referencia");
        List<User> users_ref = new ArrayList<>();
        ItfUser iUser = User::new;
        User user1 = iUser.create("Carlos", 45);
        User user2 = iUser.create("Alejandro", 22);
        User user3 = iUser.create("Rodrigo", 38);
        users_ref.add(user1);
        users_ref.add(user2);
        users_ref.add(user3);
        users_ref.stream().map(User::getUsername).forEach(System.out::println);
    } //Main class

    //Referencia a método estático
    public static int toCube(int numero) {
        return numero * numero * numero;
    }
}
