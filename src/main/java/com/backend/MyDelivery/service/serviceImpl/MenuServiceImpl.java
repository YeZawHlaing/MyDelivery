package com.backend.MyDelivery.service.serviceImpl;

import com.backend.MyDelivery.entity.Menu;
import com.backend.MyDelivery.service.MenuService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class MenuServiceImpl implements MenuService {


    @Override
    public String saveMenu(Menu menu) throws ExecutionException, InterruptedException {
        Firestore firestoreDb= FirestoreClient.getFirestore();

     ApiFuture<WriteResult> StoreResult= firestoreDb.collection("menu").document(menu.getDish()).set(menu);

        return StoreResult.get().getUpdateTime().toString();
    }

    @Override
    public List<Menu> getMenu() throws ExecutionException, InterruptedException {
        Firestore firestoreDb= FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = firestoreDb.collection("menu").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Menu> menulist = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            menulist.add(document.toObject(Menu.class));
        }
        return menulist;

    }
}
