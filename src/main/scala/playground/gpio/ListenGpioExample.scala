package playground.gpio

import com.pi4j.io.gpio.event.{GpioPinDigitalStateChangeEvent, GpioPinListenerDigital}
import com.pi4j.io.gpio.{GpioFactory, PinPullResistance, RaspiPin}

class ListenGpioExample {

  def main(args: Array[String]): Unit = {

    println("Starting to listen")

    val gpio = GpioFactory.getInstance()

    val button = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN)

    button.setShutdownOptions(true)

    button.addListener(new GpioPinListenerDigital() {
      @Override
      override def handleGpioPinDigitalStateChangeEvent(event: GpioPinDigitalStateChangeEvent): Unit = {
        println(s"Pin Event! Edge: ${event.getEdge.getName}@${event.getEdge.getValue}" +
          s"Value: ${event.getState.getName}@${event.getState.getValue}")
      }
    })

    println("listen for feedback")

    while(true) {
      Thread.sleep(500)
    }



  }

}
