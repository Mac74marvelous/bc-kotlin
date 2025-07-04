// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.services.blocking

import com.aducaky.api.TestServerExtension
import com.aducaky.api.client.okhttp.AducakyOkHttpClient
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
internal class PetServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pet()

        val pet =
            petService.create(
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

        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun retrieve() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pet()

        val pet = petService.retrieve(0L)

        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun update() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pet()

        val pet =
            petService.update(
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

        pet.validate()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun delete() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pet()

        petService.delete(0L)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun findByStatus() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pet()

        val pets =
            petService.findByStatus(
                PetFindByStatusParams.builder()
                    .status(PetFindByStatusParams.Status.AVAILABLE)
                    .build()
            )

        pets.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun findByTags() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pet()

        val pets = petService.findByTags(PetFindByTagsParams.builder().addTag("string").build())

        pets.forEach { it.validate() }
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun updateById() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pet()

        petService.updateById(
            PetUpdateByIdParams.builder().petId(0L).name("name").status("status").build()
        )
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun uploadImage() {
        val client =
            AducakyOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pet()

        val response =
            petService.uploadImage(
                PetUploadImageParams.builder()
                    .petId(0L)
                    .additionalMetadata("additionalMetadata")
                    .image("some content")
                    .build()
            )

        response.validate()
    }
}
