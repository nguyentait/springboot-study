package com.nguyentc7.app;

import com.nguyentc7.app.entity.Car;
import com.nguyentc7.app.entity.IdentityCard;
import com.nguyentc7.app.entity.User;
import com.nguyentc7.app.repository.CarRepository;
import com.nguyentc7.app.repository.IdentityCardRepository;
import com.nguyentc7.app.repository.UserRepository;
import com.nguyentc7.app.request.CreateUserReq;
import com.nguyentc7.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
	@Autowired
	private IUserService userService;
	@Autowired
	private IdentityCardRepository identityCardRepository;

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

		CreateUserReq user1 = new CreateUserReq("Nguyen Van A","nva@gmail.com",
				"1234567890","avatar.jpg","123456");
		CreateUserReq user2 = new CreateUserReq("Nguyen Van B","nvb@gmail.com",
				"1234567890","avatar.jpg","123456");
		CreateUserReq user3 = new CreateUserReq("Nguyen Van C","nvc@gmail.com",
				"1234567890",null,"123456");
		CreateUserReq user4 = new CreateUserReq("Nguyen Van D","nvd@gmail.com",
				"1234567890",null,"123456");
		CreateUserReq user5 = new CreateUserReq("Nguyen Van E","nve@gmail.com",
				"1234567890",null,"123456");

		userService.createUser(user1);
		userService.createUser(user2);
		userService.createUser(user3);
		userService.createUser(user4);
		userService.createUser(user5);


		IdentityCard idc = new IdentityCard();
		idc.setId("ABC123");
		idc.setExpired(new Date());
		idc.setIssued(new Date());

		// Lưu idc vào database
		identityCardRepository.save(idc);
		User u = userRepository.findById(1L).get();
		u.setIdentityCard(idc);
		userRepository.save(u);
		System.out.println(u);
	}
}
