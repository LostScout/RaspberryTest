import actors.{GetNodes, MemberListener}
import akka.actor.{Actor, ActorSystem, Address, Props}
import akka.cluster.ClusterEvent.{CurrentClusterState, MemberEvent, MemberRemoved, MemberUp}
import akka.cluster.{Cluster, MemberStatus}
import akka.pattern.ask
import akka.util.Timeout
import playground.gpio.ListenGpioExample

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

object Main extends App {
//  implicit val timeout: Timeout = 30.seconds
//  implicit val ec = ExecutionContext.Implicits.global
//
//  val actorSystem = ActorSystem("RaspberryBush")
//  val cluster = Cluster(actorSystem)
//
//  val memberListener = actorSystem.actorOf(Props(classOf[MemberListener]), "MemberListener")

  val example = new ListenGpioExample()
  example.main(Array())

}



