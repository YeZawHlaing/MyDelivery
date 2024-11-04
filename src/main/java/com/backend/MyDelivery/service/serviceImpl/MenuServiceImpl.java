package com.backend.MyDelivery.service.serviceImpl;

import com.backend.MyDelivery.entity.Menu;
import com.backend.MyDelivery.service.MenuService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MenuServiceImpl implements MenuService {


    @Override
    public String saveMenu(Menu menu) throws ExecutionException, InterruptedException {
        Firestore firestoreDb= FirestoreClient.getFirestore();

     ApiFuture<WriteResult> StoreResult= firestoreDb.collection("menu").document(menu.getDish()).set(menu);

        return StoreResult.get().getUpdateTime().toString();
    }
}
