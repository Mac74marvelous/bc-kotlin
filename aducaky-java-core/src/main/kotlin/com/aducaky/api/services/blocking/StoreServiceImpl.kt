// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.services.blocking

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
import com.aducaky.api.core.prepare
import com.aducaky.api.models.store.StoreListInventoryParams
import com.aducaky.api.models.store.StoreListInventoryResponse
import com.aducaky.api.services.blocking.store.OrderService
import com.aducaky.api.services.blocking.store.OrderServiceImpl
import java.util.function.Consumer

class StoreServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    StoreService {

    private val withRawResponse: StoreService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val order: OrderService by lazy { OrderServiceImpl(clientOptions) }

    override fun withRawResponse(): StoreService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StoreService =
        StoreServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun order(): OrderService = order

    override fun listInventory(
        params: StoreListInventoryParams,
        requestOptions: RequestOptions,
    ): StoreListInventoryResponse =
        // get /store/inventory
        withRawResponse().listInventory(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StoreService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val order: OrderService.WithRawResponse by lazy {
            OrderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StoreService.WithRawResponse =
            StoreServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun order(): OrderService.WithRawResponse = order

        private val listInventoryHandler: Handler<StoreListInventoryResponse> =
            jsonHandler<StoreListInventoryResponse>(clientOptions.jsonMapper)

        override fun listInventory(
            params: StoreListInventoryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StoreListInventoryResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "inventory")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
