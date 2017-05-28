package de.tobisee.mqtt2sql;

import com.google.gson.Gson;
import de.tobisee.mqtt2sql.Entity.BMP180;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by Tobi on 27.05.2017.
 */
public class MQTTClient implements MqttCallback {

    String topic = "MQTT Examples";
    String content = "Message from MqttPublishSample";
    int qos = 2;
    String broker = "tcp://192.168.1.30:1883";
    String clientId = "JavaSample";
    private final MqttClient client;

    public MQTTClient() throws MqttException {
        MemoryPersistence persistence = new MemoryPersistence();
        client = new MqttClient(broker, clientId, persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        System.out.println("Connecting to broker: " + broker);
        client.connect(connOpts);
    }

    public void start() {


        try {
            client.subscribe("/BMP180/#");
            client.setCallback(this);

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection Lost");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        long timestamp = System.currentTimeMillis();
        System.out.println("Topic: "+s);
        System.out.println(mqttMessage.toString());
        BMP180 date = JSONParsing(timestamp, mqttMessage.toString());
        System.out.println(date);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete");
    }

    private BMP180 JSONParsing(long timestamp, String payload){
        Gson gson = new Gson();
        BMP180 date = gson.fromJson(payload,BMP180.class);
        date.setTimestamp(timestamp);
        return date;
    }
}
