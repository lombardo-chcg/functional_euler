package com.lombardo.app

import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}

trait EulerTestBase extends FlatSpec with Matchers with BeforeAndAfterAll {
  override def afterAll = System.gc()
}
