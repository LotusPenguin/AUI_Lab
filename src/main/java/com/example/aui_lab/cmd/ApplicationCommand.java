package com.example.aui_lab.cmd;

import ch.qos.logback.core.net.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ApplicationCommand implements CommandLineRunner {

//    private final DeviceController deviceController;
//    private final ObjectWriter writer;
//
//    @Autowired
//    public ApplicationCommand(
//            DeviceController deviceController;
//            ObjectWriter objectWriter
//    ){
//        this.deviceController = deviceController;
//        this.objectWriter = objectWriter;
//    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "help" -> {
                    System.out.println("list_all_categories, list_all_devices, add_new_device, delete_existing_device, stop_application");
                }
                case "list_all_categories" -> {

                }
                case "list_all_devices" -> {

                }
                case "add_new_device" -> {

                }
                case "delete_existing_device" -> {

                }
                case "stop_application" -> {

                }
            }
        }
    }
}
