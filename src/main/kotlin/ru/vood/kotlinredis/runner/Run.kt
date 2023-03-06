package ru.vood.kotlinredis.runner

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kotlinredis.repo.ISomeRepo
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Service
class Run(val iSomeRepo: ISomeRepo) : CommandLineRunner{


     val logger: Logger = LoggerFactory.getLogger(
        Run::class.java
    )

    override fun run(vararg args: String?) {


        val begin = LocalDateTime.now()
        val cnt = 1000000
        (1 ..cnt)
            .map { iSomeRepo.getSomeData(it.toString())  }

        val end = LocalDateTime.now()


        val between = ChronoUnit.MILLIS.between(begin, end)

        logger.info("load $cnt continued  $between milli seconds. RPS ${cnt.toDouble()/(between.toDouble()/1000)}")


    }
}