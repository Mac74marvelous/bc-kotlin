// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.client

import com.aducaky.api.core.ClientOptions
import com.aducaky.api.core.getPackageVersion
import com.aducaky.api.services.async.PetServiceAsync
import com.aducaky.api.services.async.PetServiceAsyncImpl
import com.aducaky.api.services.async.StoreServiceAsync
import com.aducaky.api.services.async.StoreServiceAsyncImpl
import com.aducaky.api.services.async.UserServiceAsync
import com.aducaky.api.services.async.UserServiceAsyncImpl
import java.util.function.Consumer

class AducakyClientAsyncImpl(private val clientOptions: ClientOptions) : AducakyClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: AducakyClient by lazy { AducakyClientImpl(clientOptions) }

    private val withRawResponse: AducakyClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val pet: PetServiceAsync by lazy { PetServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val store: StoreServiceAsync by lazy {
        StoreServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val user: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): AducakyClient = sync

    override fun withRawResponse(): AducakyClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AducakyClientAsync =
        AducakyClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun pet(): PetServiceAsync = pet

    override fun store(): StoreServiceAsync = store

    override fun user(): UserServiceAsync = user

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AducakyClientAsync.WithRawResponse {

        private val pet: PetServiceAsync.WithRawResponse by lazy {
            PetServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val store: StoreServiceAsync.WithRawResponse by lazy {
            StoreServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val user: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AducakyClientAsync.WithRawResponse =
            AducakyClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun pet(): PetServiceAsync.WithRawResponse = pet

        override fun store(): StoreServiceAsync.WithRawResponse = store

        override fun user(): UserServiceAsync.WithRawResponse = user
    }
}
