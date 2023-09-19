class User(val id: Int, val name: String)

class UserManager private constructor() {
    private val users = mutableListOf<User>()

    companion object {
        private val instance = UserManager()

        fun getInstance(): UserManager {
            return instance
        }
    }

    fun addUser(name: String) {
        val id = users.size + 1
        val user = User(id, name)
        users.add(user)
    }

    fun listUsers() {
        for ((index, user) in users.withIndex()) {
            println("${index + 1} - ${user.name}")
        }
    }
}

fun main() {
    val userManager = UserManager.getInstance()

   
    val numUsers = readLine()?.toIntOrNull() ?: 0

    for (i in 1..numUsers) {
        val name = readLine() ?: ""
        userManager.addUser(name)
    }

    userManager.listUsers()
}
