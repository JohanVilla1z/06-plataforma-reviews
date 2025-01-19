package org.example.utils;

import java.util.Map;
import java.util.Scanner;

public class ConsoleUtils {
  private final Scanner scanner = new Scanner(System.in);

  public String getString(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

  public Integer getInteger(String message) {
    try {
      System.out.println(message);
      int value = scanner.nextInt();
      scanner.nextLine();

      if (value < 0) {
        System.out.println("Ingresa un numero positivo.");
        return getInteger(message);
      }

      return value;
    } catch (Exception e) {
      System.err.println("Ingresa un numero con formato valido.");
      scanner.nextLine();
      return getInteger(message);
    }
  }

  public Float getRating(String message) {
    try {
      System.out.println(message);
      float value = scanner.nextFloat();
      scanner.nextLine();

      if (value < 0 || value > 5) {
        System.err.println("Ingresa un numero entre 0 y 5.");
        return getRating(message);
      }

      return value;
    } catch (Exception e) {
      System.err.println("Ingresa un numero con formato valido.");
      scanner.nextLine();
      return getRating(message);
    }
  }

  public Float getFloat(String message) {
    Float input;

    try {
      System.out.println(message);

      input = Float.parseFloat(scanner.nextLine());

      return input;
    } catch (NumberFormatException e) {
      System.err.println("Ingresa un numero con formato valido.");
      return getFloat(message);
    }
  }

  public Boolean getBoolean(String prompt) {
    Map<String, Boolean> responses = Map.of(
            "s", true, "si", true, "y", true, "yes", true,
            "n", false, "no", false
    );
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim().toLowerCase();
      if (responses.containsKey(input)) {
        return responses.get(input);
      } else {
        System.err.println("Error: Debe ingresar una respuesta valida (sí/no).");
      }
    }
  }

}