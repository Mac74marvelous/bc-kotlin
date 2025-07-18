// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.services.async

import com.aducaky.api.core.ClientOptions
import com.aducaky.api.core.RequestOptions
import com.aducaky.api.core.handlers.errorBodyHandler
import com.aducaky.api.core.handlers.errorHandler
import com.aducaky.api.core.handlers.jsonHandler
import com.aducaky.api.core.http.HttpMethod
import com.aducaky.api.core.http.HttpRequest
import com.aducaky.api.core.http.HttpResponse
import com.aducaky.api.core.http.HttpResponse.Handler
import com.aducaky.api.core.http.HttpResponseFor
import com.aducaky.api.core.http.parseable
import com.aducaky.api.core.prepareAsync
import com.aducaky.api.models.store.StoreListInventoryParams
import com.aducaky.api.models.store.StoreListInventoryResponse
import com.aducaky.api.services.async.store.OrderServiceAsync
import com.aducaky.api.services.async.store.OrderServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class StoreServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    StoreServiceAsync {

    private val withRawResponse: StoreServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val order: OrderServiceAsync by lazy { OrderServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): StoreServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StoreServiceAsync =
        StoreServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun order(): OrderServiceAsync = order

    override fun listInventory(
        params: StoreListInventoryParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<StoreListInventoryResponse> =
        // get /store/inventory
        withRawResponse().listInventory(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StoreServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val order: OrderServiceAsync.WithRawResponse by lazy {
            OrderServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StoreServiceAsync.WithRawResponse =
            StoreServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun order(): OrderServiceAsync.WithRawResponse = order

        private val listInventoryHandler: Handler<StoreListInventoryResponse> =
            jsonHandler<StoreListInventoryResponse>(clientOptions.jsonMapper)

        override fun listInventory(
            params: StoreListInventoryParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StoreListInventoryResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "inventory")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listInventoryHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
