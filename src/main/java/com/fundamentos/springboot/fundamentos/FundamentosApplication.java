package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.dto.UserDto;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;

import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import com.fundamentos.springboot.fundamentos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency dependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties beanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public FundamentosApplication(
			@Qualifier("componentTwoImpl") ComponentDependency dependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWithProperties beanWithProperties,
			UserPojo userPojo,
			UserRepository userRepository,
			UserService userService)
	{
		this.dependency = dependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.beanWithProperties = beanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
		//getInformationJpqlFromUser();
		//saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional(){
		User test1 = User.builder().withName("testTransactional1")
				.withEmail("testTransactional1@gmail.com").withFecah(LocalDate.now()).build();
		User test2 = User.builder().withName("testTransactional2")
				.withEmail("testTransactional2@gmail.com").withFecah(LocalDate.now()).build();
		User test3 = User.builder().withName("testTransactional3")
				//.withEmail("testTransactional1@gmail.com").withFecah(LocalDate.now()).build();
				.withEmail("testTransactional3@gmail.com").withFecah(LocalDate.now()).build();
		User test4 = User.builder().withName("testTransactional4")
				.withEmail("testTransactional4@gmail.com").withFecah(LocalDate.now()).build();

		List<User> users = Arrays.asList(test1, test2, test3, test4);

		try {
			userService.saveTransactional(users);
		}catch (Exception e){
			log.error("esta es la exception transactional: "+e.getMessage());
		}

		userService.getAllUsers().stream()
				.forEach(user -> log.info("usuario Transaccional: "+user));
	}

	private void getInformationJpqlFromUser(){

		User usuario = userRepository.findByUserEmail("jhon@gmail.com")
				.orElseThrow(()-> new RuntimeException("usuario no encontrado"));
		log.info("usuario del metodo findByUserEmail: "+usuario);

		userRepository.findAndSort("j", Sort.by("id").descending())
				.stream().forEach(user -> log.info("usuario con metodo sort: "+user));

		userRepository.findByName("yuli")
				.stream()
				.forEach(user -> log.info("usuario by name: "+user));

		User usuario2 = userRepository.findByEmailAndName("juan@gmail.com", "juan")
				.orElseThrow(()-> new RuntimeException("usuario no encontrado"));
		log.info("usuario del metodo findByEmailAndName: "+usuario2);

		userRepository.findByNameLike("%j%")
				.stream().forEach(user -> log.info("usuario con metodo like: "+user));

		userRepository.findByNameOrEmail("juan", null)
				.stream().forEach(user -> log.info("usuario con metodo or: "+user));

		userRepository.findByFecahBetween(
				LocalDate.of(2021, 03, 01),
				LocalDate.of(2021, 03, 30))
				.stream().forEach(user -> log.info("usuario con metodo between: "+user));

		userRepository.findByNameContainingOrderByIdDesc("jhon")
				.stream().forEach(user -> log.info("usuario con metodo order by: "+user));

	}

	private void saveUsersInDataBase(){
		User user1 = User.builder().withName("jhon").withEmail("jhon@gmail.com")
				.withFecah(LocalDate.of(2021, 03, 02)).build();
		User user3 = User.builder().withName("yuli").withEmail("yuli@gmail.com")
				.withFecah(LocalDate.of(2021, 03, 20)).build();
		User user4 = User.builder().withName("daniel").withEmail("daniel@gmail.com")
				.withFecah(LocalDate.of(2021, 04, 02)).build();
		User user5 = User.builder().withName("juan").withEmail("juan@gmail.com")
				.withFecah(LocalDate.of(2021, 04, 02)).build();
		User user6 = User.builder().withName("pablo").withEmail("pablo@gmail.com")
				.withFecah(LocalDate.of(2021, 05, 02)).build();

		List<User> usersList = Arrays.asList(user1, user3, user4, user5, user6);

		usersList.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		dependency.saludar();
		myBean.print();
		myBeanWithDependency.printhWithDependency();
		System.out.println(beanWithProperties.funcion());
		System.out.println(userPojo.getEmail()+" - "+userPojo.getPassword());

		try{
			int value = 10/0;
			log.debug("mi valor: "+value);
		}catch (Exception e){
			log.error("esto es un error dividir 0 "+e.getMessage()+" "+e.getStackTrace());
		}
	}
}
