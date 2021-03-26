package co.com.laaguilar;

/**
 * Clase principal para ejecución mediante SpringBoot
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /**
     * Método principal
     * @param args 
     */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}