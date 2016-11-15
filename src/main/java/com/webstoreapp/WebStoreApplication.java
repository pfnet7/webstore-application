package com.webstoreapp;

import io.swagger.jaxrs.config.BeanConfig;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class WebStoreApplication extends Application {

    public WebStoreApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setResourcePackage("com.webstoreapp");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(UserController.class);
        resources.add(OfferController.class);

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }

}
