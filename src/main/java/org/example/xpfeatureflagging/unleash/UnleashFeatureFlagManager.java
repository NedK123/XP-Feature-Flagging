package org.example.xpfeatureflagging.unleash;

import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import lombok.AllArgsConstructor;
import org.example.xpfeatureflagging.core.FeaturesManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UnleashFeatureFlagManager implements FeaturesManager {

    private Unleash unleash;

    @Override
    public boolean isFeatureEnabled(String projectId, String featureName) {
        System.out.println(projectId + " " + featureName);
        return unleash.isEnabled(featureName, UnleashContext.builder().addProperty("mxevolve-project", projectId).build());
    }

}
