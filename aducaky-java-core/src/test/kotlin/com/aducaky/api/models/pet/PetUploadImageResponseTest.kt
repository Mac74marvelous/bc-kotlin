// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.models.pet

import com.aducaky.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PetUploadImageResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val petUploadImageResponse =
            PetUploadImageResponse.builder().code(0).message("message").type("type").build()

        assertThat(petUploadImageResponse.code()).contains(0)
        assertThat(petUploadImageResponse.message()).contains("message")
        assertThat(petUploadImageResponse.type()).contains("type")
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val petUploadImageResponse =
            PetUploadImageResponse.builder().code(0).message("message").type("type").build()

        val roundtrippedPetUploadImageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(petUploadImageResponse),
                jacksonTypeRef<PetUploadImageResponse>(),
            )

        assertThat(roundtrippedPetUploadImageResponse).isEqualTo(petUploadImageResponse)
    }
}
