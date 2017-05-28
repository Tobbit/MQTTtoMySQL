package de.tobisee.mqtt2sql;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by Tobi on 27.05.2017.
 */
public class Main {



    public static void main(String ...args) throws MqttException {
        MQTTClient mqttClient = new MQTTClient();
        mqttClient.start();

    }
}
