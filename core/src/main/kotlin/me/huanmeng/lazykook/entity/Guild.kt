package me.huanmeng.lazykook.entity

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import me.huanmeng.lazykook.locateValue
import kotlin.reflect.KProperty

/**
 * 2024/4/16<br>
 * LazyKook<br>
 * @author huanmeng_qwq
 */
data class Guild(
    val id: String,
    val name: String,
    val topic: String,
    @JsonProperty("user_id")
    val userId: String,
    val icon: String,
    @JsonProperty("notify_type")
    val notifyType: NotifyType,
    val region: String,
    @JsonProperty("enable_open")
    val enableOpen: Boolean,
    @JsonProperty("open_id")
    val openId: String,
    @JsonProperty("default_channel_id")
    val defaultChannelId: String,
    @JsonProperty("welcome_channel_id")
    val welcomeChannelId: String,
    val roles: List<Role>,
    val channels: List<Channel>,
    @field:JsonAnySetter
    @get:JsonAnyGetter
    val unknownField: MutableMap<String, Any?> = hashMapOf()
) {
    operator fun <V, V1 : V> getValue(thisRef: Any?, property: KProperty<*>): V1 = locateValue(unknownField, property)
}