package day12_mq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class TestMWQ {
@Test
public void producer() throws Exception{
	//创建连接工厂
	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
	
	//通过连接工厂创建连接
	Connection connection = connectionFactory.createConnection();
	
	//启动连接
	connection.start();
	
	//创建session，参数1：是否启动事务，参数2：消息确认模式
	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	//创建消息队列
	Queue queue = session.createQueue("test-queue");//参数是队列的名字
	
	//创建消息生产者
	MessageProducer producer = session.createProducer(queue);//参数是队列，也就是生产的消息放在这个队列中
	
	//创建消息
	TextMessage textMessage = session.createTextMessage("hello activeMQ!!!");
	
	//发送消息
	producer.send(textMessage);
	
	//关闭资源
	producer.close();
	session.close();
	connection.close();
}
/**
 * 消息消费者
 * @throws Exception 
 */
@Test
public void consumer() throws Exception{
	//创建连接工厂
	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
	
	//创建连接
	Connection connection = connectionFactory.createConnection();
	
	//启动连接
	connection.start();
	
	//创建session，参数1：是否启动事务，参数2：消息确认模式
	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	
	//创建消息队列
	Queue queue = session.createQueue("test-queue");//和要接收的消息队列一样
	
	//创建消费者
	MessageConsumer consumer = session.createConsumer(queue);
	
	//监听消息
	consumer.setMessageListener(new MessageListener() {
		
	
		public void onMessage(Message message) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("消费者接收到的消息是：" + textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	});
	
    //等待键盘输入，如果没有这句话是接收不到消息的
	System.in.read();
	//关闭资源
	consumer.close();
	session.close();
	connection.close();
}
}
