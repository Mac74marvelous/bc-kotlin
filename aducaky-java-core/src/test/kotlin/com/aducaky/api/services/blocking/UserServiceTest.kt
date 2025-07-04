// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.services.blocking

import com.aducaky.api.TestServerExtension
import com.aducaky.api.client.okhttp.AducakyOkHttpClient
import com.aducaky.api.models.user.User
import com.aducaky.api.models.user.UserCreateParams
import com.aducaky.api.models.user.UserCreateWithListParams
import com.aducaky.api.models.user.UserLoginParams
import com.aducaky.api.models.user.UserUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.user()

        val user =
            userService.create(
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

        user.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.user()

        val user = userService.retrieve("username")

        user.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun update() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.user()

        userService.update(
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
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun delete() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.user()

        userService.delete("username")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createWithList() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.user()

        val user =
            userService.createWithList(
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

        user.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun login() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.user()

        userService.login(
            UserLoginParams.builder().password("password").username("username").build()
        )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun logout() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val userService = client.user()

        userService.logout()
    }
}
