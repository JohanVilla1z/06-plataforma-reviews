package org.example;

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
import org.example.factories.ReviewFactory;
import org.example.repositories.MenuRepository;
import org.example.repositories.RestaurantRepository;
import org.example.services.menu.AddDishService;
import org.example.services.menu.DeleteDishService;
import org.example.services.menu.SelectDishService;
import org.example.services.menu.UpdateDishService;
import org.example.services.restaurant.CreateRestaurantService;
import org.example.services.restaurant.DeleteRestaurantService;
import org.example.services.restaurant.ListRestaurantService;
import org.example.services.restaurant.SelectRestaurantService;
import org.example.services.restaurant.UpdateRestaurantService;
import org.example.services.reviews.CreateDishReviewService;
import org.example.services.reviews.CreateRestaurantReviewService;
import org.example.services.reviews.ListDishReviewsService;
import org.example.utils.ConsoleUtils;
import org.example.utils.MainMenu;

public class Main {
  public static void main(String[] args) {
    ConsoleUtils consoleUtils = new ConsoleUtils();
    RestaurantRepository restaurantRepository = RestaurantRepository.getInstance();
    MenuRepository menuRepository = MenuRepository.getInstance();

    SelectRestaurantService selectRestaurantService = new SelectRestaurantService(restaurantRepository, consoleUtils);
    SelectDishService selectDishService = new SelectDishService(consoleUtils, selectRestaurantService);
    ReviewFactory reviewFactory = new ReviewFactory();

    AddDishService addDishService = new AddDishService(selectRestaurantService, menuRepository, consoleUtils);
    CreateRestaurantService createRestaurantService = new CreateRestaurantService(restaurantRepository, consoleUtils,
        addDishService);
    ListRestaurantService listRestaurantService = new ListRestaurantService(restaurantRepository);
    UpdateRestaurantService updateRestaurantService = new UpdateRestaurantService(selectRestaurantService,
        restaurantRepository, consoleUtils);
    DeleteRestaurantService deleteRestaurantService = new DeleteRestaurantService(restaurantRepository,
        selectRestaurantService);
    UpdateDishService updateDishService = new UpdateDishService(selectDishService, consoleUtils, menuRepository);
    DeleteDishService deleteDishService = new DeleteDishService(restaurantRepository, selectDishService);
    CreateDishReviewService createDishReviewService = new CreateDishReviewService(selectDishService, consoleUtils,
        reviewFactory);
    CreateRestaurantReviewService createRestaurantReviewService = new CreateRestaurantReviewService(
        selectRestaurantService, reviewFactory, consoleUtils);
    ListDishReviewsService listDishReviewsService = new ListDishReviewsService(selectDishService);

    CreateRestaurantController createRestaurantController = new CreateRestaurantController(createRestaurantService);
    ListRestaurantController listRestaurantController = new ListRestaurantController(listRestaurantService,
        consoleUtils);
    UpdateRestaurantController updateRestaurantController = new UpdateRestaurantController(updateRestaurantService);
    DeleteRestaurantController deleteRestaurantController = new DeleteRestaurantController(deleteRestaurantService);
    AddDishController addDishController = new AddDishController(addDishService);
    UpdateDishController updateDishController = new UpdateDishController(updateDishService);
    DeleteDishController deleteDishController = new DeleteDishController(deleteDishService);
    CreateDishReviewController createDishReviewController = new CreateDishReviewController(createDishReviewService);
    CreateRestaurantReviewController createRestaurantReviewController = new CreateRestaurantReviewController(
        createRestaurantReviewService);
    ListDishReviewsController listDishReviewsController = new ListDishReviewsController(listDishReviewsService);

    MainMenu mainMenu = new MainMenu(
        consoleUtils,
        createRestaurantController,
        listRestaurantController,
        updateRestaurantController,
        deleteRestaurantController,
        addDishController,
        updateDishController,
        deleteDishController,
        createDishReviewController,
        createRestaurantReviewController,
        listDishReviewsController

    );

    mainMenu.execute();
  }
}
