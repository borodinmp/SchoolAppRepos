package home.controller;

import home.domain.TestResult;
import home.domain.Testing;
import home.domain.User;
import home.repos.TestResultRepo;
import home.repos.TestingRepo;
import home.service.FindService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@Controller
public class MainController {

        @Autowired
        FindService findService;

        @Autowired
        private TestResultRepo testResultRepo;

        @Autowired
        private TestingRepo testingRepo;

        @Value("${upload.path}")
        private String uploadPath;

        @GetMapping("/")
        public String greeting() {
            return "greeting";
            }

        @GetMapping("/main")
        public String main(@RequestParam(required = false, defaultValue = "") String filter,
                           @RequestParam(required = false, defaultValue = "") String selectFilter,
                           Model model){

            findService.find(filter, selectFilter);
            Iterable<Testing> testings = findService.getTestings();

            model.addAttribute("testings", testings);
            model.addAttribute("filter", filter);
            model.addAttribute("selectFilter", selectFilter);

            return "main";
            }

            private static final  int i = 1++;

        @PostMapping("text/{user}")
        public String add(
                @AuthenticationPrincipal User currentUser,
                @PathVariable User user,
                @Valid TestResult testResult,
                @RequestParam(value="1") String rbutton1,
                @RequestParam(value="2") String rbutton2,
                @RequestParam(value="3") String rbutton3,
                @RequestParam(value="4") String rbutton4,
                @RequestParam(value="5") String rbutton5,
                BindingResult bindingResult,
                Model model
                ){

            if(bindingResult.hasErrors()) {
                Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
                model.mergeAttributes(errorsMap);
                model.addAttribute("testResult", testResult);
            } else {
                if (user.getTestResults().size() == 0) {
                    String[] rbuttonList = {rbutton1, rbutton2, rbutton3, rbutton4, rbutton5};

                    for (int i = 0, j = 1 ; i < rbuttonList.length; i++, j++) {

                        if (rbuttonList[i].equals("1")) {
                            testResult = new TestResult(true, currentUser, j, testingRepo.findQuest(j));
                        } else if (rbuttonList[i].equals("2")) {
                            testResult = new TestResult(false, currentUser, j, testingRepo.findQuest(j));
                        }

                        testResultRepo.save(testResult);
                    }

                    model.addAttribute("testResult", null);

                } else {
                    boolean chkUsr = true;
                    model.addAttribute("chkUsr", chkUsr);
                }
            }

            Iterable<Testing> testings = testingRepo.findAll();
            model.addAttribute("testings", testings);

            Iterable<TestResult> testResults = testResultRepo.findAll();
            model.addAttribute("testResults", testResults);

            return "main";
        }

        @GetMapping("/user-testing/{user}")
        public String userTestings(
                @AuthenticationPrincipal User currentUser,
                @PathVariable User user,
                Model model){

            List<TestResult> testResults = user.getTestResults();

            Iterable<Testing> testings = testingRepo.findAllActive();

            model.addAttribute("testings", testings);

            model.addAttribute("testResults", testResults);

            model.addAttribute("isCurrentUser", currentUser.equals(user));

            return "userTesting";
        }

        @PostMapping("/user-testing/{user}")
        public String updateTestings(
                @AuthenticationPrincipal User currentUser,
                @PathVariable Long user,
                @RequestParam("id") Testing testing,
                @RequestParam("question") String question,
                @RequestParam("rbutton") String rbutton){

/*            if (testing.getAuthor().equals(currentUser)) {
                if (!StringUtils.isEmpty(question)) {
                    testing.setQuestion(question);
                }*/

/*                if (!StringUtils.isEmpty(rbutton)) {
                    if (rbutton.equals(1)){
                        testResult.setAnswer(true);
                    }
                    else if (rbutton.equals(2)){
                        testResult.setAnswer(false);
                    }
                }*/

                testingRepo.save(testing);
           /* }*/

            return "redirect:/user-testing/" + user;
        }

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
