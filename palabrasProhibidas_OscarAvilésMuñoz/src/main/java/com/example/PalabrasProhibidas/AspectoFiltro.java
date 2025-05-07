package com.example.PalabrasProhibidas;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * Aspecto AOP que intercepta la ejecución del servicio de filtrado de mensajes.
 * Imprime el mensaje original y el resultado procesado.
 */
@Aspect
@Component
public class AspectoFiltro {

    /**
     * Se ejecuta antes del método procesarMensaje().
     *
     * @param joinPoint punto de ejecución, contiene el mensaje original.
     */
    @Before("execution(* com.example.palabrasprohibidas.FiltroServicio.procesarMensaje(..))")
    public void antesDeFiltrar(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("[AOP] Analizando mensaje: \"" + args[0] + "\"");
    }

    /**
     * Se ejecuta después del método procesarMensaje(), mostrando el resultado filtrado.
     *
     * @param resultado el mensaje ya filtrado.
     */
    @AfterReturning(pointcut = "execution(* com.example.palabrasprohibidas.FiltroServicio.procesarMensaje(..))", returning = "resultado")
    public void despuesDeFiltrar(Object resultado) {
        System.out.println("[AOP] Resultado del filtrado: \"" + resultado + "\"\n");
    }
}
