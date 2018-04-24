/**
*
*
 
*
* Author : Shaik Fareed
*
* 
*
**/ 
package com.ab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ab.entity.Product;
import com.ab.repository.ProductRepository;

@SpringBootApplication
public class CartServiceApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;
	

    public static void main(String[] args) {
    	SpringApplication.run(CartServiceApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Nexus S");
        product1.setPrice(99.99);
        product1.setInfo("The Nexus S is a smartphone co-developed by Google and Samsung and manufactured by Samsung Electronics for release in 2010. It was the first smartphone to use the Android 2.3 Gingerbread operating system, and the first Android device to support Near Field Communication (NFC).");
        product1.setSrc("/img/phones/nexus-s.0.jpg");
        
        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Dell Venue");
        product2.setPrice(109.99);
        product2.setInfo("The Dell Venue is a line of Android smartphones and tablets manufactured by Dell. The first Dell Venue was released for both T-Mobile and AT&T in the United States, and for KT in South Korea. It was the second Dell smartphone to be released in the US and features the Dell Stage UI also found on the Dell Streak line of tablets.");
        product2.setSrc("/img/phones/dell-venue.0.jpg");
        
        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Droid 2");
        product3.setPrice(89.99);
        product3.setInfo("The Motorola Droid 2 is the fifth phone in Verizon's Droid line. It runs the Android operating system by Google, and can run Flash Player 10.1. It comes with 8 GB of internal memory and is shipped with an additional 8 GB SDHC card, upgradable to 32 GB. It has a 3.7 in display and a 5-megapixel camera.");
        product3.setSrc("/img/phones/droid-2-global-by-motorola.0.jpg");
        
        Product product4 = new Product();
        product4.setId(4);
        product4.setName("Droid Pro");
        product4.setPrice(129.99);
        product4.setInfo("The Motorola Droid Pro is an Android-based smartphone manufactured by Motorola and released on November 18, 2010, for Verizon Wireless and June 5, 2011, for Sprint. These devices are available for Verizon, Sprint and Boost Mobile in the United States, and are designed for business users.");
        product4.setSrc("/img/phones/droid-pro-by-motorola.0.jpg");
        
        Product product5 = new Product();
        product5.setId(5);
        product5.setName("Motorola Bravo");
        product5.setPrice(119.99);
        product5.setInfo("The Motorola Bravo has a nice 3.7 inch WVGA display, a slim build, and a multimedia-friendly feature set that includes DLNA support. It has good call quality as well. The Motorola Bravo is a midrange Android smartphone with solid multimedia features.");
        product5.setSrc("/img/phones/motorola-bravo-with-motoblur.0.jpg");
        
        Product product6 = new Product();
        product6.setId(6);
        product6.setName("Motorola Defy");
        product6.setPrice(139.99);
        product6.setInfo("The Motorola Defy, also known as Motorola Defy A8210 & MB525, is an Android-based smartphone from Motorola. It fills a unique market segment, by being one of the few small, IP67 rated smartphones available. It is water-resistant, dust-resistant, and has an impact-resistant screen.");
        product6.setSrc("/img/phones/motorola-defy-with-motoblur.0.jpg");
        
        List<Product> list = new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);
        list.add(product6);
        
        productRepository.save(list);
    }
    
}
