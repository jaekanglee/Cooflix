package com.ppizil.domain.usecase

import com.ppizil.domain.model.ParamMovieEntity
import javax.inject.Inject

class CreateMoveListParamImpl @Inject constructor() : CreateMoveListParam {
    override suspend fun invoke(param : ParamMovieEntity): HashMap<String, String> =
        param
            .run {

                HashMap<String, String>().apply {
                    if (!language.isNullOrBlank()) put("language", language)
                    if (!region.isNullOrBlank()) put("region", region)
                }
            }
}