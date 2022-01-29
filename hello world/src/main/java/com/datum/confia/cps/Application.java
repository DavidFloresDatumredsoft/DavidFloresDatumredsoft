package com.datum.confia.cps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    /**
     * Main method to start the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
      return builder.sources(Application.class);
    }

/*
    @Bean 
    public CassandraClusterFactoryBean cluster() { 
    	CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean(); 
    	cluster.setContactPoints(environment.getProperty("spring.data.cassandra.contact-points")); 
    	cluster.setPort(Integer.parseInt(environment.getProperty("spring.data.cassandra.port"))); 
    	cluster.setJmxReportingEnabled(false);
    	return cluster; 
    }

*/
/*
    @Bean
    public BrokerService broker() throws Exception {
        final BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:5671");
        broker.setBrokerName("broker");
        broker.setUseJmx(false);
        return broker;
    }
    */
    
    /*
    @Bean
    public ActiveMQConnectionFactory amqpConnection() {
    	ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

    	connectionFactory.setBrokerURL("tcp://172.16.2.199:61616");
    	connectionFactory.setUserName("amq-broker");
    	connectionFactory.setPassword("AmqDev2021.");
    	
    	return connectionFactory;
    }*/
}