import kotlin.concurrent.thread

fun main() {
    val urls = mutableListOf<String>()

    while (true) {
        val input = readLine() ?: break
        if (input.isBlank()) break
        urls.add(input)
    }

    println("Iniciando downloads...")

    // Cria uma lista de Pair (indice, tamanho)
    val results = mutableListOf<Pair<Int, Int>>()

    val threads = urls.mapIndexed { index, url ->
        thread {
            val length = openLink(url)
            synchronized(results) {
                results.add(Pair(index, length))
            }
        }
    }

    // Aguarde até que todas as Threads terminem suas respectivas execuções.
    threads.forEach { it.join() }

    // Sort results by index to print in the correct order
    results.sortedBy { it.first }.forEachIndexed { idx, result ->
        println("Arq${idx + 1}: ${result.second}")
    }

    println("Tempo total: ${urls.size}")
}

fun openLink(url: String): Int {
    // Simula o "download" de uma URL (1 segundo por URL)
    Thread.sleep(1000)
    return url.length
}
