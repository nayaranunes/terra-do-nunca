package br.com.nayaranunes.terradonunca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@EntityScan("br.com.nayaranunes.terradonunca.domain")///{DataSourceAutoConfiguration.class})
public class TerradonuncaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerradonuncaApplication.class, args);
	}

}
