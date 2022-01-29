package com.confia.cps.log.view.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${CPS.AMBIENTE}")
	private String sufix;
	@Value("${cassandra.host}")
	private String cassandraHost;
	@Value("${cassandra.port}")
	private String cassandraPort;
	@Value("${cassandra.keyspace}")
	private String keyspaceName;
	@Value("${cassandra.datacenter}")
	private String cassandraDatacenter;
	
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.NONE;
    }

    
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean bean = super.cluster();
        bean.setContactPoints(cassandraHost);
        bean.setPort( Integer.parseInt( cassandraPort ) );
        return bean;
    }

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.confia.cps.log.view.domain"};
    }
}
