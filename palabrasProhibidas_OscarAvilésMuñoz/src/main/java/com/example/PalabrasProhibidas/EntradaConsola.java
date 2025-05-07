package com.example.PalabrasProhibidas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

/**
 * Componente que se ejecuta al iniciar la aplicación.
 * Permite al usuario ingresar mensajes desde la consola para ser filtrados.
 */
@Component
public class EntradaConsola implements CommandLineRunner {

    private final ServicioFiltro serviciofiltro;

    /**
     * Constructor que recibe el servicio de filtrado como dependencia.
     *
     * @param filtroServicio instancia del servicio de filtrado.
     */
    public EntradaConsola(ServicioFiltro serviciofiltro) {
        this.serviciofiltro = serviciofiltro;
    }

    /**
     * Se ejecuta automáticamente al iniciar la aplicación.
     * Lee mensajes desde la consola y los filtra utilizando el servicio.
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al filtro de mensajes. Escribe un mensaje (escribe 'salir' para terminar):");

        while (true) {
            System.out.print("> ");
            String mensaje = scanner.nextLine();
            if ("salir".equalsIgnoreCase(mensaje)) break;

            String resultado = serviciofiltro.procesarMensaje(mensaje);
            System.out.println("Mensaje filtrado: " + resultado + "\n");
        }

        System.out.println("¡Gracias por usar el sistema!");
    }
}