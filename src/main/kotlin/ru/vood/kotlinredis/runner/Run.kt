package ru.vood.kotlinredis.runner

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.kotlinredis.repo.ISomeRepo

@Service
class Run(val iSomeRepo: ISomeRepo) : CommandLineRunner{
    override fun run(vararg args: String?) {


        (3 .. 4)
            .map { iSomeRepo.getSomeData(it.toString())  }

    }
}