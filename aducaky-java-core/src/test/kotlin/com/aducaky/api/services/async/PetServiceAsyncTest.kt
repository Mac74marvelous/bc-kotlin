// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.services.async

import com.aducaky.api.TestServerExtension
import com.aducaky.api.client.okhttp.AducakyOkHttpClientAsync
import com.aducaky.api.models.pet.Category
import com.aducaky.api.models.pet.Pet
import com.aducaky.api.models.pet.PetCreateParams
import com.aducaky.api.models.pet.PetFindByStatusParams
import com.aducaky.api.models.pet.PetFindByTagsParams
import com.aducaky.api.models.pet.PetUpdateByIdParams
import com.aducaky.api.models.pet.PetUpdateParams
import com.aducaky.api.models.pet.PetUploadImageParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PetServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pet()

        val petFuture =
            petServiceAsync.create(
                PetCreateParams.builder()
                    .pet(
                        Pet.builder()
                            .name("doggie")
                            .addPhotoUrl("string")
                            .id(10L)
                            .category(Category.builder().id(1L).name("Dogs").build())
                            .status(Pet.Status.AVAILABLE)
                            .addTag(Pet.Tag.builder().id(0L).name("name").build())
                            .build()
                    )
                    .build()
            )

        val pet = petFuture.get()
        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pet()

        val petFuture = petServiceAsync.retrieve(0L)

        val pet = petFuture.get()
        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun update() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pet()

        val petFuture =
            petServiceAsync.update(
                PetUpdateParams.builder()
                    .pet(
                        Pet.builder()
                            .name("doggie")
                            .addPhotoUrl("string")
                            .id(10L)
                            .category(Category.builder().id(1L).name("Dogs").build())
                            .status(Pet.Status.AVAILABLE)
                            .addTag(Pet.Tag.builder().id(0L).name("name").build())
                            .build()
                    )
                    .build()
            )

        val pet = petFuture.get()
        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun delete() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pet()

        val future = petServiceAsync.delete(0L)

        val response = future.get()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun findByStatus() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pet()

        val petsFuture =
            petServiceAsync.findByStatus(
                PetFindByStatusParams.builder()
                    .status(PetFindByStatusParams.Status.AVAILABLE)
                    .build()
            )

        val pets = petsFuture.get()
        pets.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun findByTags() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pet()

        val petsFuture =
            petServiceAsync.findByTags(PetFindByTagsParams.builder().addTag("string").build())

        val pets = petsFuture.get()
        pets.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun updateById() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pet()

        val future =
            petServiceAsync.updateById(
                PetUpdateByIdParams.builder().petId(0L).name("name").status("status").build()
            )

        val response = future.get()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun uploadImage() {
        val client =
            AducakyOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pet()

        val responseFuture =
            petServiceAsync.uploadImage(
                PetUploadImageParams.builder()
                    .petId(0L)
                    .additionalMetadata("additionalMetadata")
                    .image("some content")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
