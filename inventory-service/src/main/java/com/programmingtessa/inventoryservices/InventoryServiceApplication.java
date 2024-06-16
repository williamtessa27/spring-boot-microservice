package com.programmingtessa.inventoryservices;

import com.programmingtessa.inventoryservices.model.Inventory;
import com.programmingtessa.inventoryservices.repository.InventoryRepository;
import com.programmingtessa.inventoryservices.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

    private final InventoryService inventoryService;

    public InventoryServiceApplication(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            if (inventoryService.countData() == 0) {
                Inventory inventory = new Inventory();
                inventory.setSkuCode("iphone_13");
                inventory.setQuantity(100);

                Inventory inventory1 = new Inventory();
                inventory1.setSkuCode("iphone_13_red");
                inventory1.setQuantity(0);

                inventoryRepository.save(inventory);
                inventoryRepository.save(inventory1);
            }
        };
    }
}
