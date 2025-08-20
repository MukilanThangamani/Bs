package TestBase;

import PageObjects.TaskSettingPage;
import org.testng.annotations.Test;

public class TaskPageTest extends BaseClass {

    @Test(priority = 8)
    public void testTaskSettings() throws InterruptedException {
        TaskSettingPage tp = new TaskSettingPage(driver);
        String[] taskname = {randomString(), randomString(), randomString(), randomString()};
        String[] charge = {randomAmount(), randomAmount(), randomAmount(), randomAmount()};
        //li[text()='Master']
        String[] role = {"Master", "Tailor"};//,"Embroider","Designer"

        for (int i = 0; i < 2; i++) {
            tp.setAddTask(taskname[i], charge[i], role[i]);
        }
        tp.verifyTasksInTable(taskname, charge);
        Thread.sleep(1000);

        //For Duplicate.
        String[] tasks = {"RSTbd", randomAmount(), "Master"};
        tp.addTask(tasks[0], tasks[1], tasks[2]);
        tp.printDuplicateTaskErrorMessage();
        tp.nextInTask();
        System.out.println("➡ Continue with the next test case...");
    }

}
