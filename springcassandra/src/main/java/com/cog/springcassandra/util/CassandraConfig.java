package com.cog.springcassandra.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.cassandra.config.DataCenterReplication;
import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
@EnableCassandraRepositories(basePackages = { "org.spring.cassandra.example.repo" })
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public CassandraCqlClusterFactoryBean cluster() {
		CassandraCqlClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(env.getProperty("cassandra.contactpoints"));
		cluster.setPort(Integer.parseInt(env.getProperty("cassandra.port")));
		cluster.setKeyspaceCreations(getKeyspaceCreations());
		cluster.setUsername(env.getProperty("cassandra.username"));
		cluster.setPassword(env.getProperty("cassandra.password"));
		return cluster;
	}

	@Override
	protected String getKeyspaceName() {
		 return env.getProperty("cassandra.keyspace");
	}
	
	  @Override
	    public SchemaAction getSchemaAction() {
	        return SchemaAction.CREATE_IF_NOT_EXISTS;
	    }

	   

	    @Override
	    public String[] getEntityBasePackages() {
	        return new String[]{"com.cog.springcassandra.data"};
	    }

	    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
	        List<CreateKeyspaceSpecification> createKeyspaceSpecifications = new ArrayList<>();
	        createKeyspaceSpecifications.add(getKeySpaceSpecification());
	        return createKeyspaceSpecifications;
	    }
	    
	    
	    private CreateKeyspaceSpecification getKeySpaceSpecification() {
	        CreateKeyspaceSpecification keyspaceSpecification = new CreateKeyspaceSpecification();
	        DataCenterReplication dcr = new DataCenterReplication("datacenter1", 3L);
	        keyspaceSpecification.name(env.getProperty("cassandra.keyspace"));
	        keyspaceSpecification.ifNotExists(true).createKeyspace().withNetworkReplication(dcr);
	        return keyspaceSpecification;
	    }
}
