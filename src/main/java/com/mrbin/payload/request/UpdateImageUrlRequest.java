package com.mrbin.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateImageUrlRequest {
    @JsonProperty("collection")
    private String collection;

    @JsonProperty("query-param")
    private String queryParam;

    @JsonProperty("public_id")
    private String publicId;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("public_id_list")
    private List<String> publicIdLIst;

    @JsonProperty("image_url_list")
    private List<String> imageUrlList;

    public UpdateImageUrlRequest(String collection, String publicId, String imageUrl) {
        this.collection = collection;
        this.publicId = publicId;
        this.imageUrl = imageUrl;
    }

    public UpdateImageUrlRequest(String collection, List<String> publicIdLIst, List<String> imageUrlList) {
        this.collection = collection;
        this.publicIdLIst = publicIdLIst;
        this.imageUrlList = imageUrlList;
    }
}
