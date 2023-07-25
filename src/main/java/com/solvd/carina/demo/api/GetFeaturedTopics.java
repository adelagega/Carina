package com.solvd.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url="${base_url}/topics?orderby=featured&page=${page}&client_id=${client_id}", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetFeaturedTopics extends AbstractApiMethodV2 {

    public GetFeaturedTopics(int page) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("page", String.valueOf(page));
        replaceUrlPlaceholder("client_id", Configuration.getRequired("access_key"));
    }
}
