package home.controller;

import home.domain.TestResult;
import home.domain.Testing;
import home.domain.User;
import home.repos.TestResultRepo;
import home.repos.TestingRepo;
import home.service.FindService;
import home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    FindService findService;

    @Autowired
    private TestResultRepo testResultRepo;

    @Autowired
    private TestingRepo testingRepo;


    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main/{user}")
    public String main(
            @PathVariable User user,
            Model model) {

        if (user.getTestResults().size() != 0) {
            boolean chkUsr = true;
            model.addAttribute("chkUsr", chkUsr);
            return "main";
        } else {
            findService.find();
            Iterable<Testing> testings = findService.getTestings();
            model.addAttribute("testings", testings);

            return "main";
        }
    }
    @PostMapping("main/test/{user}")
    public String add(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            @Valid TestResult testResult,
            @RequestParam("1") String r1, @RequestParam("2") String r2, @RequestParam("3") String r3,
            @RequestParam("4") String r4, @RequestParam("5") String r5, @RequestParam("6") String r6,
            Model model){
            String[] rbuttonList = {r1, r2, r3, r4, r5, r6};

            for (int i = 0, j = 1; i < rbuttonList.length; i++, j++) {

                if (rbuttonList[i].equals("1")) {
                    testResult = new TestResult(true, currentUser, j, testingRepo.findQuest(j), testingRepo.findChckQuest(j));
                }
                if (rbuttonList[i].equals("2")) {
                    testResult = new TestResult(false, currentUser, j, testingRepo.findQuest(j), testingRepo.findChckQuest(j));
                }
                testResultRepo.save(testResult);
            }
        return "redirect:/user-testing/{user}";
    }

    @GetMapping("/user-testing/{user}")
    public String userTestings(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model) {

        List<TestResult> testResults = user.getTestResults();

        model.addAttribute("testResults", testResults);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userTesting";
    }

    @GetMapping("/users-show")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String userShow(
            Model model) {

        model.addAttribute("users", userService.findUser());

        return "usersShow";
    }

    @GetMapping("/all-user-testing/{user}")
    public String teacherPanel(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model) {

        List<TestResult> testResults = user.getTestResults();

        model.addAttribute("testResults", testResults);
        model.addAttribute("fullName", user.getFullName());

        return "allUserTesting";
    }

    @PostMapping("/delete/{user}")
    @Transactional
    public String delete(
            @PathVariable User user,
            Model model) {

        testResultRepo.deleteAllByAuthor(user);
        model.addAttribute("users", userService.findUser());

        return "usersShow";
    }

}
