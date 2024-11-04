package com.backend.MyDelivery.service;

import com.backend.MyDelivery.entity.Menu;

import java.util.concurrent.ExecutionException;

public interface MenuService {

    public String saveMenu(Menu menu) throws ExecutionException, InterruptedException;
}
