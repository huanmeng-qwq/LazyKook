package me.huanmeng.lazykook.http.request

import com.fasterxml.jackson.annotation.JsonProperty

annotation class Comment(val value: String)

data class GatewayRequest(
    val compress: Int = 1
)

data class PageRequest(
    val page: Int = 1,
    @JsonProperty("page_size")
    val pageSize: Int = 20,
    val sort: String? = null
)

data class GuildViewRequest(
    @JsonProperty("guild_id")
    val guildId: String
)

data class GuildUserListRequest(
    @JsonProperty("guild_id")
    val guildId: String,
    @JsonProperty("channel_id")
    val channelId: String? = null,
    val search: String? = null,
    @JsonProperty("role_id")
    val roleId: String? = null,
    @JsonProperty("mobile_verified")
    val mobileVerified: Int? = null,
    @JsonProperty("active_time")
    val activeTime: Int? = null,
    @JsonProperty("joined_at")
    val joinedAt: Long? = null,
    val page: Int = 1,
    val pageSize: Int = 20,
    @JsonProperty("filter_user_id")
    val filterUserId: String? = null,
)

data class GuildNicknameRequest(
    @JsonProperty("guild_id")
    val guildId: String,
    @JsonProperty("user_id")
    val userId: String? = null,
    val nickname: String? = null,
)

data class GuildLeaveRequest(
    @JsonProperty("guild_id")
    val guildId: String
)

data class GuildKickRequest(
    @JsonProperty("guild_id")
    val guildId: String,
    @JsonProperty("target_id")
    val userId: String,
)

data class GuildMuteListRequest(
    @JsonProperty("guild_id")
    val guildId: String,
    @JsonProperty("return_type")
    val returnType: String? = null,// sug: detail
)

data class GuildMuteCreateRequest(
    @JsonProperty("guild_id")
    val guildId: String,
    @JsonProperty("user_id")
    val userId: String,
    val type: Int,
)

data class GuildMuteDeleteRequest(
    @JsonProperty("guild_id")
    val guildId: String,
    @JsonProperty("user_id")
    val userId: String,
    val type: Int,
)

data class GuildBoostHistoryRequest(
    @JsonProperty("guild_id")
    val guildId: String,
    @JsonProperty("start_time")
    @Comment("unix")
    val startTime: Int,
    @JsonProperty("end_time")
    @Comment("unix")
    val endTime: Int,
)

// user
data class UserViewRequest(
    @JsonProperty("user_id")
    val userId: String,
    @JsonProperty("guild_id")
    val guildId: String? = null,
)

// role
data class RoleListRequest(
    @JsonProperty("guild_id")
    val guildId: String,
    val page: Int = 1,
    @JsonProperty("page_size")
    val pageSize: Int = 20,
)

// channel
data class ChannelViewRequest(
    @JsonProperty("target_id")
    val channelId: String,
    @JsonProperty("need_children")
    val needChildren: Boolean = false
)

// message
data class MessageCreateRequest(
    @JsonProperty("target_id")
    val targetId: String,
    val content: String,
    @JsonProperty("quote")
    val quote: String? = null,
    @JsonProperty("temp_target_id")
    val tempTargetId: String? = null,
    val nonce: String? = null,
    val type: Int = 1,
)

data class MessageUpdateRequest(
    @JsonProperty("target_id")
    val targetId: String,
    val content: String,
    @JsonProperty("quote")
    val quote: String? = null,
    @JsonProperty("temp_target_id")
    val tempTargetId: String? = null,
)

data class MessageDeleteRequest(
    @JsonProperty("msg_id")
    val msgId: String,
)

data class MessageViewRequest(
    @JsonProperty("msg_id")
    val msgId: String,
)