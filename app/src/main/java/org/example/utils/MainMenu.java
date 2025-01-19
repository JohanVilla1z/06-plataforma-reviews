package org.example.utils;

import org.example.controllers.interfaces.ICommandController;
import org.example.controllers.menu.AddDishController;
import org.example.controllers.menu.DeleteDishController;
import org.example.controllers.menu.UpdateDishController;
import org.example.controllers.restaurant.CreateRestaurantController;
import org.example.controllers.restaurant.DeleteRestaurantController;
import org.example.controllers.restaurant.ListRestaurantController;
import org.example.controllers.restaurant.UpdateRestaurantController;
import org.example.controllers.reviews.CreateDishReviewController;
import org.example.controllers.reviews.CreateRestaurantReviewController;
import org.example.controllers.reviews.ListDishReviewsController;
import org.example.utils.interfaces.IMainMenu;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements IMainMenu<Integer> {
  private final ConsoleUtils consoleUtils;
  private final CreateRestaurantController createRestaurantController;
  private final ListRestaurantController listRestaurantController;
  private final UpdateRestaurantController updateRestaurantController;
  private final DeleteRestaurantController deleteRestaurantController;
  private final AddDishController addDishController;
  private final UpdateDishController updateDishController;
  private final DeleteDishController deleteDishController;
  private final CreateDishReviewController createDishReview;
  private final CreateRestaurantReviewController createRestaurantReview;
  private final ListDishReviewsController listDishReviewsController;


  public MainMenu(ConsoleUtils consoleUtils, CreateRestaurantController createRestaurantController, ListRestaurantController listRestaurantController, UpdateRestaurantController updateRestaurantController, DeleteRestaurantController deleteRestaurantController, AddDishController addDishController, UpdateDishController updateDishController, DeleteDishController deleteDishController, CreateDishReviewController createDishReview, CreateRestaurantReviewController createRestaurantReview, ListDishReviewsController listDishReviewsController) {
    this.consoleUtils = consoleUtils;
    this.createRestaurantController = createRestaurantController;
    this.listRestaurantController = listRestaurantController;
    this.updateRestaurantController = updateRestaurantController;
    this.deleteRestaurantController = deleteRestaurantController;
    this.addDishController = addDishController;
    this.updateDishController = updateDishController;
    this.deleteDishController = deleteDishController;
    this.createDishReview = createDishReview;
    this.createRestaurantReview = createRestaurantReview;
    this.listDishReviewsController = listDishReviewsController;
  }

  private Integer showMenu() {
    return consoleUtils.getInteger(
            "1. Crear Restaurante" +
                    "\n2. Listar restaurantes" +
                    "\n3. Actualizar un restaurante" +
                    "\n4. Eliminar restaurante" +
                    "\n5. Agregar menu a restaurante" +
                    "\n6. Actualizar un plato" +
                    "\n7. Eliminar un plato" +
                    "\n8. Agregar reseña de plato" +
                    "\n9. Agregar reseña de restaurante" +
                    "\n10.Listar las reseñas de un plato" +
                    "\n0. Exit" +
                    "\nEscoge una opcion: "
    );
  }

  @Override
  public Integer execute() {
    Map<Integer, ICommandController> controllerMap = new HashMap<>();
    controllerMap.put(1, createRestaurantController);
    controllerMap.put(2, listRestaurantController);
    controllerMap.put(3, updateRestaurantController);
    controllerMap.put(4, deleteRestaurantController);
    controllerMap.put(5, addDishController);
    controllerMap.put(6, updateDishController);
    controllerMap.put(7, deleteDishController);
    controllerMap.put(8, createDishReview);
    controllerMap.put(9, createRestaurantReview);
    controllerMap.put(10, listDishReviewsController);

    Integer option;
    while (true) {
      option = showMenu();
      if (option == 0) {
        System.out.println("Gracias por usar el sistema!!");
        break;
      }
      if (controllerMap.containsKey(option)) {
        controllerMap.get(option).execute();
      } else {
        System.err.println("Opcion no valida");
      }
    }
    return option;
  }
}
