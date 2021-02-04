// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The Components15Gvwi3SchemasTasksstatePropertiesTasksPropertiesEntityrecognitiontasksItemsAllof1 model. */
@Fluent
public class Components15Gvwi3SchemasTasksstatePropertiesTasksPropertiesEntityrecognitiontasksItemsAllof1 {
    /*
     * The results property.
     */
    @JsonProperty(value = "results", required = true)
    private EntitiesResult results;

    /**
     * Get the results property: The results property.
     *
     * @return the results value.
     */
    public EntitiesResult getResults() {
        return this.results;
    }

    /**
     * Set the results property: The results property.
     *
     * @param results the results value to set.
     * @return the Components15Gvwi3SchemasTasksstatePropertiesTasksPropertiesEntityrecognitiontasksItemsAllof1 object
     *     itself.
     */
    public Components15Gvwi3SchemasTasksstatePropertiesTasksPropertiesEntityrecognitiontasksItemsAllof1 setResults(
            EntitiesResult results) {
        this.results = results;
        return this;
    }
}
