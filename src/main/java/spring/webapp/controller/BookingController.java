package spring.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.webapp.database.entity.FlightDetail;
import spring.webapp.database.repository.FlightDetailRepository;
import spring.webapp.specification.FlightDetailSpecification;
import spring.webapp.specification.SearchCriteria;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    FlightDetailRepository fdr;

    @GetMapping("/booking")
    public String booking() {
            return "bookingpage";
        }
        @PostMapping("/ticket")
        public String showticket(HttpServletRequest request,
                                 @RequestParam(value="passengeramount")String passengeramount,
                                 @RequestParam(value="startdestination")String startdestination,
                                 @RequestParam(value="enddestination")String enddestination,
                                 @RequestParam(value="departuredate")String departuredate){
            FlightDetailSpecification spec1 = new FlightDetailSpecification(new SearchCriteria("seatleft", ">=", passengeramount));
            FlightDetailSpecification spec2 = new FlightDetailSpecification(new SearchCriteria("startdestination", ":", startdestination));
            FlightDetailSpecification spec3 = new FlightDetailSpecification(new SearchCriteria("enddestination", ":", enddestination));
            FlightDetailSpecification spec4 = new FlightDetailSpecification(new SearchCriteria("departuredate", ":", departuredate));
            List<FlightDetail> flighttickets =
                    fdr.findAll(Specifications.where(spec1).and(spec2).and(spec3).and(spec4));
            if (flighttickets != null) System.out.println(flighttickets.get(0).getAirline());
            request.getSession().setAttribute("flighttickets",flighttickets);
            return "ticketview";
        }

}
