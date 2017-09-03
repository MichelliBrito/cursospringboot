package com.eventosapp;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {

	@Bean
    public DataSource dataSource(){//cria um bean datasource, ou seja, uma conexao com o banco mysql
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
        dataSource.setUsername("root");
        dataSource.setPassword("michelli14");
        return dataSource;
    }
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){//cria um bean Hibernate
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);//mostrar codigo sql no console.
		adapter.setGenerateDdl(true);//habilita para que o hibernate crie as tabelas automaticamente.
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
}
