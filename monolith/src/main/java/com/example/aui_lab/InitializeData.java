package com.example.aui_lab;


import com.example.aui_lab.device.entity.Category;
import com.example.aui_lab.device.entity.Device;
import com.example.aui_lab.device.service.api.CategoryService;
import com.example.aui_lab.device.service.api.DeviceService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;


@Component
public class InitializeData implements InitializingBean{
    private final DeviceService deviceService;
    private final CategoryService categoryService;

    @Autowired
    public InitializeData(
            DeviceService deviceService,
            CategoryService categoryService
    ) {
        this.deviceService = deviceService;
        this.categoryService = categoryService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Category mice = Category.builder()
                .id(UUID.randomUUID())
                .name("Mice")
                .packagingPrice(2.99)
                .build();
        Category keyboards = Category.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .name("Keyboards")
                .packagingPrice(5.99)
                .build();
        Category gamepads = Category.builder()
                .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                .name("Gamepads")
                .packagingPrice(3.99)
                .build();

        categoryService.create(mice);
        categoryService.create(keyboards);
        categoryService.create(gamepads);

        Device deathAdderElite = Device.builder()
                .id(UUID.fromString("ff327e8a-77c0-4f9b-90a2-89e16895d1e1"))
                .manufacturer("Razer")
                .name("Deathadder Elite")
                .category(mice).build();
        Device orochiV2 = Device.builder().manufacturer("Razer").name("Orochi v2").category(mice).id(UUID.randomUUID()).build();
        Device g50 = Device.builder().manufacturer("Logitech").name("G50").category(mice).id(UUID.randomUUID()).build();
        Device blackWidow = Device.builder().manufacturer("Razer").name("BlackWidow").category(keyboards).id(UUID.randomUUID()).build();
        Device k70RGB = Device.builder().manufacturer("Corsair").name("K70 RGB").category(keyboards).id(UUID.randomUUID()).build();
        Device g715 = Device.builder().manufacturer("Logitech").name("G715").category(keyboards).id(UUID.randomUUID()).build();
        Device ultimateBT = Device.builder().manufacturer("8bitDo").name("Ultimate Bluetooth Controller").category(gamepads).id(UUID.randomUUID()).build();
        Device dualShock4 = Device.builder().manufacturer("Sony").name("DualShock 4").category(gamepads).id(UUID.randomUUID()).build();


        deviceService.create(deathAdderElite);
        deviceService.create(orochiV2);
        deviceService.create(g50);
        deviceService.create(blackWidow);
        deviceService.create(k70RGB);
        deviceService.create(g715);
        deviceService.create(ultimateBT);
        deviceService.create(dualShock4);
    }

    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }

}
