package com.onnet.databinding.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SingleDataItem : Serializable {
    @SerializedName("adult")
    var adult: Boolean? = null

    @SerializedName("ageLimit")
    var ageLimit: String? = null

    @SerializedName("ageRestriction")
    var ageRestriction: Long? = null

    @SerializedName("castncrew")
    var castncrew: String? = null

    @SerializedName("catalogSlug")
    var catalogSlug: String? = null

    @SerializedName("contentType")
    var contentType: String? = null

    @SerializedName("cpname")
    var cpname: String? = null

    @SerializedName("deeplink")
    var deeplink: String? = null

    @SerializedName("deeplinkApp")
    var deeplinkApp: String? = null

    @SerializedName("downloadable")
    var downloadable: Boolean? = null

    @SerializedName("dr")
    var dr: Long? = null

    @SerializedName("ds")
    var ds: String? = null

    @SerializedName("episodeNo")
    var episodeNo: String? = null

    @SerializedName("episodeNumber")
    var episodeNumber: String? = null

    @SerializedName("free")
    var free: Boolean? = null

    @SerializedName("genres")
    var genres: String? = null

    @SerializedName("id")
    var id: Long? = null

    @SerializedName("landscapeImage")
    var landscapeImage: String? = null

    @SerializedName("ln")
    var ln: String? = null

    @SerializedName("masterParentId")
    var masterParentId: String? = null

    @SerializedName("nfdcContent")
    var nfdcContent: Boolean? = null

    @SerializedName("panaromicImage")
    var panaromicImage: String? = null

    @SerializedName("parentId")
    var parentId: String? = null

    @SerializedName("playbackType")
    var playbackType: String? = null

    @SerializedName("releaseDate")
    var releaseDate: String? = null

    @SerializedName("rights")
    var rights: String? = null

    @SerializedName("sds")
    var sds: String? = null

    @SerializedName("seasonNo")
    var seasonNo: String? = null

    @SerializedName("subtitleLanguage")
    var subtitleLanguage: String? = null

    @SerializedName("subtitleUrl")
    var subtitleUrl: String? = null

    @SerializedName("tags")
    var tags: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("weburl")
    var weburl: String? = null
}