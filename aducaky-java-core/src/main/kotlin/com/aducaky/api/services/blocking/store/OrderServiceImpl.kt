// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.services.blocking.store

import com.aducaky.api.core.ClientOptions
import com.aducaky.api.core.JsonValue
import com.aducaky.api.core.RequestOptions
import com.aducaky.api.core.checkRequired
import com.aducaky.api.core.handlers.emptyHandler
import com.aducaky.api.core.handlers.errorHandler
import com.aducaky.api.core.handlers.jsonHandler
import com.aducaky.api.core.handlers.withErrorHandler
import com.aducaky.api.core.http.HttpMethod
import com.aducaky.api.core.http.HttpRequest
import com.aducaky.api.core.http.HttpResponse
import com.aducaky.api.core.http.HttpResponse.Handler
import com.aducaky.api.core.http.HttpResponseFor
import com.aducaky.api.core.http.json
import com.aducaky.api.core.http.parseable
import com.aducaky.api.core.prepare
import com.aducaky.api.models.Order
import com.aducaky.api.models.store.order.OrderCreateParams
import com.aducaky.api.models.store.order.OrderDeleteParams
import com.aducaky.api.models.store.order.OrderRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class OrderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderService {

    private val withRawResponse: OrderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OrderService =
        OrderServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(params: OrderCreateParams, requestOptions: RequestOptions): Order =
        // post /store/order
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: OrderRetrieveParams, requestOptions: RequestOptions): Order =
        // get /store/order/{orderId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun delete(params: OrderDeleteParams, requestOptions: RequestOptions) {
        // delete /store/order/{orderId}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OrderService.WithRawResponse =
            OrderServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Order> =
            jsonHandler<Order>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: OrderCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "order")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Order> =
            jsonHandler<Order>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: OrderRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderId", params.orderId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "order", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

        override fun delete(
            params: OrderDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("orderId", params.orderId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "order", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { deleteHandler.handle(it) } }
        }
    }
}
