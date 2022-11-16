package com.zaki.projectmanager.controllers;

import com.zaki.projectmanager.models.LoginUser;
import com.zaki.projectmanager.models.Project;
import com.zaki.projectmanager.models.User;
import com.zaki.projectmanager.services.ProjectService;
import com.zaki.projectmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService    userService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());

        return "index.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {

        User user = userService.register(newUser, result);

        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/dashboard";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {

        User user = userService.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String showHome(Model model, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long)session.getAttribute("userId");
            User currentUser = userService.findByID(userId);
            model.addAttribute("currentUser", currentUser);
            List<Project> projectsAsProjectLeader = projectService.findAllProjectNotAsProjectLead(currentUser);
            model.addAttribute("projectLeader", projectsAsProjectLeader);
            List<Project> projectsAsNotProjectLeader = projectService.findAllProjectsAsProjectLeader(currentUser);
            model.addAttribute("notProjectLeader", projectsAsNotProjectLeader);
            return "dashboard.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("projects/new")
    public String createPage(HttpSession session, @ModelAttribute("newProject") Project newProject) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long)session.getAttribute("userId");
            User currentUser = userService.findByID(userId);
            return "new_project.jsp";
        }
        return "redirect:/";
    }

    @PostMapping("projects/new")
    public String addNewProject(@Valid @ModelAttribute("newProject") Project newProject, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "new_project.jsp";
        }
        Long userId = (Long)session.getAttribute("userId");
        User currentUser = userService.findByID(userId);
        newProject.setProjectLeader(currentUser);
        newProject.addUserToProject(currentUser);
        projectService.createProject(newProject);
        return "redirect:/dashboard";
    }

    @GetMapping("/projects/{id}")
    public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long)session.getAttribute("userId");
            model.addAttribute("currentUserId", userId);
            Project thisProject = projectService.findProject(id);
            model.addAttribute("projectDet", thisProject);
            return "view_project.jsp";
        }
        return "redirect:/";
    }

    @DeleteMapping("/projects/{id}/delete")
    public String deleteProject(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long)session.getAttribute("userId");
            projectService.deleteProject(id);
            return "redirect:/dashboard";
        }
        return "redirect:/";
    }

    @GetMapping("projects/{id}/join")
    public String joinProject(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long)session.getAttribute("userId");
            User userToAdd = userService.findByID(userId);
            Project thisProject = projectService.findProject(id);
            thisProject.addUserToProject(userToAdd);
            projectService.updateProject(thisProject);
            return "redirect:/dashboard";
        }
        return "redirect:/";
    }

    @GetMapping("projects/{id}/leave")
    public String leaveProject(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long)session.getAttribute("userId");
            User userToRemove = userService.findByID(userId);
            Project thisProject = projectService.findProject(id);
            List<User> projectMembers = thisProject.getUsers();
            projectMembers.remove(userToRemove);
            projectService.updateProject(thisProject);
            return "redirect:/dashboard";
        }
        return "redirect:/";
    }

    @GetMapping("projects/{id}/edit")
    public String editProjectPage(@PathVariable("id") Long id, @ModelAttribute("newProject") Project newProject, Model model, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            Long userId = (Long)session.getAttribute("userId");
            Project projectToEdit = projectService.findProject(id);
            model.addAttribute("thisProject", projectToEdit);
            return "edit_project.jsp";
        }
        return "redirect:/";
    }

    @PutMapping("projects/{id}/edit")
    public String updateProject(@Valid @PathVariable("id") Long id,
                                @ModelAttribute("newProject") Project newProject,
                                BindingResult result,
                                HttpSession session) {
        if (result.hasErrors()) {
            return "projects/{id}/edit";
        } else {
            Long userId = (Long)session.getAttribute("userId");
            User updatedBy = userService.findByID(userId);
            newProject.setProjectLeader(updatedBy);
            newProject.addUserToProject(updatedBy);
            projectService.updateProject(newProject);
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}