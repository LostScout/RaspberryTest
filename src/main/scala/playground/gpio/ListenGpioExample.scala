package playground.gpio

import com.pi4j.io.gpio.event.{GpioPinDigitalStateChangeEvent, GpioPinListenerDigital}
import com.pi4j.io.gpio.{GpioFactory, PinPullResistance, PinState, RaspiPin}

class ListenGpioExample {

  def main(args: Array[String]): Unit = {

    println("Starting to listen")

    val gpio = GpioFactory.getInstance()

    val button = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_DOWN)
    button.setShutdownOptions(true)

    val pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "MyLED", PinState.LOW)
    pin.setShutdownOptions(true, PinState.LOW)



    button.addListener(new GpioPinListenerDigital() {
      @Override
      override def handleGpioPinDigitalStateChangeEvent(event: GpioPinDigitalStateChangeEvent): Unit = {
        event.getState.getValue match {
          case 0 =>
            pin.low()
            println("goin low")
          case 1 =>
            println("going high")
            pin.high()
          case msg =>
            println("soemthing else?")
        }
        println(s"Pin Event! Edge: ${event.getEdge.getName}@${event.getEdge.getValue} " +
          s"Value: ${event.getState.getName}@${event.getState.getValue}")
      }
    })

    println("listen for feedback")

    while(true) {
      Thread.sleep(500)
    }



  }

}
