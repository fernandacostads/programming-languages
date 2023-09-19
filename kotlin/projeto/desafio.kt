// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String) {
    val conteudos = mutableListOf<ConteudoEducacional>()
    val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        for (conteudo in conteudos) {
            println("- ${conteudo.nome} (${conteudo.duracao} minutos)")
        }
    }

    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        for (usuario in inscritos) {
            println("- ${usuario.nome}")
        }
    }
}

fun main() {
    // Criar alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val conteudo3 = ConteudoEducacional("Kotlin Avançado", 180)

    // Criar uma formação
    val formacaoKotlin = Formacao("Formação Kotlin")
    formacaoKotlin.adicionarConteudo(conteudo1)
    formacaoKotlin.adicionarConteudo(conteudo2)
    formacaoKotlin.adicionarConteudo(conteudo3)

    // Criar alguns usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("Carol")

    // Matricular usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)

    // Listar conteúdos e inscritos na formação
    formacaoKotlin.listarConteudos()
    formacaoKotlin.listarInscritos()
}
