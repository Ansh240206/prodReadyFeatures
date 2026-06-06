package com.project.prodReadyFeatures.Auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        //Get Security Context
        //Get Authentication
        //Get the principle
        //Get the username
        return Optional.of("GitButtowski");
    }
}
