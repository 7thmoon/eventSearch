package org.springframework.webflow.samples.booking;


import java.util.ArrayList;
import java.util.List;

import model.Event;
import model.Performer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.webflow.samples.booking.config.MongoConfig;

import repository.EventRepository;
import repository.PerformerRepository;
import repository.StatsRepository;
import repository.VenueRepository;


@Service("eventService")
@JsonIgnoreProperties(ignoreUnknown=true)
public class EventService {

	@JsonProperty("events")
	private List<Event> EventList = new ArrayList<Event>();

	public EventService(){
		
	}
	public EventService(String context){
		  String url = "http://api.seatgeek.com/2/events?q=" + context;
		  RestTemplate restTemplate = new RestTemplate();
		  EventService res = restTemplate.getForObject(url,EventService.class);
		  for(Event event : res.getEventList()){
			  EventList.add(event);
		  }
			 
	}
	public void eventSave(List<Event> eventList){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		 EventRepository eventRepo = ctx.getBean(EventRepository.class);
		 VenueRepository venueRepo = ctx.getBean(VenueRepository.class);
		 PerformerRepository perfRepo = ctx.getBean(PerformerRepository.class);
		 StatsRepository statRepo = ctx.getBean(StatsRepository.class);
		 if(!eventList.isEmpty()){
			 eventRepo.save(eventList);
			 for(Event event : eventList){
				 venueRepo.save(event.getVenue());
				 perfRepo.save(event.getPerformers());
				 statRepo.save(event.getStats());
			 }
		 }
		 ctx.close();
				 
	}
	
	public Event findEventById(Long id){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		 EventRepository eventRepo = ctx.getBean(EventRepository.class);
		 Event res = eventRepo.findOne(id);
		 ctx.close();
		 return res;
	}
	
	/*public List<Performer> findPerformersById(Long id){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		 EventRepository eventRepo = ctx.getBean(EventRepository.class);
		 List<Performer> res = eventRepo.findPerformersbyId(id);
		 ctx.close();
		 return res;
	}*/
	
	public List<Event> getEventList(){
		return EventList;
	}
	
}
