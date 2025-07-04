@file:JvmName("EmptyHandler")

package com.aducaky.api.core.handlers

import com.aducaky.api.core.http.HttpResponse
import com.aducaky.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
