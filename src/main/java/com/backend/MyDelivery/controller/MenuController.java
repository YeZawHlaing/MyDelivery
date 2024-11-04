package com.backend.MyDelivery.controller;


import com.backend.MyDelivery.entity.Menu;
import com.backend.MyDelivery.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@CrossOrigin
@RestController
@RequestMapping("/api/backend")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/saveMenu")
    public String postMenu(@RequestBody  Menu menu) throws ExecutionException, InterruptedException {
        return menuService.saveMenu(menu);
    }
}
