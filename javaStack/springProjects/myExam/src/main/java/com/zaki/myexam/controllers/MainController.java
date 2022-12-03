package com.zaki.myexam.controllers;

import com.zaki.myexam.models.Join;
import com.zaki.myexam.models.LoginUser;
import com.zaki.myexam.models.Trip;
import com.zaki.myexam.models.User;
import com.zaki.myexam.services.JoinService;
import com.zaki.myexam.services.TripService;
import com.zaki.myexam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private final UserService userService;
    private final TripService tripService;
    private final JoinService joinService;

    public MainController(UserService userService, TripService tripService, JoinService joinService) {
        super();
        this.userService = userService;
        this.tripService = tripService;
        this.joinService = joinService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "index.jsp";
    }

    @GetMapping("/dashboard")
    public String dashboard(@ModelAttribute("join") Join join, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long loggedID = (Long)session.getAttribute("user_id");
            User user = userService.oneUser(loggedID);
            List<Trip> trips = tripService.allTrips();
            model.addAttribute("trips", trips);
            model.addAttribute("logged", user);
            return "dashboard.jsp";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {

        userService.register(newUser, result);

        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }

        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {

        User user = userService.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());

        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String dashboard(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/add/trip")
    public String addTrip(Model model, @ModelAttribute("trip") Trip trip, HttpSession session, RedirectAttributes redirectAttributes) {

        Long loggedID = (Long)session.getAttribute("user_id");
        User userName = userService.oneUser(loggedID);
        model.addAttribute("userName", userName);
        return "addTrip.jsp";
    }

    @PostMapping("/add/trip")
    public String createEvent(@Valid @ModelAttribute("trip") Trip trip, BindingResult result, Model model, HttpSession session) {
        //        tripService.tripDay(trip, result);
        User user = userService.findUser((Long)session.getAttribute("user_id"));
        if (result.hasErrors()) {
            return "addTrip.jsp";
        } else {
            Long loggedID = (Long)session.getAttribute("user_id");
            User userName = userService.oneUser(loggedID);
            trip.getPlayers().add(userName);
            tripService.createTrip(trip);
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/edit/trip/{id}")
    public String editPage(Model model, HttpSession session, @PathVariable("id") Long id, @ModelAttribute("trip") Trip trip) {
        Long loggedID = (Long)session.getAttribute("user_id");
        User userName = userService.oneUser(loggedID);
        Trip currentTrip = tripService.singleTrip(id);
        model.addAttribute("userName", userName);
        model.addAttribute("currentTrip", currentTrip);
        return "editTrip.jsp";
    }

    @PostMapping("/edit/trip/{id}")
    public String updateTrip(@Valid @ModelAttribute("trip") Trip trip, BindingResult result, Model model, HttpSession session) {
        User user = userService.findUser((Long)session.getAttribute("user_id"));
        if (result.hasErrors()) {
            return "editTrip.jsp";
        } else {
            tripService.updateTrip(trip);
            return "redirect:/dashboard";
        }
    }

    @RequestMapping("/delete/trip/{id}")
    public String destroy(@PathVariable("id") Long id) {
        tripService.deleteTrip(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/trip/{id}")
    public String name(Model model, @PathVariable("id") Long id, HttpSession session) {

        Long loggedID = (Long)session.getAttribute("user_id");
        User user = userService.oneUser(loggedID);
        Trip trip = tripService.singleTrip(id);
        List<Date> joinDate = joinService.joinDate(trip.getId());
        //        System.out.println(joinDate);
        //        model.addAttribute("assignedUsers", userService.getAssignedTrips(trip));
        //        model.addAttribute("userName", user);
        System.out.println(trip.getId());
        System.out.println(trip.getUser());
        model.addAttribute("trip", trip);
        model.addAttribute("joinDate", joinDate);
        //        System.out.println(trip.getJoins());
        return "showTrip.jsp";
    }

    @PostMapping("/trip/{id}")
    public String editCategory(@PathVariable("id") Long id, @RequestParam(value = "userId") Long userId, Model model) {

        User player = userService.oneUser(userId);
        Trip trip = tripService.singleTrip(id);
        trip.getPlayers().add(player);
        tripService.createTrip(trip);
        //                model.addAttribute("assignedUsers", userService.getAssignedTrips(trip));
        //                model.addAttribute("unassignedCategories", userService.getUnassignedTrips(trip));

        return "redirect:/trip/" + id;
    }

    //    @GetMapping("trips/{id}/join")
    //    public String joinTrip(@PathVariable("id") Long id, HttpSession session) {
    //        if (session.getAttribute("user_id") != null) {
    //            Long userId = (Long)session.getAttribute("user_id");
    //            User userToAdd = userService.findUser(userId);
    //            Trip thisTrip = tripService.singleTeam(id);
    //            User player = userService.oneUser(userId);
    //            Trip trip = tripService.singleTeam(id);
    //            trip.getPlayers().add(player);
    //            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    //            Date date = new Date();
    //            System.out.println(date);
    //            Join join = joinService.singleJoin();
    //            join.setCreatedAt(date);
    //
    //            System.out.println(join.getCreatedAt());
    //
    //            //            tripService.updateTeam(trip);
    //            joinService.createJoin(join);
    //            return "redirect:/dashboard";
    //        }
    //        return "redirect:/";
    //    }

    @PostMapping("/trips/join")
    public String joinMe(Model model, HttpSession session, @Valid @ModelAttribute("join") Join join, BindingResult result) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.println(formatter.format(date));
        join.setCreatedAt(date);
        joinService.joinThisTrip(join);
        return "redirect:/dashboard";
    }

    //    @GetMapping("trips/{id}/remove")
    //    public String leaveProject(@PathVariable("id") Long id, Model model, HttpSession session) {
    //        if (session.getAttribute("user_id") != null) {
    //            Long userId = (Long)session.getAttribute("user_id");
    //            User userToRemove = userService.findUser(userId);
    //            Long loggedID = (Long)session.getAttribute("user_id");
    //            User user = userService.oneUser(loggedID);
    //            Trip thisTrip = tripService.singleTeam(id);
    //            model.addAttribute("logged", loggedID);
    //            thisTrip.getPlayers().remove(userToRemove);
    //            tripService.updateTeam(thisTrip);
    //            return "redirect:/trip/" +id;
    //        }
    //        return "redirect:/";
    //    }
    @PostMapping("remove/{id}")
    public String removeJoin(@Valid @ModelAttribute("join") Join join, @PathVariable("id") Long id, Model model, HttpSession session) {
        joinService.joinThisTrip(join);
        return "redirect:/trip/" + id;
    }
}
