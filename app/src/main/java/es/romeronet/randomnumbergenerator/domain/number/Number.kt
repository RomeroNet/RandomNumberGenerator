package es.romeronet.randomnumbergenerator.domain.number

data class Number(val value: Int): Comparable<Number> {
    override fun compareTo(other: Number): Int {
        // 0 won't be needed, as there can't be repeated numbers.

        return if (this.value > other.value) {
            1
        } else -1
    }
}