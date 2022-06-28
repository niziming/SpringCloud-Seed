package cn.zm.mq.service;

import cn.zm.mq.entity.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
  @Autowired
  private AmqpTemplate amqpTemplate;

  @Value("${spring.rabbitmq.exchange}")
  private String exchange;

  @Value("${spring.rabbitmq.routingkey}")
  private String routingkey;

  public void send(Employee company) {
    amqpTemplate.convertAndSend(exchange, routingkey, company);
    System.out.println("Send msg = " + company);
  }
}
