// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.client

import com.aducaky.api.core.ClientOptions
import com.aducaky.api.core.getPackageVersion
import com.aducaky.api.services.blocking.PetService
import com.aducaky.api.services.blocking.PetServiceImpl
import com.aducaky.api.services.blocking.StoreService
import com.aducaky.api.services.blocking.StoreServiceImpl
import com.aducaky.api.services.blocking.UserService
import com.aducaky.api.services.blocking.UserServiceImpl
import java.util.function.Consumer

class AducakyClientImpl(private val clientOptions: ClientOptions) : AducakyClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: AducakyClientAsync by lazy { AducakyClientAsyncImpl(clientOptions) }

    private val withRawResponse: AducakyClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pet: PetService by lazy { PetServiceImpl(clientOptionsWithUserAgent) }

    private val store: StoreService by lazy { StoreServiceImpl(clientOptionsWithUserAgent) }

    private val user: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): AducakyClientAsync = async

    override fun withRawResponse(): AducakyClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AducakyClient =
        AducakyClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun pet(): PetService = pet

    override fun store(): StoreService = store

    override fun user(): UserService = user

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AducakyClient.WithRawResponse {

        private val pet: PetService.WithRawResponse by lazy {
            PetServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val store: StoreService.WithRawResponse by lazy {
            StoreServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val user: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AducakyClient.WithRawResponse =
            AducakyClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pet(): PetService.WithRawResponse = pet

        override fun store(): StoreService.WithRawResponse = store

        override fun user(): UserService.WithRawResponse = user
    }
}
