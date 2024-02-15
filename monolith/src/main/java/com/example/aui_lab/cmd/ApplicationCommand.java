package com.example.aui_lab.cmd;

import com.example.aui_lab.device.controller.api.CategoryController;
import com.example.aui_lab.device.controller.api.DeviceController;
import com.example.aui_lab.device.dto.PutDeviceRequest;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final DeviceController deviceController;
    private final CategoryController categoryController;
    private final ObjectWriter writer;

    @Autowired
    public ApplicationCommand(
            DeviceController deviceController,
            CategoryController categoryController,
            ObjectWriter writer
    ) {
        this.deviceController = deviceController;
        this.categoryController = categoryController;
        this.writer = writer;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            command = scanner.next();
            switch (command) {
                case "help" -> {
                    System.out.println("list_all_categories, list_all_devices, add_new_device, delete_existing_device, stop_application");
                }
                case "list_all_categories" -> {
                    System.out.println(writer.writeValueAsString(categoryController.getCategories()));
                }
                case "list_all_devices" -> {
                    System.out.println(writer.writeValueAsString(deviceController.getDevices()));
                }
                case "add_new_device" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    PutDeviceRequest request = PutDeviceRequest.builder()
                            .name(scanner.next())
                            .category(UUID.fromString(scanner.next()))
                            .build();
                    try {
                        deviceController.putDevice(uuid, request);
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Bad Request");
                    }
                }
                case "delete_existing_device" -> {
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        deviceController.deleteDevice(uuid);
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "stop_application" -> {
                    System.exit(0);
                }
            }
        }
    }
}
