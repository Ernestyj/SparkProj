package com.eugene.dataanalysis

import breeze.linalg._

/**
  * Created by eugene on 16/3/30.
  */
object BreezeVector {
    def main(args: Array[String]): Unit = {
        val simpleMatrix=DenseMatrix((4.0,7.0),(3.0,-5.0))
        println(simpleMatrix)
        val firstVector=simpleMatrix(::,0)
        println(firstVector)
        val denseEig=eig(simpleMatrix)
        println(denseEig.eigenvectors)
    }
}
