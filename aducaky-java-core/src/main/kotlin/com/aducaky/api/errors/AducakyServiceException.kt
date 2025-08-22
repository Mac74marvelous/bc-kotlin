// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.errors

import com.aducaky.api.core.JsonValue
import com.aducaky.api.core.http.Headers

abstract class AducakyServiceException
protected constructor(message: String, cause: Throwable? = null) :
    AducakyException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
