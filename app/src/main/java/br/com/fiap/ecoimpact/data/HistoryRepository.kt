package br.com.fiap.ecoimpact.data

object HistoryRepository {
    private val history = mutableListOf<String>()

    fun addRecord(record: String) {
        history.add(0, record)
    }

    fun getHistory(): List<String> {
        return history
    }
}