package com.Goit11;


import com.Goit11.Client.ClientService;
import com.Goit11.Databases.Database;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Database database = Database.getInstance();
        ClientService clientService = new ClientService(database);
//        System.out.println(clientService.create("af"));
//        System.out.println(clientService.listAll());
//        System.out.println(clientService.getByIdVersion2(3));
//        clientService.setName(7,"Sova");
//        clientService.deleteById(22);
//        clientService.deleteById(3);

    }
}