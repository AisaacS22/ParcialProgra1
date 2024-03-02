package isa.ejercicio;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void salaryIncrement(double amount) {
        this.salary += amount;
    }

    public static Employee findById(int id) {
        // Aquí podrías implementar la lógica para buscar un empleado por su ID en una base de datos o lista de empleados
        return null; // Por simplicidad, devolvemos null en este ejemplo
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
