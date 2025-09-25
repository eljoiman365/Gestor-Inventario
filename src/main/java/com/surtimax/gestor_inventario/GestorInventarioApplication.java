package com.surtimax.gestor_inventario;


import com.surtimax.gestor_inventario.main.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GestorInventarioApplication  {

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(GestorInventarioApplication.class,args);
        Principal principal = context.getBean(Principal.class);
        principal.menuPrincipal();
    }
}
