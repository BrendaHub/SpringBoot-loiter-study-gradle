package com.loiter.profile;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnvironmentConditionProfile implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        return environment.acceptsProfiles(Profiles.of("even"));
    }
}
