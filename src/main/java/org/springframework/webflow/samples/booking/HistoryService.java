package org.springframework.webflow.samples.booking;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.webflow.samples.booking.config.MongoConfig;

import repository.HistoryRepository;
import model.History;
import model.User;

public class HistoryService {
	
	public HistoryService(){
	}
	
	public void historySave(User user, String content){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		HistoryRepository hisRepo = ctx.getBean(HistoryRepository.class);
		History his = new History(user, content);
		hisRepo.save(his);
		ctx.close();
	}
}