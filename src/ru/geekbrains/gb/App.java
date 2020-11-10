package ru.geekbrains.gb;

public class App {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Котопес", "Уборщик", "ololo@mail.ru", "2-12-85-666", 50000, 10);
        employees[1] = new Employee("Симпсон Гомер Игоревич", "Физик-ядерщик", "ololo@mail.ru", "2-12-85-656", 100000, 45);
        employees[2] = new Employee("Паркер Петр Сергеевич", "Фотограф","ololo@mail.ru", "2-12-85-657", 300000, 30);
        employees[3] = new Employee("Крокодил Генадий Крокодилович", "Инженер","ololo@mail.ru", "2-12-85-556", 300000, 50);
        employees[4] = new Employee("Скайуокер Энекен Витальевич", "Сисадмин","ololo@mail.ru", "2-15-85-656", 200000, 20);

        for (Employee employee : employees) {
            if (employee.age >= 40) {
                employee.displayInformation();
            }
        }

    }
}
