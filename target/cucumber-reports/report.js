$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/automationpractice/feature/feature/getuserdetails.feature");
formatter.feature({
  "name": "Read Info Feed",
  "description": "  This test case is to verify info.seed value",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To verify Info Feed value",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Load the property file",
  "keyword": "Given "
});
formatter.match({
  "location": "GetUserDetailsSteps.loadThePropertyFile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Call the API",
  "keyword": "When "
});
formatter.match({
  "location": "GetUserDetailsSteps.callTheAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the response",
  "keyword": "Then "
});
formatter.match({
  "location": "GetUserDetailsSteps.verifyTheResponse()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/java/com/automationpractice/feature/feature/studentRegisterForm.feature");
formatter.feature({
  "name": "Fill and Submit the Student Form",
  "description": "  This test case is to fill student form and submit. Finally Close the browser.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "To fill and submit Student form",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User navigate to Student Registration Form page",
  "keyword": "Given "
});
formatter.match({
  "location": "StudentRegisterForm.userNavigateToStudentRegistrationFormPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Student details",
  "keyword": "When "
});
formatter.match({
  "location": "StudentRegisterForm.enterStudentDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify user details",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentRegisterForm.verifyUserDetails()"
});
formatter.result({
  "status": "passed"
});
});