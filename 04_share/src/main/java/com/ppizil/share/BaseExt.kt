package com.ppizil.share

import kotlin.coroutines.cancellation.CancellationException

public suspend inline fun <R> runSuspendCatching(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch(c: CancellationException) {
        throw c
    } catch (e: Throwable) {
        Result.failure(e)
    }
}