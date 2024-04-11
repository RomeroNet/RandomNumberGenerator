package es.romeronet.randomnumbergenerator.domain.number

data class Number(val value: Int): Comparable<Number> {
    override fun compareTo(other: Number): Int {
        if (this.value == other.value) {
            return 0
        }

        return if (this.value > other.value) {
            1
        } else -1
    }
}