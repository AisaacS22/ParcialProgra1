package isa.ejercicio;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    private static List<Employee> empList = Arrays.asList(arrayOfEmps);
    private static Integer[] empIds = {1, 2, 3};

    public static void main(String[] args) {
        // Creación de Java Stream
        // Obtener un stream de un arreglo existente
        System.out.println("Creando un stream a partir de un arreglo existente:");
        Stream.of(arrayOfEmps).forEach(System.out::println);

        // Obtener un stream de una lista existente
        System.out.println("\nCreando un stream a partir de una lista existente:");
        empList.stream().forEach(System.out::println);

        // Crear un stream a partir de objetos individuales
        System.out.println("\nCreando un stream a partir de objetos individuales:");
        Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]).forEach(System.out::println);

        // Crear un stream usando Stream.builder()
        System.out.println("\nCreando un stream usando Stream.builder():");
        Stream.Builder<Employee> empStreamBuilder = Stream.builder();
        empStreamBuilder.accept(arrayOfEmps[0]);
        empStreamBuilder.accept(arrayOfEmps[1]);
        empStreamBuilder.accept(arrayOfEmps[2]);
        Stream<Employee> empStream = empStreamBuilder.build();
        empStream.forEach(System.out::println);

        // forEach
        // Iterar sobre los elementos del stream y aplicar una función a cada elemento
        System.out.println("\nIncrementando el salario de cada empleado:");
        empList.stream().peek(e -> e.salaryIncrement(10.0)).forEach(System.out::println);

        // map
        // Aplicar una función a cada elemento del stream y obtener un nuevo stream
        System.out.println("\nObteniendo un nuevo stream al mapear los IDs de los empleados:");
        Stream.of(empIds).map(Employee::findById).forEach(System.out::println);

        // collect
        // Recolectar los elementos del stream en una lista
        System.out.println("\nRecolectando elementos del stream en una lista:");
        List<Employee> employees = empList.stream().collect(Collectors.toList());
        System.out.println(employees);

        // filter
        // Filtrar los elementos del stream según un predicado
        System.out.println("\nFiltrando empleados con salarios mayores a 200000:");
        List<Employee> highSalaryEmployees = empList.stream()
                .filter(e -> e.getSalary() > 200000)
                .collect(Collectors.toList());
        System.out.println(highSalaryEmployees);

        // findFirst
        // Obtener el primer elemento del stream que cumpla con un predicado
        System.out.println("\nEncontrando el primer empleado con salario mayor a 100000:");
        Employee employee = Stream.of(empIds)
                .map(Employee::findById)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);
        System.out.println(employee);

        // toArray
        // Convertir el stream en un arreglo
        System.out.println("\nConvirtiendo el stream en un arreglo:");
        Employee[] employeesArray = empList.stream().toArray(Employee[]::new);
        System.out.println(Arrays.toString(employeesArray));

        // flatMap
        // Convertir un stream de listas en un solo stream
        System.out.println("\nObteniendo un único stream de nombres de empleados:");
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(namesFlatStream);
    }
}
