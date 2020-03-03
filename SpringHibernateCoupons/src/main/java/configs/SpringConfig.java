package configs;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"db","beans"})
@PropertySource("classpath:app.properties")
@EnableTransactionManagement//an obligation to use transaction wrapping in every action
public class SpringConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getDataSource() {//database connections manager
		DriverManagerDataSource dati= new DriverManagerDataSource(env.getProperty("db.url"),env.getProperty("db.username"),env.getProperty("db.password"));
		dati.setDriverClassName(env.getProperty("db.driver"));
		return dati;
		
	}
	
	@Bean
	public LocalSessionFactoryBean getFactory() {//creates the real connection to database, using data-source. writes himself the sql query, ises jdbc template
		//with the help of JPA library writes. only needs to know the hibernate entities. uses reflection->
		//at the runtime does the calculation by looking and scanning for annotations
		LocalSessionFactoryBean factory= new LocalSessionFactoryBean();
		factory.setPackagesToScan("beans");
		factory.setDataSource(getDataSource());
		Properties hibernateProps= new Properties();
		hibernateProps.setProperty("hibernate.hbm2ddl.auto", "update");
		factory.setHibernateProperties(hibernateProps);
		return factory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getHibernateManager(SessionFactory getFactory) {
		//transaction- checks the phases of the statement i want to execute.only allows full fulfillment 
		HibernateTransactionManager hibi=new HibernateTransactionManager();
		hibi.setSessionFactory(getFactory);
			return hibi;
		
	}
	
	
}
