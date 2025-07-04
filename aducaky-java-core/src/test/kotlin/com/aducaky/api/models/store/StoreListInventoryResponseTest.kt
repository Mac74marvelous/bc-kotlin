// File generated from our OpenAPI spec by Stainless.

package com.aducaky.api.models.store

import com.aducaky.api.core.JsonValue
import com.aducaky.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class StoreListInventoryResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val storeListInventoryResponse =
            StoreListInventoryResponse.builder()
                .putAdditionalProperty("foo", JsonValue.from(0))
                .build()
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val storeListInventoryResponse =
            StoreListInventoryResponse.builder()
                .putAdditionalProperty("foo", JsonValue.from(0))
                .build()

        val roundtrippedStoreListInventoryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(storeListInventoryResponse),
                jacksonTypeRef<StoreListInventoryResponse>(),
            )

        assertThat(roundtrippedStoreListInventoryResponse).isEqualTo(storeListInventoryResponse)
    }
}
