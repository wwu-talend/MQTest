package test;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ReceiveTest {

	private static final String url = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "choice2.queue";

	public static void main(String[] args) {
System.out.println("I funk you");
		System.out.println("maim kaishi l ");
		ReceiveTest rm = new ReceiveTest();
        rm.receiveMessage();

	}
	
	
	 public void receiveMessage(){
		   System.out.println("begin l ");
		 
	        Connection connection = null;
	        try{
	            try{
	                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
	                connection = connectionFactory.createConnection();
	                
	                
	                
	            }catch(Exception e){
//	                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//	                connection = connectionFactory.createConnection();
	            }            
	            connection.start();
	            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	            Destination destination = session.createQueue(QUEUE_NAME);
	            
	            MessageProducer publisher = session.createProducer(destination);
	            publisher.setDeliveryMode(DeliveryMode.PERSISTENT);
	            
	            String sele = "text == 'gongchandang'";
	            MessageConsumer consumer = session.createConsumer(destination,sele);
	            consumeMessagesAndClose(connection,session,consumer);
	        }catch(Exception e){
	            
	        }
	 }
	 
	 protected void consumeMessagesAndClose(Connection connection,
	            Session session, MessageConsumer consumer) throws JMSException {
	        for (int i = 0; i < 5;) {
	            Message message = consumer.receive(1000);
	            if (message != null) {
	                i++;
	                onMessage(message);
	            }
	        }
	        System.out.println("Closing connection");
	        consumer.close();
	        session.close();
	        connection.close();
	    }

	 public void onMessage(Message message){
	        try{
	            if (message instanceof TextMessage) {
	                TextMessage txtMsg = (TextMessage)message;
	                String msg = txtMsg.getText();
	                System.out.println("Received: " + msg);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }



}
