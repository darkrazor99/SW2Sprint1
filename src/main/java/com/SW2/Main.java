package com.SW2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SW2.enteties.RoleEntity;
import com.SW2.enteties.Userentinty;
import com.SW2.models.RoleRepository;
import com.SW2.models.UserModel;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	@Bean
    CommandLineRunner init(RoleRepository roleRepository,UserModel usermodel) {

        return args -> {

            RoleEntity adminRole = roleRepository.findByName("ADMIN");
            if (adminRole == null) {
                RoleEntity newAdminRole = new RoleEntity();
                newAdminRole.setName("ADMIN");
                roleRepository.save(newAdminRole);
            }

            RoleEntity userRole = roleRepository.findByName("USER");
            if (userRole == null) {
                RoleEntity newUserRole = new RoleEntity();
                newUserRole.setName("USER");
                roleRepository.save(newUserRole);
            }
            RoleEntity SellerRole = roleRepository.findByName("SELLER");
            if (SellerRole == null) {
                RoleEntity newUserRole = new RoleEntity();
                newUserRole.setName("SELLER");
                roleRepository.save(newUserRole);
            }
            Userentinty test= usermodel.findByUsername("test");
            if (test == null) {
            	Userentinty user= new Userentinty("test","test","test");
                usermodel.addAdmin(user);
            }
            
        };

    }
}
//admin2 pass =1;
//user1 pass = 1;
//seller1 pass =1;