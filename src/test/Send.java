package test;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Send {

	 private static final String url = "tcp://localhost:61616";
	 private static final String QUEUE_NAME = "choice2.queue";
	 protected String expectedBody = "gongchandang";

	
	
	public static void main(String[] args) {
		try {
			new Send().sendMessage();//this is from test4

			
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
	
	public void sendMessage() throws JMSException{

        Connection connection = null;
        
        try{            
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connection = connectionFactory.createConnection();
            
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);          
            Destination destination = session.createQueue(QUEUE_NAME);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage(expectedBody);
            message.setText(expectedBody);
            message.setStringProperty("text", expectedBody);
                producer.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            connection.close();
        }
    }



}
