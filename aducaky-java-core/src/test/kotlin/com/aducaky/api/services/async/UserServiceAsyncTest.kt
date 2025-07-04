// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.services.async

import com.aducaky.api.TestServerExtension
import com.aducaky.api.client.okhttp.AducakyOkHttpClientAsync
import com.aducaky.api.models.user.User
import com.aducaky.api.models.user.UserCreateParams
import com.aducaky.api.models.user.UserCreateWithListParams
import com.aducaky.api.models.user.UserLoginParams
import com.aducaky.api.models.user.UserUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val userFuture =
            userServiceAsync.create(
                UserCreateParams.builder()
                    .user(
                        User.builder()
                            .id(10L)
                            .email("john@email.com")
                            .firstName("John")
                            .lastName("James")
                            .password("12345")
                            .phone("12345")
                            .username("theUser")
                            .userStatus(1)
                            .build()
                    )
                    .build()
            )

        val user = userFuture.get()
        user.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val userFuture = userServiceAsync.retrieve("username")

        val user = userFuture.get()
        user.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun update() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val future =
            userServiceAsync.update(
                UserUpdateParams.builder()
                    .existingUsername("username")
                    .user(
                        User.builder()
                            .id(10L)
                            .email("john@email.com")
                            .firstName("John")
                            .lastName("James")
                            .password("12345")
                            .phone("12345")
                            .username("theUser")
                            .userStatus(1)
                            .build()
                    )
                    .build()
            )

        val response = future.get()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun delete() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val future = userServiceAsync.delete("username")

        val response = future.get()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createWithList() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val userFuture =
            userServiceAsync.createWithList(
                UserCreateWithListParams.builder()
                    .addItem(
                        User.builder()
                            .id(10L)
                            .email("john@email.com")
                            .firstName("John")
                            .lastName("James")
                            .password("12345")
                            .phone("12345")
                            .username("theUser")
                            .userStatus(1)
                            .build()
                    )
                    .build()
            )

        val user = userFuture.get()
        user.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun login() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val responseFuture =
            userServiceAsync.login(
                UserLoginParams.builder().password("password").username("username").build()
            )

        val response = responseFuture.get()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun logout() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userServiceAsync = client.user()

        val future = userServiceAsync.logout()

        val response = future.get()
    }
}
