// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The DocumentError model. */
@Fluent
public final class DocumentError {
    /*
     * Document Id.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

    /*
     * Document Error.
     */
    @JsonProperty(value = "error", required = true)
    private TextAnalyticsError error;

    /**
     * Get the id property: Document Id.
     *
     * @return the id value.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: Document Id.
     *
     * @param id the id value to set.
     * @return the DocumentError object itself.
     */
    public DocumentError setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the error property: Document Error.
     *
     * @return the error value.
     */
    public TextAnalyticsError getError() {
        return this.error;
    }

    /**
     * Set the error property: Document Error.
     *
     * @param error the error value to set.
     * @return the DocumentError object itself.
     */
    public DocumentError setError(TextAnalyticsError error) {
        this.error = error;
        return this;
    }
}