package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency dependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	public FundamentosApplication(
			@Qualifier("componentTwoImpl") ComponentDependency dependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency)
	{
		this.dependency = dependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dependency.saludar();
		myBean.print();
		myBeanWithDependency.printhWithDependency();
	}
}
