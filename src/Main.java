import Models.Matematica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int num = 4;
        List<String> lista = new ArrayList<String>();
        List<Integer> listaInt = new ArrayList<Integer>();
        listaInt.add(1);
        listaInt.add(2);
        listaInt.add(3);
        lista.add("Hola");
        lista.add("Mundo");
        lista.add("Vamos!");
        lista.add("avion");
        lista.add("elote");
        lista.add("indio");
        lista.add("oso");
        lista.add("uva");

        Predicate<Integer> es_par = n -> n % 2 == 0;
        Function<Integer, Integer> duplicar = n -> n * 2;
        Consumer<String> mensaje = msg -> System.out.println(msg);
        Consumer<String> mensaje2 = System.out::println;

        Function<Integer, Integer> cuadrado = Matematica::cuadrado;

        System.out.println("(" + num + ") Es par?: " + es_par.test(num));
        System.out.printf("(" + num + ") Duplicado: " + duplicar.apply(num));

        /// CONSUMER PARA MOSTRAR UN MENSAJE CON UNA EXPRESION LAMBDA
        mensaje.accept("hola mundo!");
        /// CONSUMER PARA MOSTRAR UN MENSAJE CON REFERENCIA A UN METODO
        mensaje2.accept("Hola mundo 2!");

        /// PREDICATE PARA TENER UNA ENTRADA DE UN DATO Y UNA SALIDA
        System.out.println("(" + num + ") El cuadrado de num es: " + cuadrado.apply(num));

        /// STREAM + MAP PARA IMPRIMIR LISTA EN MAYUSCULAS
        System.out.println("\nSTREAM + MAP PARA IMPRIMIR LISTA EN MAYUSCULAS");
        lista.stream().map(String::toUpperCase).forEach(System.out::println);

        /// IMPRIMIR PALABRAS CON MÁS DE CUATRO LETRAS CON FILTER
        System.out.printf("\nIMPRIMIR PALABRAS CON MÁS DE CUATRO LETRAS CON FILTER\n");
        lista.stream()
                .map(String::toUpperCase)
                .filter(msj -> msj.length() > 4)
                .forEach(System.out::println);


        /// MAP Y REDUCE PARA SUMAR LOS CUADRADOS
        int nuevoNum = listaInt.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(nuevoNum);


        /// LISTA DE STRING A MAYUSCULAS Y FILTRAR LAS PALABRAS QUE COMIENZAN CON VOCAL

        System.out.printf("\nLISTA DE VOCALES:\n");
        lista.stream()
                .filter(palabra -> palabra.matches("(?i)[aeiou].*"))
                //(?i) -> ignora mayúsculas y minúsculas
                //[aeiou] -> Asegura que empiece con vocal
                //.* -> permite cualquier caracter luego de asegurarse que no comience con vocal
                .forEach(System.out::println);

        /// SIMULAR OPCIONAL VACIO Y PLANTEAR DOS MENSAJES

        Optional<String> opcional = Optional.empty();
        opcional.ifPresentOrElse(
                msg -> System.out.println("Mensaje: " + msg),
                () -> System.out.println("No hay mensaje.")
        );

        /// USAR

        Optional<String> palabraContar = Optional.of("hola");
        palabraContar.ifPresent(
                palabraContar.map(msg -> msg.length())
                        .orElse(() -> System.out.println("no hay mensaje"))


        );

    }
}