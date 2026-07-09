package mx.edu.itvo.biblioteca;

import mx.edu.itvo.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

    @Autowired
    private LibroRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("-------------------------------------");
        System.out.println("PRÁCTICA 3");
        System.out.println("-------------------------------------");

        System.out.println("Conectado correctamente a MariaDB");

        System.out.println("Número de libros registrados: "
                + repository.count());

        System.out.println("-------------------------------------");

    }

}