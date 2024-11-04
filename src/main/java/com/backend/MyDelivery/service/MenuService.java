package com.backend.MyDelivery.service;

import com.backend.MyDelivery.entity.Menu;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface MenuService {

    public String saveMenu(Menu menu) throws ExecutionException, InterruptedException;
    public List<Menu> getMenu() throws ExecutionException, InterruptedException;
}
