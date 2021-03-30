// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The Components1D9IzucSchemasTasksstatePropertiesTasksPropertiesKeyphraseextractiontasksItemsAllof1 model. */
@Fluent
public class Components1D9IzucSchemasTasksstatePropertiesTasksPropertiesKeyphraseextractiontasksItemsAllof1 {
    /*
     * The results property.
     */
    @JsonProperty(value = "results", required = true)
    private KeyPhraseResult results;

    /**
     * Get the results property: The results property.
     *
     * @return the results value.
     */
    public KeyPhraseResult getResults() {
        return this.results;
    }

    /**
     * Set the results property: The results property.
     *
     * @param results the results value to set.
     * @return the Components1D9IzucSchemasTasksstatePropertiesTasksPropertiesKeyphraseextractiontasksItemsAllof1 object
     *     itself.
     */
    public Components1D9IzucSchemasTasksstatePropertiesTasksPropertiesKeyphraseextractiontasksItemsAllof1 setResults(
            KeyPhraseResult results) {
        this.results = results;
        return this;
    }
}
