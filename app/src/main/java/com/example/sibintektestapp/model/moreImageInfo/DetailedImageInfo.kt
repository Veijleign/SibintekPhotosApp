package com.example.sibintektestapp.model.moreImageInfo

import com.google.gson.annotations.SerializedName

//@Serializable
data class DetailedImageInfo(
    val alt_description: String,
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val downloads: Int,
    val exif: Exif,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val location: Location,
    val meta: Meta,
    val promoted_at: Any,
    val public_domain: Boolean,
    val related_collections: RelatedCollections,
    val slug: String,
    val sponsorship: Sponsorship,
    val tags: List<Tag>,
    val tags_preview: List<TagsPreview>,
    val topic_submissions: TopicSubmissions,
    val topics: List<Any>,
    val updated_at: String,
    val urls: Urls,
    val user: User,
    val views: Int,
    val width: Int
) {
    data class Exif(
        val aperture: Any,
        val exposure_time: Any,
        val focal_length: String,
        val iso: Any,
        val make: Any,
        val model: Any,
        val name: Any
    )

    data class Links(
        val download: String,
        val download_location: String,
        val html: String,
        val self: String
    )

    data class Location(
        val city: Any,
        val country: Any,
        val name: String,
        val position: Position
    ) {
        data class Position(
            val latitude: Any,
            val longitude: Any
        )
    }

    data class Meta(
        val index: Boolean
    )

    data class RelatedCollections(
        val results: List<Result>,
        val total: Int,
        val type: String
    ) {
        data class Result(
            val cover_photo: CoverPhoto,
            val curated: Boolean,
            val description: Any,
            val featured: Boolean,
            val id: String,
            val last_collected_at: String,
            val links: Links,
            val preview_photos: List<PreviewPhoto>,
            val `private`: Boolean,
            val published_at: String,
            val share_key: String,
            val tags: List<Tag>,
            val title: String,
            val total_photos: Int,
            val updated_at: String,
            val user: User
        ) {
            data class CoverPhoto(
                val alt_description: String,
                val blur_hash: String,
                val color: String,
                val created_at: String,
                val current_user_collections: List<Any>,
                val description: String,
                val height: Int,
                val id: String,
                val liked_by_user: Boolean,
                val likes: Int,
                val links: Links,
                val promoted_at: String,
                val slug: String,
                val sponsorship: Any,
                val topic_submissions: TopicSubmissions,
                val updated_at: String,
                val urls: Urls,
                val user: User,
                val width: Int
            ) {
                data class Links(
                    val download: String,
                    val download_location: String,
                    val html: String,
                    val self: String
                )

                data class TopicSubmissions(
                    val film: Film,
                    @SerializedName("food-drink")
                    val food_drink: FoodDrink
                ) {
                    data class Film(
                        val status: String
                    )

                    data class FoodDrink(
                        val status: String
                    )
                }

                data class Urls(
                    val full: String,
                    val raw: String,
                    val regular: String,
                    val small: String,
                    val small_s3: String,
                    val thumb: String
                )

                data class User(
                    val accepted_tos: Boolean,
                    val bio: String,
                    val first_name: String,
                    val for_hire: Boolean,
                    val id: String,
                    val instagram_username: String,
                    val last_name: String,
                    val links: Links,
                    val location: String,
                    val name: String,
                    val portfolio_url: String,
                    val profile_image: ProfileImage,
                    val social: Social,
                    val total_collections: Int,
                    val total_likes: Int,
                    val total_photos: Int,
                    val twitter_username: String,
                    val updated_at: String,
                    val username: String
                ) {
                    data class Links(
                        val followers: String,
                        val following: String,
                        val html: String,
                        val likes: String,
                        val photos: String,
                        val portfolio: String,
                        val self: String
                    )

                    data class ProfileImage(
                        val large: String,
                        val medium: String,
                        val small: String
                    )

                    data class Social(
                        val instagram_username: String,
                        val paypal_email: Any,
                        val portfolio_url: String,
                        val twitter_username: String
                    )
                }
            }

            data class Links(
                val html: String,
                val photos: String,
                val related: String,
                val self: String
            )

            data class PreviewPhoto(
                val blur_hash: String,
                val created_at: String,
                val id: String,
                val slug: String,
                val updated_at: String,
                val urls: Urls
            ) {
                data class Urls(
                    val full: String,
                    val raw: String,
                    val regular: String,
                    val small: String,
                    val small_s3: String,
                    val thumb: String
                )
            }

            data class Tag(
                val source: Source,
                val title: String,
                val type: String
            ) {
                data class Source(
                    val ancestry: Ancestry,
                    val cover_photo: CoverPhoto,
                    val description: String,
                    val meta_description: String,
                    val meta_title: String,
                    val subtitle: String,
                    val title: String
                ) {
                    data class Ancestry(
                        val category: Category,
                        val subcategory: Subcategory,
                        val type: Type
                    ) {
                        data class Category(
                            val pretty_slug: String,
                            val slug: String
                        )

                        data class Subcategory(
                            val pretty_slug: String,
                            val slug: String
                        )

                        data class Type(
                            val pretty_slug: String,
                            val slug: String
                        )
                    }

                    data class CoverPhoto(
                        val alt_description: String,
                        val blur_hash: String,
                        val color: String,
                        val created_at: String,
                        val current_user_collections: List<Any>,
                        val description: String,
                        val height: Int,
                        val id: String,
                        val liked_by_user: Boolean,
                        val likes: Int,
                        val links: Links,
                        val plus: Boolean,
                        val premium: Boolean,
                        val promoted_at: String,
                        val slug: String,
                        val sponsorship: Any,
                        val topic_submissions: TopicSubmissions,
                        val updated_at: String,
                        val urls: Urls,
                        val user: User,
                        val width: Int
                    ) {
                        data class Links(
                            val download: String,
                            val download_location: String,
                            val html: String,
                            val self: String
                        )

                        data class TopicSubmissions(
                            @SerializedName("architecture-interior")
                            val architecture_interior: ArchitectureInterior,
                            @SerializedName("color-of-water")
                            val color_of_water: ColorOfWater,
                            val nature: Nature,
                            @SerializedName("textures-patterns")
                            val textures_patterns: TexturesPatterns,
                            val wallpapers: Wallpapers
                        ) {
                            data class ArchitectureInterior(
                                val approved_on: String,
                                val status: String
                            )

                            data class ColorOfWater(
                                val approved_on: String,
                                val status: String
                            )

                            data class Nature(
                                val approved_on: String,
                                val status: String
                            )

                            data class TexturesPatterns(
                                val approved_on: String,
                                val status: String
                            )

                            data class Wallpapers(
                                val approved_on: String,
                                val status: String
                            )
                        }

                        data class Urls(
                            val full: String,
                            val raw: String,
                            val regular: String,
                            val small: String,
                            val small_s3: String,
                            val thumb: String
                        )

                        data class User(
                            val accepted_tos: Boolean,
                            val bio: String,
                            val first_name: String,
                            val for_hire: Boolean,
                            val id: String,
                            val instagram_username: String,
                            val last_name: String,
                            val links: Links,
                            val location: String,
                            val name: String,
                            val portfolio_url: String,
                            val profile_image: ProfileImage,
                            val social: Social,
                            val total_collections: Int,
                            val total_likes: Int,
                            val total_photos: Int,
                            val twitter_username: String,
                            val updated_at: String,
                            val username: String
                        ) {
                            data class Links(
                                val followers: String,
                                val following: String,
                                val html: String,
                                val likes: String,
                                val photos: String,
                                val portfolio: String,
                                val self: String
                            )

                            data class ProfileImage(
                                val large: String,
                                val medium: String,
                                val small: String
                            )

                            data class Social(
                                val instagram_username: String,
                                val paypal_email: Any,
                                val portfolio_url: String,
                                val twitter_username: String
                            )
                        }
                    }
                }
            }

            data class User(
                val accepted_tos: Boolean,
                val bio: String,
                val first_name: String,
                val for_hire: Boolean,
                val id: String,
                val instagram_username: String,
                val last_name: String,
                val links: Links,
                val location: Any,
                val name: String,
                val portfolio_url: String,
                val profile_image: ProfileImage,
                val social: Social,
                val total_collections: Int,
                val total_likes: Int,
                val total_photos: Int,
                val twitter_username: String,
                val updated_at: String,
                val username: String
            ) {
                data class Links(
                    val followers: String,
                    val following: String,
                    val html: String,
                    val likes: String,
                    val photos: String,
                    val portfolio: String,
                    val self: String
                )

                data class ProfileImage(
                    val large: String,
                    val medium: String,
                    val small: String
                )

                data class Social(
                    val instagram_username: String,
                    val paypal_email: Any,
                    val portfolio_url: String,
                    val twitter_username: String
                )
            }
        }
    }

    data class Sponsorship(
        val impression_urls: List<Any>,
        val sponsor: Sponsor,
        val tagline: String,
        val tagline_url: String
    ) {
        data class Sponsor(
            val accepted_tos: Boolean,
            val bio: String,
            val first_name: String,
            val for_hire: Boolean,
            val id: String,
            val instagram_username: String,
            val last_name: Any,
            val links: Links,
            val location: String,
            val name: String,
            val portfolio_url: String,
            val profile_image: ProfileImage,
            val social: Social,
            val total_collections: Int,
            val total_likes: Int,
            val total_photos: Int,
            val twitter_username: String,
            val updated_at: String,
            val username: String
        ) {
            data class Links(
                val followers: String,
                val following: String,
                val html: String,
                val likes: String,
                val photos: String,
                val portfolio: String,
                val self: String
            )

            data class ProfileImage(
                val large: String,
                val medium: String,
                val small: String
            )

            data class Social(
                val instagram_username: String,
                val paypal_email: Any,
                val portfolio_url: String,
                val twitter_username: String
            )
        }
    }

    data class Tag(
        val source: Source,
        val title: String,
        val type: String
    ) {
        data class Source(
            val ancestry: Ancestry,
            val cover_photo: CoverPhoto,
            val description: String,
            val meta_description: String,
            val meta_title: String,
            val subtitle: String,
            val title: String
        ) {
            data class Ancestry(
                val category: Category,
                val subcategory: Subcategory,
                val type: Type
            ) {
                data class Category(
                    val pretty_slug: String,
                    val slug: String
                )

                data class Subcategory(
                    val pretty_slug: String,
                    val slug: String
                )

                data class Type(
                    val pretty_slug: String,
                    val slug: String
                )
            }

            data class CoverPhoto(
                val alt_description: String,
                val blur_hash: String,
                val color: String,
                val created_at: String,
                val current_user_collections: List<Any>,
                val description: String,
                val height: Int,
                val id: String,
                val liked_by_user: Boolean,
                val likes: Int,
                val links: Links,
                val plus: Boolean,
                val premium: Boolean,
                val promoted_at: String,
                val slug: String,
                val sponsorship: Any,
                val topic_submissions: TopicSubmissions,
                val updated_at: String,
                val urls: Urls,
                val user: User,
                val width: Int
            ) {
                data class Links(
                    val download: String,
                    val download_location: String,
                    val html: String,
                    val self: String
                )

                data class TopicSubmissions(
                    @SerializedName("architecture-interior")
                    val architecture_interior: ArchitectureInterior,
                    @SerializedName("color-of-water")
                    val color_of_water: ColorOfWater,
                    val nature: Nature,
                    val wallpapers: Wallpapers
                ) {
                    data class ArchitectureInterior(
                        val approved_on: String,
                        val status: String
                    )

                    data class ColorOfWater(
                        val approved_on: String,
                        val status: String
                    )

                    data class Nature(
                        val approved_on: String,
                        val status: String
                    )

                    data class Wallpapers(
                        val approved_on: String,
                        val status: String
                    )
                }

                data class Urls(
                    val full: String,
                    val raw: String,
                    val regular: String,
                    val small: String,
                    val small_s3: String,
                    val thumb: String
                )

                data class User(
                    val accepted_tos: Boolean,
                    val bio: String,
                    val first_name: String,
                    val for_hire: Boolean,
                    val id: String,
                    val instagram_username: String,
                    val last_name: String,
                    val links: Links,
                    val location: String,
                    val name: String,
                    val portfolio_url: String,
                    val profile_image: ProfileImage,
                    val social: Social,
                    val total_collections: Int,
                    val total_likes: Int,
                    val total_photos: Int,
                    val twitter_username: String,
                    val updated_at: String,
                    val username: String
                ) {
                    data class Links(
                        val followers: String,
                        val following: String,
                        val html: String,
                        val likes: String,
                        val photos: String,
                        val portfolio: String,
                        val self: String
                    )

                    data class ProfileImage(
                        val large: String,
                        val medium: String,
                        val small: String
                    )

                    data class Social(
                        val instagram_username: String,
                        val paypal_email: Any,
                        val portfolio_url: String,
                        val twitter_username: String
                    )
                }
            }
        }
    }

    data class TagsPreview(
        val source: Source,
        val title: String,
        val type: String
    ) {
        data class Source(
            val ancestry: Ancestry,
            val cover_photo: CoverPhoto,
            val description: String,
            val meta_description: String,
            val meta_title: String,
            val subtitle: String,
            val title: String
        ) {
            data class Ancestry(
                val type: Type
            ) {
                data class Type(
                    val pretty_slug: String,
                    val slug: String
                )
            }

            data class CoverPhoto(
                val alt_description: String,
                val blur_hash: String,
                val color: String,
                val created_at: String,
                val current_user_collections: List<Any>,
                val description: String,
                val height: Int,
                val id: String,
                val liked_by_user: Boolean,
                val likes: Int,
                val links: Links,
                val promoted_at: String,
                val slug: String,
                val sponsorship: Any,
                val topic_submissions: TopicSubmissions,
                val updated_at: String,
                val urls: Urls,
                val user: User,
                val width: Int
            ) {
                data class Links(
                    val download: String,
                    val download_location: String,
                    val html: String,
                    val self: String
                )

                data class TopicSubmissions(
                    @SerializedName("architecture-interior")
                    val architecture_interior: ArchitectureInterior,
                    @SerializedName("color-of-water")
                    val color_of_water: ColorOfWater,
                    val wallpapers: Wallpapers
                ) {
                    data class ArchitectureInterior(
                        val approved_on: String,
                        val status: String
                    )

                    data class ColorOfWater(
                        val approved_on: String,
                        val status: String
                    )

                    data class Wallpapers(
                        val approved_on: String,
                        val status: String
                    )
                }

                data class Urls(
                    val full: String,
                    val raw: String,
                    val regular: String,
                    val small: String,
                    val small_s3: String,
                    val thumb: String
                )

                data class User(
                    val accepted_tos: Boolean,
                    val bio: String,
                    val first_name: String,
                    val for_hire: Boolean,
                    val id: String,
                    val instagram_username: String,
                    val last_name: String,
                    val links: Links,
                    val location: String,
                    val name: String,
                    val portfolio_url: String,
                    val profile_image: ProfileImage,
                    val social: Social,
                    val total_collections: Int,
                    val total_likes: Int,
                    val total_photos: Int,
                    val twitter_username: Any,
                    val updated_at: String,
                    val username: String
                ) {
                    data class Links(
                        val followers: String,
                        val following: String,
                        val html: String,
                        val likes: String,
                        val photos: String,
                        val portfolio: String,
                        val self: String
                    )

                    data class ProfileImage(
                        val large: String,
                        val medium: String,
                        val small: String
                    )

                    data class Social(
                        val instagram_username: String,
                        val paypal_email: Any,
                        val portfolio_url: String,
                        val twitter_username: Any
                    )
                }
            }
        }
    }

    class TopicSubmissions

    data class Urls(
        val full: String,
        val raw: String,
        val regular: String,
        val small: String,
        val small_s3: String,
        val thumb: String
    )

    data class User(
        val accepted_tos: Boolean,
        val bio: String,
        val first_name: String,
        val for_hire: Boolean,
        val id: String,
        val instagram_username: String,
        val last_name: Any,
        val links: Links,
        val location: String,
        val name: String,
        val portfolio_url: String,
        val profile_image: ProfileImage,
        val social: Social,
        val total_collections: Int,
        val total_likes: Int,
        val total_photos: Int,
        val twitter_username: String,
        val updated_at: String,
        val username: String
    ) {
        data class Links(
            val followers: String,
            val following: String,
            val html: String,
            val likes: String,
            val photos: String,
            val portfolio: String,
            val self: String
        )

        data class ProfileImage(
            val large: String,
            val medium: String,
            val small: String
        )

        data class Social(
            val instagram_username: String,
            val paypal_email: Any,
            val portfolio_url: String,
            val twitter_username: String
        )
    }
}