package me.huanmeng.lazykook.http

import me.huanmeng.lazykook.http.request.*
import me.huanmeng.lazykook.http.response.*

/**
 * 2024/4/15<br>
 * LazyKook<br>
 * @author huanmeng_qwq
 */
data class APIRouter<REQ : Class<*>, RESP : Class<*>>(
    @get:JvmName("path")
    val path: String,
    @get:JvmName("requestClass")
    val requestClass: REQ,
    @get:JvmName("responseClass")
    val responseClass: RESP,
    @get:JvmName("version")
    val version: APIVersion = APIVersion.V3,
    @get:JvmName("apiMethod")
    val apiMethod: HttpMethod = HttpMethod.POST
) {
    fun buildPath(): String {
        return version.versionPath + path
    }
}

enum class APIVersion(@get:JvmName("versionPath") val versionPath: String) {
    V3("/v3")
}

enum class HttpMethod {
    GET, POST
}

object Requests {
    val GATEWAY =
        APIRouter("/gateway/index", GatewayRequest::class.java, GatewayResponse::class.java, apiMethod = HttpMethod.GET)

    object Guild {
        val LIST = APIRouter(
            "/guild/list", PageRequest::class.java, GuildListResponse::class.java,
            apiMethod = HttpMethod.GET
        )
        val VIEW = APIRouter(
            "/guild/view",
            GuildViewRequest::class.java,
            GuildViewResponse::class.java,
            apiMethod = HttpMethod.GET
        )
        val USER_LIST = APIRouter(
            "/guild/user-list",
            GuildUserListRequest::class.java,
            GuildUserListResponse::class.java,
            apiMethod = HttpMethod.GET
        )
        val NICKNAME = APIRouter(
            "/guild/nickname",
            GuildNicknameRequest::class.java,
            Any::class.java,
        )
        val LEAVE = APIRouter(
            "/guild/leave",
            GuildLeaveRequest::class.java,
            Any::class.java,
        )
        val KICK = APIRouter(
            "/guild/kickout",
            GuildKickRequest::class.java,
            Any::class.java
        )
        val MUTE_LIST = APIRouter(
            "/guild-mute/list",
            GuildMuteListRequest::class.java,
            GuildMuteListResponse::class.java,
            apiMethod = HttpMethod.GET
        )
        val MUTE_CREATE = APIRouter(
            "/guild-mute/create",
            GuildMuteCreateRequest::class.java,
            Any::class.java
        )
        val MUTE_DELETE = APIRouter(
            "/guild-mute/delete",
            GuildMuteDeleteRequest::class.java,
            Any::class.java
        )
        val BOOST_HISTORY = APIRouter(
            "/guild-boost/history",
            GuildBoostHistoryRequest::class.java,
            GuildBoostHistoryResponse::class.java
        )
    }

    object User {
        val VIEW = APIRouter(
            "/user/view",
            UserViewRequest::class.java,
            me.huanmeng.lazykook.entity.User::class.java,
            apiMethod = HttpMethod.GET
        )
    }

    object Role {
        val LIST = APIRouter(
            "/guild-role/list",
            RoleListRequest::class.java,
            RoleListResponse::class.java,
            apiMethod = HttpMethod.GET
        )
    }
}