//package com.ERP.Entities;
//
////import com.ERP.Repositories.AssetRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import java.sql.Date;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
////@TestPropertySource(locations = "classpath:application-test.properties")
//public class AssetsTest
//{
//    @Autowired
//    private TestEntityManager entityManager;
//    @Autowired
//    private AssetRepository assetRepository;
//
//    private Asset asset;
//    @BeforeEach
//    void setUp() {
//        // Initialize a sample AdminEntity instance for testing
//        asset = new Asset();
//        asset.setAssetId(1);
//        asset.setName("newAsset");
//        asset.setDescription("New asset is used");
//        asset.setCurrentValue("something");
//        asset.setStatus("Ongoing");
//        asset.setPurchaseCost(5000.0);
//        Date purchaseDate = Date.valueOf("2024-04-25");
//        asset.setPurchaseDate(purchaseDate);
////        Date purchaseDate = new Date(); // This will set the purchase date to the current date and time
////        asset.setPurchaseDate(purchaseDate);
//    }
//        @Test
//        public void testAssetConstructor() {
//            // Given
//            int assetId = 1;
//            String name = "newAsset";
//            String description = "New asset is used";
//            String currentValue="something";
//            String status="Ongoing";
//            double purchaseCost=5000;
//            Date purchaseDate = Date.valueOf("2024-04-25");
//
//            // When
//            Asset asset1 = new Asset(assetId,name,description,purchaseDate,purchaseCost,currentValue,status);
//
//            // Then
//            assertNotNull(asset1);
//            assertEquals(name, asset1.getName());
//            assertEquals(description, asset1.getDescription());
//            assertEquals(currentValue, asset1.getCurrentValue());
//            assertEquals(status, asset1.getStatus());
//            assertEquals(purchaseCost, asset1.getPurchaseCost());
//            assertEquals(purchaseDate, asset1.getPurchaseDate());
//        }
//}
//
