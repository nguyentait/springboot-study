package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.entity.Car;
import com.example.demo.entity.User;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication

public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
		//System.out.println(applicationContext.getBean(UserController.class));
	}
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		Car car = new Car();
		car.setName("Ford Tourneo Titanium");
		ArrayList<String> images = new ArrayList<>();
		images.add("img1.jpg");
		images.add("img2.jpg");
		car.setImages(images);
		Car.Engine engine = new Car.Engine(220,"2.0 ecoboots");
		car.setEngine(engine);
		carRepository.save(car);
		Optional<Car> getCar = carRepository.findById(1);
		System.out.println(getCar.get().toString());

		User user1 = new User(1L,"Nguyen Van A","nguyenvana@gmail.com",
				"12345679","avatar.jpg","123456",new Date(),"USER");
		User user2 = new User(2L,"Nguyen Van B","nguyenvanb@gmail.com",
				"12345679","avatar.jpg","123456",new Date(),"USER");
		User user3 = new User(3L,"Nguyen Van C","nguyenvanc@gmail.com",
				"12345679","avatar.jpg","123456",new Date(),"USER");
		User user4 = new User(4L,"Nguyen Van D","nguyenvand@gmail.com",
				"12345679","avatar.jpg","123456",new Date(),"USER");
		User user5 = new User(5L,"Nguyen Van E","nguyenvane@gmail.com",
				"12345679","avatar.jpg","123456",new Date(),"USER");
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		userRepository.save(user5);
	}
}
