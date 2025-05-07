package com.example.PalabrasProhibidas;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

/**
 * Servicio encargado de procesar mensajes para detectar y reemplazar
 * palabras prohibidas por símbolos. Si hay más de 3, lanza una advertencia.
 */
@Service
public class ServicioFiltro {

    /**
     * Lista de palabras consideradas prohibidas.
     */
    private final List<String> palabrasProhibidas = Arrays.asList("tonto", "feo", "malo", "lento", "gay", "idiota", "estúpido", "Elle");

    /**
     * Procesa un mensaje de texto y reemplaza palabras prohibidas por símbolos.
     *
     * @param mensaje el mensaje ingresado por el usuario.
     * @return el mensaje filtrado o una advertencia si contiene más de 3 palabras prohibidas.
     */
    public String procesarMensaje(String mensaje) {
        int contador = 0;
        String[] palabras = mensaje.split("\\s+");
        StringBuilder mensajeFiltrado = new StringBuilder();

        for (String palabra : palabras) {
            if (palabrasProhibidas.contains(palabra.toLowerCase())) {
                contador++;
                mensajeFiltrado.append("!#%?@ ");
            } else {
                mensajeFiltrado.append(palabra).append(" ");
            }
        }

        if (contador > 3) {
            return "[ADVERTENCIA] El mensaje contiene demasiadas palabras prohibidas.";
        }

        return mensajeFiltrado.toString().trim();
    }
}