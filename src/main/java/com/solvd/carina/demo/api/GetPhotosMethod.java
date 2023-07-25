package com.solvd.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url="${base_url}/search/photos?per_page=${per_page}&query=${query}&client_id=${client_id}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPhotosMethod extends AbstractApiMethodV2 {
    public GetPhotosMethod(String query, int perPage) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("per_page", String.valueOf(perPage));
        replaceUrlPlaceholder("query", query);
        replaceUrlPlaceholder("client_id",Configuration.getRequired("access_key"));
    }
}

