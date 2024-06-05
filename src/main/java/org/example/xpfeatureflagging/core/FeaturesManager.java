package org.example.xpfeatureflagging.core;

public interface FeaturesManager {
    boolean isFeatureEnabled(String projectId, String featureName);
}
