package com.ayush.ecommerce.config;

import com.ayush.ecommerce.entity.Country;
import com.ayush.ecommerce.entity.Product;
import com.ayush.ecommerce.entity.ProductCategory;
import com.ayush.ecommerce.entity.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    public MyDataRestConfig(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        // disable HTTP methods for Product: PUT, POST, DELETE and PATCH
        disableHttpMethods(Product.class,config, theUnsupportedActions);

        // disable HTTP methods for ProductCategory: PUT, POST, DELETE and PATCH
        disableHttpMethods(ProductCategory.class,config, theUnsupportedActions);

        // disable HTTP methods for Countries: PUT, POST, DELETE and PATCH
        disableHttpMethods(Country.class,config, theUnsupportedActions);

        // disable HTTP methods for States: PUT, POST, DELETE and PATCH
        disableHttpMethods(States.class,config, theUnsupportedActions);

        // call an internal helper method to expose the id's

        expose(config);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void expose(RepositoryRestConfiguration config) {
        // get a list of all entity classes from entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array of entity types
        List<Class> entityClasses = new ArrayList<>();

        // get the entity types for those entities
        for (EntityType type : entities){
            entityClasses.add(type.getJavaType());
        }

        // expose the entity id's for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}