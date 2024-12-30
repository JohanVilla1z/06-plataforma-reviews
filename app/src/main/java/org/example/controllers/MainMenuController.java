package org.example.controllers;

import org.example.services.MainMenuService;

public class MainMenuController {
  private final MainMenuService mainMenuService;

  public MainMenuController(MainMenuService mainMenuService) {
    this.mainMenuService = mainMenuService;
  }

  public void run() {
    mainMenuService.start();
  }
}
