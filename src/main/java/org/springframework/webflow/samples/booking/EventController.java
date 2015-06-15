package org.springframework.webflow.samples.booking;

import java.security.Principal;
import java.util.List;




import model.Event;
import model.Performer;
import model.SearchCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EventController {
	private EventService eventService;
	
	@Autowired
    public EventController(EventService eventService, BookingService bookingService ) {
	this.eventService = eventService;
    }
	
	 private String getSearchPattern(SearchCriteria criteria) {
		if (StringUtils.hasText(criteria.getSearchString())) {
			  return "%" + criteria.getSearchString().toLowerCase().replace('*', '%') + "%";
		} else {
			  return "";
		}
	 }
 
	/*public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView("eventList");	
		mv.addObject("eventList", this.eventService.getEventList());
		return mv;
	}*/
	

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String list(SearchCriteria criteria, Model model) {
    	EventService eventService = new EventService(getSearchPattern(criteria));
    	List<Event> eventList = eventService.getEventList();
    	if(!eventList.isEmpty())
    		eventService.eventSave(eventList);
    	model.addAttribute("eventList", eventList);
    	return "hotels/list";
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model model) {
    	Event res = eventService.findEventById(id);
    	if(res != null){
    		model.addAttribute("event", res);
    		List<Performer> performers = res.getPerformers();
    		model.addAttribute("performers", performers);
    		for(Performer p : performers)
    			System.out.println("performer: " + p.getName());
    	}
    	return "hotels/show";
    }

}