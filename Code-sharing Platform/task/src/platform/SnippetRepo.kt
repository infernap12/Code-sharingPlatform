package platform

import org.springframework.stereotype.Repository

@Repository
class SnippetRepo {
    private val list = mutableListOf<Snippet>()

    fun get(index: Int): Snippet {
        try {
            return list[index]
        } catch (e: IndexOutOfBoundsException) {
            throw UnknownSnippetException(e)
        }
    }

    fun getLatest(): List<Snippet> {
        return list.asSequence().sortedByDescending { it.lastModified }.take(10).toList()
    }

    fun add(snippet: Snippet): Int {
        list.add(snippet)
        return list.indexOf(snippet)
    }
}