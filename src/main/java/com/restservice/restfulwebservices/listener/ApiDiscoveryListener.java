package com.restservice.restfulwebservices.listener;

import com.ca.mfaas.eurekaservice.client.ApiMediationClient;
import com.ca.mfaas.eurekaservice.client.config.ApiMediationServiceConfig;
import com.ca.mfaas.eurekaservice.client.impl.ApiMediationClientImpl;
import com.ca.mfaas.eurekaservice.client.util.ApiMediationServiceConfigReader;
import com.ca.mfaas.exception.ServiceDefinitionException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApiDiscoveryListener implements ServletContextListener {
    private ApiMediationClient apiMediationClient;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        apiMediationClient = new ApiMediationClientImpl();
        String configurationFile = "/application.yml";
        ApiMediationServiceConfig config = new ApiMediationServiceConfigReader(configurationFile).readConfiguration();
        try {
            apiMediationClient.register(config);
        } catch (ServiceDefinitionException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        apiMediationClient.unregister();
    }
}
