// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The JobManifest model. */
@Fluent
public class JobManifest {
    /*
     * The set of tasks to execute on the input documents. Cannot specify the
     * same task more than once.
     */
    @JsonProperty(value = "tasks", required = true)
    private JobManifestTasks tasks;

    /**
     * Get the tasks property: The set of tasks to execute on the input documents. Cannot specify the same task more
     * than once.
     *
     * @return the tasks value.
     */
    public JobManifestTasks getTasks() {
        return this.tasks;
    }

    /**
     * Set the tasks property: The set of tasks to execute on the input documents. Cannot specify the same task more
     * than once.
     *
     * @param tasks the tasks value to set.
     * @return the JobManifest object itself.
     */
    public JobManifest setTasks(JobManifestTasks tasks) {
        this.tasks = tasks;
        return this;
    }
}
