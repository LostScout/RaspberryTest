package actors

import akka.actor.{Actor, ActorLogging, Address}
import akka.cluster.ClusterEvent.{CurrentClusterState, MemberEvent, MemberRemoved, MemberUp}
import akka.cluster.{Cluster, MemberStatus}

case object GetNodes

class MemberListener extends Actor with ActorLogging {

  val cluster = Cluster(context.system)

  override def preStart(): Unit =
    cluster.subscribe(self, classOf[MemberEvent])

  override def postStop(): Unit =
    cluster unsubscribe self

  var nodes = Set.empty[Address]

  def receive: Receive = {
    case state: CurrentClusterState =>
      nodes = state.members.collect {
        case m if m.status == MemberStatus.Up => m.address
      }
    case MemberUp(member) =>
      log.info(s"Added cluster member: $member")
      nodes += member.address
    case MemberRemoved(member, _) =>
      log.info(s"Removed cluster member: $member")
      nodes -= member.address
    case _: MemberEvent ⇒ // ignore
    case GetNodes =>
      sender ! nodes
  }
}