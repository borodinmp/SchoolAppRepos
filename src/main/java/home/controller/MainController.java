package home.controller;

import home.domain.TestResult;
import home.domain.Testing;
import home.domain.User;
import home.repos.TestResultRepo;
import home.repos.TestingRepo;
import home.repos.UserRepo;
import home.service.FindService;
import home.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

@Controller
public class MainController {

        @Autowired
        FindService findService;

        @Autowired
        private TestResultRepo testResultRepo;

        @Autowired
        private TestingRepo testingRepo;

        @Autowired
        private UserRepo userRepo;

        @Autowired
        private UserService userService;

        @GetMapping("/")
        public String greeting() {
            return "greeting";
            }

        @GetMapping("/main/{user}")
        public String main(
                @PathVariable User user,
                @RequestParam(required = false, defaultValue = "") String filter,
                @RequestParam(required = false, defaultValue = "") String selectFilter,
                           Model model){

            if (user.getTestResults().size() != 0) {
                boolean chkUsr = true;
                model.addAttribute("chkUsr", chkUsr);
                return "main";
            } else {
                findService.find(filter, selectFilter);
                Iterable<Testing> testings = findService.getTestings();

                model.addAttribute("testings", testings);
                model.addAttribute("filter", filter);
                model.addAttribute("selectFilter", selectFilter);

                return "main";
            }
        }

        @PostMapping("main/test/{user}")
        public String add(
                @AuthenticationPrincipal User currentUser,
                @PathVariable User user,
                @Valid TestResult testResult,
                @RequestParam(value="1") String rbutton1, @RequestParam(value="2") String rbutton2, @RequestParam(value="3") String rbutton3,
                @RequestParam(value="4") String rbutton4, @RequestParam(value="5") String rbutton5, @RequestParam(value="6") String rbutton6,
                @RequestParam(value="7") String rbutton7, @RequestParam(value="8") String rbutton8, @RequestParam(value="9") String rbutton9,
                @RequestParam(value="10") String rbutton10, @RequestParam(value="11") String rbutton11,
                BindingResult bindingResult,
                Model model
                ){

                if (bindingResult.hasErrors()) {
                    Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
                    model.mergeAttributes(errorsMap);
                    model.addAttribute("testResult", testResult);
                } else {
                        String[] rbuttonList = {rbutton1, rbutton2, rbutton3, rbutton4, rbutton5, rbutton6, rbutton7, rbutton8, rbutton9,
                                rbutton10, rbutton11};

                        for (int i = 0, j = 1; i < rbuttonList.length; i++, j++) {

                            if (rbuttonList[i].equals("1")) {
                                testResult = new TestResult(true, currentUser, j, testingRepo.findQuest(j), testingRepo.findChckQuest(j));
                            } else if (rbuttonList[i].equals("2")) {
                                testResult = new TestResult(false, currentUser, j, testingRepo.findQuest(j), testingRepo.findChckQuest(j));
                            } else {
                                boolean chkBtn = true;
                                model.addAttribute("chkBtn", chkBtn);
                            }

                            testResultRepo.save(testResult);
                        }

                        model.addAttribute("testResult", null);

                }

                Iterable<Testing> testings = testingRepo.findAll();
                model.addAttribute("testings", testings);

                Iterable<TestResult> testResults = testResultRepo.findAll();
                model.addAttribute("testResults", testResults);

            return "redirect:/user-testing/{user}";
        }

        @GetMapping("/user-testing/{user}")
        public String userTestings(
                @AuthenticationPrincipal User currentUser,
                @PathVariable User user,
                Model model){

            List<TestResult> testResults = user.getTestResults();

            model.addAttribute("testResults", testResults);
            model.addAttribute("isCurrentUser", currentUser.equals(user));

            return "userTesting";
        }

    @GetMapping("/users-show")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
    public String userShow(
            Model model){

        model.addAttribute("users", userService.findUser());

        return "usersShow";
    }

    @GetMapping("/all-user-testing/{user}")
    public String teacherPanel(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model){

        List<TestResult> testResults = user.getTestResults();

        model.addAttribute("testResults", testResults);
        model.addAttribute("fullName", user.getFullName());

        return "allUserTesting";
    }

/*        @PostMapping("/user-testing/{user}")
        public String updateTestings(
                @AuthenticationPrincipal User currentUser,
                @PathVariable Long user,
                @RequestParam("id") Testing testing,
                @RequestParam("question") String question,
                @RequestParam("rbutton") String rbutton){

            if (testing.getAuthor().equals(currentUser)) {
                if (!StringUtils.isEmpty(question)) {
                    testing.setQuestion(question);
                }

                if (!StringUtils.isEmpty(rbutton)) {
                    if (rbutton.equals(1)){
                        testResult.setAnswer(true);
                    }
                    else if (rbutton.equals(2)){
                        testResult.setAnswer(false);
                    }
                }

                testingRepo.save(testing);
            }

            return "redirect:/user-testing/" + user;
        }*/

        @PostMapping("delete")
        @Transactional
        public String delete(@RequestParam Long id, Map<String,Object> model) {

            Iterable<Testing> testings;

            testingRepo.deleteById(id);
            testings = testingRepo.findAll();
            model.put("testings", testings);
            return "main";
            }

    }
