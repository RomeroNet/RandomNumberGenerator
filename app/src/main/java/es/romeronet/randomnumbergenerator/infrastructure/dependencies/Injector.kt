package es.romeronet.randomnumbergenerator.infrastructure.dependencies

import es.romeronet.randomnumbergenerator.application.number.GenerateRandomNumbers

object Injector {
    val generateRandomNumbers = GenerateRandomNumbers()
}