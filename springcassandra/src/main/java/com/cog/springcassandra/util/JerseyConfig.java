package com.cog.springcassandra.util;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.cog.springcassandra.controller.FileUploadController;
import com.cog.springcassandra.controller.ProductController;
import com.cog.springcassandra.controller.UserController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(UserController.class);
		register(ProductController.class);
		register(FileUploadController.class);
		
		/* Required for support of Multipart-FileUpload */
		register(MultiPartFeature.class);
	}

	@PostConstruct
	public void init() {
		this.configureSwagger();
	}

	private void configureSwagger() {
		 // Available at localhost:port/api/swagger.json
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setConfigId("SpringCassandra Application");
		config.setTitle("Spring Boot + Jersey + Swagger + Cassandra Application");
		config.setVersion("v1");
		config.setContact("Gurusharan Gupta");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath("/api");
		config.setResourcePackage("com.cog.springcassandra");
		config.setPrettyPrint(true);
		config.setScan(true);
	}

}
