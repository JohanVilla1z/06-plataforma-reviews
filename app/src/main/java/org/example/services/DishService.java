package org.example.services;

import org.example.factories.ReviewFactory;
import org.example.models.Dish;
import org.example.models.Menu;
import org.example.repositories.DataRepository;
import org.example.services.interfaces.IDishService;
import org.example.utils.ConsoleUtils;

import java.util.Optional;

public class DishService implements IDishService {
    private final DataRepository repository;
    private final ConsoleUtils consoleUtils;
    private final ReviewFactory reviewFactory;

    public DishService(DataRepository repository) {
        this.repository = repository;
        this.consoleUtils = new ConsoleUtils();
        this.reviewFactory = new ReviewFactory();
    }

    @Override
    public void addDish(String menuName, Dish dish) {
        Optional<Menu> menu = repository.getAllMenus().stream()
            .filter(m -> m.getName().equalsIgnoreCase(menuName))
            .findFirst();

        if (menu.isPresent()) {
            menu.get().addDish(dish);
            System.out.println("Plato agregado exitosamente al menú: " + menuName);
        } else {
            System.err.println("No se encontró un menú con el nombre: " + menuName);
        }
    }

    @Override
    public void editDish(String menuName, String dishName, Dish updatedDish) {
        Optional<Menu> menu = repository.getAllMenus().stream()
            .filter(m -> m.getName().equalsIgnoreCase(menuName))
            .findFirst();

        if (menu.isPresent()) {
            menu.get().editDish(dishName, updatedDish);
            System.out.println("Plato actualizado exitosamente en el menú: " + menuName);
        } else {
            System.err.println("No se encontró un menú con el nombre: " + menuName);
        }
    }

    @Override
    public void removeDish(String menuName, String dishName) {
        Optional<Menu> menu = repository.getAllMenus().stream()
            .filter(m -> m.getName().equalsIgnoreCase(menuName))
            .findFirst();

        if (menu.isPresent()) {
            menu.get().removeDish(dishName);
            System.out.println("Plato eliminado exitosamente del menú: " + menuName);
        } else {
            System.err.println("No se encontró un menú con el nombre: " + menuName);
        }
    }

    @Override
    public void listDishes(String menuName) {
        Optional<Menu> menu = repository.getAllMenus().stream()
            .filter(m -> m.getName().equalsIgnoreCase(menuName))
            .findFirst();

        if (menu.isPresent()) {
            System.out.println("=== Platos en el menú: " + menuName + " ===");
            menu.get().getDishes().forEach(System.out::println);
        } else {
            System.err.println("No se encontró un menú con el nombre: " + menuName);
        }
    }

    @Override
    public void addDishReview(String menuName, String dishName) {
        Optional<Menu> menu = repository.getAllMenus().stream()
            .filter(m -> m.getName().equalsIgnoreCase(menuName))
            .findFirst();

        if (menu.isPresent()) {
            Optional<Dish> dish = menu.get().getDishes().stream()
                .filter(d -> d.getName().equalsIgnoreCase(dishName))
                .findFirst();

            if (dish.isPresent()) {
                String comment = consoleUtils.getString("Ingresa un comentario para la reseña:");
                float rating = consoleUtils.getInteger("Ingresa una calificación (1-5):").floatValue();
                dish.get().addDishReview(reviewFactory.createDishReview(comment, rating)); //TODO: aaaaaaaaaa factory
                System.out.println("Review agregada exitosamente al plato: " + dishName);
            } else {
                System.err.println("No se encontró un plato con el nombre: " + dishName);
            }
        } else {
            System.err.println("No se encontró un menú con el nombre: " + menuName);
        }
    }

    @Override
    public void listDishReviews(String menuName, String dishName) {
        Optional<Menu> menu = repository.getAllMenus().stream()
            .filter(m -> m.getName().equalsIgnoreCase(menuName))
            .findFirst();

        if (menu.isPresent()) {
            Optional<Dish> dish = menu.get().getDishes().stream()
                .filter(d -> d.getName().equalsIgnoreCase(dishName))
                .findFirst();

            if (dish.isPresent()) {
                System.out.println("=== Reviews del plato: " + dishName + " ===");
                dish.get().getReviews().forEach((review) -> System.out.println(review.getComment()));
            } else {
                System.err.println("No se encontró un plato con el nombre: " + dishName);
            }
        } else {
            System.err.println("No se encontró un menú con el nombre: " + menuName);
        }
    }

    @Override
    public void calculateDishAverageRating(String menuName, String dishName) {
        Optional<Menu> menu = repository.getAllMenus().stream()
            .filter(m -> m.getName().equalsIgnoreCase(menuName))
            .findFirst();

        if (menu.isPresent()) {
            Optional<Dish> dish = menu.get().getDishes().stream()
                .filter(d -> d.getName().equalsIgnoreCase(dishName))
                .findFirst();

            if (dish.isPresent()) {
                System.out.println("Calificación promedio del plato: " + dish.get().averageRating());
            } else {
                System.err.println("No se encontró un plato con el nombre: " + dishName);
            }
        } else {
            System.err.println("No se encontró un menú con el nombre: " + menuName);
        }
    }
}
