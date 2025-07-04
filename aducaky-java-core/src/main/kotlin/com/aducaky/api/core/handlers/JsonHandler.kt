@file:JvmName("JsonHandler")

package com.aducaky.api.core.handlers

import com.aducaky.api.core.http.HttpResponse
import com.aducaky.api.core.http.HttpResponse.Handler
import com.aducaky.api.errors.AducakyInvalidDataException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw AducakyInvalidDataException("Error reading response", e)
            }
    }
