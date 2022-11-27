package com.zaki.myexam.controllers;

import com.zaki.myexam.models.LoginUser;
import com.zaki.myexam.models.Trip;
import com.zaki.myexam.models.User;
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
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private final UserService userService;
    private final TripService tripService;

    public MainController(UserService userService, TripService tripService) {
        super();
        this.userService = userService;
        this.tripService = tripService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            return "dashboard.jsp";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "index.jsp";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long loggedID = (Long)session.getAttribute("user_id");
            User user = userService.oneUser(loggedID);
            List<Trip> trips = tripService.allTeams();
            model.addAttribute("teams", trips);
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
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {

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
    public String addTeam(Model model, @ModelAttribute("team") Trip trip, HttpSession session, RedirectAttributes redirectAttributes) {

        Long loggedID = (Long)session.getAttribute("user_id");
        User userName = userService.oneUser(loggedID);
        model.addAttribute("userName", userName);
        return "addTeam.jsp";
    }

    @PostMapping("/add/trip")
    public String createEvent(@Valid @ModelAttribute("team") Trip trip, BindingResult result, Model model, HttpSession session) {
//        tripService.tripDay(trip, result);
        User user = userService.findUser((Long)session.getAttribute("user_id"));
        if (result.hasErrors()) {
            return "addTeam.jsp";
        } else {

            tripService.createTeam(trip);

            return "redirect:/dashboard";
        }
    }

    @GetMapping("/trip/{id}")
    public String name(Model model, @PathVariable("id") Long id, HttpSession session) {

        Long loggedID = (Long)session.getAttribute("user_id");
        User user = userService.oneUser(loggedID);
        Trip trip = tripService.singleTeam(id);
//        model.addAttribute("assignedUsers", userService.getAssignedteams(trip));
//        model.addAttribute("unassignedUsers", userService.getUnassignedteams(trip));
        model.addAttribute("userName", user);
        model.addAttribute("team", trip);
        return "showTeam.jsp";
    }

    @PostMapping("/trip/{id}")
    public String editCategory(@PathVariable("id") Long id, @RequestParam(value = "userId") Long userId, Model model) {

        User player = userService.oneUser(userId);
        Trip trip = tripService.singleTeam(id);
        trip.getPlayers().add(player);
        tripService.createTeam(trip);
//        model.addAttribute("assignedUsers", userService.getAssignedteams(trip));
//        model.addAttribute("unassignedCategories", userService.getUnassignedteams(trip));

        return "redirect:/trip/" + id;
    }

    @GetMapping("/edit/trip/{id}")
    public String editName(Model model, HttpSession session, @PathVariable("id") Long id, @ModelAttribute("team") Trip trip) {
        Long loggedID = (Long)session.getAttribute("user_id");
        User userName = userService.oneUser(loggedID);
        Trip currentTrip = tripService.singleTeam(id);
        model.addAttribute("userName", userName);
        model.addAttribute("currentTeam", currentTrip);
        return "editTeam.jsp";
    }

    @RequestMapping("/delete/trip/{id}")
    public String destroy(@PathVariable("id") Long id) {
        tripService.deleteTeam(id);
        return "redirect:/dashboard";
    }

    @PostMapping("/edit/trip/{id}")
    public String updateNameForm(Model model,
                                 @PathVariable("id") Long id,
                                 @Valid @ModelAttribute("team") Trip trip,
                                 BindingResult result,
                                 HttpSession session) {
//        tripService.tripDay(trip, result);
        Long loggedID = (Long)session.getAttribute("user_id");
        User userName = userService.oneUser(loggedID);
        Trip currentTrip = tripService.singleTeam(id);

        if (result.hasErrors()) {
            model.addAttribute("userName", userName);
            model.addAttribute("currentTeam", currentTrip);

            return "editTeam.jsp";
        } else {

            return "redirect:/dashboard";
        }
    }
    @GetMapping("trips/{id}/join")
    public String joinTrip(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long)session.getAttribute("user_id");
            User userToAdd = userService.findUser(userId);
            Trip thisTrip = tripService.singleTeam(id);
            User player = userService.oneUser(userId);
            Trip trip = tripService.singleTeam(id);
            trip.getPlayers().add(player);
            return "redirect:/dashboard";
        }
        return "redirect:/";
    }
}
