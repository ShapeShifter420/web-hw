import org.ShapeShifter420.webapp.mailsender.MailSender;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.io.UnsupportedEncodingException;

public class MailTest{
    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(MailTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
    //@Test
    public void MainTest(){
        MailSender m = new MailSender();
        try {
            Assert.assertEquals(m.send("Бронирование стола","Ваш регистрационный код: ",""),"Успех");
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            Assert.fail();
        }
}}