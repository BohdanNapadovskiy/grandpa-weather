package com.grandpaweather.config.dbmigrations;

import com.grandpaweather.domain.Customer;
import com.grandpaweather.repository.ProductRepository;
import com.grandpaweather.domain.Product;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.RollbackExecution;
import io.mongock.api.annotations.BeforeExecution;
import io.mongock.api.annotations.RollbackBeforeExecution;
import io.mongock.api.annotations.Execution;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@ChangeUnit(id = "product-initializer", order = "1", author = "Bohdan")
public class ProductsInitializerChangeUnit {
    private static final Logger log = LoggerFactory.getLogger(ProductsInitializerChangeUnit.class);

    @BeforeExecution
    public void beforeExecution(MongoTemplate mongoTemplate) {
        log.info("Creating collection in mongo db");
        mongoTemplate.createCollection("products");
    }

    @RollbackBeforeExecution
    public void rollbackBeforeExecution(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection("products");
    }

    @Execution
    public void execution(ProductRepository repository) {
        log.info("Saving products in mongo collection");
        List<Product> products = createListOfProducts();
        repository.saveAll(products);

    }

    @RollbackExecution
    public void rollbackExecution(ProductRepository repository) {
        log.error("Error by creating triggers");
        repository.deleteAll();
    }


    private List<Product> createListOfProducts() {
        log.info("Creating products for saving in mongo collection");
        List<Product> products = new ArrayList<>();
        products.add(Product.builder()
                .category("Знеболюючі")
                .name("Цитрамон")
                .customers(createCitramonCustomers())
                .priority(1)
                .build());
        products.add(Product.builder()
                .category("Знеболюючі")
                .name("Нурофен")
                .customers(createNurofenCustomers())
                .priority(2)
                .build());
        products.add(Product.builder()
                .category("Знеболюючі")
                .name("Спазмалгон")
                .customers(createSpazmalgonCustomers())
                .priority(3)
                .build());
        products.add(Product.builder()
                .category("Знеболюючі місцевої дії")
                .name("Фастум гель")
                .customers(createFastumGelCustomers())
                .priority(1)
                .build());
        products.add(Product.builder()
                .category("Знеболюючі місцевої дії")
                .name("Диклофенак")
                .customers(createDyklofynakGelCustomers())
                .priority(2)
                .build());
        products.add(Product.builder()
                .category("Знеболюючі місцевої дії")
                .name("Долорен")
                .customers(createDolarenGelCustomers())
                .priority(3)
                .build());
        products.add(Product.builder()
                .category("Кліматичні прилади")
                .name("Кондиціонери")
                .customers(new ArrayList<>())
                .priority(1)
                .build());
        products.add(Product.builder()
                .category("Кліматичні прилади")
                .name("Зволожувачі повітря")
                .customers(new ArrayList<>())
                .priority(2)
                .build());
        products.add(Product.builder()
                .category("Кліматичні прилади")
                .name("Очишувачі повітря")
                .customers(new ArrayList<>())
                .priority(3)
                .build());
        products.add(Product.builder()
                .category("Інші товари")
                .name("Парасоля")
                .customers(new ArrayList<>())
                .priority(1)
                .build());
        products.add(Product.builder()
                .category("Інші товари")
                .name("Парасоля")
                .customers(new ArrayList<>())
                .priority(1)
                .build());
        products.add(Product.builder()
                .category("Інші товари")
                .name("Дощовик")
                .customers(new ArrayList<>())
                .priority(2)
                .build());
        products.add(Product.builder()
                .category("Інші товари")
                .name("Водовідштовхуючий крем/спрей для взутт")
                .customers(new ArrayList<>())
                .priority(3)
                .build());
        products.add(Product.builder()
                .category("Інші товари")
                .name("Автомобільні шини")
                .customers(new ArrayList<>())
                .priority(4)
                .build());
        products.add(Product.builder()
                .category("Інші товари")
                .name("Шиномонтаж")
                .customers(new ArrayList<>())
                .priority(5)
                .build());
        products.add(Product.builder()
                .category("Інші товари")
                .name("Фольга")
                .customers(new ArrayList<>())
                .priority(6)
                .build());
        products.add(Product.builder()
                .category("Народна медицина")
                .name("Імбир")
                .customers(createATBCustomers())
                .priority(1)
                .build());

        return products;
    }

    private List<Customer> createATBCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .name("АТБ")
                .productURI("https://www.atbmarket.com/product/korin-imbira-1-gat")
                .productImageURI("https://src.zakaz.atbmarket.com/prodwebp/catalog_product_gal/i5/catalog_product_gal_4633.webp")
                .price(228.95)
                .priority(1)
                .build());
        return customers;
    }

    private List<Customer> createCitramonCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .name("Аптека Подорожник")
                .productURI("https://podorozhnyk.ua/citramon-d-tabl-10/")
                .productImageURI("https://i.podorozhnyk.com/products/20a96bd7-a53c-4e52-aef4-971c3890c3e4-large.webp")
                .price(30.61)
                .priority(1)
                .build());
        customers.add(Customer.builder()
                .name("АПТЕКА НИЗЬКИХ ЦІН (АНЦ)")
                .productURI("https://anc.ua/ru/item/tsitramon-darnitsya-tabletki-10-1041158")
                .productImageURI("https://storage.googleapis.com/static-storage/products/images/v2/1041158_seYGtqtN_20230809_103110.medium.webp")
                .price(25.9)
                .priority(2)
                .build());
        customers.add(Customer.builder()
                .name("Аптека доброго дня")
                .productURI("https://www.add.ua/ua/citramon-d-tabletki-10.html")
                .productImageURI("https://www.add.ua/media/catalog/product/cache/c7ff4e8ca657db3dcc51883bafd4e31f/1/8/182088-43350-big-1500x1500-90bbphotoaid-removed-background.jpg")
                .price(34.1)
                .priority(3)
                .build());
        customers.add(Customer.builder()
                .name("Аптека Конекс")
                .productURI("https://etabletka.ua/product/citramon-darnicya-tabletki-10#stores")
                .productImageURI("https://cdn.konex.com.ua/file/etabletka/products/85549/47363-citramon-darnicya-tabletki-10.jpg")
                .price(33.01)
                .priority(4)
                .build());
        customers.add(Customer.builder()
                .name("apteka24.ua")
                .productURI("https://www.apteka24.ua/uk/tsitramon-d-tabl-n10-10kh1/")
                .productImageURI("https://i.apteka24.ua/products/28cc993d-dc8d-4f40-9827-c21e17462ecd.jpeg")
                .price(29.00)
                .priority(5)
                .build());
        return customers;

    }

    private List<Customer> createNurofenCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .name("АПТЕКА НИЗЬКИХ ЦІН (АНЦ)")
                .productURI("https://anc.ua/item/nurofen-tabletki-vkriti-obolonkoyu-200-mg-blister-6-11891")
                .productImageURI("https://storage.googleapis.com/static-storage/products/images/v2/11891_rQNZArwT_20221018_221526.webp")
                .price(57.2)
                .priority(3)
                .build());
        customers.add(Customer.builder()
                .name("Аптека Подорожник")
                .productURI("https://podorozhnyk.ua/nurofen-tabl-p-o-200mg-24/")
                .productImageURI("https://i.podorozhnyk.com/products/58a0e37f-c7c8-4d93-9cea-2e2af94ac759-large.webp")
                .price(74.61)
                .priority(2)
                .build());
        customers.add(Customer.builder()
                .name("Аптека доброго дня")
                .productURI("https://www.add.ua/ua/nurofen-200-mg-tabletki-12.html")
                .productImageURI("https://www.add.ua/media/catalog/product/cache/c7ff4e8ca657db3dcc51883bafd4e31f/n/u/nurofen-_12_-_-200-__5000167046878.jpg")
                .price(85.4)
                .priority(1)
                .build());
        customers.add(Customer.builder()
                .name("Аптека Конекс")
                .productURI("https://etabletka.ua/product/nurofen-tabletki-200mg-12")
                .productImageURI("https://cdn.konex.com.ua/file/etabletka/products/39123/4931-nurofen-tabletki-200mg-12.jpg")
                .price(90.25)
                .priority(4)
                .build());
        return customers;

    }


    private List<Customer> createSpazmalgonCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .name("АПТЕКА НИЗЬКИХ ЦІН (АНЦ)")
                .productURI("https://anc.ua/item/spazmalgon-tabletki-blister-10-4553")
                .productImageURI("https://storage.googleapis.com/static-storage/products/images/v2/4553_tibaZUTv_20220613_141537.medium.webp")
                .price(59.9)
                .priority(1)
                .build());
        customers.add(Customer.builder()
                .name("Аптека Подорожник")
                .productURI("https://podorozhnyk.ua/spazmalgon-tabl-10/")
                .productImageURI("https://i.podorozhnyk.com/products/32248983-bc72-429a-b1b2-813fa27bea82-large.webp")
                .price(58.83)
                .priority(2)
                .build());
        customers.add(Customer.builder()
                .name("Аптека доброго дня")
                .productURI("https://www.add.ua/spazmalgon-500mg-10-tabletki.html")
                .productImageURI("https://www.add.ua/media/catalog/product/cache/0cb86aa621afec2b43f6f8736c54c157/s/p/spasmalgon_n10_pack_0001_jpg.webp")
                .price(58.3)
                .priority(3)
                .build());
        customers.add(Customer.builder()
                .name("Аптека Конекс")
                .productURI("https://etabletka.ua/product/spazmalgon-tabletki-10")
                .productImageURI("https://cdn.konex.com.ua/file/etabletka/products/3389/45269-spazmalgon-tabletki-10-2.jpg")
                .price(58.24)
                .priority(4)
                .build());
        return customers;

    }

    private List<Customer> createFastumGelCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .name("АПТЕКА НИЗЬКИХ ЦІН (АНЦ)")
                .productURI("https://anc.ua/item/fastum-gel-25--tuba-50-g-5087")
                .productImageURI("https://storage.googleapis.com/static-storage/products/images/v2z/5087_2.medium.webp")
                .price(127.9)
                .priority(1)
                .build());
        customers.add(Customer.builder()
                .name("Аптека Подорожник")
                .productURI("https://podorozhnyk.ua/fastum-gel-2-5-tuba-30g-1/")
                .productImageURI("https://i.podorozhnyk.com/products/ecae4bdc-bbb1-487b-b8d3-f0c297451327-large.webp")
                .price(102.73)
                .priority(2)
                .build());
        customers.add(Customer.builder()
                .name("Аптека доброго дня")
                .productURI("https://www.add.ua/fastum-50g-gel.html")
                .productImageURI("https://www.add.ua/media/catalog/product/cache/0cb86aa621afec2b43f6f8736c54c157/2/4/2428-519-big-1500x1500-cd43_jpg.webp")
                .price(119.9)
                .priority(3)
                .build());
        return customers;

    }

    private List<Customer> createDyklofynakGelCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .name("АПТЕКА НИЗЬКИХ ЦІН (АНЦ)")
                .productURI("https://anc.ua/item/diklofenak-viola-gel-5--tuba-50-g-stm-1056209")
                .productImageURI("https://storage.googleapis.com/static-storage/products/images/v2/1056209_VWeinJkA_20230731_150147.medium.webp")
                .price(86.6)
                .priority(1)
                .build());
        customers.add(Customer.builder()
                .name("Аптека Подорожник")
                .productURI("https://podorozhnyk.ua/diklofenak-gel-5-tuba-50g-1-viola/")
                .productImageURI("https://i.podorozhnyk.com/products/698d452e-b8a1-403f-ade4-83b91ea27d11-large.webp")
                .price(120.78)
                .priority(2)
                .build());
        customers.add(Customer.builder()
                .name("Аптека доброго дня")
                .productURI("https://www.add.ua/ua/diklofenak-zdorovye-forte-gel-3-50g.html")
                .productImageURI("https://www.add.ua/media/catalog/product/cache/0cb86aa621afec2b43f6f8736c54c157/i/m/img_original_0-_21__1_jpg.webp")
                .price(55.8)
                .priority(3)
                .build());
        return customers;
    }

    private List<Customer> createDolarenGelCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder()
                .name("АПТЕКА НИЗЬКИХ ЦІН (АНЦ)")
                .productURI("https://anc.ua/item/dolaren-gel-50g-nabros-pharma-28105")
                .productImageURI("https://storage.googleapis.com/static-storage/products/images/v2z/28105.medium.webp")
                .price(150.2)
                .priority(1)
                .build());
        customers.add(Customer.builder()
                .name("Аптека Подорожник")
                .productURI("https://podorozhnyk.ua/dolaren-gel-tuba-50g-1/")
                .productImageURI("https://i.podorozhnyk.com/products/16c10348-b79e-44bd-952f-6e0c26a928ae-large.webp")
                .price(157.36)
                .priority(2)
                .build());
        customers.add(Customer.builder()
                .name("Аптека доброго дня")
                .productURI("https://add.ua/ua/dolaren-50g-gel.html")
                .productImageURI("https://www.add.ua/media/catalog/product/cache/0cb86aa621afec2b43f6f8736c54c157/1/4/14_5_jpg.webp")
                .price(162.8)
                .priority(3)
                .build());
        return customers;

    }


}
