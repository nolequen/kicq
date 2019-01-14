package su.nlq.icq.bot.commands

import io.ktor.client.request.parameter
import su.nlq.icq.bot.api.HttpAPI

class Typing(
    private val to: String,
    private val status: Status = Status.Typing
) : Command<Unit> {

  override suspend fun execute(api: HttpAPI) = api.request<Unit>("im/setTyping") {
    parameter("t", to)
    parameter("typingStatus", status)
  }

  enum class Status {
    Looking,
    Typing,
    Typed,
    None;
  }
}